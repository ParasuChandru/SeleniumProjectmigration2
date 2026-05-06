/**
 * An Empty page to navigate through configuration for all the centers
 */
package com.guidewire.commonpagefunctions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.guidewire.config.CONSTANTS;


public class MyActivities_Page extends GenericFunctions{

	// DO NOT DELETE THIS PAGE


	public MyActivities_Page(WebDriver driver, ExtentTest test, ExtentReports extent) {
		super(driver, test, extent);
	}

	//objects 
	@FindBy(xpath="//a[@id=':TabLinkMenuButton']")
	public WebElement SettingsLogo_Link;
	
	@FindBy(xpath="//div[@id='gw-TabBarWidget--settings']/div[1]/span")
	public WebElement gw_SettingsLogo_Link;

	@FindBy(xpath="//span[@id='TabBar:LogoutTabBarLink-textEl' or @id='InternalToolsTabBar:LogoutTabBarLink-textEl']")
	public WebElement Logout_Button;
	
	@FindBy(xpath="//div[contains(@id,'LogoutTabBarLink')]/div/div[2]")
	public WebElement gw_Logout_Button;

	@FindBy(xpath="//span[@id='Admin:CurrentDateInfoBar:CurrentDate-btnInnerEl']/span[2]")
	public WebElement CurrentApplicationDate_Date;
	
	@FindBy(xpath="//div[@id='Admin-CurrentDateInfoBar-CurrentDate']/div[2]")
	public WebElement gw_CurrentApplicationDate_Date;


	/**
	 * Logout function common to all the xCenters
	 * @throws InterruptedException
	 */
	public void Logout() throws InterruptedException {
		//Add code here to click Logout. Currently this feature is not working in application. Hence closing browser as temporary solution.
		Thread.sleep(500);
		if(!CONSTANTS.getGW_VERSION().contentEquals("10")) {
			//Add code for GW version other than 10

		}
		else {
			Thread.sleep(2000);
			Click_On_Button("", gw_SettingsLogo_Link, "Clicked on Settings->Log out");
			Click_On_Button("", gw_Logout_Button, "Browser closed. ");
			Thread.sleep(2000);

		}

	}


	//	public Date getStringToDateFormat(String StringDate) throws ParseException {
	//		DateFormat dateFormat = new SimpleDateFormat( "dd.MM.yyyy" );
	//		Calendar cal = Calendar.getInstance();
	//		cal.setTime( dateFormat.parse( StringDate ) );
	//		Date date = cal.getTime();
	//		return date;
	//	}

}
