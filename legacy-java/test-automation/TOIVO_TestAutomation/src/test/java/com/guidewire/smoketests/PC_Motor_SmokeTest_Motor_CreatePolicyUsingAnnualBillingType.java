package com.guidewire.smoketests;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.guidewire.basetest.BaseTest;
import com.guidewire.config.CONSTANTS;
import com.guidewire.config.PC_CONSTANTS;
import com.guidewire.config.PC_MENU_CONSTANTS;
import com.guidewire.policycenter.PC_AccountFileSummary_Page;
import com.guidewire.policycenter.PC_CoverablesOfPolicy_Motor_Page;
import com.guidewire.policycenter.PC_CreateAccount_Page;
import com.guidewire.policycenter.PC_EnterAccountInformation_Page;
import com.guidewire.policycenter.PC_MyActivities_Page;
import com.guidewire.policycenter.PC_NewSubmissions_Page;
import com.guidewire.policycenter.PC_Payments_Page;
import com.guidewire.policycenter.PC_PolicyInfo_Page;
import com.guidewire.policycenter.PC_PolicyReview_Page;
import com.guidewire.policycenter.PC_Quote_Page;
import com.guidewire.policycenter.PC_RiskAnalysis_Page;
import com.guidewire.policycenter.PC_SubmissionBound_Page;
import com.guidewire.policycenter.PC_Summary_Page;

public class PC_Motor_SmokeTest_Motor_CreatePolicyUsingAnnualBillingType extends BaseTest{
	private PC_MyActivities_Page pc_MyActivities_Page;
	private PC_EnterAccountInformation_Page pc_EnterAccountInformation_Page;
	private PC_CreateAccount_Page pc_CreateAccount_Page;
	private PC_NewSubmissions_Page pc_NewSubmissions_Page;
	private PC_AccountFileSummary_Page pc_AccountFileSummary_Page;
	private PC_PolicyInfo_Page pc_PolicyInfo_Page;
	private PC_CoverablesOfPolicy_Motor_Page pc_CoverablesOfPolicy_Motor_Page;
	private PC_RiskAnalysis_Page pc_RiskAnalysis_Page;
	private PC_PolicyReview_Page pc_PolicyReview_Page;
	private PC_Quote_Page pc_Quote_Page;
	private PC_SubmissionBound_Page pc_SubmissionBound_Page;
	private PC_Payments_Page pc_Payments_Page;
	private PC_Summary_Page pc_Summary_Page;

