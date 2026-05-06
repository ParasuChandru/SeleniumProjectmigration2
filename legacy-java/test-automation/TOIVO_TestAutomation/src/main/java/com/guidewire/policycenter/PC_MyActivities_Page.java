package com.guidewire.policycenter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.guidewire.commonpagefunctions.PC_GenericFunctions;



public class PC_MyActivities_Page extends PC_GenericFunctions {
	public PC_MyActivities_Page(WebDriver driver, ExtentTest test, ExtentReports extent) {
		super(driver, test, extent);
	}
	PC_NewSubmissions_Page pc_NewSubmissions_Page;

	@FindBy(xpath="//span[@id='DesktopActivities:DesktopActivitiesScreen:0']")
	public WebElement MyActivities_Header;

	@FindBy(xpath="//div[@class='gw-TitleBar--title' and text()='My Activities']")
	public WebElement gw_MyActivities_Header;

	@FindBy(xpath="//div[@class='gw-TitleBar--title' and text()='My Summary']")
	public WebElement gw_MySummary_Header;
		
}


