package com.guidewire.commonpagefunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.guidewire.config.CONSTANTS;
import com.guidewire.config.PC_CONSTANTS;
import com.guidewire.menu.PC_TopMenu;
import com.guidewire.menu.*;
import com.guidewire.policycenter.*;

public class PC_GenericFunctions extends GenericFunctions {
	public PC_TopMenu pc_TopMenu;
	public SideMenu sideMenu;
	   
   String VersionPart1="//select[@name='SubmissionWizard-MultiQuoteAcceleratedMenuActions-PolicyPeriodSelector-PolicyPeriodSelector_Arg']";
   String VersionPart2="/descendant::option[contains(text(),'";
   String VersionPart3="')]";
    
	public PC_GenericFunctions(WebDriver driver, ExtentTest test, ExtentReports extent){
        super(driver, test, extent);
        pc_TopMenu = new PC_TopMenu(driver,test, extent);
        PageFactory.initElements(driver, pc_TopMenu);
        sideMenu = new SideMenu(driver,test, extent);
        PageFactory.initElements(driver, sideMenu);
	}

	
	public PC_TopMenu get_pcTopMenu(){
		return pc_TopMenu;
	}
	
	/**
     * Setting the object for PC_SideMenu
     * @return returns an object of the page
     */
	public SideMenu get_SideMenu(){
	    return sideMenu;
    }
	
	
	/**
     * Function to create and return the
     * @param PageName
     * @return
	 * @throws Exception 
     */
	public Object VerifyAccountPages(String PageName) throws Exception {
		Thread.sleep(1000);
		Object page = null;
		switch (PageName) {
			case "Create":
				
				break;
			case "New Account":
                //
				break;
				
			case PC_CONSTANTS.PC_ENTER_ACCOUNT_INFORMATION_HEADER_EXPECTED :
				PC_EnterAccountInformation_Page pc_EnterAccountInformation_Page = new PC_EnterAccountInformation_Page(driver, test, extent);
				PageFactory.initElements(driver, pc_EnterAccountInformation_Page);
//				pc_EnterAccountInformation_Page.Verify(pc_EnterAccountInformation_Page.EnterAccountInformation_PageHeader.getText(), PC_CONSTANTS.PC_ENTER_ACCOUNT_INFORMATION_HEADER_EXPECTED, "header name",  "Navigated to '"+ PC_CONSTANTS.PC_ENTER_ACCOUNT_INFORMATION_HEADER_EXPECTED +"' page Successfully.");
				page = pc_EnterAccountInformation_Page;
				break;
			
			case PC_CONSTANTS.PC_CREATE_ACCOUNT_HEADER_EXPECTED:
				PC_CreateAccount_Page pc_CreateAccount_Page = new PC_CreateAccount_Page(driver, test, extent);
				PageFactory.initElements(driver, pc_CreateAccount_Page);
//				pc_CreateAccount_Page.Verify(pc_CreateAccount_Page.CreateAccount_PageHeader.getText(), PC_CONSTANTS.PC_CREATE_ACCOUNT_HEADER_EXPECTED, "header name",  "Navigated to '"+ PC_CONSTANTS.PC_CREATE_ACCOUNT_HEADER_EXPECTED +"' page Successfully.");
				page =  pc_CreateAccount_Page;
				break;
			
			case PC_CONSTANTS.PC_ACCOUNT_FILE_SUMMARY_HEADER_EXPECTED:
				PC_AccountFileSummary_Page pc_AccountFileSummary_Page = new PC_AccountFileSummary_Page(driver, test, extent);
				PageFactory.initElements(driver, pc_AccountFileSummary_Page);
//				try {
//					pc_AccountFileSummary_Page.Verify(pc_AccountFileSummary_Page.AccountFileSummary_PageHeader.getText(), PC_CONSTANTS.PC_ACCOUNT_FILE_SUMMARY_HEADER_EXPECTED, "header name",  "Navigated to '"+ PC_CONSTANTS.PC_ACCOUNT_FILE_SUMMARY_HEADER_EXPECTED +"' page Successfully.");
//				}catch(Exception e) {
//					pc_AccountFileSummary_Page.Verify(pc_AccountFileSummary_Page.gw_AccountFileSummary_PageHeader.getText(), PC_CONSTANTS.PC_ACCOUNT_FILE_SUMMARY_HEADER_EXPECTED, "header name",  "Navigated to '"+ PC_CONSTANTS.PC_ACCOUNT_FILE_SUMMARY_HEADER_EXPECTED +"' page Successfully.");
//				}
				page = pc_AccountFileSummary_Page;
				break;
				
			case PC_CONSTANTS.PC_NEWSUBMIISSION_HEADER_EXPECTED:
				PC_NewSubmissions_Page pc_NewSubmissions_Page = new PC_NewSubmissions_Page(driver, test, extent);
				PageFactory.initElements(driver, pc_NewSubmissions_Page);
				pc_NewSubmissions_Page.Verify(pc_NewSubmissions_Page.gw_NewSubmission_Header.getText(), PC_CONSTANTS.PC_NEWSUBMIISSION_HEADER_EXPECTED, "header name",  "Navigated to '"+ PC_CONSTANTS.PC_NEWSUBMIISSION_HEADER_EXPECTED +"' page Successfully.");
				page = pc_NewSubmissions_Page;
				break;
				
            case PC_CONSTANTS.PC_POLICY_INFO_HEADER_EXPECTED:
            	PC_PolicyInfo_Page pc_PolicyInfo_Page = new PC_PolicyInfo_Page(driver, test, extent);
                PageFactory.initElements(driver, pc_PolicyInfo_Page);
//                pc_PolicyInfo_Page.Verify(pc_PolicyInfo_Page.gw_PolicyInfo_Header.getText(), PC_CONSTANTS.PC_POLICY_INFO_HEADER_EXPECTED, "page header name", "Navigated to '"+ PC_CONSTANTS.PC_POLICY_INFO_HEADER_EXPECTED +"' page Successfully.");
                page = pc_PolicyInfo_Page;
                break;
                
            case PC_CONSTANTS.PC_POLICYREVIEW_HEADER:
            	PC_PolicyReview_Page pc_PolicyReview_Page = new PC_PolicyReview_Page(driver,test,extent);
                PageFactory.initElements(driver, pc_PolicyReview_Page);
//                try {
//                pc_PolicyReview_Page.Verify(pc_PolicyReview_Page.PolicyReview_Header.getText(), PC_CONSTANTS.PC_POLICYREVIEW_HEADER, "page header name", "Navigated to '"+ PC_CONSTANTS.PC_POLICYREVIEW_HEADER +"' page Successfully.");
//                }catch(Exception e) {
////                pc_PolicyReview_Page.Verify(pc_PolicyReview_Page.gw_PolicyReview_Header.getText(), PC_CONSTANTS.PC_POLICYREVIEW_HEADER, "page header name", "Navigated to '"+ PC_CONSTANTS.PC_POLICYREVIEW_HEADER +"' page Successfully.");
//                }
                page = pc_PolicyReview_Page;
                break;
                
            case PC_CONSTANTS.PC_RISKANALYSIS_HEADER:
            	PC_RiskAnalysis_Page pc_RiskAnalysis_Page = new PC_RiskAnalysis_Page(driver,test,extent);
                PageFactory.initElements(driver, pc_RiskAnalysis_Page);
                Thread.sleep(1000);
//                try {
//                pc_RiskAnalysis_Page.Verify(pc_RiskAnalysis_Page.RiskAnalysis_Header.getText(), PC_CONSTANTS.PC_RISKANALYSIS_HEADER, "page header name", "Navigated to '"+ PC_CONSTANTS.PC_RISKANALYSIS_HEADER +"' page Successfully.");
//                }catch(Exception e) {
////                	pc_RiskAnalysis_Page.Verify(pc_RiskAnalysis_Page.gw_RiskAnalysis_Header.getText(), PC_CONSTANTS.PC_RISKANALYSIS_HEADER, "page header name", "Navigated to '"+ PC_CONSTANTS.PC_RISKANALYSIS_HEADER +"' page Successfully.");
//                }
                page = pc_RiskAnalysis_Page;
                break;
                
            case PC_CONSTANTS.PC_QUOTE_HEADER:
            	PC_Quote_Page pc_Quote_Page = new PC_Quote_Page(driver,test,extent);
                PageFactory.initElements(driver, pc_Quote_Page);
//            	pc_Quote_Page.Verify(pc_Quote_Page.gw_Quote_Header.getText(), PC_CONSTANTS.PC_QUOTE_HEADER, "page header name", "Navigated to '"+ PC_CONSTANTS.PC_QUOTE_HEADER +"' page Successfully.");
                page =  pc_Quote_Page;
//                wait_For_Overlay(20);
                break;

            case PC_CONSTANTS.PC_SUMMARY_HEADER:
            	PC_Summary_Page pc_Summary_Page = new PC_Summary_Page(driver,test,extent);
                PageFactory.initElements(driver, pc_Summary_Page);
//                pc_Summary_Page.Verify(pc_Summary_Page.Summary_Header.getText(), PC_CONSTANTS.PC_SUMMARY_HEADER, "page header name", "Navigated to '"+ PC_CONSTANTS.PC_SUMMARY_HEADER +"' page Successfully.");
                page =  pc_Summary_Page;
                break;
               
            case PC_CONSTANTS.PC_COVERABLES_OF_POLICY_MOTOR:
            	PC_CoverablesOfPolicy_Motor_Page pc_CoverablesOfPolicy_Motor_Page = new PC_CoverablesOfPolicy_Motor_Page(driver,test,extent);
                PageFactory.initElements(driver,pc_CoverablesOfPolicy_Motor_Page);
                try {
                String[] CoverablesOfPolicyForMotor = PC_CONSTANTS.PC_COVERABLES_OF_POLICY_MOTOR.split("#");
                pc_CoverablesOfPolicy_Motor_Page.Verify(pc_CoverablesOfPolicy_Motor_Page.MotorCoverablesOfPolicy_Header.getText(), CoverablesOfPolicyForMotor[0], "page header name", "Navigated to '"+ PC_CONSTANTS.PC_COVERABLES_OF_POLICY_MOTOR +"' page Successfully.");
                }catch(Exception e) {
                	 String[] CoverablesOfPolicyForMotor = PC_CONSTANTS.PC_COVERABLES_OF_POLICY_MOTOR.split("#");
                	 pc_CoverablesOfPolicy_Motor_Page.Verify(pc_CoverablesOfPolicy_Motor_Page.MotorCoverablesOfPolicy_Header.getText(), CoverablesOfPolicyForMotor[0], "page header name", "Navigated to '"+ PC_CONSTANTS.PC_COVERABLES_OF_POLICY_MOTOR +"' page Successfully.");
                  }
                page =  pc_CoverablesOfPolicy_Motor_Page;
                break;
            
             default:   
                test.log(Status.FAIL, "The specified '"+PageName +"' page  is not availabe in Policy Center");
		}
		
		return page;
	}	
	
