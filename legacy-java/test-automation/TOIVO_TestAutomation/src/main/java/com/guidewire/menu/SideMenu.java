package com.guidewire.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.guidewire.config.CONSTANTS;
import com.guidewire.config.PC_MENU_CONSTANTS;

public class SideMenu {

	public WebDriver driver;
	public ExtentTest test;
	public ExtentReports extent;
	public Actions action;

	public SideMenu(WebDriver driver, ExtentTest test, ExtentReports extent){
		this.driver=driver;
		this.test=test;
		this.extent=extent;
	}

	@FindBy(xpath="//a[contains(@id, 'MenuActions')]")
	public WebElement  SideActionsMenu ;

	@FindBy(xpath="//div[@aria-label='Actions' and @role='button']/div[2]")
	public WebElement  gw_SideActionsMenu ;
	
	@FindBy(xpath="//div[text()='Next']")
	public WebElement Next_Button;
	
	String ActionMenuOption_Part1 = "//span[contains(@class, 'x-menu-item-text') and text()='";
	String gw_ActionMenuOption_Part1 = "//div[@id='ABContacts-ContactsMenuActions-ContactsMenuActions_";
	String gw_ActionMenuOption_Part = "//div[@class='gw-label' and @aria-label='";
	String gw_ActionMenu_Part1 = "//div[text()='";
	String SideMenuOption_Part1 = "//span[@class='x-tree-node-text ' and text()='";
	String gw_SideMenuOption_Part1a = "//div[@class='gw-subMenu gw-open']/descendant::div[text()='";
	String gw_SideMenuOption_Part1 = "//div[contains(@class,'MenuLink')]/div/descendant::div[text()='";
	String gw_General_Part2 = "MenuItem']";
	String gw_General_Part = "']";
	String gw_RightArrow_Part = "/../following-sibling::div[2]/div";
	String General_Part = "']";	
	String GenericSideMenuoption_Part1 = "//span[@unselectable='on' and text()='";
	String SideMenuoption_Part2 = "']";
	String gw_Common_Part1 ="//div[contains(@class,'gw-MenuItemWidget')]/div/descendant::div[text()='";
	String gw_Overlay_On_Click = "//div[@class='gw-click-overlay gw-disable-click']";

	/**
	 * Function to click side menu.
	 * @param SideMenuName - pass the side menu option. If more than one side menu needs to be clicked, than pass side menu option with colon separated. 
	 * @throws Exception 
	 */
	public void SideMenuClick(String SideMenuName) throws Exception{
		wait_For_Overlay(10);
		WebElement SideMenuName_WebElement;
		action = new Actions(driver);
		String[] SideMenuOptions = SideMenuName.split(":");
			for ( int i=0 ; i < SideMenuOptions.length ; i++){	 
				try {					
					driver.findElement(By.xpath(gw_SideMenuOption_Part1+SideMenuOptions[i]+General_Part)).click();
					test.info("Clicked on the '"+SideMenuOptions[i]+"' option.");
				}
				catch(Exception e) {
					driver.findElement(By.xpath(gw_SideMenuOption_Part1a+SideMenuOptions[i]+General_Part)).click();
					test.info("Clicked on the '"+SideMenuOptions[i]+"' option.");
				}
			}
	}


