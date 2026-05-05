/*'*************************************************************************************************************************************************
' CLASS NAME			: PC_CONSTANTS
' DESCRIPTION			: USED TO STORE THE HEADER NAME VARIABLES THAT ARE USED IN POLICY CENTER.
' HOW TO USE			:
'-------------------------------------------------------------------------------------------------------------------------------------------------
' AUTHOR                    VERSION          CREATION DATE         REVIEWER NAME         REVIEWED DATE           COMMENTS 
'-------------------------------------------------------------------------------------------------------------------------------------------------
' Nagaraj Gaonkar			1.0	       			16-Nov-2017
'*************************************************************************************************************************************************
*/
package com.guidewire.config;

//import com.guidewire.policycenter.Luggage;

public class PC_CONSTANTS {
	
	public static Integer PC_STATICWAITTIME = 1000; //Max value should not exceed 4000
	//Home page
    public static final String PC_ACTIVITIES_HEADER_EXPECTED = "My Activities";
    public static final String PC_MYSUMMARY_HEADER_EXPECTED = "My Summary";
    public static final	String PC_MY_SUBMISSION_HEADER = "My Submissions";
    
    //Contact Search page
    public static final String PC_SEARCH_CONTACTS_HEADER_EXPECTED = "Search Contacts";

    //New CONTACT 
    public static final String PC_DUPLICATE_MESSAGE = "The contact potentially matches the following contacts. Please select one that matches, if any.";
    //Contact file details
	public static final String PC_CONTACT_FILE_DETAILS_HEADER_EXPECTED = "Contact File Details";
	
	//Headers
	public static final String PC_ACCOUNTSUMMARY_HEADER_EXPECTED = "Account File Summary";
	public static final String PC_ACCOUNTFILECONTACTS_HEADER_EXPECTED = "Account File Contacts";
    public static final String PC_NEWSUBMIISSION_HEADER_EXPECTED = "New Submissions";
    public static final String PC_POLICY_INFO_HEADER_EXPECTED = "Policy Info";
    public static final String PC_HI_LOCATIONS_HEADER_EXPECTED =  "Coverables of Policy";// "HI Locations";
    public static final String PC_COVERABLES_OF_POLICY = "Coverables of Policy#Pet"; //#Pet is appended so as to be split before comparison
    public static final String PC_COVERABLES_OF_POLICY_FOREST = "Coverables of Policy#Forest"; //#Forest is appended so as to be split before comparison
    public static final String PC_COVERABLES_OF_POLICY_MOTOR = "Coverables of Policy#Motor"; 
    public static final String PC_LOCATION_INFORMATION_HEADER_EXPECTED = "Location Information";
    public static final String PC_LINELEVELCOVERAGES_HEADER_EXPECTED = "Line-level Coverages";
    public static final String PC_STANDARDCOVERAGES_SUBHEADER_EXPECTED = "Standard Coverages";
	public static final String PC_RISKANALYSIS_HEADER = "Risk Analysis";
    public static final String PC_POLICYREVIEW_HEADER = "Policy Review";
    public static final String PC_QUOTE_HEADER = "Quote";
    public static final String PC_ISSUES_THAT_BLOCK_ISSUANCE_HEADER = "Issues that block Issuance";
    public static final String PC_NEW_CONTACT_HEADER = "New Contact";
    public static final String PC_CONTACT_FILE_ACCOUNTS_HEADER = "Contact File Accounts";
    public static final String PC_CONTACT_FILE_POLICIES_HEADER = "Contact File Policies";
    public static final String PC_ACCOUNT_HOLDER_INFO_HEADER = "Account Holder Info";
    public static final String PC_ACCOUNT_FILE_RELATED_ACCOUNTS_HEADER_EXPECTED = "Account File Related Accounts";
    public static final String PC_SEARCH_RELATED_ACCOUNT_HEADER_EXPECTED = "Search Related Account";
    public static final String PC_ACCOUNT_FILE_POLICY_TRANSACTIONS_EXPECTED = "Account File Policy Transactions";
    public static final String PC_RATE_BOOKS_HEADER = "Rate Books";
    public static final String PC_HI_LINE_RATE_BOOK_HEADER = "HI Line Rate Book";
    public static final String PC_RATE_TABLE_DEFINITIONS_HEADER = "Rate Table Definitions";
    public static final String PC_RATE_ROUTINES_HEADER = "Rate Routines";
    public static final String PC_PARAMETER_SETS_HEADER = "Parameter Sets";
    public static final String PC_CONTENT_DETAILS_HEADER = "Content details";
    public static final String PC_SUMMARY_HEADER = "Summary";
    public static final String PC_SEARCH_POLICIES_HEADER = "Search Policies";
    public static final String PC_HOME_INSURANCE = "Home Insurance";
    public static final String PC_POLICY_TRANSACTIONS = "Policy Transactions";
    public static final String PC_ACCOUNT_FILE_LOCATIONS = "Account File Locations";
    public static final String PC_START_AND_CANCELLATION_REASON = "Start and cancellation reasons";
    
    
    //Holiday page 
    public static final String PC_HOLIDAYS_HEADER_EXPECTED = "Holidays";
    
