/*'*************************************************************************************************************************************************
' CLASS NAME			: CC_CONSTANTS
' DESCRIPTION			: USED TO STORE THE HEADER NAME VARIABLES THAT ARE USED IN CLAIM CENTER.
' HOW TO USE			:
'-------------------------------------------------------------------------------------------------------------------------------------------------
' AUTHOR                    VERSION          CREATION DATE         REVIEWER NAME         REVIEWED DATE           COMMENTS 
'-------------------------------------------------------------------------------------------------------------------------------------------------
' Nagaraj Gaonkar			1.0	       			16-Nov-2017
'*************************************************************************************************************************************************
*/

package com.guidewire.config;

public class CC_CONSTANTS {
	
	
	//Home page constants
      public static final String CC_ACTIVITIES_HEADER = "Activities";
      
      
    //Step 1: Search or Create Policy
      public static final String CC_SEARCH_OR_CREATE_POLICY_HEADER_EXPECTED = "Step 1: Search or Create Policy";
      public static final String CC_LOSSDATE_ERRORMESSAGE_EXPECTED = "Loss Date : Missing required field \"Loss Date\"";
      public static final String CC_TIME_ERRORMESSAGE_EXPECTED = "Time : Date must be in the past.";
      public static final String CC_EFFECTIVEdATE_ERRORMESSAGE_EXPECTED = "Effective Date : Missing required field \"Effective Date\"";
      public static final String CC_EXPIRATIONdATE_ERRORMESSAGE_EXPECTED = "Expiration Date : Missing required field \"Expiration Date\"";
      public static final String CC_NAME_ERRORMESSAGE_EXPECTED = "Name : Missing required field \"Name\"";
//      public static final String CC_BASIC_INFORMATION_HEADER_EXPECTED = "Step 3 of 6: Basic information";
      public static final String CC_BASIC_INFORMATION_HEADER_EXPECTED = "Step 3 of 6: Basic information";
      public static final String CC_BASIC_INFORMATION_FOREST_HEADER_EXPECTED = "Step 2 of 5: Basic information";
      
      //Sleep Value      
      public static final long CC_STATICWAITTIME = 4000;
      public static final long CC_STATICWAITTIME1 = 2000;
      public static final long CC_STATICWAITTIME1K = 2000;
      
      public static final String CC_ROOT_HEADER_EXPECTED = "Default Root Group";
      public static final String CC_ACTIVITY_PATTERN_EXPECTED = "Activity Patterns";
      public static final String CC_NEW_ACTIVITY_PATTERN_PAGE_EXPECTED = "New Activity Pattern";
      public static final String CC_AAIR="Automatic Additional Information Request Log";
      
      
      //Roles
      public static final String CC_ROLES_PAGE_HEADER_EXPECTED = "Roles";
      
      //New Role
      public static final String CC_NEWROLE_HEADER_EXPECTED = "New Role";

  	public static final String CC_EDITROLE_PERMISSION_TAB_EXPECTED = "Permissions";
      

  	//Search User 
  	public static final String CC_SEARCHUSER_HEADER_EXPECTED = "Search Users";
  	
  	//User Search 
  	public static final String CC_USERSEARCH_HEADER_EXPECTED = "User Search";
  	public static final String CC_NEW_USER_WIZARD_BASICS_STEP_HEADER = "New User Wizard - Basics Step";
  	public static final String CC_NEW_USER_WIZARD_PROFILE_STEP_HEADER = "New User Wizard - Profile Step";
  	public static final String CC_NEW_USER_WIZARD_AUTHORITY_LIMITS_STEP_HEADER = "New User Wizard - Authority Limits Step";


	//Groups
  	 public static final String CC_GROUPS_HEADER = "Groups";
  	public static final String CC_NEWGROUP_HEADER = "New Group";
  	
  	//Users
  	 public static final String CC_USERS_HEADER = "Users";
     public static final String CC_NEW_USER_HEADER = "New User";
     
     //AuthorityLimitProfiles
     public static final String CC_AUTHORITY_LIMIT_PROFILES_HEADER = "Authority Limit Profile";
     public static final String CC_NEW_AUTHORITY_LIMIT_PROFILE_HEADER = "New Authority Limit Profile";
     public static final String CC_LIMIT_TYPE_COLUMN = "Limit Type";
     public static final String CC_POLICY_TYPE_COLUMN = "Policy Type";
     public static final String CC_COVERAGE_TYPE_COLUMN = "Coverage Type";
     public static final String CC_COST_TYPE_COLUMN = "Cost Type";
     public static final String CC_AMOUNT = "Amount";
     
