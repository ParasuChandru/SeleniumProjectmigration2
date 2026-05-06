package com.guidewire.commonpagefunctions;

import org.testng.Assert;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.guidewire.config.ADDRESS_DATASHEET_CONSTANTS;
import com.guidewire.config.CC_CONSTANTS;
import com.guidewire.config.CONSTANTS;
import com.guidewire.config.DB_CONSTANTS;
import com.guidewire.config.PC_CONSTANTS;
import com.guidewire.menu.SideMenu;
import com.guidewire.utilities.DataBaseUtilities;
import com.guidewire.utilities.DbConnecton;
import com.guidewire.utilities.Keyboard;

import junit.framework.AssertionFailedError;

//HTTP requests
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost; 
import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
//import java.io.IOException;
import org.apache.http.util.EntityUtils;

public class GenericFunctions{

	public WebDriver driver;
	public ExtentTest test;
	public ExtentReports extent;
	public Alert alert;
	public SideMenu sideMenu;
	public Actions actions;

	public GenericFunctions(WebDriver driver, ExtentTest test, ExtentReports extent){
		this.driver=driver;
		this.test=test;
		this.extent=extent;

		sideMenu = new SideMenu(driver, test, extent);
		PageFactory.initElements(driver, sideMenu);
	}

	String DropDown_Part1 = "//li[contains(@class,'x-boundlist-item') and text()='";
	String DropDown_Part2 = "']";

	public String Generic_DropdownOption_Part1= "//li[text()='";
	public String Generic_General_Part2 = "']";

	public String EffectiveDate = "";
	
	//****   Generic Xpath Parts ****
	String DropDown_Input_Part1 = "//span[text()=\"";
	String gw_DropDown_Input_Part1 = "//div[text()=\"";
	String gw_DropDown_Input_Part3TL = "\"]/following-sibling::div[1]/descendant::select";

	public String gw_LabelData_Part1 = "//div[text()='";
	String gw_LabelData_PartQ = "(//div[text()='";
	String gw_LabelData_Part1A = "' or contains(text(),'";
	String gw_LabelData_Part1B = "')]/../div[2]/descendant::select";
	
	String gw_GenericLabel_Part2 = "']/following-sibling::div/div[1]";
	String gw_GenericLabel_petHealthDecPart2="')]/ancestor::td/following-sibling::td/descendant::div[2]";
	String gw_GenericLabel_petHealthDecPartQa = "')]/ancestor::td/following-sibling::td/descendant::div[2])[2]";
	String gw_GenericLabel_Optional = "/div[1]";
	String gw_Select_Part = "')]/following-sibling::div/descendant::select";
	String gw_TextBox_Part = "')]/following-sibling::div/descendant::input";
	String gw_TextArea_Part = "')]/following-sibling::div/descendant::textarea";
	
	String gw_RadioButton_Input_Part1 = "//div[text()='";
	
	String gw_RadioButton_Input_Part3 = "')]/following-sibling::div/descendant::span[contains(text(),'";
	
	String gw_RadioButton_Input_Part4 = "')]";
	String gw_Generic_Part = "']";
	
	public String gw_PP_Part1 = "//div[contains(@id,'";
	String gw_PP_Part2 = "')]/div/div/select";

	String gw_MultiSelect_Link_Part1 = "//div[text()=\"";
	String gw_MultiSelect_Link_Part2 = "\" or contains(text(),\"";
	String gw_MultiSelect_Link_Part3 = "\")]/../div[2]/descendant::option[text()=\"";
	String gw_MultiSelect_Link_Part4 = "\"]";
	String gw_Overlay_On_Click = "//div[contains(@class,'gw-click-overlay')]";
	

	public SideMenu get_sideMenu(){
		return sideMenu;
	}

