/*'*************************************************************************************************************************************************
' CLASS NAME			: CONSTANTS
' DESCRIPTION			: USED TO STORE THE VARIABLES THAT ARE USED ACROSS ALL THE xCENTERS
' HOW TO USE			:
'-------------------------------------------------------------------------------------------------------------------------------------------------
' AUTHOR                    VERSION          CREATION DATE         REVIEWER NAME         REVIEWED DATE           COMMENTS 
'-------------------------------------------------------------------------------------------------------------------------------------------------
' Nagaraj Gaonkar			1.0	       
'*************************************************************************************************************************************************
*/
package com.guidewire.config;

import java.awt.Robot;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.guidewire.utilities.Xls_ReadWrite;






public final class CONSTANTS{
	
	private static long  STATICWAITTIME;
	public static long  STATICWAITTIME_1K_TO_2K=1000; 
	private static Robot robot;
	

	public static String BROWSER_TYPE = "chrome";
	private static boolean ACCEPTNEXTALERT = true;
	protected static final StringBuilder verificationerrors = new StringBuilder();
	private static Xls_ReadWrite TCXLS;
	private static Xls_ReadWrite CREDXLS;
	private static Xls_ReadWrite REPORTXLS;
	private static Xls_ReadWrite HOLIDAYSXLS;
	private static String USERNAME;
	private static String PASSWORD;
	private static String DBUSERNAME;
	private static String DBPASSWORD;
	
	private static String INSURANCECOMPANY;
	private static String APPLICATIONVERSION;
	private static String ENVIRONMENTTORUN;
	private static String CURRENT_SYSTEM_NAME;
	private static String CURRENT_RUNNING_TCName;
	private static String FAS_SYSTEM_NAME="S00479";
	private static String SAS_SYSTEM_NAME="S00591";
	public static String MASTER_ENVIRONMENT = "MASTER";
	private static String GW_VERSION;
	
	//To write individual rule number execution status in excel report
	private static String CC_FNOL_RULE_NO = "";
	private static String DC_XML_FILENAME = "";

	//POLICY DETAILS
	private static String POLICYNUM;
	private static String ACCOUNTNUM;
	private static String CLAIMNUM;
	private static String POLICY_HOLDER_NAME;
	private static String ACCOUNT_NUMBER;
	private static String EID_NUMBER;
	private static String CONSUMED = " ";
	private static String SSN_ID;
	private	static String POLICYEFFECTIVEDATE;
	private static String SUBMISSION;
	private static String PAYMENTPLAN;
	private static String POLICYPERIODSTATUS;
	private static String COVERAGEPACKAGE;
	private static String COMPANY;
	private static String LOB;
	private static String HOME_COMPANY_CODE;
	private static String MOTOR_VRN;
	private static String MOTOR_VIN;
	private static String MOTORVEHICLE_TYPE;
	private static String MOTORVEHICLE_CATEGORY;
	private static String MOTOR_MAKE;
	private static String MOTOR_MODEL;
	private static String CLAIM_NUMBER;
	private static String INVOICE_NUMBER;
	private static String CONTACT_ADDRESS;
	private static String CONTACT_POSTOFFICE;
	private static String CONTACT_POSTCODE;
	private static String COMPANY_NAME;
	
	
//	CONSTATNTS to update test script execution details in Jira
	private static  String ZEPHYR_BASE_URL= "https://prod-api.zephyr4jiracloud.com/connect";
	private static  String JIRA_STATUS_UPDATE = "N";
	private static  String JIRA_PROJECT_ID = null;
	private static  String JIRA_CYCLE_ID = null;
	private static  String JIRA_TESCASE_Exe_ID =null;  
	private static  String JIRA_TESTCASE_ID = null;
	private static  String JIRA_TC_ISSUE_ID = null;	
	private static  String JIRA_TESTSUITE_NAME = "Adhoc_Testsuite";
	
	//Generic Functions SoapUI Constants
	private static  String SOAP_TESTCASE_NAME = null;
	private static  String SOAP_TESTSUITE_NAME = null;

    //Batch Process info- pages
//	public static String TT_ENVIRONMENT = "TT3";
	public static String TT_ENVIRONMENT = "FUN9";
	
	public static String TT_SYSTEM_DATE = null;
    public static final String BATCH_PROCESS_INFO_HEADER = "Batch Process Info";
    public static final String CONFIGURATION_HEADER = "Configuration";
    public static final String CONSISTANCY_CHECKS_HEADER = "Consistency Checks";
    public static final String TESTING_SYSTEM_CLOCK_HEADER = "Testing System Clock";
    public static final String ADMINTOOLSGENERICFUNCTIONS= " "; //This page is created ( not available in application ) to write generic functions involves differant pages in admin tools
    
