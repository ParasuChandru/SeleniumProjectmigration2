package com.guidewire.basetest;


import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.CopyOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import com.google.common.io.Files;
import com.guidewire.commonpagefunctions.MyActivities_Page;
import com.guidewire.config.ADDRESS_DATASHEET_CONSTANTS;
import com.guidewire.config.CONSTANTS;
import com.guidewire.menu.SideMenu;
import com.guidewire.utilities.ExtentManager;
import com.guidewire.utilities.Keyboard;
import com.guidewire.utilities.TestUtilities;
import com.guidewire.utilities.Xls_ReadWrite;
import com.guidewire.utilities.Xml_Reader;
import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;

//import jdk.nashorn.internal.runtime.regexp.joni.ast.ConsAltNode;
import junit.framework.AssertionFailedError;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

import java.io.*;
import java.nio.file.*;
import java.util.zip.*;
import org.apache.commons.net.*;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;



@SuppressWarnings("unused")
public class BaseTest{

	public WebDriver driver = null;
	public ExtentReports extent;
	public ExtentTest test;

	public Xls_ReadWrite TCxls=null;
	public String RunOnBrowser = null;
	public String getCurrentlyLoggedInUser=null;
	public static String ScreenshotPATH;
	public String CurrentRunningTCName=null;
	private String getApplicationName;
	protected String baseURL = "";
	private final String checkNullColumn="@null";
	protected String ExcelFileToLoad = "";
	public static String week="_Week";
	public boolean OpeningBrowserFirstTime = true;       //This flag is to check whether the browser opens first time in scenario, where there are multiple application opening and closing is involved.
	public String  slEnvironmentToRun;
	public String getCurrentSystemName=null;
	public String getGW_VersionNumber=null;


	int rowNum;
	String sheetName ="TOIVO TestSuite Report";
	private String ExecutionStartTime, ExecutionEndTime, ExecutionTime;
	private MyActivities_Page myActivities_Page;

	public boolean ExtentInitForDD=false;

