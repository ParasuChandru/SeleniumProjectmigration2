package com.guidewire.policycenter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.guidewire.commonpagefunctions.PC_GenericFunctions;
import com.guidewire.config.CONSTANTS;

public class PC_Payments_Page extends PC_GenericFunctions {

	public PC_Payments_Page(WebDriver driver, ExtentTest test, ExtentReports extent) {
		super(driver, test, extent);
		
	}
	
	@FindBy(xpath="//span[contains(@id,'Payment_LTScreen:ttlBar')]")
	public WebElement Payment_PageHeader;
	
	@FindBy(xpath="//div[@id='SubmissionWizard-SubmissionWizardPayment_LTScreen-ttlBar']/div[1]/div")
	public WebElement gw_Payment_PageHeader;
		
	String PaymentPlanPart1="//div[contains(@id,'BundleLV-body')]/descendant::tr[";
	String gw_PaymentPlanPart1="//div[contains(@id,'BillingAdjustments_LTDV-0')]/descendant::tr[";
	String PaymentPlanPart2="]/descendant::td[";
	String PaymentPlanPart3="]/div";
	
		/*
		 * Function to select the payment plans
		 */
		public void SelectPaymetPlan(String Paymentplan) throws Exception {
			String ColumnIndex = "7";
				wait_For_Overlay(60);
				int size=driver.findElements(By.xpath("//div[contains(@id,'BillingAdjustments_LTDV-0')]/descendant::tr")).size();
				for(int i=1; i<=size; i++) {
					
						if(ByXpathAction(gw_PaymentPlanPart1+i+PaymentPlanPart2+1+PaymentPlanPart3).getText().contains("New") || ByXpathAction(gw_PaymentPlanPart1+i+PaymentPlanPart2+3+PaymentPlanPart3).getText().contains("New") || ByXpathAction(gw_PaymentPlanPart1+i+PaymentPlanPart2+2+PaymentPlanPart3).getText().contains("New")) {
							Thread.sleep(500); 
							SelectID_DropDown("PaymentPlanRange", Paymentplan, Paymentplan);
							
								break;
						}
					}
				if(ByXpathAction(gw_PaymentPlanPart1+2+PaymentPlanPart2+2+PaymentPlanPart3).getText().contains("Existing")) {
					ByXpathAction(gw_PaymentPlanPart1+2+PaymentPlanPart2+1+PaymentPlanPart3).click();
					}	
			}
}