     //Add Claim Information
     public static final String CC_ADD_CLAIM_INFORMATION_HEADER = "Step 4 of 6: Add claim information";
     public static final String CC_ADD_CLAIM_INFORMATION_FOREST_HEADER = "Step 3 of 5: Add claim information";
     
     //Services
     public static final String CC_SERVICES_HEADER = "Step 5 of 6: Services";
     public static final String CC_SERVICES_MENU = "Services";
     
     //Claims
     public static final String CC_CLAIMS_HEADER = "Claims";
     	public static final String CC_DRAFT = "Draft";
     public static final String CC_SAVE_AND_ASSIGN_CLAIM_HEADER = "Step 6 of 6: Save and Assign Claim";
     public static final String CC_NEW_CLAIM_SAVED_HEADER = "New Claim Saved";
     public static final String CC_WORKPLAN_HEADER = "Workplan";
     
     //IBAN
     public static final String CC_IBAN_NUMBER_INVALID = "IBAN : IBAN bank account number is incorrect";
     public static final String CC_IBAN_NUMBER_EMPTY = "Bank account number is missing";
     public static final String CC_BIC_INCORRECT = "BIC : BIC is incorrect";
     public static final String CC_NEGATIVEAMOUNT_PAYMENT = "The sum total is negative. The sum must not be smaller than 0.00e.";
     public static final String CC_IBAN_LABEL = "IBAN";
     public static final String CC_BIC_LABEL = "BIC";
     public static final String CC_NAME = "Name";
     public static final String CC_SELECT_EFT_RECORD = "Select EFT Record";
     public static final String CC_ACCOUNT_TYPE = "Account Type";
     public static final String CC_YVR_HISTORY = "YVR History";
     public static final String CC_IBAN_ACCOUNT_NUMBER = "FI55 4055 0010 6582 15";
     public static final String CC_BIC_CODE = "HELSFIHH";
     public static final String CC_IBAN_BIC_MISSING = "IBAN : Bank account number/BIC is missing";
     public static final String CC_BIC_MISSING = "BIC : Missing required field \"BIC\"";
     public static final String CC_BACKGROUNDINFO = "Because of party's background information direct compensation is not allowed";
     public static final String CC_LINEITEMS_PAYMENT = "Line Items : This payment cannot be added because it has a deductible line item whose amount exceeds the sum of the other line items' amounts.";
     
     //Summary
     public static final String CC_SUMMARY_HEADER = "Summary";
     public static final String CC_LOSS_DETAILS_HEADER = "Loss Details";
     
     
     //Search For Assignment
     public static final String CC_SEARCH_FOR_ASSIGNMENT_HEADER = "Search For Assignment";
     
     public static final String CC_ENTER_PAYEE_INFORMATION_HEADER = "Step 1 of 3: Enter payee information";
     public static final String CC_LOSS_DATE_INJURY_LABEL = "The date when the loss,damage or injury was noticed";
     public static final String CC_AWARE_OF_LOSS_LABEL = "When did the insured become aware of the loss,damage or injury?";
     public static final String CC_DAMAGE_DESCRIPTION_LABEL = "Damage Description";
     public static final String CC_WHO_OR_WHAT_CAUSED_LOSS_LABEL = "Who or what caused the loss,damage or injury?";
     public static final String CC_INSURED_LABEL = "Insured";
     public static final String CC_REASON_FOR_DAMAGE_LABEL = "Did the loss or damage occur while working, self employment or while practical work training?";
     