	/**
	 * To setup browser and url 
	 * @throws IOException 
	 * @throws Exception
	 */
	@Parameters({"EnvToRun", "TestSuiteName"})
	@BeforeTest
	public void setUp(@Optional("ReadEnvfromXls") String EnvToExecute, @Optional("Adhoc_Testsuite") String TestSuiteName) throws IOException {   //if test script is not executed from TestSuite.xml (i.e. optional value is null), then the environment will be read from excel. 
		try{
			ExecutionStartTime=CONSTANTS.getDateFormatSettings().format(new Date());	
			CurrentRunningTCName = super.getClass().getSimpleName();
			getCurrentlyLoggedInUser=System.getProperty("user.name");
			getCurrentSystemName=InetAddress.getLocalHost().getHostName();
			//			System.out.println("Current System Name is :"+getCurrentSystemName);
			//Set the Current System Name
			CONSTANTS.setCURRENT_SYSTEM_NAME(getCurrentSystemName);
			CONSTANTS.setCURRENT_RUNNING_TCName(CurrentRunningTCName);

			//To assign the application name frbased on the module name used in test script name
			switch( CurrentRunningTCName.substring(0, CurrentRunningTCName.indexOf('_'))) {
			case "DC":
				getApplicationName="CC";
				break;				
			case "ODS":
				getApplicationName="PC";
				break;
			case "HALI":
				getApplicationName="PC";
				break;
			default :
				getApplicationName=CurrentRunningTCName.substring(0, CurrentRunningTCName.indexOf('_'));

			}

			RunOnBrowser=CONSTANTS.BROWSER_TYPE; 

			//Load the ApplicationsHub Workbook into the credxls object
			CONSTANTS.setCREDXLS(new Xls_ReadWrite(ADDRESS_DATASHEET_CONSTANTS.CRED_INPUT_FILE));
			getCredentials(CONSTANTS.getCREDXLS());

			//Start here - to set the GW version based on environment
			switch (CONSTANTS.getENVIRONMENTTORUN()){	
			case "PROD1":	
				getGW_VersionNumber = "9.5";
				break;
			default:
				getGW_VersionNumber = "10";
			} 
			CONSTANTS.setGW_VERSION(getGW_VersionNumber);
			//End here - to set the GW version based on environment

			//If block checks whether the environment value is passed from Test suite xml file or individual execution.
			if (! EnvToExecute.equalsIgnoreCase("ReadEnvfromXls")) {
				CONSTANTS.setENVIRONMENTTORUN(EnvToExecute);
			}

			if 	(! EnvToExecute.equalsIgnoreCase("Adhoc_Testsuite")) {
				CONSTANTS.setJIRA_TESTSUITE_NAME(TestSuiteName);
			}
			//Choose Application URL
			baseURL=getURLParameters(CONSTANTS.getINSURANCECOMPANY(),getApplicationName );

			//Get static wait time for specific application
			int rows = CONSTANTS.getCREDXLS().getRowCount(ADDRESS_DATASHEET_CONSTANTS.APPTORUN_WORKSHEET);	
			for (int i = 2; i <= rows; i++) {
				if(CONSTANTS.getCREDXLS().getCellData(ADDRESS_DATASHEET_CONSTANTS.APPTORUN_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.APP_NAMETOLOAD, i).equalsIgnoreCase(getApplicationName)){
					CONSTANTS.setSTATICWAITTIME(Integer.parseInt(CONSTANTS.getCREDXLS().getCellData(ADDRESS_DATASHEET_CONSTANTS.APPTORUN_WORKSHEET,ADDRESS_DATASHEET_CONSTANTS.APP_STATICWAITTIME, i)));
					break;
				}

			}
			String getModuleName = "";
			String LobName = "";
			//Application specific test data load based on the Environment.
			if(CurrentRunningTCName.contains("ODS")) {
				getModuleName="ODS"+CONSTANTS.fs+CurrentRunningTCName.substring(0, CurrentRunningTCName.indexOf('_'));
			}else if(CurrentRunningTCName.contains("HALI")) {
				getModuleName="HALI"+CONSTANTS.fs+CurrentRunningTCName.substring(0, CurrentRunningTCName.indexOf('_'));
			}else {
				getModuleName=CurrentRunningTCName.substring(0, CurrentRunningTCName.indexOf('_'));
				String[] LOB=CurrentRunningTCName.split("_");
				LobName=LOB[1];
				if(!(LobName.contains("Motor")||LobName.contains("HC")||LobName.contains("Boat")||LobName.contains("Forest")||LobName.contains("Pet")||LobName.contains("WC"))) {
					LobName="Home";
				}
			}
			String Env_Folder="";
			switch(CONSTANTS.getENVIRONMENTTORUN()) {
			case "EDU": 
				Env_Folder="UPPER_ENV";
				break;
			default:
				Env_Folder="MASTER";
			}

			try {
				ExcelFileToLoad = System.getProperty("user.dir")+CONSTANTS.fs+"TestData"+CONSTANTS.fs+CONSTANTS.getINSURANCECOMPANY()+CONSTANTS.fs+CONSTANTS.getENVIRONMENTTORUN()+CONSTANTS.fs+getModuleName+"_Testdata.xlsx";
				CONSTANTS.setTCXLS(new Xls_ReadWrite(ExcelFileToLoad));
			}catch(Exception E) {
				ExcelFileToLoad = System.getProperty("user.dir")+CONSTANTS.fs+"TestData"+CONSTANTS.fs+CONSTANTS.getINSURANCECOMPANY()+CONSTANTS.fs+Env_Folder+CONSTANTS.fs+LobName+CONSTANTS.fs+getModuleName+"_"+LobName+"_Testdata.xlsx";
				CONSTANTS.setTCXLS(new Xls_ReadWrite(ExcelFileToLoad));
			}

		}catch(Exception e){
			Reporter.log("Exception is caused in BaseTest --> Setup function"+ e.getMessage());
			throw e;
		}
		finally{
			//replacing the null values(before getcredentials function execution) after getting the insurance company and environment to run values through getcredentials functions
			CONSTANTS.TESTREPORT_HTML_PATH=CONSTANTS.TESTREPORT_HTML_PATH.replace("null_null", CONSTANTS.getINSURANCECOMPANY()+"_"+CONSTANTS.getENVIRONMENTTORUN());
			CONSTANTS.TESTREPORT_SCREENSHOT_PATH=CONSTANTS.TESTREPORT_SCREENSHOT_PATH.replace("null_null", CONSTANTS.getINSURANCECOMPANY()+"_"+CONSTANTS.getENVIRONMENTTORUN());
			TestUtilities init= new TestUtilities();
			ADDRESS_DATASHEET_CONSTANTS.REP_INPUT_FILE=System.getProperty("user.dir")+File.separator+"ExtentReports"+File.separator+CONSTANTS.getINSURANCECOMPANY()+"_"+CONSTANTS.getENVIRONMENTTORUN()+week+CONSTANTS.WEEK_NUMBER+File.separator+CONSTANTS.getINSURANCECOMPANY()+"_"+CONSTANTS.getENVIRONMENTTORUN()+"_"+"TOIVO_ExecutionStatus_"+new SimpleDateFormat("ddMMMyyyy",Locale.ENGLISH).format(new Date())+".xlsx";
			init.initializeExcelReport();
			CONSTANTS.setREPORTXLS(new Xls_ReadWrite(ADDRESS_DATASHEET_CONSTANTS.REP_INPUT_FILE));
		}
	}

	public void InitializeExtentReport(String... DataDrivenValue) {
		ExtentInitForDD=true;
		ExecutionStartTime=CONSTANTS.getDateFormatSettings().format(new Date());
		// Initializing the extent reports 
		if (DataDrivenValue.length > 0) {
			test = extent.createTest(CurrentRunningTCName+"-"+DataDrivenValue[0], "The testcase "+CurrentRunningTCName +" was executed to verify following details"); 
			//			CONSTANTS.setRUNTIME_TC_NAME(CurrentRunningTCName+"-"+DataDrivenValue[0]);
		}else {
			test = extent.createTest(CurrentRunningTCName, "The testcase "+CurrentRunningTCName +" was executed to verify following details"); 
			//			CONSTANTS.setRUNTIME_TC_NAME(CurrentRunningTCName);
		}
		test.assignAuthor(getCurrentlyLoggedInUser);

	}