    //Add Holiday page 
    public static final String PC_ADDHOLIDAY_HEADER_EXPECTED = "Add Holiday";
    
    //Account
    public static final String PC_ENTER_ACCOUNT_INFORMATION_HEADER_EXPECTED = "Enter Account Information";
    public static final String PC_CREATE_ACCOUNT_HEADER_EXPECTED = "Create account";
    public static final String PC_ACCOUNT_FILE_SUMMARY_HEADER_EXPECTED = "Account File Summary";
    public static final String PC_NO_DUPLICATE_CONTACTS_FOUND = "No potential duplicate contacts found.";
    public static final String PC_DUPLICATE_CONTACTS_FOUND = "Potential duplicate contacts found.";
    public static final String ISSUE_POLICY_MESG_CONFIRMATION = "Are you sure you want to issue this policy?";
    public static final String PC_SEARCH_ACCOUNTS_HEADER = "Search Accounts";
    public static final String PC_POTENTIAL_DUPLICATE_MESSAGE = "The contact potentially matches the following contacts. Please select one that matches, if any.";
    public static final String pc_MySummary_Header = "My Summary";
     
    
    //Bound Submission
    public static final String PC_BOUND_SUBMISSION_HEADER = "Submission Bound";
    public static final String PC_SUBMISSION_BOUND_HEADER = "Submission Bound";
    

    //Roles
    public static final String PC_ROLES_PAGE_HEADER_EXPECTED = "Roles";
    
    //New Role
    public static final String PC_NEWROLE_HEADER_EXPECTED = "New Role";

	public static final String PC_EDITROLE_PERMISSION_TAB_EXPECTED = "Permissions";
    

	//Search User 
	public static final String PC_SEARCHUSER_HEADER_EXPECTED = "Search Users";
	public static final String PC_SSN_LABEL = "SSN";
	public static final String PC_SEARCH = "Search";
	public static final String PC_PERSON_SEARCH_ACCOUNT_TYPE = "Person";
	public static final String PC_COMPANY_SEARCH_ACCOUNT_TYPE = "Company";
	
	//User Search 
	public static final String PC_USER_HEADER_EXPECTED = "Users";
	public static final String PC_NEW_USER_HEADER_EXPECTED = "New User";

	//Groups
		public static final String PC_GROUPS_HEADER_EXPECTED = "Groups";
		public static final String PC_NEWGROUP_HEADER_EXPECTED = "New Group";	
		
	//Organizations
		public static final String PC_ORGANIZATIONS_HEADER = "Organizations";
		public static final String PC_NEW_ORGANIZATION_HEADER = "New Organization";
		