    //Batch Process info - menu and menu options
    public static final String SERVER_TOOLS = "Server Tools";
    public static final String INTERNAL_TOOLS = "Internal Tools";
    public static final String SYSTEM_CLOCK = "System Clock"; //This menu option displayed for BC , Where as in PC it is displayed as "testing sytem clock"
    
	//Batch Process info - Side Menu's
	public static final String INFO_PAGES = "Info Pages";
		public static final String CONFIGURATION = "Configuration";
		public static final String CONSISTENCY_CHECKS = "Consistency Checks";
		
		
	//TO BE USED FOR FUTURE PURPOSE
	protected static String URLTOBEUSED = null;
	public static final String SERVERNAME="S00255.TAPIO001.TAPIOLA.FI"; 
	public static final String SERVERPORTNUMBER="50000";
	public static final String DATABASETOCONNECT="DSN";
	//for report start time and end time format
	private static SimpleDateFormat DateFormatSettings;
	public static final String fs=File.separator;
	//for additional accuracy use the String format for date as "ddmmyyyy_hhmmss_sss_"
	public static final String DateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss_").format(new Date());
	public static final String ExtentConfigPath=System.getProperty("user.dir")+fs+"src\\main\\java"+fs+CONSTANTS.class.getPackage().getName().replace(".",fs)+fs+"extent-config.xml";
	public static String TESTREPORT_HTML_PATH=System.getProperty("user.dir")+fs+"ExtentReports"+fs;
	public static String TESTREPORT_SCREENSHOT_PATH=System.getProperty("user.dir")+fs+"ExtentReports"+fs;
	public final static String WEEK_NUMBER=new SimpleDateFormat("w").format(new java.util.Date());
//	public static final String STRDOWNLOADPATH=System.getProperty("user.dir")+fs+"downloads"+fs;    //CL:- Commented this and added below line
	public static final String STRDOWNLOADPATH="C:"+fs+"Users"+fs+System.getProperty("user.name")+fs+"Downloads"+fs;
	public static final String SAMPLEFILES_FOLDER=System.getProperty("user.dir")+fs+"SampleFiles"+fs;
	public static final String DOWNLOADPATH=System.getProperty("user.dir")+fs+"downloads";
	public static final String MOVEDFILES_FROMDOWNLOADS = System.getProperty("user.dir")+fs+"MovedFilesFrom_downloads"+fs;
	public static final String UPLOADS=System.getProperty("user.dir")+fs+"uploads"+fs;
	public static final String SYSTEM_DOWNLOADS="C:"+fs+"Users"+fs+System.getProperty("user.name")+fs+"Downloads";
	public static final String SYSTEM_DOCUMENTS="C:"+fs+"Users"+fs+System.getProperty("user.name")+fs+"Documents";
	public static final String SAHAKKA_FOLDER=System.getProperty("user.dir")+fs+"Sahakka"+fs;
	public static final String SAHAKKA_TIF_FILE= "Invoice.tif";
	public static final String HC_ACCIDENT_TIF_FILE= "HC_Accident_Output_Invoice.tif";
	public static final String HOME_CONTENT_TIF_FILE= "Home_Content_Output_Invoice.tif";
	public static final String SAHAKKA_MOTOR_TIF_FILE= "Motor_Invoice.tif";
	public static final String SAHAKKA_TIF_CONTAINER = "Tif_Container"+fs;
	public static final String SAHAKKA_INPUT_XML="2162022_334455602_080191-131N_MA.xml";
	public static final String HC_ACCIDENT_INPUT_XML="HC_Accident_Invoice.xml";
	public static final String HOME_CONTENT_INPUT_XML="Home_Content_Invoice.xml";
	public static final String SAHAKKA_MOTOR_PROPERTY_INPUT_XML="Invoice_MotorProperty.xml";
	public static final String SAHAKKA_MOTOR_PERSONALINJURY_INPUT_XML="Invoice_MotorPersonalInjury.xml";
//	public static final String SAHAKKA_MOTOR_PERSONALINJURY_INPUT_XML="Invoice_MotorPersonalInjury.xml";
	public static final String SAHAKKA_MOTOR_LIABILITYINJURY_INPUT_XML="Invoice_MotorLiabilityInjury.xml";
	public static final String SAHAKKA_MOTOR_ART6_115669_LIABILITYINJURY_INPUT_XML="Motor_SIT3_ART6_115669.xml";
	public static final String INPUT_XML="1PLIFN11_Dog.xml";
	public static final String SAHAKKA_OUTPUT_XML="Invoice.xml";
	public static final String SAHAKKA_MOTOR_OUTPUT_XML="Motor_Invoice.xml";
	public static final String HC_ACCIDENT_OUTPUT_XML="HC_Accident_Output_Invoice.xml";
	public static final String HOME_CONTENT_OUTPUT_XML="Home_Content_Output_Invoice.xml";
	public static final String SAHAKKA_COMPRESSED_FILE="Invoice.zip";
	public static final String SAHAKKA_MOTOR_COMPRESSED_FILE="Motor_Invoice.zip";
	public static final String HC_ACCIDENT_COMPRESSED_FILE="HC_Accident_Output_Invoice.zip";
	public static final String HOME_CONTENT_COMPRESSED_FILE="Home_Content_Output_Invoice.zip";
//	public static final String SAHAKKA_NW_DRIVE="D:"+fs+"Test_NWDrive"+fs;
	public static final String SAHAKKA_NW_DRIVE_SIT1="\\\\netapp04.tapio001.tapiola.fi\\data\\Yhteiset\\Testaus\\PP_kerros\\Sahakka\\Laskut_in\\Systeemitesti"+fs+"LT"+fs;
	public static final String SAHAKKA_NW_DRIVE_MOTOR="\\\\\\netapp04.tapio001.tapiola.fi\\\\data\\\\Yhteiset\\\\Testaus\\\\PP_kerros\\\\Sahakka\\\\Laskut_in\\\\SITNEXT"+fs+"LT"+fs;
	public static final String SAHAKKA_NW_DRIVE_MOTOR_SIT3="\\\\\\netapp04.tapio001.tapiola.fi\\\\data\\\\Yhteiset\\\\Testaus\\\\PP_kerros\\\\Sahakka\\\\Laskut_in\\\\SITNEXT"+fs+"LT"+fs;
	public static String RUNTIME_TC_NAME;
	//cURL paths                                     
	public static final String CURL_EXE_LOCATION = "C:"+fs+"Program Files"+fs+"curl-7.64.1-win64-mingw"+fs+"bin"+fs;
	public static final String SOURCE_FOLDER = System.getProperty("user.dir")+fs+"cURL"+fs+"Source"+fs;
	public static final String DESTINATION_FOLDER = System.getProperty("user.dir")+fs+"cURL"+fs+"Destination"+fs;
//	public static final String DOCCREA_SERVER = "http://10.16.44.11:9010/previewDocument/";  //Test Server 
	public static final String DOCCREA_SERVER = "http://10.16.44.62:9010/previewDocument/";  //Test Server 

//	public static final String DOCCREA_SERVER = "http://10.16.44.11:9030/previewDocument/";  //UAT Server 
	public static boolean PDF_CONTENT_AVAILBILITY = false;
	
	
	//CONSTATNTS TO RUN SOAPUI SCRIPTS VIA COMMAND LINE - For BC payments
	public static final String PROJECT_NAME_WITH_PATH_PART1 = "D:"+fs+"SOAPUI_Workspace"+fs+"WebService-test-automation"+fs;
	public static final String PROJECT_NAME_WITH_PATH_PART2 = "_BillingCenter-soapui-project.xml";
//	public static final String BATCH_FILENAME_WITH_PATH = "C:"+fs+"TestAutomation"+fs+"SoapUI-5.7.0"+fs+"bin"+fs+"testrunner.bat";
	public static final String BATCH_FILENAME_WITH_PATH = "D:"+fs+"MovedFolders"+fs+"TestAutomation"+fs+"SoapUI-5.7.0"+fs+"bin"+fs+"testrunner.bat";
	public static final String DOSCOMMAND = "cmd.exe /C start cmd.exe /C";
	public static final String TESTSUITE_NAME = "-sBC_payments";
	public static final String TESTCASE_NAME = "-cTC001_BC_Payment";
	public static final String REF_NUM_PARAM = "-GrefNum=";
	public static final String AMT_PARAM = "-Gamt=";
//	public static final String SOAPUI_BIN_FOLDER  ="C:"+fs+"TestAutomation"+fs+"SoapUI-5.7.0"+fs+"bin"+fs;
	public static final String SOAPUI_BIN_FOLDER  ="D:"+fs+"TestAutomation"+fs+"SoapUI-5.7.0"+fs+"bin"+fs;
	