	public  void getCredentials(Xls_ReadWrite Credxls,String... ApplicationLDAPUser){
		if (!Credxls.isSheetExist(ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET)) {
			throw new SkipException("The test data worksheet is not availble for test case "+ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET+". HEnce skipped the test caseexecution.");
		}
		int cols = Credxls.getColumnCount(ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET);
		//Always read the Environment details of the currently executing user
		for (int i = 2; i <= Credxls.getRowCount(ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET); i++) {
			if (Credxls.getCellData(ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.CRED_LOGGEDUSER, i).equalsIgnoreCase(getCurrentlyLoggedInUser)) {
				for (int colNum = 0; colNum < cols; colNum++) {
					if (checkNullColumn.equalsIgnoreCase(Credxls.getCellData(ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET, "Username", i))){
						CONSTANTS.setINSURANCECOMPANY(Credxls.getCellData(ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET, "CompanyType", i));
						CONSTANTS.setENVIRONMENTTORUN(Credxls.getCellData(ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET, "EnvironmentToRun", i).replace("_", ""));
					}					
				}
				break;
			}
		}
		//Below code is a special case with respect to the applications User Credentials.. For Example we use different Credentials for accessing YVP Application via LDAP.
		if(ApplicationLDAPUser.length>0){
			getCurrentlyLoggedInUser=ApplicationLDAPUser[0];
			Reporter.log("Currently Logged User is:"+getCurrentlyLoggedInUser);
		}
		String UsernameColumnName;
		String PasswordColumnName;
		String DataBaseUserColumnName;
		String DataBasePasswordColumnName;
		if("LT".equalsIgnoreCase(CONSTANTS.getINSURANCECOMPANY())){
			UsernameColumnName = ADDRESS_DATASHEET_CONSTANTS.CRED_LT_USERNAME;
			PasswordColumnName=ADDRESS_DATASHEET_CONSTANTS.CRED_LT_PASSWORD;
			DataBaseUserColumnName=ADDRESS_DATASHEET_CONSTANTS.CRED_DataBase_USERNAME;
			DataBasePasswordColumnName=ADDRESS_DATASHEET_CONSTANTS.CRED_DataBase_PASSWORD;
		}else {//"TRVA":
			UsernameColumnName = ADDRESS_DATASHEET_CONSTANTS.CRED_TRVA_USERNAME;
			PasswordColumnName=ADDRESS_DATASHEET_CONSTANTS.CRED_TRVA_PASSWORD;
			DataBaseUserColumnName=ADDRESS_DATASHEET_CONSTANTS.CRED_DataBase_USERNAME;
			DataBasePasswordColumnName=ADDRESS_DATASHEET_CONSTANTS.CRED_DataBase_PASSWORD;
		}

		for (int i = 2; i <= Credxls.getRowCount(ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET); i++) {
			if (Credxls.getCellData(ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.CRED_LOGGEDUSER, i).equalsIgnoreCase(getCurrentlyLoggedInUser)) {
				for (int colNum = 0; colNum < cols; colNum++) {
					if (checkNullColumn.equalsIgnoreCase(Credxls.getCellData(ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET, "Username", i))){
						Reporter.log("The column name \'Username\' is not available in test data excel sheet");
					}
					CONSTANTS.setUSERNAME(Credxls.getCellData(ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET, UsernameColumnName, i));
					CONSTANTS.setPASSWORD(Credxls.getCellData(ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET, PasswordColumnName, i));
					CONSTANTS.set_DB_USERNAME(Credxls.getCellData(ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET, DataBaseUserColumnName, i));
					CONSTANTS.set_DB_PASSWORD(Credxls.getCellData(ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET, DataBasePasswordColumnName, i));
					CONSTANTS.setJIRA_STATUS_UPDATE(Credxls.getCellData(ADDRESS_DATASHEET_CONSTANTS.CRED_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.JIRA_STATUS_UPDATE_REQUIRED, i));

				}break;
			}
		}
	}

