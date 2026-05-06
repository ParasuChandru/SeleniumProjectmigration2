package com.guidewire.policycenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.guidewire.commonpagefunctions.PC_GenericFunctions;

public class PC_PolicyReview_Page extends PC_GenericFunctions{

	public PC_PolicyReview_Page(WebDriver driver, ExtentTest test, ExtentReports extent) {
		super(driver, test, extent);
	}
	
	//Objects
	@FindBy(xpath="//span[contains(@id,'Screen:ttlBar')]")
	public WebElement PolicyReview_Header;
	
	@FindBy(xpath="//div[@id='SubmissionWizard-SubmissionWizard_PolicyReviewScreen-ttlBar']/div[1]/div")
	public WebElement gw_PolicyReview_Header;
	
	@FindBy(xpath="//div[contains(@id,'ToolbarButtonSet-QuoteTypeToolbarButtonSet-Rate')]/div")
	public WebElement gw_Rate_Button;
	
	
	 	/*
	 	 * Function to Click on Rate button
	 	 */
	 	public void RateButton_Click() throws Exception {
	 		Click_On_Button("", gw_Rate_Button, "clicked on the Rate button in Risk Analysis Page.");
	 		wait_For_Overlay(5);
	 	}
	 
}
