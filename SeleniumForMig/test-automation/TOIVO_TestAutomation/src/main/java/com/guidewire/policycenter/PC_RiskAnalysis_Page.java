package com.guidewire.policycenter;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.guidewire.commonpagefunctions.PC_GenericFunctions;
import com.guidewire.config.CONSTANTS;

public class PC_RiskAnalysis_Page extends PC_GenericFunctions{

	public PC_RiskAnalysis_Page(WebDriver driver, ExtentTest test, ExtentReports extent) {
		super(driver, test, extent);
	}
	
	//Objects
	@FindBy(xpath="//span[text()='Risk Analysis' and contains(@id,'Job_RiskAnalysisScreen')]")
	public WebElement RiskAnalysis_Header;

	@FindBy(xpath="//div[@id='SubmissionWizard-Job_RiskAnalysisScreen-0']/div[1]/div")
	public WebElement gw_RiskAnalysis_Header;
	
	@FindBy(xpath="//div[contains(@id,'-Next')]/div")
	public WebElement gw_Next_Button;
	
 	/*
 	 * Function to Click on Next button
 	 */
 	public void NextButton_Click() throws InterruptedException {
 			Thread.sleep(1000);
 			Click_On_Button("", gw_Next_Button, "clicked on the Next button in Risk Analysis Page.");
 	}	
}