	//Policy
		public static final String PC_PAYMENT_HEADER = "Payment";
		
	//Producer codes
		public static final String PC_PRODUCER_CODES_HEADER = "Producer Codes";
		public static final String PC_NEW_PRODUCER_CODE_HEADER = "New Producer Code";
		
	//Authority Profile	
		public static final String PC_AUTHORITY_PROFILES_HEADER = "Authority Profiles";
		public static final String PC_NEW_AUTHORITY_PROFILES_HEADER = "New Authority Profile";
		
	//Affinity Groups
		public static final String PC_AFFINITY_GROUPS_HEADER = "Affinity Groups";
		public static final String PC_NEW_AFFINITY_GROUP_HEADER = "New Affinity Group";
		
	//Regions
		public static final String PC_RIGIONS_HEADER = "Regions";
		public static final String PC_ADD_RIGION_HEADER = "Add Region";
		
	//Locations
		public static final String PC_VALIDATION_RESULTS_HEADER_EXPECTED = "Validation Results";
		public static final String PC_MESSAGE_VALIDATION_EXPECTED = "You are about to save a foreign location. This submission needs underwriter's review.";
		public static final String PC_REMOVE_LOCATION_EXPECTED = "Remove Location";
		public static final String PC_SET_AS_PRIMARY_EXPECTED = "Set as Primary";
		public static final String PC_AFD_COVERABLES_PRIMARY_EXPECTED = "Add Coverables";
		public static final String PC_NEW_BUILDING_EXPECTED = "New Building";
		public static final String PC_NEW_CONTENT_EXPECTED = "New Content";
		
		
		
		
		
	//HI Locations
		public static final String PC_REMOVAL_POPUP_EXPECTED = "Removing the location will remove associated covered objects.";
		public static final String PC_ADD_PET = "Add Pet";
		public static final String PC_ADD_GROUP = "Add Group";

	//Payments screen
		public static final String PC_Search_Accounts_EXPECTED = "Search Accounts";
		public static final String PC_New_Billing_Contact_EXPECTED = "New Billing Contact";
		public static final String PC_FROM_ADDRESS_BOOK = "From Address Book";
		public static final String PC_EXISTING_BILLING_CONTACT = "Existing Billing Contacts";
		public static final String PC_OTHER_CONTACTS = "Other Contacts";	

	
	//Summary 
		public static final String PC_ACCOUNT_INFORMATION_HEADER = "Account Information";
		public static final String PC_POLICY_HEADER = "Policy";
		public static final String PC_PERIOD_HEADER = "Period";
		public static final String PC_LOSS_RATIO_HEADER = "Loss Ratio";
		public static final String PC_PRODUCER_OF_RECORD_HEADER = "Producer of Record";
		public static final String PC_PRODUCER_OF_SERVICE_HEADER = "Producer of Service";
		public static final String PC_UNDER_WRITING_COMPANY_HEADER = "Underwriting Companies";
		public static final String PC_ASSOCIATED_POLICY_TRANSACTION_HEADER = "Associated Policy Transaction";
			public static final String PC_TOTAL_PREMIUM_LABEL = "Total Premium";
			public static final String PC_TAXES_AND_FEES_LABEL = "Taxes and Fees";
			public static final String PC_TOTAL_COST_LABEL = "Total Cost";
		public static final String PC_PENDING_POLICY_TRANSACTIONS_HEADER = "Pending Policy Transactions";
		public static final String PC_OPEN_POLICY_TRANSACTIONS = "Open Policy Transactions";
		public static final String PC_COMPLETED_POLICY_TRANSACTIONS_HEADER = "Completed Policy Transactions";
		public static final String PC_RECALCULATE_LOSS_RATIO_HEADER = "Recalculate Loss Ratio";
		public static final String PC_BILLING_HEADER = "Billing";
		public static final String PC_NOTES_HEADER = "Notes";
		public static final String PC_CANCEL_POLICY = "Cancel Policy";
		public static final String PC_TT5CANCEL_POLICY = "ncel Policy";
		public static final String PC_RENEW_POLICY = "Renew Policy";
		