	@Test(priority=0, enabled=true, dataProvider="getData_UsingHashtable" )
	public void SearchExistingAccountAndCreateNewAccount(Hashtable<String, String> data) throws Exception{
		CONSTANTS.setJIRA_TESTCASE_ID(data.get("TestcaseID"));
		
		Authentication_AUTOIT(data.get("PC_UserName"), data.get("PC_PassWord"));
		BrowserSetUp("PC");
		AuthenticateLogin(data.get("PC_UserName"), data.get("PC_PassWord"));

		//Verify landing page
		pc_MyActivities_Page = new PC_MyActivities_Page(driver, test, extent);
		PageFactory.initElements(driver, pc_MyActivities_Page);

		pc_MyActivities_Page.get_pcTopMenu().ClickTopMenuOption(PC_MENU_CONSTANTS.PC_ACCOUNT);		
		pc_MyActivities_Page.get_pcTopMenu().SelectFirstLevelMenuOption(PC_MENU_CONSTANTS.PC_NEW_ACCOUNT);
		
		pc_EnterAccountInformation_Page = ( PC_EnterAccountInformation_Page ) pc_MyActivities_Page.VerifyAccountPages(PC_CONSTANTS.PC_ENTER_ACCOUNT_INFORMATION_HEADER_EXPECTED) ;
		pc_EnterAccountInformation_Page.TDM_GetCustomerData("LocalTapiola", "N", "AND Language = 'English'"); // Enable this line of code to fetch English contacts
		pc_EnterAccountInformation_Page.TDM_Updateconsumed_YN(CONSTANTS.getEID_NUMBER(), "LocalTapiola");
		
		String[] PolicyHolder = CONSTANTS.getPOLICY_HOLDER_NAME().split(" ");
		String FirstName_Unique=PolicyHolder[0];							// Appending the First name ( passed from test data sheet) with random 5 digit number , as system is not allowing to create duplicate account. 
		String LastName_Unique=PolicyHolder[1];

		pc_EnterAccountInformation_Page.SearchAccountHolder(FirstName_Unique, LastName_Unique);

		//create a new account
		pc_EnterAccountInformation_Page.CreateNewAccount(data.get("AccountType"));
		//Search the contact in Address book
		pc_EnterAccountInformation_Page.SearchAddressBook(PC_CONSTANTS.PC_PERSON_SEARCH_ACCOUNT_TYPE, CONSTANTS.getEID_NUMBER());	 		
		pc_CreateAccount_Page = ( PC_CreateAccount_Page ) pc_EnterAccountInformation_Page.VerifyAccountPages(PC_CONSTANTS.PC_CREATE_ACCOUNT_HEADER_EXPECTED) ;			
		pc_CreateAccount_Page.ClickUpdate();	
		
		pc_AccountFileSummary_Page = (PC_AccountFileSummary_Page) pc_EnterAccountInformation_Page.VerifyAccountPages(PC_CONSTANTS.PC_ACCOUNT_FILE_SUMMARY_HEADER_EXPECTED);
		//End account creation

		pc_AccountFileSummary_Page.get_sideMenu().NewSubmissionActionsSideMenuClick(PC_MENU_CONSTANTS.PC_NEW_SU);
		//	
		pc_NewSubmissions_Page = (PC_NewSubmissions_Page)pc_AccountFileSummary_Page.VerifyAccountPages(PC_CONSTANTS.PC_NEWSUBMIISSION_HEADER_EXPECTED);

		//The User should select the  Motor Insurance Product. 
		pc_NewSubmissions_Page.Click_SelectButton(data.get("InsuranceType"));
		pc_PolicyInfo_Page = (PC_PolicyInfo_Page) pc_NewSubmissions_Page.VerifyAccountPages(PC_CONSTANTS.PC_POLICY_INFO_HEADER_EXPECTED);

		//The user should enter the mandatory fields like Quote Date and click on "Next " button		
		String PolicyEffectiveDateExpected=ProvidePastCurrentOrFutureDate("dd.MM.yyyy",Integer.parseInt(data.get("PolicyEffectivedate")));

		pc_PolicyInfo_Page.Click_Next_Submission_Button("TL");

		//Navigate to Coverables of Policy page
		pc_CoverablesOfPolicy_Motor_Page = (PC_CoverablesOfPolicy_Motor_Page) pc_PolicyInfo_Page.VerifyAccountPages(PC_CONSTANTS.PC_COVERABLES_OF_POLICY_MOTOR);

		pc_CoverablesOfPolicy_Motor_Page.ClickOnTabs(PC_CONSTANTS.PC_ADD_BUTTON);  //Click on Add button

		//Add the Motor details
		pc_CoverablesOfPolicy_Motor_Page.testlabels(data.get("RuleNo"), data.get("MotorVehicleRegNumber"));
		pc_CoverablesOfPolicy_Motor_Page.ClickonTrafiSearchLink();
		pc_CoverablesOfPolicy_Motor_Page.testlabels(data.get("RuleNo"), data.get("MotorVehicleDetails"));

		pc_CoverablesOfPolicy_Motor_Page.ClickOnTabs(PC_CONSTANTS.PC_VEHICLE_ROLES);  //Navigate Vehicle Roles tab
		pc_CoverablesOfPolicy_Motor_Page.AddOwner();   //Add owner details	
		pc_CoverablesOfPolicy_Motor_Page.testlabels(data.get("RuleNo"), data.get("VehicleRolesDetails")); //Add the Vehicle Roles details

		pc_CoverablesOfPolicy_Motor_Page.ClickOnTabs(PC_CONSTANTS.PC_COVERAGES);  //Navigate Coverages tab
		pc_CoverablesOfPolicy_Motor_Page.SelectCoverageProposal(data.get("CoverageProposal"));   //Select coverage proposal	

		pc_CoverablesOfPolicy_Motor_Page.ClickOnTabs(PC_CONSTANTS.PC_BONUS);  //Navigate Bonus tab
		pc_CoverablesOfPolicy_Motor_Page.SelectBonusDropdown("No");
		pc_CoverablesOfPolicy_Motor_Page.ClickOnTabs(PC_CONSTANTS.PC_OK);  //Click on Ok button

		//click on 'Quote ' button from locations page
		pc_CoverablesOfPolicy_Motor_Page.ClickOnTabs(PC_CONSTANTS.PC_NEXT_BUTTON);  //Click on Quote button

		//?Risk analysis page is opened.
		pc_RiskAnalysis_Page = (PC_RiskAnalysis_Page) pc_CoverablesOfPolicy_Motor_Page.VerifyAccountPages(PC_CONSTANTS.PC_RISKANALYSIS_HEADER);

		//The user should click next button
		pc_RiskAnalysis_Page.NextButton_Click();

		//Policy Review Page
		pc_PolicyReview_Page = (PC_PolicyReview_Page) pc_RiskAnalysis_Page.VerifyAccountPages(PC_CONSTANTS.PC_POLICYREVIEW_HEADER);
		pc_PolicyReview_Page.RateButton_Click();

		//Quote page gets displayed
		pc_Quote_Page = (PC_Quote_Page) pc_PolicyReview_Page.VerifyAccountPages(PC_CONSTANTS.PC_QUOTE_HEADER);
		//click on Finish quote button
		pc_Quote_Page.ClickOnFinishQuotebutton();

		//Start - Payment code
		pc_Quote_Page.get_sideMenu().SideMenuClick(PC_MENU_CONSTANTS.PC_PAYMENT);
		pc_Payments_Page = (PC_Payments_Page) pc_Quote_Page.VerifyPolicyPages(PC_CONSTANTS.PC_PAYMENT_HEADER);
		Thread.sleep(1000);
		pc_Payments_Page.SelectPaymetPlan("Yearly");
		pc_Payments_Page.get_sideMenu().SideMenuClick(PC_MENU_CONSTANTS.PC_QUOTE);
		//End - Payment code

		pc_Quote_Page = (PC_Quote_Page) pc_Payments_Page.VerifyAccountPages(PC_CONSTANTS.PC_QUOTE_HEADER);
		pc_Quote_Page.BindOptions(data.get("QuoteBindType"));
		pc_Quote_Page.isAlertPresent();
		pc_Quote_Page.closeAlertAndGetItsText();
		
		try {
			pc_Quote_Page.BindOptions(data.get("QuoteBindType"));
			pc_Quote_Page.isAlertPresent();
			pc_Quote_Page.closeAlertAndGetItsText();
		}catch(Exception E) {

		}
		pc_SubmissionBound_Page = (PC_SubmissionBound_Page) pc_Quote_Page.VerifyPolicyPages(PC_CONSTANTS.PC_BOUND_SUBMISSION_HEADER);

		//Navigate to Summary page
		pc_SubmissionBound_Page.PolicyNumber_Click();
		pc_Summary_Page = (PC_Summary_Page) pc_SubmissionBound_Page.VerifyPolicyPages(PC_CONSTANTS.PC_SUMMARY_HEADER);

		//Log out from PC
		pc_Summary_Page.get_pcTopMenu().Logout();
	}
}