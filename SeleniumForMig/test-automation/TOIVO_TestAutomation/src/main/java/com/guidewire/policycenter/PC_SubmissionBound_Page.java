package com.guidewire.policycenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.guidewire.commonpagefunctions.PC_GenericFunctions;
import com.guidewire.config.CONSTANTS;

public class PC_SubmissionBound_Page extends PC_GenericFunctions {
	public PC_SubmissionBound_Page(WebDriver driver, ExtentTest test, ExtentReports extent) {
		super(driver, test, extent);
	}

	//Objects	
	@FindBy(xpath="//span[@id='JobComplete:JobCompleteScreen:ttlBar']")
	public WebElement SubmissionBound_PageHeader;

	@FindBy(xpath="//div[@id='JobComplete-JobCompleteScreen-ttlBar']/div[1]/div")
	public WebElement gw_SubmissionBound_PageHeader;

	@FindBy(xpath="//div[@id='JobComplete-JobWizardInfoBar-AccountNumber']/div[2]")
	public WebElement gw_AccountNumber_Text;

	@FindBy(xpath="//div[@id='JobComplete-JobWizardInfoBar-PolicyNumber']/div[2]")
	public WebElement gw_PolicyNumber_Text;

	@FindBy(xpath="//div[@id='JobComplete-JobCompleteScreen-JobCompleteDV-ViewPolicy']/div/div/div[2]")
	public WebElement gw_PolicyNumber_Link;

	@FindBy(xpath="//div[contains(@id,'ViewPolicy-inputEl')]")
	public WebElement ViewYourPolicy_Link;

	/**
	 * Function to returnpc_PolicyTransactions_Page the Account number or Policy number
	 * @param TypeOfValueToReturn
	 * @return
	 */
	public String GetAccountNumber_Text(String TypeOfValueToReturn) throws Exception{
		String ValueToReturn = null;
		WebElement XpathToUse = null;
			switch (TypeOfValueToReturn) {
			case "Account Number":
				XpathToUse = gw_AccountNumber_Text;
				break;

			case "Policy Number":
				XpathToUse = gw_PolicyNumber_Text;
				break;
			}
			
			for(int i=1; i<=60; i++) {
				try {
					ValueToReturn = XpathToUse.getText();
					test.info("The "+TypeOfValueToReturn+" of the issued policy is '"+ValueToReturn+"'.");
					break;
				}catch(Exception E) {
					Thread.sleep(1000);
				}
			}
		return ValueToReturn;

	}
	/**
	 * Function to click on the Policy number
	 * @throws InterruptedException 

	 */
	public void PolicyNumber_Click() throws InterruptedException {
			Click_On_Button("", gw_PolicyNumber_Link, "Clicked on the Policy number available on the top of the screen");
			Thread.sleep(5000);
	}
}
