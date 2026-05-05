package com.guidewire.utilities;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.Reporter;

import com.guidewire.config.DB_CONSTANTS;

public class DataBaseUtilities {
	ResultSet rs;
	PreparedStatement statement;
	public int numberOfColumnsInTable;
	public int numberOfRowsInTable;
	
	/**
	 * This Method is Used to check the table existence in the connected database for specified environment
	 * and the script will be terminated if the table does not exist
	 * @param conn
	 * @param tableName
	 * @param environment
	 * @throws SQLException
	 */
	public void checkTableExistance(Connection conn, String tableName, String environment) throws SQLException {
		DatabaseMetaData meta = conn.getMetaData();
		ResultSet res = meta.getTables(DB_CONSTANTS.DATABASETOCONNECT+"_"+ environment, "dbo",tableName ,null);
		if (res.next()) {
			System.out.println("The table "+tableName+" exists and table details are as below:");
			System.out.println("Table catalog: "+res.getString("TABLE_CAT") );
			System.out.println("Table Schema: "	+res.getString("TABLE_SCHEM"));
			System.out.println("Table Name: "+res.getString("TABLE_NAME"));
			System.out.println("Table Type: "+res.getString("TABLE_TYPE"));
			//System.out.println("Remarks: "+res.getString("REMARKS")); 
		}
		else
		{
			Assert.fail("The Table does not exists, so the testing will be terminated");
			//System.out.println("The Table does not exists, so the testing will be terminated");
			//System.exit(0);
		}
	}
	
	/**
	 * This Method is used to returns column count in the table for a specified environment
	 * @param conn
	 * @param tableName
	 * @param environment
	 * @return
	 * @throws SQLException
	 */

	public int CheckColumnCount (Connection conn, String tableName, String environment) throws SQLException {
		String ColumCountQuery  = DB_CONSTANTS.COLUMNCOUNTQUERY+ DB_CONSTANTS.DBO +"'"+tableName+"'";
		//System.out.println("ColumCountQuery: "+ColumCountQuery); //To check the query formation
		ResultSet columncount = executeQueryFromConnection(conn,ColumCountQuery);
		while (columncount.next()) {
			numberOfColumnsInTable = columncount.getInt(1);
		}

		return numberOfColumnsInTable;
	}
	/**
	 * This Method is used to return row count in the table for a for a specified environment
	 * @param conn
	 * @param tableName
	 * @param environment
	 * @return
	 * @throws SQLException
	 */

	public int CheckRowCount (Connection conn, String tableName, String environment) throws SQLException {
		String RowCountQuery  = DB_CONSTANTS.GENERICROWCOUNTQUERY+ DB_CONSTANTS.DBO +tableName;
		//System.out.println("RowCountQuery: "+RowCountQuery);  //To check the query formation
		ResultSet Rowcount = executeQueryFromConnection(conn,RowCountQuery);
		while (Rowcount.next()) {
			numberOfRowsInTable = Rowcount.getInt(1);
		}
		System.out.println("Number of rows/records in the table "+ tableName +" is: "+numberOfRowsInTable);
		return numberOfRowsInTable;
	}
/**
 * This Method returns the result set after  Executing the Query
 * @param con
 * @param QueryToExecute
 * @return
 * @throws SQLException
 */
	public ResultSet executeQueryFromConnection(Connection con, String QueryToExecute) throws SQLException {
		try {
			statement = con.prepareStatement(QueryToExecute,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery();
			if (!QueryToExecute.contains("count(*)")) {
				ResultSetMetaData metaData = rs.getMetaData();
				numberOfColumnsInTable=metaData.getColumnCount();	
				//System.out.println("numberOfColumnsInTable: "+numberOfColumnsInTable);
			}
			return rs;		
		} catch (SQLException e) {
//			System.out.println("SQL Exception occured: "+e.getMessage());
			Reporter.log("Possible chances of failure are :", true);
			Reporter.log("1. Access rights missing", true);
			Reporter.log("2. Syntax error", true);
			Reporter.log("Database Utilities --> ExecuteQueryFromConnection Function gets SQLException " + e.getMessage());
//			Assert.fail("An Exception occured");
			throw e;
		} 
	}
	
	/**
	 * This Method is used to avoid resource leakage and closing the connection after DB operations
	 * @param connection
	 * @throws SQLException
	 */

	public void closeConnection(Connection connection) throws SQLException {
		if (!(connection==null)) {
			try {
				if (statement != null) {
					statement.close();
					rs.close();
				}
				connection.close();
			} catch (SQLException e) {
				throw e;
			}
		}
	}

	 
	
	
	
	
	/**
	 * Function to update SQL DB data
	 * @param con
	 * @param QueryToExecute
	 * @throws SQLException
	 */
	public void UpdateQuery(Connection con, String QueryToExecute) throws SQLException {
		try {
		     Statement stmt = con.createStatement();
		     stmt.executeUpdate(QueryToExecute); 
		} catch (SQLException e) {
//			System.out.println("SQL Exception occured: "+e.getMessage());
			Reporter.log("Database Utilities --> UpdateQuery Function gets SQLException " + e.getMessage());
			Assert.fail("An Exception occured");
			throw e;
		} 
	}
	
}