     //Civil Case
     public static final String CC_CIVIL_DISPUTE_IS_ABOUT_LABEL = "Civil dispute is about";
     public static final String CC_INSUREDS_PART_IN_CIVIL_LABEL = "What is the insured's part in the civil case?";
     public static final String CC_DETAILS_OF_OTHERPARTY_LABEL = "Details of the other party in the civil case";
     public static final String CC_HAVE_CLAIMS_ALREADYFILED_LABEL = "Have any claims already been filed in the case?";
     public static final String CC_DATE_OF_ACCIDENT_LABEL = "The date of the accident, circumstances or legal act";
     public static final String CC_ATTORNEY_REPRESENTOTHERS_LABEL = "In this case, does insured's attorney represent also others who are not covered in the policy?";
     public static final String CC_DATE_MOVING_CURRENT_ADDRESS_LABEL = "Date of moving in to current address";
     public static final String CC_INSURED_HAD_LEGALEXPENSE_INSURANCE_LABEL = "Has the insured had legal expenses insurance before?";
     public static final String CC_PREVIOUS_LEGALEXPENSE_INSURANCE_LABEL = "Previous coverage by other person's legal expense insurance?";
     public static final String CC_ADDITIONAL_INFORMATION_LABEL = "Additional Information";
     public static final String CC_ADDITIONAL_iNFORMATION_LABEL = "Additional information";		//Additional information with small case i
     public static final String CC_LAWYER_HIRED_LABEL = "Attorney or a lawyer hired to the case?";
     public static final String CC_VEHICLE_COVERED_INSURANCE_LABEL = "Was the vehicle covered by motor insurance during the transaction, service or repair?";
     public static final String CC_GENERIC_MEETING_HELD_LABEL = "When was the housing co-operative general meeting held?";
     public static final String CC_ACTION_FOR_ANNULMENTMEETING_LABEL = "Has the housing co-operative general meeting received an action for annulment?";
//     public static final String CC_DATE_OF_ACTION_ANNULMENT_LABEL = "Date of action for annulment";
     public static final String CC_DATE_OF_ACTION_ANNULMENT_LABEL = "Date of answering to the action for annulment";     
     public static final String CC_OBJECT_SERVICE_CASECONCERN_LABEL = "Which object or service does the case concern?";
     public static final String CC_DESCRIBE_MATTER_MOREDETAIL_LABEL = "Describe the matter in more detail";
     public static final String CC_DATE_OF_ESTATE_DISTRIBUTION_LABEL = "When was the distribution of estate?";
     public static final String CC_COMPENSATION_DECISION_LABEL = "Which insurance policy's compensation decision is the civil case related to?";
     public static final String CC_BRIEFLY_DESCRIBE_CLAIMS_LABEL = "Briefly describe the claims you have filed or the claims the other party has filed against you";
     public static final String CC_CLAIMS_CONTESTED_LABEL = "Are the claims contested?";
     public static final String CC_DATE_CLAIMS_CONTESTED_LABEL = "Date on which the claims were contested";
     public static final String CC_LEGAL_EXPENSE_BENEFICIARY = "Legal Expense Beneficiary";
     public static final String CC_NAME_BASIC_INFORMATION_LABEL = "Name";
     public static final String CC_NOTIFIER_ROLE_LABEL = "Notifiers Role";
     public static final String CC_LOSS_CAUSE_LABEL = "Loss Cause";
     public static final String CC_DAMAGE_TYPE_LABEL ="Damage Type";
     public static final String CC_LEGAL_EXPENSE = "Legal expenses";
     
     
     //Criminal Case
     public static final String CC_SUMMONS_RECEIVED_LABEL = "Summons received?";
     public static final String CC_INSURED_IS_LABEL = "Insured is";
     public static final String CC_CHARGES_PRESSED_LABEL = "Official decision: No charges pressed or charges dropped?";
     public static final String CC_POINT_OF_CHARGE_LABEL = "Point of charge:";
     public static final String CC_CRIME_DATE_LABEL = "Crime date";
     public static final String CC_DATE_OF_FILING_CLAIM_LABEL = "Date of filing claim at district court";
     public static final String CC_LOSS_LOCATION_LABEL = "  Loss Location *";
     public static final String CC_CLAIMS_FROM_DEFENDANT_LABEL = "Will there be claims from defendant for any purpose other than to cover legal expenses?";
     public static final String CC_DEFENDANT_NAME_SUMMONS_LABEL = "Name of the defendant on the summons";
     public static final String CC_DESCRIBE_CRIME_DETAIL_LABEL = "Describe the crime in more detail";
     public static final String CC_WHICH_INSURANCE_COMPANY_LABEL = "With which insurance company?";
     public static final String CC_OTHER_PERSONS_NAME_LABEL = "Other person's name, SSN, address, name of insurance company";
     public static final String CC_LOSSLOCATION_COUNTRY_LABEL = "Country";
     
     
     //Liability Case
     public static final String CC_JOINTLY_LIABLE_PARTIES_LABEL = "Was the loss, damage or injury caused by jointly and severally liable parties?";
     public static final String CC_PROCESS_BY_DIFFERENT_COMPANY_LABEL = "Is the loss, damage or injury being processed by a different company?";
     public static final String CC_CONSIDER_YOURSELF_LIABLE_LABEL = "Do you consider yourself liable?";
     public static final String CC_INJURY_PREVENTED_LABEL = "Could the loss, damage or injury have been prevented?";
     public static final String CC_HOW_INJURY_PREVENTED_LABEL = "How could the damage have been prevented or why it was not possible to prevent the damage?";
     public static final String CC_COMPENSATION_LABEL = "Can compensation be paid if the insurance company finds the insured liable?";
     public static final String CC_POLICE_INVESTIGATION_LABEL = "Has a police investigation been carried out?";
     public static final String CC_ALCOHOL_INFLUENCE_LABEL = "Was any party involved in the loss, damage or injury under the influence of alcohol or any other intoxicant?";
     public static final String CC_COMPENSATION_SOUGHT_LABEL = "Is compensation sought from somewhere else?";
     public static final String CC_DAMAGE_UNDER_GUARANTEE_LABEL = "Does the damage fall under guarantee or other contract?";
     public static final String CC_DID_DEVICE_GET_WET_LABEL = "How did the device get wet?";
     public static final String CC_RELATION_TO_INSURED_LABEL = "Relation to insured";
     public static final String CC_DAMAGE_CAUSED_TO_SOIL_LABEL = "Any damage caused to soil?";
     
     
     //Property Incident
     public static final String CC_MOISTURE_SURVEY_DONE_LABEL = "Has the moisture survey been done?";
     public static final String CC_DAMAGE_TO_HOUSING_OR_OTHER_LABEL = "Has there been damage to housing cooperative or other third parties?";
     public static final String CC_HOME_HABITABLE_LABEL = "Is the home habitable?";
     public static final String CC_CLAIMANT_ARRIVAL_TO_DESTINATION_LABEL = "When did the claimant arrive to destination?";
     public static final String CC_LUGGAGE_ARRIVED_TO_DESTINATION_LABEL = "When did the luggage arrive to destination?";
     public static final String CC_TRIP_END_DATE_LABEL = "When did the trip end?";
     public static final String CC_PLACE_OF_INSURANCE_LABEL = "Place of insurance";
     
     
     //Global variables for CCC claim rules
     public static final String CC_EFFECTIVE_DATE = "EffectiveDate";
     