	/**
	 * Function to get the URL Parameters from the Applications Hub Excel sheet and get the URL based on the EnvironmentToRun
	 * which is available in "Credentials" worksheet 
	 * @param ApplicationName
	 * @return 
	 * @throws IOException 
	 */
	public String getURLParameters(String CompanyName,String ApplicationName) throws IOException{		
		String SheetToBeSelected;
		String ApplicationNameToSelect;
		if ("LT".equalsIgnoreCase(CompanyName)){
			SheetToBeSelected = ADDRESS_DATASHEET_CONSTANTS.LT_APPLICATIONSURLPARAMETERS_BASEDONENVSELCTED_WORKSHEET;
			ApplicationNameToSelect=ADDRESS_DATASHEET_CONSTANTS.LT_APPLICATIONSURLPARAMETERS_APPLICATIONSTORUNWRTENVIRONMENT;
		}else{//"TRVA":
			SheetToBeSelected = ADDRESS_DATASHEET_CONSTANTS.TRVA_APPLICATIONSURLPARAMETERS_BASEDONENVSELCTED_WORKSHEET;
			ApplicationNameToSelect=ADDRESS_DATASHEET_CONSTANTS.TRVA_APPLICATIONSURLPARAMETERS_APPLICATIONSTORUNWRTENVIRONMENT;
		}
		Xls_ReadWrite AppURLxls = new Xls_ReadWrite(ADDRESS_DATASHEET_CONSTANTS.CRED_INPUT_FILE);
		if (!AppURLxls.isSheetExist(SheetToBeSelected)) {
			throw new SkipException("The test data worksheet is not availble for test case "+ SheetToBeSelected + ". Hence skipped the test case execution.");
		}
		int cols = AppURLxls.getColumnCount(SheetToBeSelected);
		for (int i = 2; i <= AppURLxls.getRowCount(SheetToBeSelected); i++) {
			if (AppURLxls.getCellData(SheetToBeSelected,ApplicationNameToSelect, i).equalsIgnoreCase(ApplicationName+"_"+CONSTANTS.getENVIRONMENTTORUN())) {
				for (int colNum = 0; colNum < cols; colNum++) {
					if (checkNullColumn.equalsIgnoreCase(AppURLxls.getCellData(SheetToBeSelected,ADDRESS_DATASHEET_CONSTANTS.LT_APPLICATIONSURLPARAMETERS_URLTOBEUSED, i))) {
						assertEquals(true, "Unable to Find the URL to be used from Applications HUB worksheet","");
					}
					baseURL = AppURLxls.getCellData(SheetToBeSelected,"URLTobeUsed", i);
				}
				break;
			}
		}
		return baseURL;
	}