	//Billing
		public static final String PC_BILLING_METHOD_LABEL = "Billing Method";
		public static final String PC_BILLING_PLAN_LABEL = "Payment Plan";
		public static final String PC_INVOICING_LABEL = "Invoicing";
		public static final String PC_INSTALLMENTS_LABEL = "Installments";
		public static final String PC_TOTAL_BILLED_LABEL = "Total Billed";
		public static final String PC_CURRENT_LABEL = "Current";
		public static final String PC_PAST_DUE_LABEL = "Past Due";
		public static final String PC_PAID_LABEL = "Paid";
		public static final String PC_UNBILLED_LABEL = "Unbilled";
		public static final String PC_TOTAL_CHARGES_LABEL = "Total Charges";
		
		
	//Notes
		public static final String PC_UPDATE = "Update";
		public static final String PC_TOPIC  = "Topic:";
		public static final String PC_SECURITY_LEVEL = "Security Level:";
		public static final String PC_RELATED_TO = "Related To:";
		public static final String PC_AUTHOR = "Author:";
		public static final String PC_DELETE = "Delete";
		public static final String PC_EDIT = "Edit";
		public static final String PC_OK = "OK";
		public static final String PC_BASIC = "Basic";
		public static final String PC_RATE = "Rate";
		public static final String PC_RETURN = "Return";
		
	//Search Account
		public static final String PC_SEARCH_MESSAGE = "The search returned zero results.";
		
	//Search Policy
		public static final String PC_COUNTRY = "Country";
		
	//Edit Account
		public static final String PC_EDIT_ACCOUNT = "Edit Account";
		
	//Start Policy Change
		public static final String PC_START_POLICY_CHANGE = "Start Policy Change";
		
	//Forms
		public static final String PC_FORMS_HEADER = "Forms";
		
	//Policy Change Bound page	
		public static final String PC_POLICY_CHANGE_BOUND_HEADER_EXPECTED = "Policy Change Bound";
		public static final String PC_VIEW_YOUR_POLICY = "View your policy";
		public static final String PC_REVIEW_CHANGES = "Review Changes";
		public static final String PC_GO_TO_YOUR_DESKTOP = "Go to your desktop";
		
		
	//Line-level Coverages
		public static final String PC_THIRD_PARTY_LIABILITY = "Third Party Liability";
		public static final String PC_LANDLORDs_LIABILITY = "Landlord's Liability ";
		public static final String PC_LEGAL_EXPENSES = "Legal Expenses";
		public static final String PC_LANDLORDs_LEGAL_EXPENSES = "Landlords Legal Expenses";
		public static final String PC_OTHER_PARTY_COSTS = "Other Party Costs";
		public static final String PC_LUGGAGE = "Luggage cover";

	//Start Cancellation
		public static final String PC_START_CANCELLATION = "Start Cancellation For Policy";
		public static final String PC_CONFIRMATION = "Confirmation";
		public static final String PC_CANCELLATIONBOUND = "Cancellation Bound";
		public static final String PC_CANCELLATIONSCHEDULED = "Cancellation Scheduled";
		public static final String PC_CANCELLATIONRESCINDED = "Cancellation Rescinded";
		public static final String PC_CANCELLATIONWITHDRAWN = "Cancellation Withdrawn";
		
		public static final String PC_SCRIPTPARAMETERS = "Script Parameters";
		public static final String PC_DAYSQUOTEISVALID = "DaysQuoteIsValid";
		
	//New Primary Named Insured	
		public static final String PC_NEWPRIMARYNAMEDINSURED = "New Primary Named Insured";
		public static final String PC_NEWSECONDARYNAMEDINSURED = "New Secondary Named Insured";
		
