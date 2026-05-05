package com.guidewire.policycenter;
import java.text.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.guidewire.commonpagefunctions.PC_GenericFunctions;
import com.guidewire.config.CONSTANTS;
import com.guidewire.config.PC_CONSTANTS;


public class PC_CreateAccount_Page extends PC_GenericFunctions {
	public PC_CreateAccount_Page(WebDriver driver, ExtentTest test, ExtentReports extent) {
		super(driver, test, extent);
	}
	@FindBy(xpath="//span[@id='CreateAccount:CreateAccountScreen:ttlBar' or contains(@id,'ttlBar')]")	
	public WebElement CreateAccount_PageHeader;
	
	@FindBy(xpath="//div[@id='CreateAccountForContact-CreateAccountScreen-Update']/descendant::div[4]")	
	public WebElement gw_Update_Button;
	
	public void EnterHomeCompanyAndProducer(String HomeCompany, String Orgnization, String ProducerCode) throws InterruptedException, ParseException {
		
	}
	
	/**
	 * Function to click Update button
	 * @throws InterruptedException
	 */
	public void ClickUpdate() throws InterruptedException {
		if(!CONSTANTS.getGW_VERSION().contentEquals("10")) {
			//Add code for GW version other than 10
		}else {
			Generic_WaitForObject(gw_Update_Button, 5);
			gw_Update_Button.click();					
		}
		test.log(Status.INFO, "Clicked on 'Update' button");
		Thread.sleep(2000);
	}
	
}

