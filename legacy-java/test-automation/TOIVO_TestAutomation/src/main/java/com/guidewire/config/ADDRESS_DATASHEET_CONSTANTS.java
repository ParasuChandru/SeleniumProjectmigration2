/*'*************************************************************************************************************************************************
' Class Name			: Address_DataSheet_Constants
' Description			: Used to store the Address DataSheet variables that are used across all the TOIVO applications.
' How to Use			:
'-------------------------------------------------------------------------------------------------------------------------------------------------
' Author                    Version          Creation Date         Reviewer Name         Reviewed Date           Comments 
'-------------------------------------------------------------------------------------------------------------------------------------------------
' 					         v1.0             06-January-2016		
'*************************************************************************************************************************************************
*/package com.guidewire.config;

import java.io.File;	

public class ADDRESS_DATASHEET_CONSTANTS {

	
	public static final String fs=File.separator;
	/**
	 * Test Data Worksheet part for all applications
	 */
	public static final String TESTCASES_WORKSHEET ="Testcases";
	public static final String TESTCASES_TESTCASEID="TestCaseID";
	public static final String TESTDATA_WORKSHEET = "ApplicationLevelTestData";
	
	/*
	 * CREDENTIALS Worksheet
	 */
	public static final String CRED_INPUT_FILE=System.getProperty("user.dir")+fs+"TestData"+fs+"ApplicationsHub.xlsx";
	public static final String CRED_WORKSHEET ="Credentials";
	public static final String CRED_LOGGEDUSER="CurrentlyLoggedUser_OR_AppUser";
	public static final String CRED_LT_USERNAME="LT_Username";
	public static final String CRED_LT_PASSWORD="LT_Password";
	public static final String CRED_TRVA_USERNAME="TRVA_Username";
	public static final String CRED_TRVA_PASSWORD="TRVA_Password";
	public static final String CRED_DataBase_USERNAME="DataBaseUserName";
	public static final String CRED_DataBase_PASSWORD="DataBasePassword";
	
	/*
	 * To run and set wait time for Guidewire Applications
	 */
	public static final String APPTORUN_WORKSHEET ="RunApplications";
	public static final String APP_NAMETOLOAD="ApplicationsToRun";
	public static final String APP_STATICWAITTIME="WaitTimeForApp";
	public static final String RUNMODE="Runmode";
	/**
	 * LT_URL_Applications Worksheet
	 */
	public static final String LT_APPLICATIONSURLPARAMETERS_BASEDONENVSELCTED_WORKSHEET="LT_ApplicationURLParameters";
	public static final String LT_APPLICATIONSURLPARAMETERS_APPLICATIONSTORUNWRTENVIRONMENT = "ApplicationsToRunWRTEnvironment"; 
	public static final String LT_APPLICATIONSURLPARAMETERS_URLTOBEUSED = "URLTobeUsed";
	
	/**
	 * TRVA_URL_Applications Worksheet
	 */
	public static final String TRVA_APPLICATIONSURLPARAMETERS_BASEDONENVSELCTED_WORKSHEET="TRVA_ApplicationURLParameters";
	public static final String TRVA_APPLICATIONSURLPARAMETERS_APPLICATIONSTORUNWRTENVIRONMENT = "ApplicationsToRunWRTEnvironment"; 
	public static final String TRVA_APPLICATIONSURLPARAMETERS_VERSIONOFTHEAPPLICATION = "VersionOfTheApplication";
	public static final String TRVA_APPLICATIONSURLPARAMETERS_URLTOBEUSED = "URLTobeUsed";
	public static final String TRVA_APPLICATIONSURLPARAMETERS_SSN_NUMBER = "SSN_Number";
	/*
	 * RUN MODES FOR BROWSERS
	 */
	public static final String RUN_ON_FIREFOX = "RunOnFirefox";
	public static final String RUN_ON_CHROME = "RunOnChrome";
	public static final String RUN_ON_IE = "RunOnIE";
	public static final String RUN_ON_SAFARI = "RunOnSafari";
	public static final String RUN_ON_OPERA = "RunOnOpera";
	public static final String RUN_ON_HEADLESS = "RunOnHeadless";
	public static final String RUN_ON_EDGE = "RunOnMSEdge";
	public static final String YES="Y";
	
	/*
	 * Reports Worksheet
	 */
	public static String REP_INPUT_FILE;
	