	/**
	 * Function to verify the actual text with expected text.
	 * @param ActualText       - pass the actual text ( using WebElement.getText() ) from the respective page.
	 * @param ExpectedText	   - pass the expected text from constants file
	 * @param FieldType		   - pass the type of the field from the calling scripts. e.g. Header name, Sub-header name, Section name, text, label, Account number ...etc.
	 * @param CustomizedMessage- Pass customized message. But make sure that to pass FieldType as empty to report customized message. If you doesn't want to print customized message, than pass this paramater as empty.
	 * Note : if you want to report both standard and customizedd 
	 */
	public void Verify(String ActualText, String ExpectedText, String FieldType, String... CustomizedMessage ){
		String MessageToBeDisplayed = "The actual "+FieldType+" '"+ActualText+"' is matched with expected "+FieldType+" '"+ExpectedText+"'.";
		if( ! FieldType.isEmpty() & CustomizedMessage.length == 0)
			assertEquals(ExpectedText, ActualText,  MessageToBeDisplayed );
		else if (FieldType.isEmpty() & CustomizedMessage.length > 0 )
			assertEquals(ExpectedText, ActualText, CustomizedMessage[0]);
		else
			assertEquals(ExpectedText, ActualText, CustomizedMessage[0]+" "+MessageToBeDisplayed);

	}
	/**
	 * Calling TestNG verification for failure condition, which will in turn write log in extent 
	 * @param message
	 */
	public void testfail(String message ) {
		Assert.fail(message);
	}
	/**
	 * Calling TestNG verification for success/pass condition, which will in turn write log in extent 
	 * @param message
	 */
	public void testpass(String message) {
		assertEquals(true, true, message);
	}
	/**
	 * AssertEquals function is used to verify the expected and actual value
	 * @param expected value needs to be passed
	 * @param actual value retreived from the application
	 * @param message to be logged if the match is true
	 */
	public  void assertEquals(Object expected, Object actual,String message) {
		if (expected == null && actual == null) {
			test.log(Status.FAIL, "Expected and Actual values are NULL");
			Reporter.log("Expected and Actual values are NULL", false);//ExtentManager.extent.setTestRunnerOutput("Expected and Actual values are NULL"); 
			return;
		}
		if (expected != null && expected.equals(actual)) {
			test.log(Status.PASS, message);
			Reporter.log(message);//ExtentManager.extent.setTestRunnerOutput(message); 
			return;
		} else{
			Reporter.log("Expected Result: '" + expected + "' does NOT match with Actual Result: '" + actual + "' .");
			extent.setTestRunnerOutput("Expected Result: '" + expected + "' does NOT match with Actual Result: '" + actual + "' .");
			//test.log(Status.FAIL, "Expected Result: '" + expected + "' does NOT match with Actual Result: '" + actual + "' .");
			//	Reporter.log("Error Snapshot is Located in : " + CONSTANTS.TESTREPORTPATH + getApplicationName + CONSTANTS.fs+ Captialize(RunOnBrowser) + "_" + CurrentRunningTCName + CONSTANTS.DateFormat + ".jpg");
			Assert.fail(format("", expected, actual));
		}
	}

	/**
	 * Sub to check Assertion failure messages
	 * @param message
	 */
	public void fail(String message) {
		if (message == null) {
			throw new AssertionFailedError();
		}
		throw new AssertionFailedError(message);
	}

	/**
	 * Sub to report the issue in the required formatted text
	 * @param message
	 * @param expected
	 * @param actual
	 * @return
	 */
	public  String format(String message, Object expected, Object actual) {
		String formatted = "The Expected Outcome is not matched with Actual Outcome.\n";
		if (message != null && message.length() > 0) {
			formatted = message + "  ";
		}
		System.out.println(formatted + "Expected :'" + expected + "' but Actual is:'" + actual + "'");
		return formatted + "Expected : '" + expected + "',  but Actual is: '" + actual + "'.";
	}


	/**
	 * Function to check whether element is present or not
	 * @param WebElementName
	 * @return
	 */
	public boolean isWebElementPresent(WebElement WebElementName){
		try {
			WebElementName.isDisplayed();
			return true;
		}catch (NoSuchElementException e){
			Reporter.log("Exception in GenericFunctions-->isWebElementPresent function " + e.getMessage());
			return false;
		}
	}