	/**
	 * Function to create object of the policy pages
	 * @param PageName  - Pass name of the PageName
	 * @throws InterruptedException
	 */
	public Object VerifyPolicyPages(String PageName) throws InterruptedException{
		//Verify whether user is navigated to right page or not.
		Object page = null;
		switch(PageName){
		case PC_CONSTANTS.PC_BOUND_SUBMISSION_HEADER :
			PC_SubmissionBound_Page pc_SubmissionBound_Page = new PC_SubmissionBound_Page(driver, test, extent);
			PageFactory.initElements(driver, pc_SubmissionBound_Page);
			page = pc_SubmissionBound_Page;
			break;
			
		case PC_CONSTANTS.PC_PAYMENT_HEADER :
			PC_Payments_Page pc_Payments_Page = new PC_Payments_Page(driver, test, extent);
			PageFactory.initElements(driver, pc_Payments_Page);
			page = pc_Payments_Page;
			break;
			
		case PC_CONSTANTS.PC_SUMMARY_HEADER:
			PC_Summary_Page pc_Summary_Page = new PC_Summary_Page(driver, test, extent);
			PageFactory.initElements(driver, pc_Summary_Page);
//			pc_Summary_Page.Verify(pc_Summary_Page.gw_Summary_Header.getText(), PC_CONSTANTS.PC_SUMMARY_HEADER, "header name",  "Navigated to '"+ PC_CONSTANTS.PC_SUMMARY_HEADER +"' page Successfully.");
			page = pc_Summary_Page;
			break;
		
		case PC_CONSTANTS.PC_POLICY_INFO_HEADER_EXPECTED:
			PC_PolicyInfo_Page pc_PolicyInfo_Page = new PC_PolicyInfo_Page(driver, test, extent);
			PageFactory.initElements(driver, pc_PolicyInfo_Page);
			if(!CONSTANTS.getGW_VERSION().contentEquals("10")) {
				//Add code for GW version other than 10
			}else {
				pc_PolicyInfo_Page.Verify(pc_PolicyInfo_Page.gw_PolicyInfo_Header.getText(), PC_CONSTANTS.PC_POLICY_INFO_HEADER_EXPECTED, "page header name", "Navigated to '"+ PC_CONSTANTS.PC_POLICY_INFO_HEADER_EXPECTED +"' page Successfully.");
			}
			page = pc_PolicyInfo_Page;
			break;
			
		default:
			test.log(Status.FAIL, "The specified '"+PageName+"' page is not availabe in Policy Center");

		}
		return page;
		
	}
		
	
	/**
	 * Function to create object of the Search pages
	 * @param PageName  - Pass name of the PageName
	 * @throws InterruptedException
	 */
	public Object VerifySearchPages(String PageName) throws InterruptedException{
		//Verify whether user is navigated to right page or not.
		Object page = null;
		switch(PageName){
			
		case PC_CONSTANTS.PC_ACCOUNT_FILE_SUMMARY_HEADER_EXPECTED:
			PC_AccountFileSummary_Page pc_AccountFileSummary_Page = new PC_AccountFileSummary_Page(driver, test, extent);
			PageFactory.initElements(driver, pc_AccountFileSummary_Page);
//			pc_AccountFileSummary_Page.Verify(pc_AccountFileSummary_Page.AccountFileSummary_PageHeader.getText(), PC_CONSTANTS.PC_ACCOUNT_FILE_SUMMARY_HEADER_EXPECTED, "header name",  "Navigated to '"+ PC_CONSTANTS.PC_ACCOUNT_FILE_SUMMARY_HEADER_EXPECTED +"' page Successfully.");
			page = pc_AccountFileSummary_Page;
			break;	
		
		case PC_CONSTANTS.PC_SUMMARY_HEADER:
			PC_Summary_Page pc_Summary_Page = new PC_Summary_Page(driver, test, extent);
			PageFactory.initElements(driver, pc_Summary_Page);
//			pc_Summary_Page.Verify(pc_Summary_Page.Summary_Header.getText(), PC_CONSTANTS.PC_SUMMARY_HEADER, "header name",  "Navigated to '"+ PC_CONSTANTS.PC_SUMMARY_HEADER +"' page Successfully.");
			page = pc_Summary_Page;
			break;
		
		case PC_CONSTANTS.PC_POLICY_INFO_HEADER_EXPECTED:
			PC_PolicyInfo_Page pc_PolicyInfo_Page = new PC_PolicyInfo_Page(driver, test, extent);
			PageFactory.initElements(driver, pc_PolicyInfo_Page);
//			pc_PolicyInfo_Page.Verify(pc_PolicyInfo_Page.PolicyInfo_Header.getText(), PC_CONSTANTS.PC_POLICY_INFO_HEADER_EXPECTED, "header name",  "Navigated to '"+ PC_CONSTANTS.PC_POLICY_INFO_HEADER_EXPECTED +"' page Successfully.");
			page = pc_PolicyInfo_Page;
			break;
					
		default:
			test.log(Status.FAIL, "The specified '"+PageName+"' page is not availabe in Policy Center");

		}
		return page;
		
	}
	
	/**
	 * Function to define the Desktop pages in PC
	 * @param PageName
	 * @return
	 * @throws InterruptedException
	 */
	public Object VerifyDesktopPages(String PageName) throws InterruptedException {
		Thread.sleep(1000);
		Object page = null;
		switch (PageName) {
			case PC_CONSTANTS.PC_ACTIVITIES_HEADER_EXPECTED:
				PC_MyActivities_Page pc_MyActivities_Page = new PC_MyActivities_Page(driver, test, extent);
				PageFactory.initElements(driver, pc_MyActivities_Page);
				page = pc_MyActivities_Page;
				break;
			
			default:
				test.log(Status.FAIL, "The specified '"+PageName+"' page is not availabe in Policy Center");

			}
			return page;
			
		}
}
