package com.guidewire.config;

public class DB_CONSTANTS {

	public static final String SERVERNAME="s16750.tapio001.tapiola.fi"; 
	public static final String SERVERPORTNUMBER="2083";
	public static final String DATABASETOCONNECT="Subledger_Clearing"; 
	//public static final String ENVIRONMENT = "CI"; // To be picked from Excel sheet 
	public static final String DATABASETYPE = "jdbc:sqlserver://";
	//public static final String LOOKUPTABLEQUERY = "Select LookupName, LookupKeyA,LookupKeyB,ValidFrom,ResolvedKeyValue from dbo.LKP_GenericTable";// will be formed
	public static final String COLUMNCOUNTQUERY = "Select count(column_name) from information_Schema.columns where table_name = ";
	public static final String GENERICROWCOUNTQUERY ="Select count(*) from ";
	public static final String SELECT="Select";
	public static final String FROM ="From";
	public static final String DBO ="dbo.";
	public static final String WHERE ="Where";
	public static final String IN = "IN";
	public static final String MAX = "MAX";
	public static final String AS = "AS";
	public static final String WITH = "WITH";
	public static final String EXCEPT = "EXCEPT";
	public static final String AND = "AND";
	//public static final String LATESTBATCHRUNROWCOUNT = "Select" ;
	
	
	public static final String TDM_DB_SERVERNAME="LHT-1MS-TDM0002.tapio001.tapiola.fi"; 
	public static final String TDM_DB_SERVERPORTNUMBER="2083";
	public static final String ODS_DB_SERVERPORTNUMBER="1433";
	public static final String HALI_DB_SERVERPORTNUMBER="1433";
	public static final String TDM_DATABASETOCONNECT="Shredder"; 
	
	//public static final String GW_DB_SERVERNAME="S00600.tapio001.tapiola.fi";
	public static final String GW_DB_SERVERNAME="LHT-GWSQLTL0001.tapio001.tapiola.fi";
	public static final String GW_POLICYCENTER="POLICYCENTER";
	public static final String GW_BILLINGCENTER="BILLINGCENTER"; 
	public static final String GW_CLAIMCENTER="CLAIMCENTER";
	public static final String GW_FUN_CLAIMCENTER8="GW_FUN_CLAIMCENTER8";
	public static final String GW_DB_UAERNAME="Sqltestautomationuser";
	public static final String GW_DB_PASSWORD="thjk6VZ%q8SrVwP345$lwLdD2#C7-_#-#"; 
	
	public static final String GW_DB_QUERY_FetchPolicyNum="select top 1 [Policy Number],FirstName,LastName,value from tdm.vwExPolicy where Producer='paakaupunkiseutu' and Created <> 'Older than 30 days' and ProductCode='VehicleInsurance_LT' and [Policy Status]='Bound'";
	
	public static final String GW_DB_QUERY_FetchPolicyDetails_Motor="select top 1 [Account Number],[Policy Number],[Claim Number] from tdm.vwExPolicy where Producer='paakaupunkiseutu' and Created <> 'Older than 30 days' and ProductCode='VehicleInsurance_LT' and [Policy Status]='Bound'";
	
	public static final String GW_DB_QUERY_FetchAccountNum_Motor="select top 1 [Account Number] from tdm.vwExPolicy where Producer='paakaupunkiseutu' and Created <> 'Older than 30 days' and ProductCode='VehicleInsurance_LT' and [Policy Status]='Bound'";
	public static final String GW_DB_QUERY_FetchPolicyNum_Motor="select top 1 [Policy Number] from tdm.vwExPolicy where Producer='paakaupunkiseutu' and Created <> 'Older than 30 days' and ProductCode='VehicleInsurance_LT' and [Policy Status]='Bound'";
	public static final String GW_DB_QUERY_FetchClaimNum_Motor="select top 1 Claim from TDM.vwClaim";   //View name "GW_SIT_CLAIMCENTER1"

}