	//driver path location
	//public static final String FIREFOXDRIVERPATH=System.getProperty("user.dir")+fs+"src"+fs+CONSTANTS.class.getPackage().getName().replace(".",fs)+fs+"webdriver_geckodriver.exe";
	public static final String FIREFOXDRIVERPATH1=System.getProperty("user.dir")+"\\src\\main\\java\\com\\guidewire\\Config\\geckodriver.exe";
	//public static final String CHROMEDRIVERPATH=System.getProperty("user.dir")+fs+"src"+fs+CONSTANTS.class.getPackage().getName().replace(".",fs)+fs+"webdriver_chromedriver.exe";
	public static final String CHROMEDRIVERPATH=System.getProperty("user.dir")+"\\src\\main\\java\\com\\guidewire\\Config\\chromedriver.exe";
	public static final String CHROMEDRIVERPATH_142=System.getProperty("user.dir")+"\\src\\main\\java\\com\\guidewire\\Config\\chromedriver_142.exe";
	public static final String CHROMEDRIVERPATH_146=System.getProperty("user.dir")+"\\src\\main\\java\\com\\guidewire\\Config\\chromedriver_146.exe";
	public static final String CHROMEDRIVERPATH_140=System.getProperty("user.dir")+"\\src\\main\\java\\com\\guidewire\\Config\\chromedriver_140.exe";
	