	/**
	 * BrowserSetUp is an function to setup which browser webdriver should be enabled
	 * @throws Exception 
	 * @OptinalParam URL_ToBeOpened - Pass the two Character intials of application related to URL. e.g If application name is Contact Manager, than pass optional parameter as CM. Also make sure that, URl is mentioned in Application Hub sheet.
	 */ 
	public void BrowserSetUp(String... URL_ToBeOpened) throws Exception {
		String URLToLoad;
		if (OpeningBrowserFirstTime) {

			switch( CurrentRunningTCName.substring(0, CurrentRunningTCName.indexOf('_'))) {
			case "LE":

				break;
			default :
				if(!ExtentInitForDD) {
					InitializeExtentReport();				
			}
			}

			//Checking Run Mode from the Respective application sheet
			CheckRunMode(CONSTANTS.getTCXLS(),CurrentRunningTCName, ADDRESS_DATASHEET_CONSTANTS.TESTCASES_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.TESTCASES_TESTCASEID);
			OpeningBrowserFirstTime = false;
		} 

		if (URL_ToBeOpened.length > 0) {
			getApplicationName = URL_ToBeOpened[0];
			baseURL=getURLParameters(CONSTANTS.getINSURANCECOMPANY(),getApplicationName );
		}

		CONSTANTS.setRobot(new Robot());
		
		URLToLoad = baseURL;  //Uncomment this line when AutoIT is to be used
		
		//	int proxyType=ProxyType.AUTODETECT.ordinal();
		try{
			switch (RunOnBrowser) {
			case "chrome":
				ChromeOptions chromeOptions = new ChromeOptions();
				DesiredCapabilities ChromeCapabilities = DesiredCapabilities.chrome();
				ChromeCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);	
				// Set ACCEPT_SSL_CERTS  variable to true
				ChromeCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				ChromeCapabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true); //17-05-2016 - Newly added to remove cache issues
//				prefs.put("download.extensions_to_open", "pdf"); //prefs.put("--always-authorize-plugins",true);
				Map<String, Object> prefs = new HashMap<>();
				// 1. Disable the "Keep/Discard" prompt
				prefs.put("safebrowsing.disable_download_protection", true);
				prefs.put("profile.default_content_settings.popups", 0);
				prefs.put("plugins.always_open_pdf_externally", true);
				prefs.put("download.prompt_for_download", false);
				prefs.put("download.directory_upgrade", true);
				prefs.put("download.default_directory", CONSTANTS.STRDOWNLOADPATH);
				chromeOptions.setExperimentalOption("prefs", prefs);
				chromeOptions.addArguments("--safebrowsing-disable-download-protection");
				chromeOptions.addArguments("--safebrowsing-disable-extension-blacklist");
				chromeOptions.addArguments("--disable-popup-blocking");
				if(getCurrentSystemName.equalsIgnoreCase(CONSTANTS.getSAS_SYSTEM_NAME())){
					System.setProperty("webdriver.chrome.driver",CONSTANTS.CHROMEDRIVERPATH_146);
				}else if(getCurrentSystemName.contains("FI-VDI-")){
					System.setProperty("webdriver.chrome.driver",CONSTANTS.CHROMEDRIVERPATH);					
				}else{
					System.setProperty("webdriver.chrome.driver",CONSTANTS.CHROMEDRIVERPATH_146);
				}
				driver = new ChromeDriver(chromeOptions);
				break;
				
			case "edge":
				System.setProperty("webdriver.edge.driver", CONSTANTS.MSEDGEDRIVERPATH);
				driver = new EdgeDriver();
				break;

			default:
				Reporter.log("Driver Not Found");
				break;
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			String BrowserVersion = getBrowserVersion();
			driver.get(URLToLoad);
			test.info("Application URL: '"+baseURL+"' is opened in "+BrowserVersion+" successfully.");
			test.info("Logged in with UserName - "+CONSTANTS.getUSERNAME());
		}
		catch(Exception e){
			Reporter.log("Exception is caused in WAS_Generic Functions --> BrowserSetup function"	+ e.getMessage());
			throw e;
		}

	}


	/**
	 * Function to return browser version 
	 * @return browser name and version
	 */
	public String getBrowserVersion() {
		String browser_version;
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browsername = cap.getBrowserName();
		String GetuAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		// This block to find out IE Version number
		if ("internet explorer".equalsIgnoreCase(browsername)) {
			// uAgent return as "MSIE 8.0 Windows" for IE8
			if (GetuAgent.contains("MSIE") && GetuAgent.contains("Windows")) {
				browser_version = GetuAgent.substring(GetuAgent.indexOf("MSIE") + 5, GetuAgent.indexOf("Windows") - 2);
			} else if (GetuAgent.contains("Trident/7.0")) {
				browser_version = "11.0";
			} else {
				browser_version = "0.0";
			}
		} 
		else if ("firefox".equalsIgnoreCase(browsername)) {
			browser_version=GetuAgent.substring(GetuAgent.indexOf("Firefox")).split(" ")[0].replace("/", "-");
			browser_version=browser_version.replace("Firefox-", "");
		}else{	//Browser version for Chrome and Opera
			browser_version = cap.getVersion();
		}		
		String browserversion = browser_version.substring(0, browser_version.indexOf('.'));
		return Captialize(browsername) + " browser (Version: " + browserversion +" )";
	}


	/**
	 * Function to Captialize the word
	 * @param RequiredWord
	 * @return
	 */
	public String Captialize(String RequiredWord)
	{
		return RequiredWord.substring(0,1).toUpperCase()+RequiredWord.substring(1, RequiredWord.length()).toLowerCase();
	}


	public void openBrowser(){
		//testInstance.log(Status.INFO, "Opening Browser" + RunOnBrowser);
		RunOnBrowser="firefox";

		if(RunOnBrowser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\com\\project\\application\\config\\chromedriver.exe");
			driver =  new ChromeDriver();
		}else if (RunOnBrowser.equals("ie")){
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\com\\project\\application\\config\\IEDriverServer.exe");
			driver =  new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}


	public void OpenURL(String URL){
		driver.get(URL);
	}



	/**
	 * To Check Test case class is runnable or not is checked here.
	 * @param TCxls_INPUTFILE
	 * @param callerClassName
	 * @param Worksheet_Name
	 * @param Worksheet_FieldNameToSearch
	 */
	public void CheckRunMode(Xls_ReadWrite TCxls_INPUTFILE,String callerClassName,String Worksheet_Name,String Worksheet_FieldNameToSearch) {

		System.out.print(callerClassName + " - ");
		if(!TestUtilities.isTestCaseRunnable(TCxls_INPUTFILE,callerClassName,Worksheet_Name,Worksheet_FieldNameToSearch)){
			throw new SkipException("Skipping Test Case \'"+callerClassName+"\' as runmode set to NO");
		}
		else if (!TestUtilities.runTestcaseOnBrowser(TCxls_INPUTFILE,callerClassName, RunOnBrowser)){
			throw new SkipException("Skipping Test Case \'"+callerClassName+"\' as run on \'"+RunOnBrowser+ "\' browser set to NO");
		}
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
			fail(format("", expected, actual));
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
		return formatted + "Expected : '" + expected + "',  but Actual is: '" + actual + "'.";
	}

	/**
	 * Function to Login to xCenter application based on the optional credentials
	 * @param Credentials
	 * @throws Exception
	 */
	public  void AuthenticateLogin(String... Credentials) throws Exception	{

		/*
		 * This code should be uncommented and executed in cases 
		 * where there is double authentication window is not available
		 */
		switch (CONSTANTS.getENVIRONMENTTORUN()) {
			case "SIT1":
				if(Credentials.length > 0) {			
					CONSTANTS.setUSERNAME(Credentials[0]);
					CONSTANTS.setPASSWORD(Credentials[1].replace("{","").replace("}",""));
				}
				Verify_PageLoadState(driver, 15);
				driver.findElement(By.xpath("//input[@name='Login-LoginScreen-LoginDV-username']")).sendKeys(CONSTANTS.getUSERNAME());
				driver.findElement(By.xpath("//input[@name='Login-LoginScreen-LoginDV-password']")).sendKeys(CONSTANTS.getPASSWORD());
				driver.findElement(By.xpath("//div[text()='Log In']")).click();
				Thread.sleep(15000);
				
				
				if(Credentials.length > 0) {
					test.info("Logged in as '"+Credentials[0]+"'.");
				}
				break;

		default:
			break;
		}
	}
	
	
	/**
	 * Function to Verify if all the DOM elements are loaded successfully
	 * before proceeding further
	 * @param driver
	 * @param timeoutInSeconds
	 */
	public void Verify_PageLoadState(WebDriver driver, int timeoutInSeconds) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
		    @Override
		    public Boolean apply(WebDriver driver) {
		        return ((JavascriptExecutor) driver)
		            .executeScript("return document.readyState").equals("complete");
		    }
		};
		new WebDriverWait(driver, timeoutInSeconds).until(pageLoadCondition);
	}


	/**
	 * Function to Login to Guidewire applications through AUTO IT
	 * @param Username
	 * @param Password
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void Authentication_AUTOIT(String... Credentials) throws InterruptedException, IOException, Exception {
		switch (CONSTANTS.getENVIRONMENTTORUN()) {
			case "SIT1":
				if(Credentials.length > 0) {
					CONSTANTS.setUSERNAME(Credentials[0]);
					CONSTANTS.setPASSWORD(Credentials[1]);
				}
				Runtime.getRuntime().exec(CONSTANTS.AUTHENTICATION_HANDLER + ' ' + CONSTANTS.getUSERNAME() + ' ' + CONSTANTS.getPASSWORD());
				Thread.sleep(2000);
				break;
			
			default:
				break;
		}
	}

	@DataProvider(name="getData_UsingHashtable")
	public Object[][] getData_Usinghashtable(){
		try{
			return TestUtilities.getData_UsingHashtable(CONSTANTS.getTCXLS(), super.getClass().getSimpleName());
		}
		catch ( NullPointerException e){
			//			test.log(Status.FAIL, "The test data provoider could not identify excel");
			throw e;
		}

	}


	@BeforeClass
	public void createExtentInstance(){
		org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.OFF);
		Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
		extent=ExtentManager.GetExtent();

	}

	@AfterClass
	public void tearDown() throws InterruptedException, IOException {

		extent.flush(); 	// write all resources to report file
		//IF block to quit edge browser if pop message displayed with message "Are you sure you want to leave"
		try { 	//Quit driver if it is opened. -NG - commented below code as it leads to configuration error
			driver.close();
			tearSuite_ReleaseMemory(); 
		}catch (Exception e){

		}
	}



	/**
	 * Used to Kill the remains of the Webdrivers in the processes after the suite execution
	 * @throws IOException 
	 */
	@SuppressWarnings("deprecation")
	@AfterSuite
	public void tearSuite_ReleaseMemory() throws IOException{
		try {
			CONSTANTS.setREPORTXLS(null);
			Runtime rt = Runtime.getRuntime();
			rt.exec("taskkill /F /IM chromedriver_146.exe /FI \"USERNAME eq "+getCurrentlyLoggedInUser+"\" ");  //To kill chrome driver processes
			rt.exec("taskkill /F /IM chrome.exe /FI \"USERNAME eq "+getCurrentlyLoggedInUser+"\" ");  //To kill chrome driver processes
			} finally {}
	}



	@SuppressWarnings("deprecation")
	public void CloseBrowserForcefully_forCCrules() throws IOException{
		try {
			Runtime rt = Runtime.getRuntime();
			rt.exec("taskkill /F /IM chromedriver.exe /FI \"USERNAME eq "+getCurrentlyLoggedInUser+"\" ");  //To kill chrome driver processes
			rt.exec("taskkill /F /IM chrome.exe /FI \"USERNAME eq "+getCurrentlyLoggedInUser+"\" ");  //To kill chrome driver processes
			} finally {}	
	}



	@BeforeSuite
	/**
	 * Function to change the html report folder and Error Screenshot folder name before the Suite starts
	 */
	public void CreateRepFolder() throws Exception{
		CONSTANTS.setDateFormatSettings(); //set the date format before starting each test
		CONSTANTS.TESTREPORT_HTML_PATH = CONSTANTS.TESTREPORT_HTML_PATH+CONSTANTS.getINSURANCECOMPANY()+"_"+CONSTANTS.getENVIRONMENTTORUN()+week+CONSTANTS.WEEK_NUMBER+File.separator;
		CONSTANTS.TESTREPORT_SCREENSHOT_PATH=CONSTANTS.TESTREPORT_SCREENSHOT_PATH+CONSTANTS.getINSURANCECOMPANY()+"_"+CONSTANTS.getENVIRONMENTTORUN()+week+CONSTANTS.WEEK_NUMBER+File.separator+CONSTANTS.DateFormat+"ErrorScreenshots";

	}

	/**
	 * @param testResult
	 * @throws Exception 
	 * @throws  
	 */
	@AfterMethod 
	public void takeScreenShotOnFailure(ITestResult testResult) throws Exception {
		// Code for writing in test results in xls - Start here NG1
		//Code to write in excel report for data driven approach - Test case name appended with rule number
		String CC_fnol_rule_number = CONSTANTS.getCC_FNOL_RULE_NO();
		String TCNameBeforeAppendingWithRuleNo = ""; 
		String Jira_ExecutionStatus="";
		String Jira_Comments="";
		boolean TCNameChangeFlag = false;
		try {
			if (! CC_fnol_rule_number.equals("")) {
				TCNameBeforeAppendingWithRuleNo = CurrentRunningTCName;
				CurrentRunningTCName = CC_fnol_rule_number + "-" + TCNameBeforeAppendingWithRuleNo;
				TCNameChangeFlag = true; //Current running test case name changed for reporting purpose ( for excel report -CC rules)
			}
		}catch(Exception E) {

		}

		if (! CONSTANTS.getDC_XML_FILENAME().equals("")) {
			TCNameBeforeAppendingWithRuleNo = CurrentRunningTCName;
			CurrentRunningTCName = TCNameBeforeAppendingWithRuleNo + "-" + CONSTANTS.getDC_XML_FILENAME();
			TCNameChangeFlag = true; //Current running test case name changed for reporting purpose ( for excel report -CC rules)
		}

		rowNum = CONSTANTS.getREPORTXLS().findRowNumber(CurrentRunningTCName);
		//Write to the Excel only if the test case name, Application Name does NOT exist in the excel
		if(rowNum==0){
			rowNum = CONSTANTS.getREPORTXLS().getRowCount(sheetName);
			CONSTANTS.getREPORTXLS().setCellData(sheetName, "Name of the Executed Test Script", rowNum, CurrentRunningTCName);
			CONSTANTS.getREPORTXLS().setCellData(sheetName, "Application Name", rowNum, getApplicationName);
		}
		//If the test name already exists then assign the row at which test case name exists to row number
		CONSTANTS.getREPORTXLS().setCellData(sheetName, "Exec.Environment", rowNum, CONSTANTS.getINSURANCECOMPANY()+"-"+CONSTANTS.getENVIRONMENTTORUN());
		CONSTANTS.getREPORTXLS().setCellData(sheetName, "Execution Start Time", rowNum, ExecutionStartTime);
		// Code for writing in test results in xls - End here NG1

		if (testResult.getStatus() == ITestResult.FAILURE){
			//Create Error Screenshot Directory if doesnot exists
			File dir = new File(CONSTANTS.TESTREPORT_SCREENSHOT_PATH+CONSTANTS.fs+getApplicationName+CONSTANTS.fs);
			//If SecurityManager.checkWrite(java.lang.String) method denies write access to the file.Hence made the directory writable
			if(!(dir.setWritable(true))){
				Reporter.log("Exception in GenericFunctions-->takeScreenShotOnFailure function"); 
			}
			dir.mkdirs();
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			//Here the screenshot path is reduced to a maximum of 20 literals
			File imagePath=new File(CONSTANTS.TESTREPORT_SCREENSHOT_PATH+CONSTANTS.fs+getApplicationName+CONSTANTS.fs+CONSTANTS.DateFormat+Captialize(RunOnBrowser)+"_"+CurrentRunningTCName.substring(0, Math.min(CurrentRunningTCName.length(), 20)) +".jpg");
			if(!(imagePath.setWritable(true))){
				Reporter.log("Exception in GenericFunctions-->takeScreenShotOnFailure function"); 
			}
			try {
				ImageIO.write(image, "JPG", imagePath);
			} catch (IOException e) {
				throw e;
			}
			CONSTANTS.getREPORTXLS().setCellData(sheetName, "Execution Status", rowNum, "FAILED");						   //Code for writing in test results in xls
			CONSTANTS.getREPORTXLS().setCellData(sheetName, "Comments", rowNum, testResult.getThrowable().getMessage());   //Code for writing in test results in xls
			System.out.println("FAILED ");
			Jira_ExecutionStatus="2";
			Jira_Comments=" Test Environment : " + CONSTANTS.getENVIRONMENTTORUN() + ". " + testResult.getThrowable().getMessage().substring(0, 94) + "..."; //Limiting the error message to 100 chars
			//Extent Reports take screenshot
			test.log(Status.FAIL, "Failure Stack Trace: "+ testResult.getThrowable().getMessage());
			//Check below line if the screenshot is NOT displayed properly
			String RelativePathForScreenshot=System.getProperty("user.dir")+CONSTANTS.fs+"ExtentReports"+CONSTANTS.fs+CONSTANTS.getINSURANCECOMPANY()+"_"+CONSTANTS.getENVIRONMENTTORUN()+week+CONSTANTS.WEEK_NUMBER+CONSTANTS.fs;
			test.log(Status.FAIL, "Snapshot below: ");
			test.addScreenCaptureFromPath(imagePath.getAbsoluteFile().toString().replace(RelativePathForScreenshot, ""));
			//test.log(Status.FAIL,"Snapshot below: " + test.addScreenCaptureFromPath(imagePath.getAbsoluteFile().toString().replace(RelativePathForScreenshot, ""), ""));			

		}else if (testResult.getStatus() == ITestResult.SKIP) {
			System.out.println("SKIPPED ");
			CONSTANTS.getREPORTXLS().setCellData(sheetName, "Execution Status", rowNum, "NOT EXECUTED");			//Code for writing in test results in xls
			CONSTANTS.getREPORTXLS().setCellData(sheetName, "Comments", rowNum, "Test skipped: " + testResult.getThrowable().getMessage()); //Code for writing in test results in xls
			test.log(Status.SKIP, "Test skipped: " + testResult.getThrowable().getMessage());
			Jira_ExecutionStatus="-1";
			Jira_Comments= " Test Environment : " + CONSTANTS.getENVIRONMENTTORUN() + ". " +testResult.getThrowable().getMessage();
		}else{ //Code for writing in test results in xls -esle block
			CONSTANTS.getREPORTXLS().setCellData(sheetName, "Execution Status", rowNum, "PASSED"); 
			CONSTANTS.getREPORTXLS().setCellData(sheetName, "Comments", rowNum, "");
			//Test is PASSED/INFO/
			Jira_ExecutionStatus="1";
			Jira_Comments = " Test Environment : " + CONSTANTS.getENVIRONMENTTORUN() + ". " + "Test execution status updated from Webdriver at " + CONSTANTS.getDateFormatSettings().format(new Date()) ;
		}
		ExecutionEndTime=CONSTANTS.getDateFormatSettings().format(new Date()); //Code for writing in test results in xls
		CONSTANTS.getREPORTXLS().setCellData(sheetName, "Execution End Time", rowNum, ExecutionEndTime); //Code for writing in test results in xls
		ExecutionTime = Date_Difference(ExecutionStartTime, ExecutionEndTime);		
		CONSTANTS.getREPORTXLS().setCellData(sheetName, "Execution Time", rowNum, ExecutionTime); //Code for writing in test results in xls
		// Auto size the column widths based on the names
		CONSTANTS.getREPORTXLS().autoSizeColumns(); //Code for writing in test results in xls
		if (TCNameChangeFlag ) { // if TC name is changed for reporting purpose reset it back.
			CurrentRunningTCName = TCNameBeforeAppendingWithRuleNo; 
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
	 * Calculate date as per the PC/BC system clock time 
	 * @param ValidDateFormat - Valid Date format could be for eg: dd.MM.yyyy,..etc
	 * @param dateRequired - dateRequired field will take 0 for current date, positive number(1,2,..) for future date and negative number for Past dates 
	 * @throws ParseException
	 * @return Calculated Date as String
	 */
	@SuppressWarnings("static-access")
	public String ProvidePastCurrentOrFutureDate(String ValidDateFormat, int dateRequired) throws ParseException{
		String TESTING_SYSTEM_DATE = CONSTANTS.getTT_SYSTEM_DATE();
		//		String TESTING_SYSTEM_DATE = "02.04.2062";

		//Declarations
		Date today = new Date();
		DateFormat dateformat = new SimpleDateFormat(ValidDateFormat); 	//Valid Date format could be for eg: dd.MM.yyyy,..etc
		String TodayDateWitoutTime=dateformat.format(today);
		Calendar cal = new GregorianCalendar();	 //Create a calender class to be instanciated

		if ( TESTING_SYSTEM_DATE != null ) {  //if execution is on Time travel if block execution
			Date TTEnvDate = dateformat.parse(TESTING_SYSTEM_DATE);
			Date TodayDate = dateformat.parse(TodayDateWitoutTime); //Convert back to date time with HH:MM:SS = 00:00:00
			long diffInMillies = Math.abs(TTEnvDate.getTime() - TodayDate.getTime());
			long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			dateRequired = dateRequired + (int)diffInDays+1; //Add difference date to required date in application 
		}

		//Calculating date
		cal.setTime(today);
		cal.add(cal.DAY_OF_MONTH, dateRequired);	//dateRequired field will take 0 for current date, positive number(1,2,..) for future date and negative number for Past dates 
		Date Past_Date1 = cal.getTime();
		//Return the calculated date
		return dateformat.format(Past_Date1);

	}
		
	/**
	 * Function to Return the Time difference between two DateTimeStamp
	 * @param Start_Date
	 * @param End_Date
	 * @return
	 * @throws Exception
	 */
	public String Date_Difference(String Start_Date, String End_Date) throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date StartDate = simpleDateFormat.parse(Start_Date);
        Date EndDate = simpleDateFormat.parse(End_Date);
        
        // Calculating the difference in milliseconds
        long differenceInMilliSeconds
            = Math.abs(EndDate.getTime() - StartDate.getTime());
        // Calculating the difference in Hours
        long differenceInHrs = (differenceInMilliSeconds/(60 * 60 * 1000)) % 24;
        // Calculating the difference in Minutes
        long differenceInMins = (differenceInMilliSeconds/(60 * 1000)) % 60;
        // Calculating the difference in Seconds
        long differenceInSecs = (differenceInMilliSeconds/1000) % 60;
        
        return differenceInMins+":"+differenceInSecs;
	}
}