	/**
	 * Function to click Actions menu.
	 * @param SideMenuName - pass the side menu option. If more than one side menu needs to be clicked, than pass side menu option with colon separated. 
	 * @throws InterruptedException
	 */
	public void ActionsSideMenuClick(String MenuNameSelections) throws InterruptedException{
		String gw_FirstLevel = "";
		Thread.sleep(1000);
		gw_SideActionsMenu.click();

		test.log(Status.INFO, "Clicked 'Actions' menu at left hand top side.");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		Actions actions = new Actions(driver);
		String[] SideMenuOptions = MenuNameSelections.split(":");
		if(!CONSTANTS.getGW_VERSION().contentEquals("10")) {
			//Add code for GW version other than 10
		}
		for ( int i=0 ; i < SideMenuOptions.length ; i++){
			if ( i< SideMenuOptions.length -1 ){
				if(!CONSTANTS.getGW_VERSION().contentEquals("10")) {
					//Add code for GW version other than 10
				}else {
					if(SideMenuOptions[i].contains("#")) {
						String[] MultipleKeys = SideMenuOptions[i].split("#");
						Thread.sleep(1000);
						driver.findElement(By.xpath(gw_ActionMenuOption_Part+MultipleKeys[0]+gw_General_Part+gw_RightArrow_Part)).click();
						}else {
						try {
							executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(gw_ActionMenuOption_Part1+SideMenuOptions[i]+gw_General_Part2)));
							//						actions.moveToElement(driver.findElement(By.xpath(gw_ActionMenuOption_Part1+SideMenuOptions[i]+gw_General_Part2))).build().perform();
						}catch(Exception E) {
							driver.findElement(By.xpath(gw_ActionMenuOption_Part+SideMenuOptions[i]+gw_General_Part)).click();
							//Re-Click on the New Persion Option
							driver.findElement(By.xpath(gw_ActionMenuOption_Part+SideMenuOptions[i]+gw_General_Part)).click();
						}
					}
					test.log(Status.INFO, "Mouseover menu option '"+SideMenuOptions[i] + "'.");
				}
			} else {
				if(!CONSTANTS.getGW_VERSION().contentEquals("10")) {
					//Add code for GW version other than 10
				}else {
					//GW 10 Part
					try {
						System.out.println(SideMenuOptions[i]);
						driver.findElement(By.xpath(gw_Common_Part1+SideMenuOptions[i]+General_Part)).click();
					}catch(Exception e) {
						//						driver.findElement(By.linkText(SideMenuOptions[i])).click();						
						driver.findElement(By.xpath("//div[@id='Claim-ClaimMenuActions-ClaimFileMenuItemSet-ClaimMenuActions_ClaimActions-ClaimMenuActions_ClaimExposureValidation']/descendant::div[text()='Ability to pay']"));
					}
					test.log(Status.INFO, "Navigated to Actions-> "+ MenuNameSelections.replace(":", "->") );
				}
			}      
		}   
		if(SideMenuOptions[0].equals(PC_MENU_CONSTANTS.PC_ReWrite_NewTerm)||SideMenuOptions[0].equals(PC_MENU_CONSTANTS.PC_ReWrite_FullTerm)) {
		}
	}

	
	/**
	 * Function to click on New Submission tab on Actions menu.
	 * @param SideMenuName - pass the side menu option.
	 * @throws InterruptedException
	 */
	public void NewSubmissionActionsSideMenuClick(String MenuNameSelections) throws InterruptedException{
		Thread.sleep(500);
		if(!CONSTANTS.getGW_VERSION().contentEquals("10")) {
			//Add code for GW version other than 10
		}else {
			gw_SideActionsMenu.click();
			Thread.sleep(500);
			test.log(Status.INFO, "Clicked 'Actions' menu at left hand top side.");
			JavascriptExecutor executor = (JavascriptExecutor)driver;

			switch (MenuNameSelections) {
			case "New Su":
				driver.findElement(By.xpath(gw_ActionMenu_Part1+MenuNameSelections+General_Part)).click();;
				break;

			case "Issue Policy":
				driver.findElement(By.xpath("//div[text()='Issue Policy']")).click();;
				break;

			case "ncel Policy":
				driver.findElement(By.xpath("//div[text()='ncel Policy']")).click();;
				break;

			default:
				WebElement SideMenuName_WebElement = driver.findElement(By.xpath(gw_ActionMenuOption_Part1+MenuNameSelections+General_Part));
				executor.executeScript("arguments[0].click();", SideMenuName_WebElement);
				break;				
			}
		}
		}

	
	/**
	 * Generic function to perform JSExecutor/Actions/Ordinary click based on the param
	 * @param ClickType
	 * @param XpathToClick
	 * @param message
	 * @throws InterruptedException
	 */
	public void Click_On_Button(String ClickType, WebElement WebElementToClick, String... message) throws InterruptedException {
		Thread.sleep(500);
		Actions action = null;
		//Click on the element xpath based on the ClickType passed as param
		switch (ClickType) {
		case "javascript":
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", WebElementToClick);
			break;

		case "Actions":
			action = new Actions(driver);
			action.moveToElement(WebElementToClick).click().build().perform();  
			break;

		default:
			WebElementToClick.click();	
		}
		//if any message value is passed to the optional message param then log it
		if(message.length > 0) {
			test.info(message[0]);
		}
	}
	

	
	/**
	  * Function to wait for the Overlay load to complete during which the click is disabled
	  * @param SecondsToWait
	  * @throws Exception
	  */
	 public void wait_For_Overlay(int SecondsToWait) throws Exception{
		 for(int j=1; j<SecondsToWait; j++){
				if(isXpathExists(gw_Overlay_On_Click)) {
					Thread.sleep(1000);
				}else {
					break;
				}
			}
	 }
	 
	 
	 /**
	 * Function to check element is present or not
	 * @param xpathOfElement
	 * @return true - if xpath exists, false - if xpath does not exists.
	 */
	public boolean isXpathExists(String xpathOfElement) {
		try {
			driver.findElement(By.xpath(xpathOfElement));
			return true;
		} catch (NoSuchElementException e) {
			//	Reporter.log("NoAlertPresentException in WAS_GenericFunctions-->isXpathExists function " + e.getMessage());
			return false;
		}
	}


}