	public static final String IEDRIVERPATH=System.getProperty("user.dir")+"\\src\\main\\java\\com\\guidewire\\Config\\IEDriverServer.exe";
	public static final String AUTHENTICATION_HANDLER=System.getProperty("user.dir")+"\\src\\main\\java\\com\\guidewire\\Config\\WindowsAuthentication.exe";  //For Chrome
	//public static final String AUTHENTICATION_HANDLER=System.getProperty("user.dir")+"\\src\\main\\java\\com\\guidewire\\Config\\IE_WindowsAuthentication.exe"; //For IE
	public static final String QUIT_PAGE_HANDLER=System.getProperty("user.dir")+"\\src\\main\\java\\com\\guidewire\\Config\\AreYouSureYouWantToLeave.exe";
	public static final String PHANTOMJSDRIVERPATH = System.getProperty("user.dir")+"\\src\\main\\java\\com\\guidewire\\Config\\phantomjs.exe";
	public static final String MSEDGEDRIVERPATH=System.getProperty("user.dir")+"\\src\\main\\java\\com\\guidewire\\Config\\MicrosoftWebDriver.exe";
	public static final String EDGE_BROWSERQUIT_HANDLER=System.getProperty("user.dir")+"\\src\\main\\java\\com\\guidewire\\Config\\AreYouSureYouWantToLeave.exe";
	public static final String KEEP_PDF_HANDLER=System.getProperty("user.dir")+"\\src\\main\\java\\com\\guidewire\\Config\\Keep_DownloadPDF.exe";  //For Chrome
		
	//General messages 
	
	public static final String NO_SEARCH_RESULTS_MESSAGE = "The search returned zero results.";
	
		
	//General dropdown option
	public static final String YES= "Yes";
	public static final String NO= "No";
	public static final String UNKNOWN = "Unknown";
	public static final String INSURED = "Insured";
	
	//Commissioning/decommissioning
	private static String PC_Comm_Decomm_Num= "";
	
	private CONSTANTS() {
		throw new IllegalAccessError("CONSTANTS class");
	}
	
	/**
	 * @return
	 */
	public static Xls_ReadWrite getTCXLS() {
		return TCXLS;
	}

	/**
	 * @param tCXLS
	 */
	public static void setTCXLS(Xls_ReadWrite tCXLS) {
		CONSTANTS.TCXLS = tCXLS;
	}

	
	/**
	 * @return
	 */
	public static Xls_ReadWrite getCREDXLS() {
		return CREDXLS;
	}

	/**
	 * @param cREDXLS
	 */
	public static void setCREDXLS(Xls_ReadWrite cREDXLS) {
		CREDXLS = cREDXLS;
	}

	/**
	 * @return
	 */
	public static Xls_ReadWrite getREPORTXLS() {
		return REPORTXLS;
	}

	/**
	 * @param rEPORTXLS
	 */
	public static void setREPORTXLS(Xls_ReadWrite rEPORTXLS) {
		REPORTXLS = rEPORTXLS;
	}
	
	/**
	 * @return
	 */
	public static Robot getRobot() {
		return robot;
	}

	/**
	 * @param robot
	 */
	public static void setRobot(Robot robot) {
		CONSTANTS.robot = robot;
	}

	
	/**
	 * @return
	 */
	public static String getUSERNAME() {
		return USERNAME;
	}

	/**
	 * @param lDAPUSERNAME
	 */
	public static void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	/**
	 * @return
	 */
	public static String getPASSWORD() {
		return PASSWORD;
	}

	/**
	 * @param lDAPPASSWORD
	 */
	public static void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public static String get_DB_USERNAME() {
		return DBUSERNAME;
	}

	/**
	 * @param lDAPUSERNAME
	 */
	public static void set_DB_USERNAME(String userName) {
		DBUSERNAME = userName;
	}

	/**
	 * @return
	 */
	public static String get_DB_PASSWORD() {
		return DBPASSWORD;
	}

