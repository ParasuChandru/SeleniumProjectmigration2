package com.guidewire.policycenter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.guidewire.commonpagefunctions.PC_GenericFunctions;

public class PC_AccountFileSummary_Page extends PC_GenericFunctions {
	public PC_AccountFileSummary_Page(WebDriver driver, ExtentTest test, ExtentReports extent) {
		super(driver, test, extent);
	}

	
	@FindBy(xpath="//span[@id='AccountFile_Summary:AccountFile_SummaryScreen:ttlBar']")
	public WebElement AccountFileSummary_PageHeader;
	
	@FindBy(xpath="//div[@id='AccountFile_Summary-ttlBar']/div[1]/div")
	public WebElement gw_AccountFileSummary_PageHeader;
	
}
