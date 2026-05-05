package com.guidewire.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.guidewire.config.CONSTANTS;
import com.guidewire.config.PC_CONSTANTS;

public class PC_TopMenu {

	public WebDriver driver;
	public ExtentTest test;
	public ExtentReports extent;
	public Actions actions;


	public PC_TopMenu(WebDriver driver, ExtentTest test, ExtentReports extent){
		this.driver=driver;
		this.test=test;
		this.extent=extent;
	}

	@FindBy(xpath="//span[@id='TabBar:AccountTab-btnWrap']")
	public WebElement Account_Menu;

	@FindBy(xpath="//div[@id='TabBar-AccountTab']/div[3]/div")
	public WebElement gw_Account_Menu;	

	@FindBy(xpath="//span[@id='TabBar:AccountTab:AccountTab_NewAccount-textEl']")
	public WebElement NewAccount_Menu;

	@FindBy(xpath="//span[@id='TabBar:PolicyTab-btnWrap']")
	public WebElement Policy_Menu;

	@FindBy(xpath="//div[@id='TabBar-PolicyTab']/div[3]/div")
	public WebElement gw_Policy_Menu;

	@FindBy(xpath="//span[@id='TabBar:ContactTab-btnWrap']")
	public WebElement Contact_Menu;

	@FindBy(xpath="//div[@id='TabBar-ContactTab']/div[3]/div")
	public WebElement gw_Contact_Menu;

	@FindBy(xpath="//span[@id='TabBar:DesktopTab-btnWrap']")
	public WebElement Desktop_Menu;

	@FindBy(xpath="//div[@id='TabBar-DesktopTab']/div[3]/div")
	public WebElement gw_Desktop_Menu;

	@FindBy(xpath="//input[@id='TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl']")
	public WebElement SearchAccount_Input;

	@FindBy(xpath="//div[@id='TabBar-AccountTab-AccountTab_AccountNumberSearchItem']/div/input")
	public WebElement gw_account_Input;

	@FindBy(xpath="//span[@id='TabBar:SearchTab-btnWrap']")
	public WebElement Search_Menu;

	@FindBy(xpath="//div[@id='TabBar-SearchTab']/div[3]/div")
	public WebElement gw_Search_Menu;

	@FindBy(xpath="//span[@id='TabBar:TeamTab-btnInnerEl']")
	public WebElement Team_Menu;

	@FindBy(xpath="//span[@id='TabBar:AdminTab-btnWrap']")
	public WebElement Administration_Menu;

	@FindBy(xpath="//div[@id='TabBar-AdminTab']/div[3]/div")
	public WebElement gw_Administration_Menu;

	@FindBy(xpath="//span[@id='TabBar:SearchTab:Search_ContactSearch-textEl']")
	public WebElement Contacts_SearchmenuOption;

	@FindBy(xpath="//span[@id='TabBar:SalesEventsManagementTab-btnWrap']")
	public WebElement SalesEvent_Menu;

	@FindBy(xpath="//div[@id='TabBar-AdminTab']/div[3]/div")
	public WebElement gw_SalesEvent_Menu;

	@FindBy(xpath="//a[@id=':TabLinkMenuButton']")
	public WebElement SettingsLogo_Link;

	@FindBy(xpath="//div[@id='gw-TabBarWidget--settings']/div[1]/span")
	public WebElement gw_SettingsLogo_Link;

	@FindBy(xpath="//span[text()='OK']")
	public WebElement OK_UnsavedWork_Button;

	@FindBy(xpath="//span[@id='TabBar:LogoutTabBarLink-textEl' or @id='InternalToolsTabBar:LogoutTabBarLink-textEl']")
	public WebElement LogOut_Button;

	@FindBy(xpath="//div[@id='TabBar-LogoutTabBarLink']/div/div[2]")
	public WebElement gw_LogOut_Button;

	@FindBy(xpath="//label[contains(@id,'PolicyTab_PolicyRetrievalItem-labelEl')]/following-sibling::div[1]/descendant::input[1]")
	public WebElement Search_PolicyNum_Input;

	@FindBy(xpath="//div[@id='TabBar-PolicyTab-PolicyTab_PolicyRetrievalItem']/div/input")
	public WebElement gw_Search_PolicyNum_Input;

	@FindBy(xpath="//span[@id='TabBar:AccountTab-btnInnerEl']")
	public WebElement AccountTab_Click;

	@FindBy(xpath="//span[@id='CancellationWizard:CancellationWizardInfoBar:CancellationLabel-btnInnerEl']")
	public WebElement Cancellation_Status;

	@FindBy(xpath="//span[contains(@id,'JobLabel-btnInnerEl')]/span")
	public WebElement Submission_Status;
	
	@FindBy(xpath="//div[@id='TabBar-SalesEventsManagementTab']/div[3]/div")
	public WebElement gw_SalesEventManagement_Menu;
	
