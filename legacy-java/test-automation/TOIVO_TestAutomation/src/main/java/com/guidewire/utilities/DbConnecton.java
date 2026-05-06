package com.guidewire.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.Reporter;

import com.guidewire.config.CONSTANTS;
import com.guidewire.config.DB_CONSTANTS;

public class DbConnecton {
	
	private static Connection connection;
	
	public static Connection openConnection( String UserID, String Password, String envrironment) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		System.setProperty("java.net.preferIPv6Addresses", "true");  
		String jdbcClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
		// Set URL for data source
		String url = DB_CONSTANTS.DATABASETYPE+DB_CONSTANTS.SERVERNAME+":"+ DB_CONSTANTS.SERVERPORTNUMBER+";"+"databaseName= "+DB_CONSTANTS.DATABASETOCONNECT+"_"+ envrironment;
		//System.out.println(url); //To Check the URL formation 
		Properties properties = new Properties(); /** Create Properties object */
		properties.put("user", UserID); /** Set user ID for connection */
		properties.put("password", Password); /** Set password for connection */
		connection = null;
		try {
			/** Load class into memory */
			Class.forName ( jdbcClassName).newInstance(); 
			/** Establish the connection using the IBM Data Server Driver for JDBC */
			connection= DriverManager.getConnection (url,properties);                
			/** Commit changes      * false -manually */			
			connection.setAutoCommit(true);	
			System.out.println("Successfully Connected to the Database: "+DB_CONSTANTS.DATABASETOCONNECT+"_"+ envrironment);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			Assert.fail("An Exception occured");
		} finally {
			if (connection != null) {
				Reporter.log("Connected successfully to the database : "+DB_CONSTANTS.DATABASETOCONNECT+"_"+ envrironment);
			}
		}
		return connection;
	}
	
	/**
	 * Function to connect Databse - GW/TDM
	 * @param UserID
	 * @param Password
	 * @param DBConnect
	 * @param TDM_GW
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection DB_openConnection( String UserID, String Password, String DBConnect, String... TDM_GW) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		System.setProperty("java.net.preferIPv6Addresses", "true");  
		String jdbcClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
		// Set URL for data source
		String url="";
		if(TDM_GW.length>0) {
			url = DB_CONSTANTS.DATABASETYPE+DB_CONSTANTS.GW_DB_SERVERNAME+":"+ DB_CONSTANTS.ODS_DB_SERVERPORTNUMBER+";"+"databaseName= "+DBConnect;
		}
		else {
			url = DB_CONSTANTS.DATABASETYPE+DB_CONSTANTS.TDM_DB_SERVERNAME+":"+ DB_CONSTANTS.TDM_DB_SERVERPORTNUMBER+";"+"databaseName= "+DBConnect;
		}

		System.out.println(url); //To Check the URL formation 
		Properties properties = new Properties(); /** Create Properties object */
		properties.put("user", UserID); /** Set user ID for connection */
		properties.put("password", Password); /** Set password for connection */
		connection = null;
		try {
			/** Load class into memory */
			Class.forName ( jdbcClassName).newInstance(); 
			/** Establish the connection using the IBM Data Server Driver for JDBC */
			connection= DriverManager.getConnection (url,properties);                
			/** Commit changes      * false -manually */			
			connection.setAutoCommit(true);	
			System.out.println("Successfully Connected to the Database: "+DBConnect);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			Assert.fail("An Exception occured");
		} finally {
			if (connection != null) {
				Reporter.log("Connected successfully to the database : "+DBConnect);

			}
		}
		return connection;
	}
	
	
	
	/**
	 * Function to open DB connection for ODS and HALI
	 * @param UserID
	 * @param Password
	 * @param envrironment
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection open_DBConnection( String UserID, String Password, String envrironment) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		System.setProperty("java.net.preferIPv6Addresses", "true");  
		String jdbcClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
		String url = "";
		Properties properties = new Properties(); /** Create Properties object */
		
		switch (envrironment) {
		case "ODS":
		case "Ods":
		case "ods":
			//ODS
			if(CONSTANTS.getENVIRONMENTTORUN().equalsIgnoreCase("SIT1")) {
				url = DB_CONSTANTS.DATABASETYPE+"LHT-CCSQLTL0006.tapio001.tapiola.fi"+":"+ DB_CONSTANTS.ODS_DB_SERVERPORTNUMBER+";"+"databaseName= ODSPOLICY_SIT";
			}else if(CONSTANTS.getENVIRONMENTTORUN().equalsIgnoreCase("UATCLUSTER")){
				url = DB_CONSTANTS.DATABASETYPE+"LHT-CCSQLTL0006.tapio001.tapiola.fi"+":"+ DB_CONSTANTS.ODS_DB_SERVERPORTNUMBER+";"+"databaseName= ODSPOLICY_UAT";
			}
			System.out.println(url); //To Check the URL formation 			
			properties.put("user", "LTODSPOLICY"); /** Set user ID for connection */
			properties.put("password", "LT0d5POLcusr%$1TESTn"); /** Set password for connection */
			break;
			
		case "HALI":
		case "hali":
		case "Hali":	
			//HALI
			if(CONSTANTS.getENVIRONMENTTORUN().equalsIgnoreCase("SIT1")) {
				url = DB_CONSTANTS.DATABASETYPE+"LHT-CCSQLTL0006.tapio001.tapiola.fi"+":"+ DB_CONSTANTS.HALI_DB_SERVERPORTNUMBER+";"+"databaseName= HALI_TEST";
			}else if(CONSTANTS.getENVIRONMENTTORUN().equalsIgnoreCase("UATCLUSTER")) {
				url = DB_CONSTANTS.DATABASETYPE+"LHT-CCSQLTL0006.tapio001.tapiola.fi"+":"+ DB_CONSTANTS.HALI_DB_SERVERPORTNUMBER+";"+"databaseName= HALI_UAT";
			}
//			System.out.println(url); //To Check the URL formation 			
			properties.put("user", "HaliDBAdmin"); /** Set user ID for connection */
			properties.put("password", "H2l1DbADm/511nte$t"); /** Set password for connection */
			break;
		}

		
		connection = null;
		try {
			/** Load class into memory */
			Class.forName ( jdbcClassName).newInstance(); 
			/** Establish the connection using the IBM Data Server Driver for JDBC */
			connection= DriverManager.getConnection (url,properties);                
			/** Commit changes      * false -manually */			
			connection.setAutoCommit(true);	
//			System.out.println("Successfully Connected to the Database: "+ envrironment);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
//			Assert.fail("An Exception occured");
		} finally {
			if (connection != null) {

				Reporter.log("Connected successfully to the database : shredder");

			}
		}
		return connection;
	}
}