	//Administration Pages
		public static final String PC_CLAUSE_PACKAGES = "Clause Packages";
		public static final String PC_NEWCLAUSEPACKAGE = "New Clause Package";
		
		public static final String PC_MYQUEUES = "My Queues";
		public static final String PC_DESKTOP = "Desktop";
		public static final String PC_UWACTIVITY = "UW Activity";
		public static final String PC_DOCUMENTS = "Documents";
		public static final String PC_START_REINSTATEMENT = "Start Reinstatement";
		public static final String PC_REINSTATEMENT_BOUND = "Reinstatement Bound";
		
	//Account File Summary
		public static final String PC_RENEWAL_MONTH = "Renewal Month";
		public static final String PC_RENEWAL_DAY = "Renewal Day";
		public static final String PC_FEBRUARY_MONTH = "February";
		public static final String PC_SEPTEMBER_MONTH = "September";
		
		public static final String PC_OFFERINGS = "Offerings";
		public static final String PC_PETSSUMMARY = "PET";  //"PET Pets Summary"
		public static final String PC_PETGROUP = "Pet Group";
		
	//Policy Transaction
		public static final String PC_EFFECTIVE_DATE = "Effective Date";
		public static final String PC_EXPIRATION_DATE = "Expiration Date";
		public static final String PC_BOUND_TRANSACTION_STATUS = "Bound";
		
	//Financial Transactions
		public static final String PC_ALL_TRANSACTIONS = "All Transactions";
		public static final String PC_TRANSACTIONS_BY_JOB = "Transactions By Job";
		public static final String PC_TRANSACTIONS_BY_PERIOD = "Transactions By Period";
		public static final String PC_FINANCIAL_TRANSACTIONS = "Financial Transactions";
		
	//Error Messages
		
	//Other Constants
		public static final String PC_PHONENUMBER2 = "1234567890";
		public static final String PC_GENDER_MALE = "Male";
		public static final String PC_GENDER_FEMALE = "Female";
		public static final String PC_PRIMARY_LANGUAGE_ENG = "English (US)";
		
		//PET
		public static final String PC_DETAILS = "Details";
		public static final String PC_COVERAGES = "Coverages";
		public static final String PC_HEALTH_DECLARATION_FORM = "Health Declaration Form";
		public static final String PC_HEALTH_DECLARATION_PREVIEW = "Health Declaration Preview";
		public static final String PC_CONDITIONS = "Conditions";
		public static final String PC_EXCLUSIONS = "Exclusions";
		public static final String PC_CAT = "Cat";
		public static final String PC_DOG = "Dog";
		public static final String PC_HEALTH_DECLARATION_STATUS_DONE = "Done";
		
		//Breed - Horse
		public static final String PC_STALLION_APPALOOSA_BREEDNAME = "Appaloosa";
		public static final String PC_STALLION_APPALOOSA_BREEDCODE = "3056";
		
		//Forest
		public static final String PC_FOREST_MAINTENANCE_EQUIPMENT = "Forest Maintenance Equipment";
		public static final String PC_LUGGAGEINSURANCE = "Luggage insurance";
		
		

		
	//Quote Screen
		public static final String PC_ISSUE_POLICY = "Issue Policy";
		public static final String PC_LIFE_COVER = "Life";
		public static final String PC_THIRD_PARTY_LIABILITY_COVER = "Third party liability";
		public static final String PC_LIFE_TAX_COVER = "Life Tax";
		public static final String PC_VETERINARY_EXPENSES_COVER = "Veterinary expenses";
		public static final String PC_VETERINARY_EXPENSES_TAX_COVER = "Veterinary expenses Tax";
		public static final String PC_BASERATE = "BaseRate";
		public static final String PC_AGEFACTOR = "AgeFactor";
		
	//Content Details
		public static final String PC_STORAGE_CONTENT = "Storage content";
		public static final String PC_HOME_CONTENT = "Home content";
		