	/**
	 * Function to wait for an element and find for 30 seconds
	 * @param WebElementName
	 * @return true or false
	 * @throws NoSuchElementException
	 */
	public boolean WaitForElement(WebElement WebElementName)  
	{
		try {
			WebDriverWait wait= new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(WebElementName));
			return true;
		} catch (NoSuchElementException e)  { //NoSuchElementException , TimeOutException has to be captured here
			Reporter.log("Exception in GenericFunctions-->WaitForElement function " + e.getMessage());
			return false;
		}		
	}


	/**
	 * To generate 5 digit random number.
	 * @return 5 digit random number
	 */
	public int RandomNumGenerator() {
		Random r = new Random(); //add the System.currentTimeMillis() inside the random constructor based on timestamp
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}

	/**
	 * @return The calculated date required 
	 * @param ValidDateFormat - Valid Date format could be for eg: dd.MM.yyyy,..etc
	 * @param dateRequired - dateRequired field will take 0 for current date, positive number(1,2,..) for future date and negative number for Past dates 
	 */
	@SuppressWarnings("static-access")
	public String ProvidePastCurrentOrFutureDate(String ValidDateFormat, int dateRequired){

		//Declarations
		Date today = new Date();
		DateFormat dateformat = new SimpleDateFormat(ValidDateFormat); 	//Valid Date format could be for eg: dd.MM.yyyy,..etc
		Calendar cal = new GregorianCalendar();	 //Create a calender class to be instanciated

		//Calculating date
		cal.setTime(today);
		cal.add(cal.DAY_OF_MONTH, dateRequired);	//dateRequired field will take 0 for current date, positive number(1,2,..) for future date and negative number for Past dates 
		Date Past_Date1 = cal.getTime();  

		//Return the calculated date
		return dateformat.format(Past_Date1);
	}


	/**
	 * Function to return the integer number based on current date.... If you pass current date, it will return 0. similarly,
	 * for future dates +ve number and for backward dates -ve will be returned with reference to current date.
	 * @param ValidDateFormat
	 * @param DateNeedstobeConverted
	 * @return
	 * @throws ParseException
	 */
	public int ConvertDateIntoNumberBasedonCurrentDate(String ValidDateFormat, String DateNeedstobeConverted) throws ParseException {
		//Get the todays date and convert it into the number
		Date today = new Date();
		DateFormat dateformat = new SimpleDateFormat(ValidDateFormat); 	//Valid Date format could be for eg: dd.MM.yyyy,..etc
		Calendar cal = new GregorianCalendar();	 //Create a calendar class to be instantiated
		cal.setTime(today); //Calculating date
		Date Past_Date1 = cal.getTime();
		String todayDate=  dateformat.format(Past_Date1);
		Date todayDate1 = dateformat.parse(todayDate);
		int TodayDayNumber = (int) (todayDate1.getTime() / (24 * 60 * 60 * 1000));


		//Calculate Daynumber for required date
		Date date = dateformat.parse(DateNeedstobeConverted);
		int DayNumber = (int) (date.getTime() / (24 * 60 * 60 * 1000));

		int Days= DayNumber - TodayDayNumber;
		return Days;

	}


	/**
	 * Function to check element is present or not
	 * @param xpathOfElement
	 * @return true - if xpath exists, false - if xpath does not exists.
	 */
	public boolean isXpathExists(String xpathOfElement) {
		List<WebElement> list = driver.findElements(By.xpath(xpathOfElement));
		if(!list.isEmpty()) {
			return true;
		}else {
			return false;
		}
//		try {
//			driver.findElement(By.xpath(xpathOfElement));
//			return true;
//		} catch (NoSuchElementException e) {
//			//	Reporter.log("NoAlertPresentException in WAS_GenericFunctions-->isXpathExists function " + e.getMessage());
//			return false;
//		}
	}

	/**
	 * Function to perform Xpath Action for a property is passed
	 * @param PropertyToSearch
	 * @return
	 */
	public  WebElement ByXpathAction(String PropertyToSearch){		
		return driver.findElement(By.xpath(PropertyToSearch)); 
	}


	/**
	 * Sub to check if an alert is present
	 * @return
	 */
	public boolean isAlertPresent() {
		try {
			alert = driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			Reporter.log("NoAlertPresentException in GenericFunctions-->isAlertPresent function " + e.getMessage());
			throw e;
		}
	}



	/**
	 * Sub to return the text message displayed on alert and close the alert by accepting or dismissing it as value set for parameter for CONSTANTS.ACCEPTNEXTALERT using setACCEPTNEXTALERT setter.  
	 * NOTE: Before calling this function , the function isAlertPresent() needs to be called to verify whether alert is displayed or not.
	 * @return
	 */
	public String closeAlertAndGetItsText() {
		String alertText= alert.getText();
		if (CONSTANTS.isACCEPTNEXTALERT()) {
			alert.accept();
		} else {
			alert.dismiss();
		}
		return alertText;
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
	 * Sub to Extract Numbers from the string passed as parameter
	 * @param x
	 * @return
	 */
	public int num_extract(String x) {
		String Number= x.replaceAll("\\D+", "").trim();
		return Integer.parseInt(Number);
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

	/*
	 * Function select the dropdown options by passing 'Webelement' and available dropdown option
	 */

	public void SelectDropdownOption(WebElement WebElementOfDropdownBox, String OptionToBeSelected, String... NameOfdropdown) throws InterruptedException {
		Thread.sleep(500);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		String ContentType = " ";
		try {
			if (! WebElementOfDropdownBox.getAttribute("value").equalsIgnoreCase(OptionToBeSelected)) {

				Click_On_Button("javascript", WebElementOfDropdownBox);
				ContentType = Generic_DropdownOption_Part1+OptionToBeSelected+Generic_General_Part2;
				if ( ! WaitForElement(driver.findElement(By.xpath(ContentType)))){
					Click_On_Button("javascript", WebElementOfDropdownBox);
				}				
				executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(ContentType)));
				if(NameOfdropdown.length>0) {
					test.log(Status.INFO, "The Dropdown '"+NameOfdropdown[0]+"' value is selected as '"+OptionToBeSelected+"'.");
				}else {
					test.info("The dropdown value is selected as '"+OptionToBeSelected+"'.");
				}
			}else {
				if(NameOfdropdown.length>0) {
					test.log(Status.INFO, "The Dropdown '"+NameOfdropdown[0]+"' value populated with default value as  '"+OptionToBeSelected+"'.");
				}
				else {                                     
					test.info("The dropdown is populated with default value as : "+ OptionToBeSelected );
				}
			}
		}catch (Exception e) {
			if (WebElementOfDropdownBox.getAttribute("value")==null) {
				Click_On_Button("javascript", WebElementOfDropdownBox);                                                     
				Thread.sleep(500);
				ContentType = Generic_DropdownOption_Part1+OptionToBeSelected+Generic_General_Part2;
				if ( ! WaitForElement(driver.findElement(By.xpath(ContentType)))){
					Click_On_Button("javascript", WebElementOfDropdownBox);
				}	
				executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(ContentType)));
				if(NameOfdropdown.length>0) {
					test.log(Status.INFO, "The Dropdown '"+NameOfdropdown[0]+"' value is selected as '"+OptionToBeSelected+"'.");
				}else {
					test.info("The dropdown value is selected as '"+OptionToBeSelected+"'.");
				}

			}else {
				if(NameOfdropdown.length>0) {
					test.log(Status.INFO, "The Dropdown '"+NameOfdropdown[0]+"' value is selected as '"+OptionToBeSelected+"'.");
				}
				else {                                     
					test.info("The dropdown is populated with default value as : "+ OptionToBeSelected );
				}
			}
		}

	}


	/**
	 * Generic Function to select an option from the dropdown based on the dropdown label name and option passed as param
	 * @param LabelOfDropDown
	 * @param DropDownOption
	 * @throws Exception 
	 */
	public String  Select_FromDropDown(String LabelOfDropDown, String DropDownOption) throws Exception {		
		String SelectedValue = "";
		if(!CONSTANTS.getGW_VERSION().equalsIgnoreCase("10")) {
			// Other than guidewire 10 code 
		}else {
			if (DropDownOption.equalsIgnoreCase(ADDRESS_DATASHEET_CONSTANTS.POLICYHOLDER_NAME) ) {
				DropDownOption = CONSTANTS.getPOLICY_HOLDER_NAME();
			}
			if(LabelOfDropDown.contains("'")) {
				Select_UsingXpath(gw_DropDown_Input_Part1.replace("'", "\"")+LabelOfDropDown+gw_DropDown_Input_Part3TL.replace("'", "\""), DropDownOption);
			}else {
				SelectedValue = Select_dropDown(LabelOfDropDown, DropDownOption);
			}
		}
		return SelectedValue;
	}

	/**
	 * Generic Function to select/enter data for fields of type textbox, dropdown, radio and calendar.
	 * @param RuleLabel
	 * @throws Exception 
	 */
	public void testlabels(String RuleNum, String RuleLabel) throws Exception {
		String FieldType = "";
		if(!CONSTANTS.getGW_VERSION().contentEquals("10")) {
			//Add code for GW version other than 10

		}else {
			String[] SplitFieldsGroup = RuleLabel.split("\n");
			for ( int i =0 ; i < SplitFieldsGroup.length ; i++)	{	
				String[] FieldsLabelAndData = SplitFieldsGroup[i].split(":-");
				Thread.sleep(500);
				if(FieldsLabelAndData[0].contains("'")) {
					FieldType = ByXpathAction(gw_LabelData_Part1.replace("'", "\"")+FieldsLabelAndData[0]+gw_GenericLabel_Part2.replace("'", "\"")).getAttribute("data-gw-getset");
				}else {
					FieldType = ByXpathAction(gw_LabelData_Part1+FieldsLabelAndData[0]+gw_GenericLabel_Part2).getAttribute("data-gw-getset");
				}
				if(FieldType == null) {
					if( FieldsLabelAndData[0].contains("'")) {
						FieldType = ByXpathAction(gw_LabelData_Part1.replace("'", "\"")+FieldsLabelAndData[0]+gw_GenericLabel_Part2.replace("'", "\"")+gw_GenericLabel_Optional).getAttribute("data-gw-getset");
					}else {						
						FieldType = ByXpathAction(gw_LabelData_Part1+FieldsLabelAndData[0]+gw_GenericLabel_Part2+gw_GenericLabel_Optional).getAttribute("data-gw-getset");
					}
				}
				switch (FieldType){

				case "select" :
					Select_FromDropDown(FieldsLabelAndData[0],FieldsLabelAndData[1] );
					break;

				case "text" :	/*** Enter value for TextBox or TextArea ***/
					String Input_TextDate = FieldsLabelAndData[1];

					if(isXpathExists(gw_LabelData_Part1.replace("'", "\"")+FieldsLabelAndData[0]+gw_LabelData_Part1A.replace("'", "\"")+FieldsLabelAndData[0]+gw_TextBox_Part.replace("'", "\""))) {
						EnterInputValue(ByXpathAction(gw_LabelData_Part1.replace("'", "\"")+FieldsLabelAndData[0]+gw_LabelData_Part1A.replace("'", "\"")+FieldsLabelAndData[0]+gw_TextBox_Part.replace("'", "\"")), Input_TextDate);
					}else {
						EnterInputValue(ByXpathAction(gw_LabelData_Part1+FieldsLabelAndData[0]+gw_LabelData_Part1A+FieldsLabelAndData[0]+gw_TextArea_Part), Input_TextDate);
					}
					test.info(RuleNum +" :Entered the value '"+Input_TextDate+"' in the field '"+FieldsLabelAndData[0]+"'.");
					break;


				case "radio" :
					String RadioButtonToSelect = "";
					if (FieldsLabelAndData[1].equalsIgnoreCase("Yes")) {
						RadioButtonToSelect = "Yes";
					}else if (FieldsLabelAndData[1].equalsIgnoreCase("No")){
						RadioButtonToSelect = "No";
					}else if (FieldsLabelAndData[1].equalsIgnoreCase("Not known")){
						RadioButtonToSelect = "Not known";
					}

					//Click on the radio button based on the label 
					//ByXpathAction(RadioButton_Input_Part1+FieldsLabelAndData[0]+RadioButton_Input_Part2+FieldsLabelAndData[0]+RadioButton_Input_Part3+RadioButtonToSelect+RadioButton_Input_Part4).click();
					WebElement Radiobutton = null;
					if(FieldsLabelAndData[0].contains("'")) {
						Radiobutton = ByXpathAction(gw_RadioButton_Input_Part1.replace("'", "\"")+FieldsLabelAndData[0]+gw_LabelData_Part1A.replace("'", "\"")+FieldsLabelAndData[0]+gw_RadioButton_Input_Part3.replace("'", "\"")+RadioButtonToSelect+gw_RadioButton_Input_Part4.replace("'", "\""));
					}else {
						Radiobutton = ByXpathAction(gw_RadioButton_Input_Part1+FieldsLabelAndData[0]+gw_LabelData_Part1A+FieldsLabelAndData[0]+gw_RadioButton_Input_Part3+RadioButtonToSelect+gw_RadioButton_Input_Part4);
					}
					if(!CONSTANTS.getGW_VERSION().equalsIgnoreCase("10"))	{
						// Write code for other than guidewire 10
					}else {
						Click_On_Button("", Radiobutton);
					}
					test.info(RuleNum +" :Clicked '"+FieldsLabelAndData[1]+"' for the option '"+FieldsLabelAndData[0]+"'.");
					break;

				case "date" :
					String Calender_InputDate="";
					ByXpathAction(gw_LabelData_Part1+FieldsLabelAndData[0]+gw_LabelData_Part1A+FieldsLabelAndData[0]+gw_TextBox_Part).click();
					ByXpathAction(gw_LabelData_Part1+FieldsLabelAndData[0]+gw_LabelData_Part1A+FieldsLabelAndData[0]+gw_TextBox_Part).clear();
					/***For Date Field: - Check if the input date needs to be computed based on the effective date or not ***/ 					
					if (FieldsLabelAndData[1].contains(CC_CONSTANTS.CC_EFFECTIVE_DATE)) {
						String[] CheckEffectiveDate=FieldsLabelAndData[1].split(CC_CONSTANTS.CC_EFFECTIVE_DATE);
						if (CheckEffectiveDate.length> 0) {
							int EffectiveDayNum= ConvertDateIntoNumberBasedonCurrentDate("dd.MM.yyyy", EffectiveDate);
							int AddSubNum=num_extract(CheckEffectiveDate[1]);
							Calender_InputDate = ProvidePastCurrentOrFutureDate("dd.MM.yyyy", EffectiveDayNum+AddSubNum);
						}else {
							Calender_InputDate = EffectiveDate;
						}
					}else {
						Calender_InputDate = ProvidePastCurrentOrFutureDate("dd.MM.yyyy", Integer.parseInt(FieldsLabelAndData[1]));
					}					
					ByXpathAction(gw_LabelData_Part1+FieldsLabelAndData[0]+gw_LabelData_Part1A+FieldsLabelAndData[0]+gw_TextBox_Part).sendKeys(Calender_InputDate);
					test.info("Entered the value '"+Calender_InputDate+"' in the Date field '"+FieldsLabelAndData[0]+"'.");
					break;

				case "multiselect":
					ByXpathAction(gw_MultiSelect_Link_Part1+FieldsLabelAndData[0]+gw_MultiSelect_Link_Part2+FieldsLabelAndData[0]+gw_MultiSelect_Link_Part3+FieldsLabelAndData[1]+gw_MultiSelect_Link_Part4).click();
					test.info("Selected the value '"+FieldsLabelAndData[1]+"' in the multiselect box  '"+FieldsLabelAndData[0]+"'.");
					break;

				default:
					test.fail("The Field type '"+FieldsLabelAndData[0]+"' is not available. Pass the correct field name from the test data sheet." );

				} //End of switch
			} //End of for loop
		}
	}   //End of function

	/*
	 * Function to enter the input value to the text field by passing 'Webelement' and input value to be entered
	 */

	public void EnterInputValue(WebElement WebElementOfTextBox, String Inputvalue,  String ...NameOfTextbox ) throws InterruptedException {
		Thread.sleep(CONSTANTS.STATICWAITTIME_1K_TO_2K);
		if(!CONSTANTS.getGW_VERSION().equalsIgnoreCase("10")) {
			if (! WebElementOfTextBox.getAttribute("value").equalsIgnoreCase(Inputvalue) || WebElementOfTextBox.getText().equalsIgnoreCase("Inputvalue")) {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].value='"+Inputvalue+"';", WebElementOfTextBox);
				WebElementOfTextBox.sendKeys(Keys.TAB);
				if(NameOfTextbox.length>0) {
					test.log(Status.INFO, "Entered '"+NameOfTextbox[0]+"' text field as : "+Inputvalue);
				}
				else {
					test.log(Status.INFO, "Entered text field as : "+Inputvalue);
				}
			}else {
				if(NameOfTextbox.length>0) {
					test.log(Status.INFO, "The Input field '"+NameOfTextbox[0]+"' is retained with default value '"+Inputvalue+"'");
				}
				else
				{
					test.info("The Input field is retained with default value as : "+ Inputvalue );
				}
			}
		}else {
			if (! WebElementOfTextBox.getAttribute("value").equalsIgnoreCase(Inputvalue) || WebElementOfTextBox.getText().equalsIgnoreCase("Inputvalue")) {
				WebElementOfTextBox.clear();;
				WebElementOfTextBox.sendKeys(Inputvalue);
				WebElementOfTextBox.sendKeys(Keys.TAB);
				if(NameOfTextbox.length>0) {
					test.log(Status.INFO, "Entered '"+NameOfTextbox[0]+"' text field as : "+Inputvalue);
				}
				else {
					test.log(Status.INFO, "Entered text field as : "+Inputvalue);
				}
			}
		}
	}
	
	/*
	 * Function to enter the input field value where the field xpath is changes to the input from div
	 */
	public void EnterInputValue_DivAndinput_Field(WebElement WebElementOfDivField, WebElement WebElementOfInputField, String InputValue) throws InterruptedException {
		if(!CONSTANTS.getGW_VERSION().contentEquals("10")) {
			//Add code for GW version other than 10

		}
		else {
			Click_On_Button("", WebElementOfDivField);
			Thread.sleep(1000);
			WebElementOfInputField.sendKeys(Keys.chord(Keys.CONTROL,"a")+InputValue+Keys.TAB);
		}
	}

	/**
	 * Function to get the day of week  i.e. SUNDAY, MONDAY, TUESDAY.....SATURDAY
	 * @param DateAsString in dd.MM.yyyy Format
	 * @return of type DayOfWeek
	 * @throws ParseException
	 */
	public String  retriveDayOfTheWeek(String DateAsString) throws ParseException {

		String[] DateSplit = DateAsString.split("\\.");
		LocalDate localDate = LocalDate.of(Integer.parseInt(DateSplit[2]), Integer.parseInt(DateSplit[1]), Integer.parseInt(DateSplit[0]));
		//Getting the day of week for a given date
		//DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		String dayOfWeek = String.valueOf(localDate.getDayOfWeek());
		return dayOfWeek;

	}

	/**
	 * Function to get customer test data from TDM
	 * @param Company  - input as 'LocalTapiola' or 'Turva'
	 * @param consumed_YesNo - input as 'Y' and 'N'
	 * @throws SQLException
	 */

	public void TDM_GetCustomerData(String Company, String consumed_YesNo, String... AddtionalQuery ) throws SQLException {
		ResultSet rs = null;
		DataBaseUtilities dbu = new DataBaseUtilities();
		Connection conn = null;
		String SelectExecutionQuery;


		//If block to avoid spell mistake failures
		if ( Company.equalsIgnoreCase("turva")) {
			Company = "Turva";
		}else {
			Company = "LocalTapiola";
		}


		CONSTANTS.setTDMdataConsumed(consumed_YesNo);

		String MDMEnvToRun = " "; 
		//switch statement to connect DB table. TDM created two tables - one for TEST environments and another for UAT environments
		switch (CONSTANTS.getENVIRONMENTTORUN()){
		case "SIT3": 
			MDMEnvToRun = "HC-SIT";
			break;

		default:
			MDMEnvToRun = "SIT";
		}

		try {


			//Establishing connection to the database
			conn = DbConnecton.DB_openConnection("automationtestuser", "Smoketest@toivo2", DB_CONSTANTS.TDM_DATABASETOCONNECT);
			test.log(Status.INFO, "The Database connection is established for the Environemnt: ");

			if(AddtionalQuery.length > 0) {
				SelectExecutionQuery="SELECT TOP 1 EID_LT, FirstName, LastName, SSN, consumed_YN  FROM _AutomationTesting.[CRMCustomerData_" +MDMEnvToRun + "] WHERE consumed_YN = '"+CONSTANTS.getTDMdataConsumed()+"'" +" AND "+ "Company= '"+Company+ "' " +AddtionalQuery[0]+" order by SI_No asc";	
			} else {
				SelectExecutionQuery="SELECT TOP 1 EID_LT, FirstName, LastName, SSN, consumed_YN  FROM _AutomationTesting.[CRMCustomerData_" +MDMEnvToRun + "] WHERE consumed_YN = '"+CONSTANTS.getTDMdataConsumed()+"'" +" AND "+ "Company= '"+Company+"' AND "+ "Affinity_Group_ID is Null order by SI_No desc";
			}

			System.out.println( "Select query executed successfully :  " +SelectExecutionQuery );
			rs= dbu.executeQueryFromConnection(conn, SelectExecutionQuery );
			test.log(Status.INFO, "Select query executed successfully :  " +SelectExecutionQuery );

			while (rs.next()) {
				System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName") + " " + rs.getString("EID_LT") + " " + rs.getString("SSN"));
				CONSTANTS.setPOLICY_HOLDER_NAME(rs.getString("FirstName") + " " + rs.getString("LastName") );
				CONSTANTS.setEID_NUMBER(rs.getString("EID_LT"));
				CONSTANTS.setSSN_ID(rs.getString("SSN"));
			}
				dbu.closeConnection(conn);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("An Exception occured");
			System.out.println("Database connection exception occured");
			dbu.closeConnection(conn);
		}
	}

	/**
	 * Function to get customer test data from TDM
	 * @param EID_LT
	 * @throws SQLException
	 */
	public void TDM_Updateconsumed_YN(String EID_LT , String Company, String... AddtionalQuery) throws SQLException {
		DataBaseUtilities dbu = new DataBaseUtilities();
		Connection conn = null; 		
		Company = "LocalTapiola";
		
		String MDMEnvToRun = " "; 
		//switch statement to connect DB table. TDM created tables - TEST environments ( SIT & HC-SIT) and  UAT environments (UAT)
		switch (CONSTANTS.getENVIRONMENTTORUN()){
		case "SIT3": 
			MDMEnvToRun = "HC-SIT";
			break;
		default:
			MDMEnvToRun = "SIT";
		}
		try {

			//Establishing connection to the database
			conn = DbConnecton.DB_openConnection("automationtestuser", "Smoketest@toivo2", "");
			test.log(Status.INFO, "The Database connection is established for the Environemnt: ");
			String UpdateExecutionQuery;
			if(AddtionalQuery.length > 0) {
				UpdateExecutionQuery= "UPDATE _AutomationTesting.[CRMCustomerData_" +MDMEnvToRun + "] SET [consumed_YN] = 'Y_S' WHERE Company= '"+Company+"'" +AddtionalQuery[0];	// Update query without EID column
			} else {
				UpdateExecutionQuery= "UPDATE _AutomationTesting.[CRMCustomerData_" +MDMEnvToRun + "] SET [consumed_YN] = 'Y_S' WHERE EID_LT = '" +EID_LT +"'"  +" AND "+ "Company= '"+Company+"'" ;
			}
			dbu.UpdateQuery(conn, UpdateExecutionQuery );
			test.log(Status.INFO, "Update query executed successfully :  " +UpdateExecutionQuery );
			System.out.println("Update query executed successfully :  " +UpdateExecutionQuery);
			dbu.closeConnection(conn);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("An Exception occured");
			System.out.println("Database connection exception occured");
			dbu.closeConnection(conn);
		}

	}

	
	/**
	 * Function to select the dropdown value in GW10
	 * @param Name_Attribute
	 * @param TextToSelect
	 * @throws Exception
	 */
	public void Select_DropDown(String Name_Attribute, String TextToSelect, String... Name) throws Exception{
		Generic_WaitForObject(ByXpathAction(gw_LabelData_Part1+Name_Attribute+gw_LabelData_Part1A+Name_Attribute+gw_Select_Part), 4);
		String XpathOfDropDown = gw_LabelData_Part1+Name_Attribute+gw_LabelData_Part1A+Name_Attribute+gw_Select_Part;
		//		String XpathOfDropDown = gw_LabelData_Part1a+Name_Attribute+gw_LabelData_Part1a;
		Select dropdown = new Select(driver.findElement(By.xpath(XpathOfDropDown)));
		//		Select dropdown = new Select(driver.findElement(By.name(Name_Attribute)));
		dropdown.selectByVisibleText(TextToSelect);
		if(Name.length >0) {
			test.info("For the "+Name[0]+" dropdown, selected the value - '"+TextToSelect+"'.");
		}
	}

	/**
	 * Function to select the dropdown value for other than text valuein GW10
	 * @param Name_Attribute
	 * @param TextToSelect
	 * @throws Exception
	 */
	public void SelectID_DropDown(String Name_Attribute, String TextToSelect, String... Name) throws Exception{
		String XpathOfDropDown = gw_PP_Part1+Name_Attribute+gw_PP_Part2;
		Select dropdown = new Select(driver.findElement(By.xpath(XpathOfDropDown)));
		dropdown.selectByVisibleText(TextToSelect);
		if(Name.length >0) {
			test.info("For the "+Name[0]+" dropdown, selected the value - '"+TextToSelect+"'.");
		}
	}

	/**
	 * Function to select the dropdown value in GW10
	 * @param NameOfDropDown
	 * @param OptionToSelect
	 * @throws Exception
	 */
	public String Select_dropDown(String NameOfDropDown, String OptionToSelect) throws Exception{
		String XpathOfDropDown = gw_LabelData_Part1+NameOfDropDown+gw_LabelData_Part1A+NameOfDropDown+gw_Select_Part;
		Generic_WaitForObject(ByXpathAction(XpathOfDropDown), 5);
		Select dropdown = new Select(driver.findElement(By.xpath(XpathOfDropDown)));
		String ReturnValue = "";
		//Check the default value, compare and if it 
		if(driver.findElement(By.xpath(XpathOfDropDown)).getAttribute("value").equalsIgnoreCase(OptionToSelect)) {
			test.info("For the "+NameOfDropDown+" dropdown, '"+OptionToSelect+"' is the default selected value.");
			ReturnValue = driver.findElement(By.xpath(XpathOfDropDown)).getAttribute("value");
		}else {
			dropdown.selectByVisibleText(OptionToSelect);
			test.info("For the "+NameOfDropDown+" dropdown, selected the value - '"+OptionToSelect+"'.");
			ReturnValue = OptionToSelect;
		}

		//Return selected/Default value
		return ReturnValue;
	}

	/**
	 * Select function to select the value from dropdown using "select by value" and 
	 * if it does not work then select by visible text. This is especially usefull for selecting
	 * dropdown values in tables for GW10
	 * @param DropDown_Xpath
	 * @param Option
	 * @throws Exception
	 */
	public void Select_UsingXpath(String DropDown_Xpath, String Option, String...optional) throws Exception{
		Select dropdown = new Select(driver.findElement(By.xpath(DropDown_Xpath)));
		dropdown.selectByVisibleText(Option);		
		if(optional.length>0) {
			test.info(optional[0]);
		}else {
			test.info("Selected the value - '"+Option+"' from the dropdown.");
		}
		Thread.sleep(500);
	}


	/**
	 * Generic Function to wait for the object in any page. 
	 * @param ObjectToWaitFor
	 * @param WaitTime
	 * @throws InterruptedException 
	 */
	public void Generic_WaitForObject(WebElement ObjectToWaitFor, int WaitTime) throws InterruptedException {
		boolean ExitForLoop = false;
		for(int i=1; i<WaitTime; i++) {
				if(ObjectToWaitFor.isDisplayed()) {
					ExitForLoop = true;
				}
			if(ExitForLoop) {
				break;
			}
		}
	}


	/**
	  * Function to wait for the Overlay load to complete during which the click is disabled
	  * @param SecondsToWait
	  * @throws Exception
	  */
	 public void wait_For_Overlay(int SecondsToWait) throws Exception{
		 for(int j=1; j<SecondsToWait; j++){
	//			if(isXpathExists(gw_Overlay_On_Click)) {
			 	String overlayAttribute = driver.findElement(By.xpath(gw_Overlay_On_Click)).getAttribute("class");
			 	if(overlayAttribute.contains("gw-disable-click")) {
			 		Thread.sleep(1000);
				}else {
					break;
				}
			}
	 }
		
}