     //Statics from the Claim rule excels
     public static final String CC_ESCALATE_TO_MANUAL = "Escalate to manual";
     public static final String CC_AUTOMATICALLY_REJECT = "Automatically reject";
     public static final String CC_AUTOMATIC_PAYMENT = "Automatic_payment";
     public static final String CC_TAX_CERTIFICATE = "Tax certificate";
     

     //Property-Content column names
     public static final String CC_CONTENTNAME ="Content Name";
     public static final String CC_OBJECT ="Object";
     public static final String CC_QTY = "Qty";
     public static final String CC_PURCHAGE_YEAR ="Purchase year";
     public static final String CC_OWNER_OF_THE_OBJECT ="Owner of the object";
     public static final String CC_COST_OF_REPAIR ="Cost of repair (incl.VAT)";
     public static final String CC_VALUE ="Value (incl.VAT)";
     public static final String CC_VENDOR = "Vendor";
     
     public static final String CC_ROOM="Room";
     public static final String CC_UTILITY_STRUCTURE="Utility / Structure";
     public static final String CC_LOSS_COSTS="Loss costs";
     public static final String CC_LOSS_ESTIMATE="Loss estimate";
     
     //Property Delay cloumn names
     public static final String CC_QUANTITY = "Quantity";
     public static final String CC_CATEGORY ="Category";
     public static final String CC_COST ="Cost";
     public static final String CC_PURCHAGE_DATE ="Purchase Date";
     
