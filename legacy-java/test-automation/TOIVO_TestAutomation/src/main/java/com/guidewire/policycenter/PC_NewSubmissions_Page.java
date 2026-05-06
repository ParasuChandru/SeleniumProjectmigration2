package com.guidewire.policycenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.guidewire.commonpagefunctions.PC_GenericFunctions;


public class PC_NewSubmissions_Page extends PC_GenericFunctions{

	public PC_NewSubmissions_Page(WebDriver driver, ExtentTest test, ExtentReports extent) {
		super(driver, test, extent);
	}

	PC_PolicyInfo_Page pc_PolicyInfo_Page;

	//Objects
	@FindBy(xpath="//span[@id='NewSubmission:NewSubmissionScreen:ttlBar']")
	public WebElement NewSubmission_Header;

	@FindBy(xpath="//div[@class='gw-TitleBar--title' and text()='New Submissions']")
	public WebElement gw_NewSubmission_Header;

	@FindBy(xpath="//a[@id='NewSubmission:NewSubmissionScreen:ProductOffersDV:ProductSelectionLV:0:addSubmission']")
	public WebElement Select_Button;

	String gw_InsuranceType_Part1 = "//td[2]/descendant::div[text()='";
	String gw_InsuranceType_Part2 = "']/ancestor::td/preceding-sibling::td/descendant::div[text()='Select']/..";

	
	/**
	 * Function to click on the Select button based on the Insurance type
	 * @param InsuranceType
	 * @throws InterruptedException 
	 */
	public void Click_SelectButton(String InsuranceType) throws InterruptedException {
		if(InsuranceType.contains("'")) {
			Click_On_Button("", ByXpathAction(gw_InsuranceType_Part1.replace("'", "\"")+InsuranceType+gw_InsuranceType_Part2.replace("'", "\"")), "Click done on the Select button for the Insurance Type:- '"+InsuranceType+"'.");
		}else {
			Click_On_Button("", ByXpathAction(gw_InsuranceType_Part1+InsuranceType+gw_InsuranceType_Part2), "Click done on the Select button for the Insurance Type:- '"+InsuranceType+"'.");
		}
	}
	}
