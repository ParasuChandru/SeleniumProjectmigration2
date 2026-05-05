package com.guidewire.policycenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.guidewire.commonpagefunctions.PC_GenericFunctions;


public class PC_Quote_Page extends PC_GenericFunctions{

	public PC_Quote_Page(WebDriver driver, ExtentTest test, ExtentReports extent) {
		super(driver, test, extent);
	}

	//Objects
	@FindBy(xpath="//span[contains(@id,'QuoteScreen:ttlBar') or contains(@id,'SubmissionWizard_QuoteScreen:ttlBar') or contains(@id,'PolicyFile_PricingScreen:0')]")
	public WebElement Quote_Header;

	@FindBy(xpath="//div[@id='SubmissionWizard-SubmissionWizard_QuoteScreen-ttlBar' or @id='PolicyFile_Pricing-PolicyFile_PricingScreen-0' or @id='PolicyChangeWizard-PolicyChangeWizard_QuoteScreen-ttlBar']/div[1]/div")
	public WebElement gw_Quote_Header;
	
	@FindBy(xpath="//div[@id='SubmissionWizard-SubmissionWizard_QuoteScreen-JobWizardToolbarButtonSet-BindOptions']/div[1]")
	public WebElement gw_BindOptions_Button;

	@FindBy(xpath="//div[@class='gw-label' and text()='Issue Policy' or @aria-label='Issue Policy']")
	public WebElement gw_IssuePolicy;
	
	@FindBy(xpath="//div[text()='OK']")
	public WebElement gw_OK_Button;
	
	@FindBy(xpath="//div[contains(@id,'Wizard_QuoteScreen-JobWizardToolbarButtonSet-QuoteTypeToolbarButtonSet-FinishQuote')]/div")
	public WebElement FinishQuote_Button;
	
	@FindBy(xpath="//div[@id='SubmissionWizard-SubmissionWizard_QuoteScreen-CreateQuoteWithSMS']/div")
	public WebElement gw_CreateQuote_Button;
	
	
	/**
	 * Function to Select QuoteBindType
	 * @param BindType 
	 * @throws InterruptedException 
	 */
	public void BindOptions(String BindType) throws InterruptedException {
		Click_On_Button("", gw_BindOptions_Button, "Clicked 'Bind Options' button");
		Thread.sleep(1500);   //PCS commented on 30-01-2026 to improve the execution speed and changed the sleep time from 5000 to 1500
		Click_On_Button("", gw_IssuePolicy, "selected issue policy option.");
		Thread.sleep(2000);  //PCS commented on 30-01-2026 to improve the execution speed and changed the sleep time from 2000 to 1000
	}

	/**
	 * Function to verify Issue Policy Confirmation message
	 * @param OkCancel
	 * @throws InterruptedException 
	 */
	public void VerifyIssuePolicyConfirmation(String PolicyEffectiveDate, String OkCancel) throws InterruptedException {
			try {		
				isAlertPresent();
				String TextMessage=closeAlertAndGetItsText();
				test.info("Clicked OK to alert message '" + TextMessage +"'");
			}catch (Exception E) {
				Thread.sleep(2000);
				if(gw_OK_Button.isDisplayed()) {
					alert.accept();
				}
			}
		Thread.sleep(15000);
	}

	/*
	 * Function to click on Create Quote button
	 */
	public void CreateQuoteButtonClick() throws InterruptedException {
		Click_On_Button("", gw_CreateQuote_Button, "Clicked on the create quote button.");	
		Thread.sleep(3000);
	}
	

	/*
	 * click on finish quote button
	 */
	public void ClickOnFinishQuotebutton() throws Exception {
		Click_On_Button("", FinishQuote_Button);
		try {
			System.out.println("Finish Quote Start - "+ProvidePastCurrentOrFutureDate("HH:mm:ss", 0));
			for(int i=1;i<30;i++) {
				if(FinishQuote_Button.isDisplayed()) {
					Thread.sleep(1000);
				}else {
					break;
				}
			}
			System.out.println("Finish Quote End - "+ProvidePastCurrentOrFutureDate("HH:mm:ss", 0));
		}catch(Exception E) {
			System.out.println(E.getMessage());
		}
		wait_For_Overlay(3);
	}
}