	/**
	 * @param lDAPPASSWORD
	 */
	public static void set_DB_PASSWORD(String password) {
		DBPASSWORD = password;
	}

	/**
	 * @return
	 */
	public static String getINSURANCECOMPANY() {
		return INSURANCECOMPANY;
	}

	/**
	 * @param iNSURANCECOMPANY
	 */
	public static void setINSURANCECOMPANY(String iNSURANCECOMPANY) {
		INSURANCECOMPANY = iNSURANCECOMPANY;
	}

		
	/**
	 * @return
	 */
	public static String getAPPLICATIONVERSION() {
		return APPLICATIONVERSION;
	}

	/**
	 * @param aPPLICATIONVERSION
	 */
	public static void setAPPLICATIONVERSION(String aPPLICATIONVERSION) {
		APPLICATIONVERSION = aPPLICATIONVERSION;
	}

	/**
	 * @return
	 */
	public static String getENVIRONMENTTORUN() {
		return ENVIRONMENTTORUN;
	}

	/**
	 * @param eNVIRONMENTTORUN
	 */
	public static void setENVIRONMENTTORUN(String eNVIRONMENTTORUN) {
		ENVIRONMENTTORUN = eNVIRONMENTTORUN;
	}

			
	/**
	 * @return
	 */
	public static long getSTATICWAITTIME() {
		return STATICWAITTIME;
	}

	/**
	 * @param sTATICWAITTIME
	 */
	public static void setSTATICWAITTIME(long sTATICWAITTIME) {
		STATICWAITTIME = sTATICWAITTIME;
	}

	/**
	 * @return
	 */
	public static boolean isACCEPTNEXTALERT() {
		return ACCEPTNEXTALERT;
	}

	/**
	 * @param aCCEPTNEXTALERT
	 */
	public static void setACCEPTNEXTALERT(boolean aCCEPTNEXTALERT) {
		ACCEPTNEXTALERT = aCCEPTNEXTALERT;
	}
	
	/**
	 * @return the dateFormatSettings
	 */
	public static SimpleDateFormat getDateFormatSettings() {
		return DateFormatSettings;
	}

	/**
	 * @param dateFormatSettings the dateFormatSettings to set
	 */
	public static void setDateFormatSettings() {
		DateFormatSettings = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss",Locale.ENGLISH);
	}

	
	/**
	 * @return
	 */
	public static String getPOLICYNUM() {
		return POLICYNUM;
	}

	/**
	 * @param pOLICYNUM
	 */
	public static void setPOLICYNUM(String pOLICYNUM) {
		POLICYNUM = pOLICYNUM;
	}
	
	/**
	 * @return
	 */
	public static String getACCOUNTYNUM() {
		return ACCOUNTNUM;
	}

	/**
	 * @param aCCOUNTNUM
	 */
	public static void setACCOUNTNUM(String aCCOUNTNUM) {
		ACCOUNTNUM = aCCOUNTNUM;
	}
	
	/**
	 * @return
	 */
	public static String getCLAIMNUM() {
		return CLAIMNUM;
	}

	/**
	 * @param cLAIMNUM
	 */
	public static void setCLAIMNUM(String cLAIMNUM) {
		CLAIMNUM = cLAIMNUM;
	}
	
	/**
	 * @return
	 */
	public static String getPOLICY_HOLDER_NAME() {
		return POLICY_HOLDER_NAME;
	}

	/**
	 * @param pOLICY_HOLDER_NAME
	 */
	public static void setPOLICY_HOLDER_NAME(String pOLICY_HOLDER_NAME) {
		POLICY_HOLDER_NAME = pOLICY_HOLDER_NAME;
	}
	
	
	/**
	 * @return
	 */
	public static String getACCOUNT_NUMBER() {
		return ACCOUNT_NUMBER;
	}

	/**
	 * @param pOLICY_HOLDER_NAME
	 */
	public static void setACCOUNT_NUMBER(String aCCOUNT_NUMBER) {
		ACCOUNT_NUMBER = aCCOUNT_NUMBER;
	}
	
	/**
	 * @return
	 */
	public static String getFAS_SYSTEM_NAME() {
		return FAS_SYSTEM_NAME;
	}

	/**
	 * @param fAS_SYSTEM_NAME
	 */
	public static void setFAS_SYSTEM_NAME(String fAS_SYSTEM_NAME) {
		FAS_SYSTEM_NAME = fAS_SYSTEM_NAME;
	}
	
	/**
	 * @return
	 */
	public static String getSAS_SYSTEM_NAME() {
		return SAS_SYSTEM_NAME;
	}

	/**
	 * @param fAS_SYSTEM_NAME
	 */
	public static void setSAS_SYSTEM_NAME(String sAS_SYSTEM_NAME) {
		SAS_SYSTEM_NAME = sAS_SYSTEM_NAME;
	}
	