     //Add Property Damage
     public static final String CC_ADD_PROPERTY_DAMAGE_BUTTON = "Add Property Damage";
     public static final String CC_OBJECT_USEBY_INSURED_LABEL = "Was the object in use by insured?";
     public static final String CC_PROPERTY_INSURED_RELATED_LABEL = "Property is related to insured:";
     public static final String CC_INJURED_LIVINGWITH_INSURED_LABEL = "Does the person who suffered the loss, damage or injury live in the same household as the insured?";
     public static final String CC_UNKNOWN_PROPERTY_BUTTON = "Unknown Property";
     public static final String CC_LAHITAPIOLA = "LähiTapiola";
     public static final String CC_DWELLINGAGEREDUCTION = "Dwelling Age Reduction";
     public static final String CC_CONTENTAGEREDUCTION = "Content Age Reduction";
     public static final String CC_SETRECOVERYRESERVES = "Set Recovery Reserves";
     public static final String CC_SETRESERVES = "Set Reserves";
     public static final String CC_EDITRESERVES = "Edit Reserves";
     public static final String CC_CHECK = "Check";
     public static final String CC_RESERVE = "Reserve";
     public static final String CC_ENTER_PAYMENT_INFORMATION_HEADER = "Step 2 of 3: Enter payment information";
     public static final String CC_SET_CHECK_INSTRUCTIONS_HEADER = "Step 3 of 3: Set check instructions";
     public static final String CC_EXPOSURES = "Exposures";
     public static final String CC_CREATERECOVERY = "Create Recovery";
     public static final String CC_VIEW_LOGS = "View Logs";
     public static final String CC_FINANCIALS_CHECKS = "Financials: Checks";
     
     public static final String CC_RECOVERY_RESERVE = "Received payment is different than the Recovery reserve";
     
     public static final String CC_PAYEECONTENTS_PART1 = "(2) 1st PartyContent - ";
     public static final String CC_PAYEECONTENTS_PART2 = "; Claim Cost/Other; EUR";
     public static final String CC_FORESTDAMAGE_CHECKBOX = "Forest Damage";
     public static final String CC_ADD_FOREST_DAMAGE_PARTIES = "Add Property Damage Parties";
     public static final String CC_BOAT_EQUIPMENT_DAMAGE = "Boat Equipment Damage";
     
     //Search or Create Policy
     public static final String CC_POLICYTYPE_PET = "pet";
     public static final String CC_POLICYTYPE_HOMEOWNER = "Homeowners";
     public static final String CC_POLICYTYPE_FOREST = "Forest";
     
     //Payments
     public static final String CC_FINANCIALS = "Financials";
     public static final String CC_TRANSACTIONS = "Transactions";
     public static final String CC_PAYMENTDETAILS = "Payment Details";
     public static final String CC_CHECKS = "Checks";
     public static final String CC_PAYMENTINFO_ROOM = "Room";
     public static final String CC_PAYMENTINFO_UTILITY = "Utility/Structure";
     public static final String CC_PAYMENTINFO_COST="Cost of repair";
     public static final String CC_PAYMENTINFO_Item ="Item";
     public static final String CC_PAYMENTINFO_YEAR="Year of deployment";
     public static final String CC_PAYMENTINFO_VALUE="Value (incl.VAT)";
  
     //Notes
     public static final String CC_NOTES_HEADER = "Notes";
     public static final String CC_NEWNOTE_HEADER = "New Note";
     
     //Add Veteranary expenses
     public static final String CC_VETERINARY_EXPENSES_TYPE = "Veterinary expenses type"; 
     public static final String CC_AMOUNT_INCL_VAT = "Amount incl.VAT"; 
     
   //Veteranary expenses
     public static final String CC_NEWEXPOSURE_VETERINARYEXPENSES = "New Exposure - Veterinary Expenses";
     public static final String CC_FNOLSNAPCHAT = "FNOL Snapshot";
     public static final String CC_SNAPCHAT_LOSSDETAILS = "Snapshot: Loss Details";
     
     
     
   //Death
     public static final String CC_NEWEXPOSURE_DEATHACCIDENT = "New Exposure - Death accident";
     
     public static final String CC_POLICY = "Policy";
     public static final String CC_POLICYDETAILS = "Policy Details";
     public static final String CC_BASICINFO = "Basic Info";
     public static final String CC_PARTIESINVOLVED = "Parties Involved";
     
     //Pet Incident
     public static final String CC_DEATH = "DEATH";
     public static final String CC_PERMANENT_LOSS_OF_USE = "Permanent loss of use";
     public static final String CC_DISAPPEARANCE = "Disappearance";
     public static final String CC_PROPERTY = "Property";
     