    //Forest Details
		public static final String PC_FOREST = "Forest";
		public static final String PC_SPECIALTREEPLANTATION = "Special Tree Plantation";
		public static final String PC_FOREST_FUNGI = "Fungi";
		public static final String PC_FOREST_ANIMALS = "Animals";
		public static final String PC_FOREST_VANDALISM = "Vandalism";
		public static final String PC_FOREST_BUILDGING = "Forest Building";
		
	//Settings Logo
		public static final String PC_INTERNATIONAL = "";
		public static final String PC_REGIONAL_FORMATS = "";
		public static final String PC_UNITEDSTATES_ENGLISH = "United States (English)";
		public static final String PC_FINNISH = "Finnish";
		public static final String PC_SWEDISH = "Swedish";
		
	//Sales Event Data
		public static final String PC_INSURED = "Insured";
		public static final String PC_NONEED_REASON = "No need";
		
		public static final String PC_DISCOUNTS = "Discounts";
		public static final String PC_CAMPAIGNADMINISTRATION = "Campaign Administration";
		public static final String PC_VIEWQUOTE = "View Quote";
		public static final String PC_RENEWALRENEWING = "Renewal Renewing";
		public static final String PC_RENEWALBOUND = "Renewal Bound";
		public static final String PC_SALESEVENTDATA="Sales event data";
		
	//Boat	
		public static final String PC_BOATDETAILS = "Boat Details";
		public static final String PC_MOTOR_BREAKDOWN = "Motor breakdown";
		public static final String PC_EQUIPMENT_COVER = "Equipment cover (movable equipments)";
		public static final String PC_FINANCIAL_COVER = "Financial cover";
		
		public static final String PC_COVERABLE_POLICY = "Coverable summary";
		public static final String PC_REWRITE_FULLTERMBOUND = "Rewrite Full Term Bound";
		public static final String PC_REWRITE_NEWTERMBOUND = "Rewrite New Term Bound";
		public static final String PC_REWRITE_NEWACCOUNTBOUND = "Rewrite New Account Bound";
		
	//History
		public static final String PC_HISTORY_PAGE = "History";
		

	//Coverable Summary
		public static final String PC_COVERABLE_SUMMARY = "Coverable summary";

		public static final String PC_ISSUANCEBOUND_PAGE = "Issuance Bound";
		
		public static final String PC_NEXT_BUTTON = "Next";
		public static final String PC_QUOTE_BUTTON = "Quote";
		public static final String PC_ADD_BUTTON = "Add";
		public static final String PC_VEHICLE_ROLES = "Vehicle Roles";
		public static final String PC_CLEAR_BUTTON = "Clear";
		
		public static final String PC_BONUS = "Bonus";
		public static final String PC_EQUIPMENT = "Equipment";
		public static final String PC_CANCEL = "Cancel";

		public static final String PC_HC_PERSONS = "HC Persons";
		
		public static final String PC_NEW_VEHICLE_OWNER = "New Vehicle Owner";
		public static final String PC_DETAILED_MOTOR_VEHICLE = "Detailed Motor Vehicle"; 
		public static final String PC_POLICY_VERSIONS = "Policy Versions"; 
		
		public static final String PC_UN_NAMED_GROUP = "Un-named Group"; 
		public static final String PC_MESSAGE_QUEUES = "Message Queues"; 
		public static final String PC_INACTIVATED_OFFER_MSG="Editing this policy transaction will invalidate the current quote. If you have already created final quote document, you need to re-quote and create new quote document. You may also require re-approval by underwriting. Are you sure to continue?";
		public static final String PC_BUNDLE_CHANGE = "Policies in the bundle either have open transactions, policies are cancelled or renewal dates don't match. Please check the policies, and try again.";
		public static final String PC_COMPARE_COVERAGE_PACKAGES = "Compare coverage packages";
		public static final String PC_ACTIVATED_OFFER_MSG="By proceeding with this edit, the total offer will no longer be visible to the customer in self-service portal. Are you sure you want to continue?";
	
}