	/**
	 * @return
	 */
	public static String getCURRENT_SYSTEM_NAME() {
		return CURRENT_SYSTEM_NAME;
	}

	/**
	 * @param cURRENT_SYSTEM_NAME
	 */
	public static void setCURRENT_SYSTEM_NAME(String cURRENT_SYSTEM_NAME) {
		CURRENT_SYSTEM_NAME = cURRENT_SYSTEM_NAME;
	}
	
	/**
	 * @return
	 */
	public static String getCURRENT_RUNNING_TCName() {
		return CURRENT_RUNNING_TCName;
	}

	/**
	 * @param cURRENT_SYSTEM_NAME
	 */
	public static void setCURRENT_RUNNING_TCName(String cURRENT_RUNNING_TCName) {
		CURRENT_RUNNING_TCName = cURRENT_RUNNING_TCName;
	}
	
	/**
	 * @return
	 */
	public static String getGW_VERSION() {
		return GW_VERSION;
	}

	/**
	 * @param cURRENT_SYSTEM_NAME
	 */
	public static void setGW_VERSION(String gW_VERSION) {
		GW_VERSION = gW_VERSION;
	}


	/**
	 * @return
	 */
	public static String getCC_FNOL_RULE_NO() {
		return CC_FNOL_RULE_NO;
	}

	/**
	 * @param cC_FNOL_RULE_NO
	 */
	public static void setCC_FNOL_RULE_NO(String cC_FNOL_RULE_NO) {
		CC_FNOL_RULE_NO = cC_FNOL_RULE_NO;
	}
	
	
	/**
	 * @return
	 */
	public static String getDC_XML_FILENAME() {
		return DC_XML_FILENAME;
	}

	/**
	 * @param cC_FNOL_RULE_NO
	 */
	public static void setDC_XML_FILENAME(String dC_XML_FILENAME) {
		DC_XML_FILENAME = dC_XML_FILENAME;
	}
	
	/**
	 * @return
	 */
	public static String getTT_SYSTEM_DATE() {
		return TT_SYSTEM_DATE;
	}

	/**
	 * @param cC_FNOL_RULE_NO
	 */
	public static void setTT_SYSTEM_DATE(String tT_SYSTEM_DATE) {
		TT_SYSTEM_DATE = tT_SYSTEM_DATE;
	}
	
	/**
	 * get Holidays Excels
	 * @return
	 */
	public static Xls_ReadWrite getHOLIDAYXLS() {
		return HOLIDAYSXLS;
	}
	
	/**
	 * Sets Holidays Excel Instance
	 * @param hOLIDAYSXLS
	 */
	public static void setHOLIDAYXLS(Xls_ReadWrite hOLIDAYSXLS) {
		HOLIDAYSXLS = hOLIDAYSXLS;
	} 

	/**
	 * @return
	 */
	public static String getEID_NUMBER() {
		return EID_NUMBER;
	}

	/**
	 * @param eID_NUMBER
	 */
	public static void setEID_NUMBER(String eID_NUMBER) {
		EID_NUMBER = eID_NUMBER;
	}
	
	/**
	 * @return
	 */
	public static String getSSN_ID() {
		return SSN_ID;
	}

	/**
	 * @param sSN_ID
	 */
	public static void setSSN_ID(String sSN_ID) {
		SSN_ID = sSN_ID;
	}
	
	/**
	 * @return
	 */
	public static String getPOLICYEFFECTIVEDATE() {
		return POLICYEFFECTIVEDATE;
	}

	/**
	 * @param pOLICYEFFECTIVEDATE
	 */
	public static void SetPOLICYEFFECTIVEDATE(String pOLICYEFFECTIVEDATE) {
		POLICYEFFECTIVEDATE = pOLICYEFFECTIVEDATE;
	}
	
	/**
	 * @return
	 */
	public static String getSUBMISSION() {
		return SUBMISSION;
	}

	/**
	 * @param sUBMISSION
	 */
	public static void setSUBMISSION(String sUBMISSION) {
		SUBMISSION = sUBMISSION;
	}
	
	/**
	 * @return
	 */
	public static String getPAYMENTPLAN() {
		return PAYMENTPLAN;
	}

	/**
	 * @param pAYMENTPLAN
	 */
	public static void setPAYMENTPLAN(String pAYMENTPLAN) {
		PAYMENTPLAN = pAYMENTPLAN;
	}
	
	/**
	 * @return
	 */
	public static String getPOLICYPERIODSTATUS() {
		return POLICYPERIODSTATUS;
	}

	/**
	 * @param pOLICYPERIODSTATUS
	 */
	public static void setPOLICYPERIODSTATUS(String pOLICYPERIODSTATUS) {
		POLICYPERIODSTATUS = pOLICYPERIODSTATUS;
	}
	