	@FindBy(xpath="//div[@id='TabBarWidget--more-options']/div[@role='button']")
	public WebElement gw_MoreOptions_Menu;

	//Account number Link
	@FindBy(xpath="//span[contains(@id,'AccountNumber-btnInnerEl')]/span[2]")
	public WebElement AccountNumber_Link;

	@FindBy(xpath="//div[@id='JobComplete-JobWizardInfoBar-AccountNumber']/div[2]")
	public WebElement gw_AccountNumber_Link;

	//Policy number link
	@FindBy(xpath="//span[contains(@id,'PolicyNumber-btnInnerEl')]/span[2]")
	public WebElement PolicyNumber_Link;

	@FindBy(xpath="//div[@id='JobComplete-JobWizardInfoBar-PolicyNumber']/div[2]")
	public WebElement gw_PolicyNumber_Link;


	//Pre Quote issues page
	@FindBy(xpath="//span[contains(@id,'PreQuoteIssueTitle')]")
	public WebElement PreQuoteIssues_Header;

	//Submission Number
	@FindBy(xpath="//input[contains(@id,'SubmissionNumberSearchItem-inputEl')]")
	public WebElement Search_SubmissionNumber_Input;

	@FindBy(xpath="//div[@id='TabBar-PolicyTab-PolicyTab_SubmissionNumberSearchItem']/div/input")
	public WebElement gw_Search_SubmissionNumber_Input;

	//	@FindBy(xpath="//span[@id='TabBar:LanguageTabBarLink-textEl']")
	@FindBy(xpath="//a[@id='TabBar:LanguageTabBarLink-itemEl']")
	public WebElement International_Link;
	//	String International_Link = "//span[@id='TabBar:LanguageTabBarLink-textEl']";

	@FindBy(xpath="//div[@id='TabBar-LanguageTabBarLink']/div[1]")
	public WebElement gw_International_Link;

	@FindBy(xpath="//span[@id='TabBar:LanguageTabBarLink:languageSwitcher-textEl']")
	public WebElement Language_Link;

	@FindBy(xpath="//div[@id='TabBar-LanguageTabBarLink-languageSwitcher']/div[1]/div")
	public WebElement gw_Language_Link;

	String Menuoption_Part1 = "//span[contains(@class, 'x-menu-item-text ') and text()='";
	String gw_Menuoption_Part1 = "//div[@class='gw-label'and text()='";
	String MenuOption2_Part1 = "//span[contains(@class, 'x-btn-inner x-btn-inner-gw-top-menu') and text()='";
	String Menuoption_Part2 = "']";

	String gw_RunBatch_Part1 = "//div[text()='";
	String gw_RunBatch_Part2 = "']/../../../../../../descendant::div[text()='Run']";

	public void ClickMenu(WebElement Menu){
		actions = new Actions(driver);
		actions.moveToElement(Menu, Menu.getSize().getWidth(), Menu.getSize().getHeight()).click().build().perform();
	}

	/**
	 * Function to click top level menu in Billing center
	 * @param TopMenuName - Pass name of the top menu as input parameter.
	 * @throws InterruptedException 
	 */
	public void ClickTopMenuOption(String TopMenuName) throws InterruptedException{
		actions = new Actions(driver);
		WebElement TopMenuName_WebElement= null;
			switch(TopMenuName){
			case "Account": 
				TopMenuName_WebElement = gw_Account_Menu;
				break;
			case "Administration" :
				TopMenuName_WebElement = gw_Administration_Menu;
				break;
			case "Search" :
				TopMenuName_WebElement = gw_Search_Menu;
				break;
			case "Contact" :
				TopMenuName_WebElement = gw_Contact_Menu;
				break;
			case "Policy":
				TopMenuName_WebElement = gw_Policy_Menu;
				break;
			case "Desktop":
				TopMenuName_WebElement = gw_Desktop_Menu;
				break;
			case "Sales Events":
				TopMenuName_WebElement = gw_SalesEvent_Menu;
				break;
			case "Sales Event Management":
				TopMenuName_WebElement = gw_SalesEventManagement_Menu;
				break;
			case "Three Line Menu":
				TopMenuName_WebElement = gw_MoreOptions_Menu;
				break;
				
			default:
				test.log(Status.FAIL, "The specified top menu option is not availabe in Billing Center");
			}
		Thread.sleep(1000);
		System.out.println("Run Time SYstem name:"+CONSTANTS.getCURRENT_SYSTEM_NAME());
		System.out.println("SAS system name:"+CONSTANTS.getSAS_SYSTEM_NAME());
		if(CONSTANTS.getCURRENT_SYSTEM_NAME().equalsIgnoreCase(CONSTANTS.getSAS_SYSTEM_NAME()) | CONSTANTS.getCURRENT_SYSTEM_NAME().contains("FI-VDI-W1")) {
			actions.moveToElement(TopMenuName_WebElement, TopMenuName_WebElement.getSize().getWidth()/2, TopMenuName_WebElement.getSize().getHeight()/2).click().build().perform();
		}else {
			//        	TopMenuName_WebElement.h
			for(int i=1; i<=5;i++) {
				if(isElementDisplayed(TopMenuName_WebElement)) {    // Chandra:- Added this if block to handle administration block click in BC
					actions.moveToElement(TopMenuName_WebElement, TopMenuName_WebElement.getSize().getWidth()/2, TopMenuName_WebElement.getSize().getHeight()/2).click().build().perform();
					break;
				}else {
					Thread.sleep(1000);
				}
			}
		}
		test.log(Status.INFO, "Clicked on top menu option '"+TopMenuName + "'.");
	}

