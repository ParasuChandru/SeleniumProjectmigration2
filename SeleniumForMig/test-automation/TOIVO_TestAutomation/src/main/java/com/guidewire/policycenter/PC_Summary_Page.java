/*************************************************************************************************************************************************************************
# Page	 Name			: Summary Page
# Description			: To write Summary page business functions and capture objects
#--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Author				Version		Creation/Modification Date		Reviewer Name			Reviewed Date		Comments 
#--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# Arijit Kumar			v0.1		9-Mar-2018																	New page																  
#**************************************************************************************************************************************************************************/

package com.guidewire.policycenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.guidewire.commonpagefunctions.PC_GenericFunctions;

public class PC_Summary_Page extends PC_GenericFunctions{

	public PC_Summary_Page(WebDriver driver, ExtentTest test, ExtentReports extent) {
		super(driver, test, extent);
	}
	
	//Objects
	@FindBy(xpath="//span[@id='PolicyFile_Summary:Policy_SummaryScreen:0']")
	public WebElement Summary_Header;
	
	@FindBy(xpath="//div[contains(@id,'Summary-ttlBar')]/div[1]/div")
	public WebElement gw_Summary_Header;
	
}