	/**
	 * @return
	 */
	public static String getCOVERAGEPACKAGE() {
		return COVERAGEPACKAGE;
	}

	/**
	 * @param cOVERAGEPACKAGE
	 */
	public static void setCOVERAGEPACKAGE(String cOVERAGEPACKAGE) {
		COVERAGEPACKAGE = cOVERAGEPACKAGE;
	}
	
	/**
	 * @return
	 */
	public static String getCOMPANY() {
		return COMPANY;
	}

	/**
	 * @param cOMPANY
	 */
	public static void setCOMPANY(String cOMPANY) {
		COMPANY = cOMPANY;
	}
	
	/**
	 * @return
	 */
	public static String getLOB() {
		return LOB;
	}

	/**
	 * @param lOB
	 */
	public static void setLOB(String lOB) {
		LOB = lOB;
	}
	
	/**
	 * @return
	 */
	public static String getHOME_COMPANY_CODE() {
		return HOME_COMPANY_CODE;
	}

	/**
	 * @param hOME_COMPANY_CODE
	 */
	public static void setHOME_COMPANY_CODE(String hOME_COMPANY_CODE) {
		HOME_COMPANY_CODE = hOME_COMPANY_CODE;
	}
	
	/**
	 * @return
	 */
	public static String getMOTOR_VRN() {
		return MOTOR_VRN;
	}

	/**
	 * @param mOTOR_VRN
	 */
	public static void setMOTOR_VRN(String mOTOR_VRN) {
		MOTOR_VRN = mOTOR_VRN;
	}
	
	/**
	 * @return
	 */
	public static String getMOTOR_VIN() {
		return MOTOR_VIN;
	}

	/**
	 * @param mOTOR_VIN
	 */
	public static void setMOTOR_VIN(String mOTOR_VIN) {
		MOTOR_VIN = mOTOR_VIN;
	}
	
	/**
	 * @return
	 */
	public static String getMOTORVEHICLE_TYPE() {
		return MOTORVEHICLE_TYPE;
	}

	/**
	 * @param mOTORVEHICLE_TYPE
	 */
	public static void setMOTORVEHICLE_TYPE(String mOTORVEHICLE_TYPE) {
		MOTORVEHICLE_TYPE = mOTORVEHICLE_TYPE;
	}
	
	/**
	 * @return
	 */
	public static String getMOTORVEHICLE_CATEGORY() {
		return MOTORVEHICLE_CATEGORY;
	}

	/**
	 * @param mOTORVEHICLE_CATEGORY
	 */
	public static void setMOTORVEHICLE_CATEGORY(String mOTORVEHICLE_CATEGORY) {
		MOTORVEHICLE_CATEGORY = mOTORVEHICLE_CATEGORY;
	}
	
	/**
	 * @return
	 */
	public static String getMOTOR_MAKE() {
		return MOTOR_MAKE;
	}

	/**
	 * @param mOTOR_MAKE
	 */
	public static void setMOTOR_MAKE(String mOTOR_MAKE) {
		MOTOR_MAKE = mOTOR_MAKE;
	}
	
	/**
	 * @return
	 */
	public static String getMOTOR_MODEL() {
		return MOTOR_MODEL;
	}

	/**
	 * @param mOTOR_MODEL
	 */
	public static void setMOTOR_MODEL(String mOTOR_MODEL) {
		MOTOR_MODEL = mOTOR_MODEL;
	}
	
	/**
	 * @return
	 */
	public static String getTDMdataConsumed() {
		return CONSUMED;
	}

	/**
	 * @param CONSUMED
	 */
	public static void setTDMdataConsumed(String cONSUMED) {
		CONSUMED = cONSUMED;
	}
	/**
	 * @return
	 */
	public static String getCLAIM_NUMBER() {
		return CLAIM_NUMBER;
	}

	/**
	 * @param cLAIM_NUMBER
	 */
	public static void setCLAIM_NUMBER(String cLAIM_NUMBER) {
		CLAIM_NUMBER = cLAIM_NUMBER;
	}
	
	/**
	 * @return
	 */
	public static String getINVOICE_NUMBER() {
		return INVOICE_NUMBER;
	}

	/**
	 * @param cLAIM_NUMBER
	 */
	public static void setINVOICE_NUMBER(String iNVOICE_NUMBER) {
		INVOICE_NUMBER = iNVOICE_NUMBER;
	}
	
	/**
	 * @return
	 */
	public static String getCONTACTADDRESS() {
		return CONTACT_ADDRESS;
	}

	/**
	 * @param cLAIM_NUMBER
	 */
	public static void setCONTACT_ADDRESS(String cONTACT_ADDRESS) {
		CONTACT_ADDRESS = cONTACT_ADDRESS;
	}
	
