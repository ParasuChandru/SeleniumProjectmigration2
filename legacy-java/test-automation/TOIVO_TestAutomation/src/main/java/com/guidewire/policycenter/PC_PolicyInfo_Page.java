package com.guidewire.policycenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.guidewire.commonpagefunctions.PC_GenericFunctions;

public class PC_PolicyInfo_Page extends PC_GenericFunctions{

	public PC_PolicyInfo_Page(WebDriver driver, ExtentTest test, ExtentReports extent) {
		super(driver, test, extent);
	}

	@FindBy(xpath="//div[@class='gw-TitleBar--title' and text()='Policy Info']")
	public WebElement gw_PolicyInfo_Header;

	@FindBy(xpath="//div[@class='gw-label' and text()='Next']")
	public WebElement gw_Next_Submission_Button;

	@FindBy(xpath="//div[contains(@id,'PrimarySalesperson-SelectPrimarySalesperson')]")
	public WebElement gw_SalesPersonSearch_Icon;

	@FindBy(xpath="//input[contains(@name,'SalespersonSearchDV-SalesPersonID')]")
	public WebElement gw_SalesPersonId_Input;

	@FindBy(xpath="//div[@id='SalespersonSearch_LTPopup-SalespersonSearchDV-Search']")
	public WebElement gw_SalesPersonSearch_Button;	

	@FindBy(xpath="//div[@class='gw-label' and text()='Select']")
	public WebElement gw_SalesPersonSelect_Button;


	/**
	 * Function to click on the Next/Submission button in Policy Info Page
	 * @throws Exception 
	 */
	public void Click_Next_Submission_Button(String Company) throws Exception {
			//Adding Sales person details
			Click_On_Button("", gw_SalesPersonSearch_Icon, "Clicked on the Sales Person Search Icon");
			wait_For_Overlay(1);
			Generic_WaitForObject(gw_SalesPersonId_Input, 5);
			EnterInputValue(gw_SalesPersonId_Input, "03984Q", "SalesPerson ID");
			Click_On_Button("",gw_SalesPersonSearch_Button,"Clicked on the Sales Person Search Button");
			wait_For_Overlay(1);
			Click_On_Button("", gw_SalesPersonSelect_Button,"Clicked on the Select button.");
			wait_For_Overlay(1);
			Click_On_Button("", gw_Next_Submission_Button, "Click done on the Next/Submission button in Policy Info Page.");
		}
}
