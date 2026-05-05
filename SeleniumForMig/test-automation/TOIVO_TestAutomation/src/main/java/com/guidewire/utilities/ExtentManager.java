/*'*************************************************************************************************************************************************
' Script Name                            : Extent Manager
' Description                             : Used to create an object for extent report initialisation results
'-----------------------------------------------------------------
' Author                          Version          Creation Date         
'-----------------------------------------------------------------
' CGI offshore automation team
'*************************************************************************************************************************************************
 */

package com.guidewire.utilities;



import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.guidewire.config.CONSTANTS;




public class ExtentManager {

	private static ExtentReports extent;
	private static ExtentTest test;
	private static ExtentHtmlReporter htmlReporter;
	private final static String filePath = CONSTANTS.TESTREPORT_HTML_PATH + CONSTANTS.DateFormat+"_Toivo_AutomationTestReport.html";
//	private final static String filePath = CONSTANTS.TESTREPORT_HTML_PATH + CONSTANTS.DateFormat+ CONSTANTS.getRUNTIME_TC_NAME().substring(0, 40)   +"_ExecutionReport.html";

	public static ExtentReports GetExtent(){
		if (extent != null)
			return extent; //avoid creating new instance of HTML file if it is not null
		
		htmlReporter=getHtmlReporter();
		extent = new ExtentReports();                    
		extent.setSystemInfo("Operating System", "Windows 7");
		extent.setSystemInfo("Selenium Version", "3.4");        
		extent.attachReporter(htmlReporter);
		return extent;
	}
	private static ExtentHtmlReporter getHtmlReporter() {
		htmlReporter = new ExtentHtmlReporter(new File(filePath));                     
		htmlReporter.loadXMLConfig(CONSTANTS.ExtentConfigPath);
		htmlReporter.setAppendExisting(false);    
		htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
		return htmlReporter;
	}

	public static ExtentTest createTest(String name, String description){
		test = extent.createTest(name, description);
		return test;
	}
}