	/**
	 * @return
	 */
	public static String getCONTACT_POSTOFFICE() {
		return CONTACT_POSTOFFICE;
	}

	/**
	 * @param cLAIM_NUMBER
	 */
	public static void setCONTACT_POSTOFFICE(String cONTACT_POSTOFFICE) {
		CONTACT_POSTOFFICE = cONTACT_POSTOFFICE;
	}
	
	/**
	 * @return
	 */
	public static String getCONTACT_POSTCODE() {
		return CONTACT_POSTCODE;
	}

	/**
	 * @param cLAIM_NUMBER
	 */
	public static void setCONTACT_POSTCODE(String cONTACT_POSTCODE) {
		CONTACT_POSTCODE = cONTACT_POSTCODE;
	}
	
	
	public static String getZEPHYR_BASE_URL() {
		return ZEPHYR_BASE_URL;
	}
	
	public static String setZEPHYR_BASE_URL(String zEPHYR_BASE_URL ) {
		return ZEPHYR_BASE_URL=zEPHYR_BASE_URL;
	}
	
	public static String getJIRA_PROJECT_ID() {
		return JIRA_PROJECT_ID;
	}


	public static void setJIRA_PROJECT_ID(String jIRA_PROJECT_ID) {
		JIRA_PROJECT_ID = jIRA_PROJECT_ID;
	}
	
	public static String getJIRA_CYCLE_ID() {
		return JIRA_CYCLE_ID;
	}


	public static void setJIRA_CYCLE_ID(String jIRA_CYCLE_ID) {
		JIRA_CYCLE_ID = jIRA_CYCLE_ID;
	}
	
	public static String getJIRA_TESCASE_Exe_ID() {
		return JIRA_TESCASE_Exe_ID;
	}


	public static void setJIRA_TESCASE_Exe_ID(String jIRA_TESCASE_Exe_ID) {
		JIRA_TESCASE_Exe_ID = jIRA_TESCASE_Exe_ID;
	}
	
	public static String getJIRA_TESTCASE_ID() {
		return JIRA_TESTCASE_ID;
	}


	public static void setJIRA_TESTCASE_ID(String jIRA_TESTCASE_ID) {
		JIRA_TESTCASE_ID = jIRA_TESTCASE_ID;
	}
	
	public static String getJIRA_TC_ISSUE_ID() {
		return JIRA_TC_ISSUE_ID;
	}


	public static void setJIRA_TC_ISSUE_ID(String jIRA_TC_ISSUE_ID) {
		JIRA_TC_ISSUE_ID = jIRA_TC_ISSUE_ID;
	}
	
	public static String getJIRA_STATUS_UPDATE() {
		return JIRA_STATUS_UPDATE;
	}


	public static void setJIRA_STATUS_UPDATE(String jIRA_STATUS_UPDATE) {
		JIRA_STATUS_UPDATE = jIRA_STATUS_UPDATE;
	}
	
	public static String getJIRA_TESTSUITE_NAME() {
		return JIRA_TESTSUITE_NAME;
	}


	public static void setJIRA_TESTSUITE_NAME(String jIRA_TESTSUITE_NAME) {
		JIRA_TESTSUITE_NAME = jIRA_TESTSUITE_NAME;
	}
	
	public static String getSOAPTESTSUITE_NAME() {
		return SOAP_TESTSUITE_NAME;
	}


	public static void setSOAPTESTSUITE_NAME(String sOAPTESTSUITE_NAME) {
		SOAP_TESTSUITE_NAME = sOAPTESTSUITE_NAME;
	}	
	
	public static String getSOAPTESTCASE_NAME() {
		return SOAP_TESTCASE_NAME;
	}


	public static void setSOAPTESTCASE_NAME(String sOAPTESTCASE_NAME) {
		SOAP_TESTCASE_NAME = sOAPTESTCASE_NAME;
	}
//	public static String getRUNTIME_TC_NAME() {
//		return RUNTIME_TC_NAME;
//	}
//
//
//	public static void setRUNTIME_TC_NAME(String rUNTIME_TC_NAME) {
//		RUNTIME_TC_NAME = rUNTIME_TC_NAME;
//	}
	
	/**
	 * @param pC_Comm_Decomm_Num
	 */
	public static void setPC_Comm_Decomm_Num(String pC_Comm_Decomm_Num) {
		PC_Comm_Decomm_Num = pC_Comm_Decomm_Num;
	}
	
	/**
	 * @return
	 */
	public static String getPC_Comm_Decomm_Num() {
		return PC_Comm_Decomm_Num;
	}
	
	public static String getcompany_name() {
		return COMPANY_NAME;
	}
}
