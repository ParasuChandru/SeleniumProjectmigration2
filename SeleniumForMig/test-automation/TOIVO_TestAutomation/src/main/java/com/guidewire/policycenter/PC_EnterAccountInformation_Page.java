package com.guidewire.policycenter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.guidewire.commonpagefunctions.PC_GenericFunctions;

public class PC_EnterAccountInformation_Page extends PC_GenericFunctions {
	public PC_EnterAccountInformation_Page(WebDriver driver, ExtentTest test, ExtentReports extent) {
		super(driver, test, extent);
	}
	
	@FindBy(xpath="//span[@id='NewAccount:NewAccountScreen:ttlBar']")
	public WebElement EnterAccountInformation_PageHeader;
		
	@FindBy(xpath="//input[@name='NewAccount-NewAccountScreen-NewAccountSearchDV-GlobalPersonNameInputSet-FirstName']")
	public WebElement gw_FirstName_Textbox;
	
	@FindBy(xpath="//input[@name='NewAccount-NewAccountScreen-NewAccountSearchDV-GlobalPersonNameInputSet-LastName']")
	public WebElement gw_LastName_Textbox;	
		
	@FindBy(xpath="//a[@id='NewAccount:NewAccountScreen:NewAccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search']")
	public WebElement Search_Button;
	
	@FindBy(xpath="//div[@id='NewAccount-NewAccountScreen-NewAccountButton']/div[1]")
	public WebElement gw_CreateNewAccount_Button;
	
	@FindBy(xpath="//span[text()='Company name']/../following-sibling::div/descendant::input[1]")
	public WebElement CompanyName_Textbox;
	
	@FindBy(xpath="//div[text()='Type']/following-sibling::div[1]/descendant::select")
	public WebElement gw_Type_Dropdown;
	
	@FindBy(xpath = "//div[text()='EID']/following-sibling::div[1]/descendant::input")
	public WebElement gw_EID_TextField;
		
	@FindBy(xpath = "//div[contains(@id,'SearchLinksInputSet-Search')]")
	public WebElement gw_Search_AddressBook_Button;
	
	String General_Part2= "']";
	String gw_AccountType_Menu_Part1= "//div[@class='gw-label' and text()='";
	String ContactsSearch_rows = "//div[contains(@id,'ContactSearchResultsLV-body')]/descendant::tr";
	String gw_ContactsSearch_rows = "//div[contains(@id,'ContactSearchResultsLV')]/descendant::tr";
	String EIDContactsSearch_Part1 = "]/td[3]/descendant::div[4]";
	String Generic_Part = "[";
	String Select_Button = "]/td[1]/div/a";
	String gw_Select_Button = "]/td[1]/descendant::div[text()='Select']";
	String SearchAccount_Rows = "//div[contains(@id,'NewAccountSearchResultsLV-body')]/descendant::tr";
	String gw_SearchAccount_Rows = "//div[@id='NewAccount-NewAccountScreen-6']/div/descendant::tr";
	String gw_Search_Button="//div[@id='NewAccount-NewAccountScreen-NewAccountSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search']";
	/**
	 * Function to search for account holder or Company
	 * @param FirstName
	 * @param LastName
	 * @param CompanyDetails - Optional Parameter
	 * @throws Exception
	 */
	public void SearchAccountHolder(String FirstName, String LastName, String...CompanyDetails) throws Exception{
		if(!(CompanyDetails.length>0)) {
				gw_FirstName_Textbox.sendKeys(FirstName);
				test.log(Status.INFO, "Entered  First name as : "+FirstName);
				gw_LastName_Textbox.sendKeys(LastName);
				test.log(Status.INFO, "Entered  Last name as : "+LastName);
				Generic_WaitForObject(ByXpathAction(gw_Search_Button), 5);
				for(int i=0;i<5;i++) {
					if(isXpathExists(gw_Search_Button)) {
						Click_On_Button("", ByXpathAction(gw_Search_Button), "Clicked 'Search' button");
						break;
					}else {
						Thread.sleep(1000);
					}
				}
		} else {
			EnterInputValue(CompanyName_Textbox, CompanyDetails[0], "Entered the Company Name as '"+CompanyDetails[0]+"'.");
			Click_On_Button("", Search_Button, "Clicked Search Button.");
		}
	}
	
	public void CreateNewAccount(String AccountType) throws InterruptedException {
			Generic_WaitForObject(gw_CreateNewAccount_Button, 5);
			Click_On_Button("", gw_CreateNewAccount_Button);
			test.log(Status.INFO, "Clicked 'Create New Account' button");
			Generic_WaitForObject(ByXpathAction(gw_AccountType_Menu_Part1+AccountType+General_Part2), 5);
	  		Click_On_Button("", ByXpathAction(gw_AccountType_Menu_Part1+AccountType+General_Part2), "Selected the '"+AccountType+ "' option from 'Create New Account' menu.");
	}
	
	/**
	 * Function to Search for the contact in the Address Book Page under Enter Account Details Page 
	 * @param Type
	 * @param EID
	 * @throws Exception 
	 */
	public void SearchAddressBook(String Type, String EID) throws Exception {
		Thread.sleep(1500);
		int TotalRows = 0;
			Generic_WaitForObject(gw_Type_Dropdown, 5);
			SelectDropdownOption(gw_Type_Dropdown, Type, "Selected the Type value as '"+Type+"'.");
			Generic_WaitForObject(gw_EID_TextField, 5);
			EnterInputValue(gw_EID_TextField, EID, "EID value has been entered as '"+EID+"' in Search Address Book Page.");
	
				Generic_WaitForObject(gw_Search_AddressBook_Button, 5);
				Click_On_Button("", gw_Search_AddressBook_Button,"Clicked the Search button in Search Address Book Page.");
			for(int i=1; i<31; i++) {
		    	if( isXpathExists(gw_ContactsSearch_rows)) {
		    		break;
		    	}else {
		    		Thread.sleep(1000);
		    	}
		    }
			for(int i=1; i<=4; i++) {
				TotalRows = driver.findElements(By.xpath(gw_ContactsSearch_rows)).size();
				System.out.println("End Time "+ProvidePastCurrentOrFutureDate("HH:mm:ss", 0));
				if(TotalRows>1) {
					break;
				}else {
					wait_For_Overlay(3);
					Thread.sleep(1000);
				}
			}
			for(int i=2; i<=TotalRows; i++) {
				if(EID.contains(ByXpathAction(gw_ContactsSearch_rows+Generic_Part+i+EIDContactsSearch_Part1).getText())) {
					Click_On_Button("",ByXpathAction(gw_ContactsSearch_rows+Generic_Part+i+gw_Select_Button),"Clicked on the select button in Search Address Book Page.");
					break;
				}else {
					Thread.sleep(1000);
				}
			}
	}
}