	/**
	 * Function to select first level menu option
	 * @param FirstlevelMenuName  - Pass name of the first level menu option name
	 * @throws InterruptedException
	 */
	public void SelectFirstLevelMenuOption(String FirstlevelMenuName) throws InterruptedException{
		actions = new Actions(driver);
		WebElement FirstlevelMenuName_WebElement = null;
			if(!FirstlevelMenuName.equalsIgnoreCase("New Account")) {		//AK 10-01-2024 - this condition is added for GW version 10.2.3
				FirstlevelMenuName_WebElement = driver.findElement(By.xpath(gw_Menuoption_Part1+FirstlevelMenuName+Menuoption_Part2));
				actions.moveToElement(FirstlevelMenuName_WebElement).click().build().perform();
			}else {
				FirstlevelMenuName_WebElement = driver.findElement(By.xpath("//div[@class='gw-subMenu gw-open']/descendant::div[@class='gw-label' and text()='New Account']"));
				actions.moveToElement(FirstlevelMenuName_WebElement).click().build().perform();
			}
		Thread.sleep(1000);
		test.log(Status.INFO, "Clicked on first level menu option '"+FirstlevelMenuName + "'.");
	}

		public void SearchAccountNum(String AccountNum) throws InterruptedException{
		Thread.sleep(CONSTANTS.getSTATICWAITTIME());
			gw_account_Input.sendKeys(AccountNum+Keys.ENTER);
	}

	/**
	 * Function to Enter the Policy number in the Policy # field under Policy Top menu and hit 
	 * ENTER button
	 * @param PolicyNumber
	 * @throws InterruptedException
	 */
	public void SearchPolicyNumber(String PolicyNumber) throws InterruptedException {
			Thread.sleep(500);
			gw_Search_PolicyNum_Input.sendKeys(PolicyNumber+Keys.ENTER);
			test.info("Entered policy number '"+PolicyNumber+"' in Policy # text box and hit the ENTER key.");

	}

	/**
	 * Function to Verify if WebElement is present/displayed or not
	 * @param element
	 * @return
	 */
	public boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch(NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Function to logout from the application
	 * @throws InterruptedException 
	 */
	public void Logout() throws InterruptedException {
			try {
				Click_On_Button("", gw_SettingsLogo_Link);
				Click_On_Button("", gw_LogOut_Button, "Clicked on Settings->Log out");
			}catch(Exception E) {
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("window.scrollBy(0, -250);");
				Click_On_Button("", gw_SettingsLogo_Link);
				Click_On_Button("", gw_LogOut_Button, "Clicked on Settings->Log out");
			}
			test.log(Status.INFO, "Browser closed. " );

	}
	/**
	 * Function to Click on Account tab on the top menu
	 * ENTER button
	 * @param MenuName
	 */
	public void ClickOnAccountMenu() throws InterruptedException {
		Thread.sleep(500);
		AccountTab_Click.click();
		test.info("Clicked on the Account Tab.");
	}
	public void StatusVerification() throws InterruptedException {
		Thread.sleep(500);
		switch(Cancellation_Status.getText()) {

		case "Cancellation (Quoted)":
			test.info("Actual Policy status is '"+Cancellation_Status.getText()+ "'. Actual Policy Status is matches with the expected Policy status");
			break;

		default:
			test.info("Actual Policy status is '"+Cancellation_Status.getText()+ "'. Actual Policy Status is NOT matches with the expected Policy status");

		}

	}
	/**
	 * Function to Click on Account Number link on the top menu
	 */
	public void ClickOnAccountNumberLink() throws InterruptedException {
		Click_On_Button("", gw_AccountNumber_Link, "Clicked on the Account Number Link.");
	}
	
	/**
	 * Function to Enter the Submission number in the Submission # field under Policy Top menu and hit 
	 * ENTER button
	 * @param Submission Number
	 * @throws InterruptedException
	 */
	public void SearchSubmissionNumber(String SubmissionNumber) throws InterruptedException {
		gw_Search_SubmissionNumber_Input.sendKeys(SubmissionNumber+Keys.ENTER);
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
		if(message.length > 0) {
			test.info(message[0]);
		}
	}
	
	
}