     //Forest
     public static final String CC_FOREST = "Forest";
     public static final String CC_FOREST_BUILDING = "Forest Building";
     public static final String CC_FOREST_MAINTENANCEEQUIPMENT = "Forest Maintenance Equipment";
     
     //Boat
     public static final String CC_BOAT = "Boat";
     
     //Coverages
     public static final String CC_STORAGE_CONTENT = "Storage content";
     public static final String CC_OTHER_CONTENT = "Other named content";
     public static final String CC_EDIT_CLAIM = "Edit";
     public static final String CC_UPDATE = "Update";
     
     //WorkPlan Activities
     public static final String CC_CLOSE_WORKSHEET = "Close WorkSheet";
     
     //Exposures
     public static final String CC_NO_VALIDATION_ERRORS = "No validation errors.";
     
     //Financials
     public static final String CC_CLAIM_COST = "Claim Cost"; 
     public static final String CC_COST_CATEGORY = "Lump-sum compensation";
     public static final String  CC_AWAITING_SUBMISSION = "Awaiting submission";
     public static final String CC_FINANCIALS_ESCALATION_BATCH = "Financials Escalation";
     public static final String CC_CREATE_A_DECISION = "Create a decision";
     public static final String CC_CREATE_A_DECISION_NON_EDIT = "Create a decision (non-editable)";
     public static final String CC_DO_NOT_CREATE_DECISION = "Do not create decision";
     public static final String CC_REQUESTED = "Requested"; 
     public static final String	CC_PROPERTY_REPAIR = "Property repair";
     
     //Documents
     public static final String CC_DOCUMENTS = "Documents";
     public static final String CC_EDIT_DOCUMENT = "Edit Document";
     public static final String CC_FINALIZE_DOCUMENT = "Finalize Document";
     
     //Recovery
     public static final String CC_ASSESSMENTS = "Assessments";
     public static final String CC_NEW_RECOVERY_ASSESSMENT_NOTIFICATION = "New Recovery Assessment Notification";

     //Administration
     public static final String CC_ACCOUNTS = "Accounts";
     public static final String CC_MESSAGE_QUEUES = "Message Queues";
     public static final String CC_KATRE = "Katre";
     public static final String CC_KATRE_REPORTS = "Katre Reports";
     
     //Create Service
     public static final String CC_CREATE_SERVICE = "Create Service";
     public static final String CC_ADD_SERVICE = "Add Service";
     	public static final String CC_DEFAULT_COMPENSABILITY_DENIED = "Direct compensation denied";
     	
     //Calendar
     public static final String CC_CLAIM_CALENDAR = "Claim Calendar";
     
     //Statements
     public static final String CC_STATEMENTS = "Statements";
     
     //Medical Document Requests
     public static final String CC_MEDICAL_DOCUMENT_REQUESTS = "Medical Document Requests";
     
     //TimeLine
     public static final String CC_CREATE_TIMELINE = "Claim Timeline";
     
     //Reinsurance
     public static final String CC_REINSURANCE = "Reinsurance Financials Summary";
     
     //Parties Involved
     public static final String CC_CONTACTS = "Contacts";
     
     //Aggregate limits
     public static final String CC_AGGREGATELIMITS = "Policy: Aggregate Limits";
     
     public static final String CC_POLICY_GENERAL = "Policy: General";
     
     public static final String CC_POLICY_VEHICLES = "Policy: Vehicles";
     
     public static final String CC_MOTOR_FIRST_AND_FINAL = "Step 2 of 2: Motor First and Final";
     
     //Compensation Cases
     public static final String CC_COMPENSATION_CASES = "Compensation Cases";
     
     //New Exposure
     public static final String CC_NEW_EXPOSURE_HEADER = "New Exposure";
     
     public static final String CC_E_INVOICE = "E-invoice";

     //New Activity in claim
     public static final String CC_NEW_ACTIVITY_IN_CLAIM = "New Activity in Claim";
     public static final String CC_SCRIPTPARAMETERS = "Script Parameters";

     //Offer Manager
     public static final String CC_TOTALOFFER_POLICYINFO= "Total offer IDs could not be fetched, please try again";
     public static final String CC_TOTAL_OFFER_ID="Total Offer Id";
     
     public static final String CC_VEHICLE_INFO="Vehicle information";
     public static final String CC_INSURANCE_FOR="Who is the insurance for?";
     

}