	/**
	 * PolicyDetailsforClaim -worksheet :To get the policy number and its details to verify CC automated rules
	 */
	public static final String POLICY_DETAILS_WORKSHEET ="PolicyDetailsforClaim";
	public static final String POLICY_PURPOSE = "PURPOSE";
	public static final String POLICY_NUMBER = "POLICY_NUM";
	public static final String ACCOUNT_NUMBER = "ACCOUNT_NUMBER";
	public static final String POLICYHOLDER_NAME = 	"POLICY_HOLDER_NAME";
	public static final String ADDRESS = "ADDRESS";
	public static final String POST_OFFICE = "POST_OFFICE";
	public static final String POST_CODE = "POST_CODE";
	public static final String INVOICE_NUMBER = "INVOICE_NUM";
	public static final String SSN = "SSN";
	public static final String CC_RULESVERIFICATION = "CC_RULES_VERIFICATION";
	public static final String POLICY_PARAM ="_PolicyParamForSmokeTest";
	public static final String POLICY_PARAM_GENERIC = "_GenericPurposePolicyDetails";
	public static final String PET_POLICY_PARAM_GENERIC = "_PETGenericPurposePolicyDetails";
	public static final String BOAT_POLICY_PARAM_GENERIC = "_BOATGenericPurposePolicyDetails";
	public static final String FOREST_POLICY_PARAM_GENERIC = "_FORESTGenericPurposePolicyDetails";
	public static final String HC_POLICY_PARAM_GENERIC = "_HEALTHCAREGenericPurposePolicyDetails";
	public static final String POLICY_LE_3RD_PARTY_COST_COVERING ="_PolicyWithLegalExpenses3rdPartyCostCoverage";
	public static final String EID_NUMBER = "EID_NUMBER";
	public static final	String CLAIM_NUMBER = "CLAIM_NUMBER";
	public static final	String VALIDATING_READONLY = "_ValidatingReadOnly";
	public static final String SIT3_PolicyParam= "SIT3_PolicyParamForSmokeTest";

//	Jira parameters to update test script execution details in Jira
	public static final String JIRA_PARAMETERS_WORKSHEET ="JiraParameters";
	public static final String JIRA_TESTSUITE_NAME_HEADER = "Testsuite_Name";
	public static final  String JIRA_PROJECTID = "ProjectID";
	public static final  String JIRA_CYCLEID = "CycleID";
	public static final String JIRA_STATUS_UPDATE_REQUIRED = "StatusUpdateinJira?";  //This column moved to Credentials worksheetsetJIRA_TESTSUITE_NAME
	
	public static final String COMPANY_NAME = "COMPANY_NAME";

	
	/*
	 *  WORKBOOK FOR FINNISH HOLIDAYS
	 */
	public static final String FINNISH_HOLIDAY_LIST=System.getProperty("user.dir")+fs+"TestData"+fs+"LT"+fs+"FinnishHolidayList.xlsx";
		//Envirnment wise sheets
		public static final String FUNC_WORKSHEET ="FUNC";
		public static final String SIT_WORKSHEET ="SIT";
		public static final String UAT_WORKSHEET ="UAT";
		public static final String TT5_WORKSHEET ="TT5";
		public static final String HOLIDAYS_COLUMNNAME = "Holidays";
	

	private ADDRESS_DATASHEET_CONSTANTS() {
	    throw new IllegalAccessError("ADDRESS_DATASHEET_CONSTANTS class");
	}
	
	public static final String BOAT_POLICY_PARAM ="_PolicyParamForBoat_Eg1";
	public static final String FOREST_POLICY_PARAM ="_PolicyParamForForest_Eg1";
	public static final String INCREASED_DEDUCTIBLE_500_POLICY_PARAM ="_PolicyParamForIncreasedDeductible_500";
	public static final String INCREASED_DEDUCTIBLE_200_POLICY_PARAM ="_PolicyParamForIncreasedDeductible_200";
	public static final String POLICYHOLDER_WITH_INSURED_CHILD ="_PolicyParam_MalePolicyHolderWithInsuredChild";
	public static final String POLICYHOLDER_WITH_INSURED_ADULT ="_PolicyParam_MalePolicyHolderWithInsuredAdult";
	public static final String POLICYHOLDER_MINOR_MOTHER_WITH_UNBORNBABY ="_PolicyParam_MinorMotherWithInsuredUnbornBaby";
	public static final String POLICY_HOLDER_NAME_INSURED ="POLICY_HOLDER_NAME_INSURED";
}
