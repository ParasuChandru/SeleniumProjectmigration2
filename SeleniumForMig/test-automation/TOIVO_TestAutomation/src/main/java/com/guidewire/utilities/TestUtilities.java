package com.guidewire.utilities;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;
import org.testng.SkipException;

import com.guidewire.commonpagefunctions.GenericFunctions;
import com.guidewire.config.ADDRESS_DATASHEET_CONSTANTS;
import com.guidewire.config.CONSTANTS;


public class TestUtilities {

	/**
	 * @param xls
	 * @param testCaseName
	 * @returns true if runmode of the testcase is set to Y
	 */
	public static boolean isTestCaseRunnable(Xls_ReadWrite xls, String testCaseName,String TESTCASES_WORKSHEET,String TESTCASES_TESTCASEID){
		boolean isExecutable=false;
		for(int i=2; i<= xls.getRowCount(TESTCASES_WORKSHEET) ; i++){
			/** String tcid=xls.getCellData("Test Cases", "TestcaseID", i);
			 * String runmode=xls.getCellData("Test Cases", "Runmode", i);
			 * System.out.println(testcaseid +" -- "+ runmode); */
			
			if(xls.getCellData(TESTCASES_WORKSHEET, TESTCASES_TESTCASEID, i).equalsIgnoreCase(testCaseName)){
				if(xls.getCellData(TESTCASES_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.RUNMODE, i).equalsIgnoreCase(ADDRESS_DATASHEET_CONSTANTS.YES)){
					isExecutable= true;					
				}else{
					isExecutable= false;
				}
			}
		}		
		return isExecutable;
     }


	/**
	 * @param xls
	 * @param testCaseName
	 * @param browserSelection
	 * @returns true if run on browser ( firefox, ie, chrome)set to yes
	 */
	public static boolean  runTestcaseOnBrowser(Xls_ReadWrite xls, String testCaseName, String browserSelection){
		boolean selectedBrowser=false;
		for(int i=2; i<= xls.getRowCount(ADDRESS_DATASHEET_CONSTANTS.TESTCASES_WORKSHEET) ; i++){
			/*String tcid=xls.getCellData("Test Cases", "TestcaseID", i);
			String runmode=xls.getCellData("Test Cases", "Runmode", i);
			System.out.println(testcaseid +" -- "+ runmode);*/

			if(xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTCASES_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.TESTCASES_TESTCASEID, i).equalsIgnoreCase(testCaseName)){
				switch (browserSelection) {
				case "firefox": 
					if(xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTCASES_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.RUN_ON_FIREFOX, i).equalsIgnoreCase(ADDRESS_DATASHEET_CONSTANTS.YES)){
						selectedBrowser = true;
					}
					break;
				case "chrome":
					if(xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTCASES_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.RUN_ON_CHROME, i).equalsIgnoreCase(ADDRESS_DATASHEET_CONSTANTS.YES)){
						selectedBrowser = true;
					}
					break;
				case "chrome-Headless":
					if(xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTCASES_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.RUN_ON_CHROME, i).equalsIgnoreCase(ADDRESS_DATASHEET_CONSTANTS.YES)){
						selectedBrowser = true;
					}
					break;
				case "ie":
					if(xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTCASES_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.RUN_ON_IE, i).equalsIgnoreCase(ADDRESS_DATASHEET_CONSTANTS.YES)){
						selectedBrowser = true;
					}
					break;
				case "safari":
					if(xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTCASES_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.RUN_ON_SAFARI, i).equalsIgnoreCase(ADDRESS_DATASHEET_CONSTANTS.YES)){
						selectedBrowser = true;
					}
					break;
				case "opera":
					if(xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTCASES_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.RUN_ON_OPERA, i).equalsIgnoreCase(ADDRESS_DATASHEET_CONSTANTS.YES)){
						selectedBrowser = true;
					}
				case "phantom":
					if(xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTCASES_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.RUN_ON_HEADLESS, i).equalsIgnoreCase(ADDRESS_DATASHEET_CONSTANTS.YES)){
						selectedBrowser = true;
					}
				case "htmlunit":
					if(xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTCASES_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.RUN_ON_HEADLESS, i).equalsIgnoreCase(ADDRESS_DATASHEET_CONSTANTS.YES)){
						selectedBrowser = true;
					}	
					break;
				case "edge":
					if(xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTCASES_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.RUN_ON_EDGE, i).equalsIgnoreCase(ADDRESS_DATASHEET_CONSTANTS.YES)){
						selectedBrowser = true;
					}
					break;
				case "edge16":
					if(xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTCASES_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.RUN_ON_EDGE, i).equalsIgnoreCase(ADDRESS_DATASHEET_CONSTANTS.YES)){
						selectedBrowser = true;
					}
					break;
				default:
					Reporter.log("The browser you have mentioned in xml file suite file is not updated in test data excel sheet");
					break;
				}
				//throw new SkipException("The Selenium script is not available to execute the test case "+testCaseName+ " mentioned in test case xlsx file. Hence skipped the test case execution");
			}
		}
		return selectedBrowser;
	}

	/**
	 * @param xls
	 * @param testCaseName
	 * @returns the test data from xls
	 */
	public static Object[][] getData(Xls_ReadWrite xls, String testCaseName) {
		// if the sheet is not present
		if (!xls.isSheetExist(testCaseName)) {
			// throw new SkipException("The test data worksheet is not availble for test case "+testCaseName+". HEnce skipped the test case execution.");
			return null;
		}

		int rows = xls.getRowCount(testCaseName);
		int cols = xls.getColumnCount(testCaseName);

		Object[][] data = new Object[rows - 1][cols];
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				Reporter.log(xls.getCellData(testCaseName, colNum,rowNum) + " -- ");
				data[rowNum - 2][colNum] = xls.getCellData(testCaseName, colNum, rowNum);
			}
		}
		return data;
	}

	// return the test data from xls
	/**
	 * @param xls
	 * @param testCaseName
	 * @param testDatafields
	 * @return
	 */
	public static Object[][] getTestData(Xls_ReadWrite xls, String testCaseName, String[] testDatafields,String testDataWorksheet,String testCasesID) {
		// if the sheet is not present
		if (!xls.isSheetExist(testDataWorksheet)) {
			return null;
//			throw new SkipException("The test data worksheet is not availble for test case "+testCaseName+". HEnce skipped the test caseexecution.");			
		}

		int cols = testDatafields.length;
		Object[][] data = new Object[1][cols];
		for (int i = 2; i <= xls.getRowCount(testDataWorksheet); i++) {
			if (xls.getCellData(testDataWorksheet, testCasesID, i).equalsIgnoreCase(testCaseName)) {
				for (int colNum = 0; colNum < cols; colNum++) {
					if ("@null".equals(xls.getCellData(testDataWorksheet, testDatafields[colNum], i))){
						System.out.println("The column name \'"+testDatafields[colNum]+"\' is not available in test data excel sheet");
					}
					data[0][colNum] = xls.getCellData(testDataWorksheet, testDatafields[colNum], i);
				}
				break;
			}
		}
		return data;
	}	
	
	/**
	 * 
	 * Get test data based on the test case name passed
	 * @param xls
	 * @param testCaseName
	 * @return
	
	 */
	public static  Object[][] getTestDataBasedOnTestCase(Xls_ReadWrite xls, String testCaseName) {
		// if the sheet is not present
		if (!xls.isSheetExist(ADDRESS_DATASHEET_CONSTANTS.TESTDATA_WORKSHEET)) {
			throw new SkipException("The test data worksheet is not available for test case "+testCaseName+". Hence skipped the test case execution.");		
//			return null;
		}
		
		int rows = xls.getRowCount(ADDRESS_DATASHEET_CONSTANTS.TESTDATA_WORKSHEET);
		for (int i = 2; i <= rows; i++) {
			if(xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTDATA_WORKSHEET, ADDRESS_DATASHEET_CONSTANTS.TESTCASES_TESTCASEID, i).equalsIgnoreCase(testCaseName)){
				rows=i;
				break;
			}
		}
		
		int cols = xls.getColCountForParticularRow(ADDRESS_DATASHEET_CONSTANTS.TESTDATA_WORKSHEET,rows);
		int headerName=rows+1;
		int headerValue=rows+2;
		
		String[][] testDataFields = new String[1][cols];
		for(int colNumber=0;colNumber<cols;colNumber++){
			if(!("".equals(xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTDATA_WORKSHEET, colNumber, headerName)))){
//			System.out.println("Header Name: "+xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTDATA_WORKSHEET, colNumber,headerName ));
//			System.out.println("Header Value: "+xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTDATA_WORKSHEET, colNumber, headerValue));
			testDataFields[0][colNumber]=xls.getCellData(ADDRESS_DATASHEET_CONSTANTS.TESTDATA_WORKSHEET, colNumber, headerValue);
			}
		}
		return testDataFields;		
	}	
	
	
	
	public static Object[][] getData_UsingHashtable(Xls_ReadWrite xls, String testname){
		String sheetName = "ApplicationLevelTestData";
		
		//reads data for only testCasename
		int testStartsRowNum = 1;
		while ( !xls.getCellData(sheetName, 0, testStartsRowNum).equals(testname)){
			testStartsRowNum++;
		}
		
		//System.out.println("test Starts from row number : "+ testStartsRowNum);
		int colStartRowNum = testStartsRowNum+1;
		int dataStartRowNum = testStartsRowNum+2;
		
		//calculate rows of data
		int rows = 0;
		while ( !xls.getCellData(sheetName, 0, dataStartRowNum+rows).equals("")){
			rows++;
		}
		
		//System.out.println("Total rows are :" + rows);
		
		//Calculate total rows
		int cols = 0;
		while( !xls.getCellData(sheetName, cols, colStartRowNum).equals("")){
			cols++;
		}
		
		
		//System.out.println("Total cols are :"+cols);
		
		Object[][] data = new Object[rows][1];
		
		int dataRow =0;
		Hashtable<String, String> table = null;
		for ( int rNum=dataStartRowNum; rNum < dataStartRowNum+rows ; rNum++){
			table = new Hashtable<String, String>();
			for (int cNum=0; cNum<cols; cNum++){
				String key = xls.getCellData(sheetName, cNum, colStartRowNum);
				String value = xls.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
			}
		data[dataRow][0] = table;
		dataRow++;
		}
		return data;
	}
	
	/**
	 * Function to generate excel report based on the test scripts
	 * @return 
	 * @throws Exception 
	 */
	public void initializeExcelReport() throws IOException {
			File reportFile = new File(ADDRESS_DATASHEET_CONSTANTS.REP_INPUT_FILE); 
			int rowNum=0;
			if(reportFile.exists()){
				Reporter.log("reportFile exists");
			}else{
				// Create an Report in excel
				XSSFWorkbook book = new XSSFWorkbook();
				XSSFSheet sheet;
				XSSFSheet sheet1;
				String sheetName ="TOIVO TestSuite Report";
				String sheet1Name = "Graphical_Summary";
				
				//Create an excel in the prescribed format
				FileOutputStream writeXLOutput = null;
				try{					
					XSSFCellStyle topHeaderContents = book.createCellStyle();
					XSSFCellStyle tableHeader = book.createCellStyle();
					XSSFCellStyle tableContentsOnLeft = book.createCellStyle();
					XSSFCellStyle tableContentsOnRight = book.createCellStyle();
					XSSFRow row;
					//Header Column Names
					XSSFCell celEnvName;
					XSSFCell  celAppName;
					XSSFCell  celTestName;
					XSSFCell  celTestStatus;
					XSSFCell  celExecStartTime;
					XSSFCell  celExecEndTime;
					XSSFCell  celExecTime;
					XSSFCell  celComments;
					XSSFCell  celJiraUpdateComments;
					XSSFCell  celJiraUpdateStatus;
					
					
					// Set the Font details for the entire sheet
					XSSFFont defaultFont;
					XSSFFont headerFont;
					String path = GenericFunctions.class.getClassLoader().getResource("./").getPath();
					path = path.replace("bin", "src");
					
					headerFont = book.createFont();
					headerFont.setFontHeightInPoints((short) 11);
					headerFont.setFontName("Calibri");
					headerFont.setColor(IndexedColors.WHITE.getIndex());
					headerFont.setBold(true);
					headerFont.setItalic(false);
					
					defaultFont = book.createFont();
					defaultFont.setFontHeightInPoints((short) 11);
					defaultFont.setFontName("Calibri");
					defaultFont.setColor(IndexedColors.BLACK.getIndex());
					defaultFont.setBold(true);
					defaultFont.setItalic(false);
							
					// create style for cells in header row
					topHeaderContents.setFont(headerFont);
					topHeaderContents.setFillPattern(FillPatternType.NO_FILL);
					topHeaderContents.setFillForegroundColor(HSSFColor.LIGHT_BLUE.index);
					topHeaderContents.setFillPattern(FillPatternType.SOLID_FOREGROUND);		
					// Set the border style for the workbook
					topHeaderContents.setAlignment( HorizontalAlignment.LEFT);
					
					// create style for cells in header row
					tableHeader.setFont(defaultFont);
					tableHeader.setFillPattern(FillPatternType.NO_FILL);
					tableHeader.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
					tableHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);
					// Set the border style for the workbook
					tableHeader.setBorderBottom(BorderStyle.THIN);
					tableHeader.setBorderLeft(BorderStyle.THIN);
					tableHeader.setBorderRight(BorderStyle.THIN);
					tableHeader.setBorderTop(BorderStyle.THIN);
					tableHeader.setAlignment(HorizontalAlignment.LEFT);
			
					
					// create style for cells in table contents
					tableContentsOnRight.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
					tableContentsOnRight.setFillPattern(FillPatternType.NO_FILL);
					tableContentsOnRight.setWrapText(false);
					// Set the border style for the workbook
					tableContentsOnRight.setBorderBottom(BorderStyle.THIN);
					tableContentsOnRight.setBorderLeft(BorderStyle.THIN);
					tableContentsOnRight.setBorderRight(BorderStyle.THIN);
					tableContentsOnRight.setBorderTop(BorderStyle.THIN);
					tableContentsOnRight.setAlignment(HorizontalAlignment.RIGHT);
							
					// create style for cells in table contents
					tableContentsOnLeft.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
					tableContentsOnLeft.setFillPattern(FillPatternType.NO_FILL);
			//		tableContentsOnLeft.setWrapText(false);
					// Set the border style for the workbook
					tableContentsOnLeft.setBorderBottom(BorderStyle.THIN);
					tableContentsOnLeft.setBorderLeft(BorderStyle.THIN);
					tableContentsOnLeft.setBorderRight(BorderStyle.THIN);
					tableContentsOnLeft.setBorderTop(BorderStyle.THIN);
					tableContentsOnLeft.setAlignment(HorizontalAlignment.LEFT);
					
					//Create worksheet
					sheet1 = book.createSheet(sheet1Name);
					//Create worksheet for individual test case level details
					sheet = book.createSheet(sheetName);
					XSSFCellStyle hiddenstyle = book.createCellStyle();
					hiddenstyle.setHidden(true);
					row = sheet1.createRow(rowNum++);
					//Header Column Names
					celAppName = row.createCell(0);
					// Merges the cells
					CellRangeAddress cellRangeAddress = new CellRangeAddress(0,0,0,1);
					celAppName.setCellValue("TOIVO – Automated Test Execution Report");
					celAppName.setCellStyle(topHeaderContents);
					sheet1.addMergedRegion(cellRangeAddress);
					
					row = sheet1.createRow(rowNum++);
					celAppName = row.createCell(0);
					celAppName.setCellValue("");
					
					row = sheet1.createRow(rowNum++);
					celTestName = row.createCell(0);
					celTestStatus = row.createCell(1);
					celTestName.setCellValue("Number of Test cases passed");
					celTestStatus.setCellFormula("COUNTIFS('TOIVO TestSuite Report'!D3:D96,\"PASSED\")");
					celTestName.setCellStyle(tableContentsOnLeft);
					celTestStatus.setCellStyle(tableContentsOnRight);
					
					row = sheet1.createRow(rowNum++);
					celTestName = row.createCell(0);
					celTestStatus = row.createCell(1);
					celTestName.setCellValue("Number of Test cases failed");
					celTestStatus.setCellFormula("COUNTIFS('TOIVO TestSuite Report'!D3:D96,\"FAILED\")");
					celTestName.setCellStyle(tableContentsOnLeft);
					celTestStatus.setCellStyle(tableContentsOnRight);
					
					row = sheet1.createRow(rowNum++);
					celTestName = row.createCell(0);
					celTestStatus = row.createCell(1);
					celTestName.setCellValue("Number of Test cases Not Executed");
					celTestStatus.setCellFormula("COUNTIFS('TOIVO TestSuite Report'!D3:D96,\"NOT EXECUTED\")");
					celTestName.setCellStyle(tableContentsOnLeft);
					celTestStatus.setCellStyle(tableContentsOnRight);
					
					row = sheet1.createRow(rowNum++);
					celTestName = row.createCell(0);
					celTestStatus = row.createCell(1);
					celTestName.setCellValue("TOTAL");
					celTestStatus.setCellFormula("SUM(B3:B5)");
					celTestName.setCellStyle(tableContentsOnLeft);
					celTestStatus.setCellStyle(tableContentsOnRight);
					
					sheet1.autoSizeColumn(0);
					
					//TADVV Individual test case level details
					rowNum = 0;
					book.setActiveSheet(1);
					
					row = sheet.createRow(rowNum++);
					celAppName = row.createCell(0);
					celAppName.setCellValue("");
					
					row = sheet.createRow(rowNum++);
					//Header Column Names
					cellRangeAddress = new CellRangeAddress(1,1,0,1);
					celAppName = row.createCell(0);
					celAppName.setCellValue("Test case level execution details");
					celAppName.setCellStyle(topHeaderContents);
					sheet.addMergedRegion(cellRangeAddress);
					
					row = sheet.createRow(rowNum++);
					//Header Column Names
					celEnvName = row.createCell(0);
					celAppName = row.createCell(1);
					celTestName = row.createCell(2);
					celTestStatus = row.createCell(3);
					celExecTime=row.createCell(4);
					celExecStartTime=row.createCell(5);
					celExecEndTime=row.createCell(6);
					celComments = row.createCell(7);
					celJiraUpdateStatus = row.createCell(8);
					celJiraUpdateComments = row.createCell(9);
					
					// Set the Header names for the sheet
					celEnvName.setCellValue("Exec.Environment");
					celAppName.setCellValue("Application Name");
					celEnvName.setCellStyle(tableHeader);
					celAppName.setCellStyle(tableHeader);
					celTestName.setCellValue("Name of the Executed Test Script");
					celTestStatus.setCellValue("Execution Status");
					celExecTime.setCellValue("Execution Time");
					celExecStartTime.setCellValue("Execution Start Time");
					celExecEndTime.setCellValue("Execution End Time");
					celComments.setCellValue("Comments");
					celComments.setCellStyle(tableHeader);
					// set style for the table header
					celTestName.setCellStyle(tableHeader);
					celTestStatus.setCellStyle(tableHeader);
					celExecStartTime.setCellStyle(tableHeader);
					celExecEndTime.setCellStyle(tableHeader);
					celExecTime.setCellStyle(tableHeader);
					celJiraUpdateStatus.setCellValue("Status Updated in Jira?");
					celJiraUpdateStatus.setCellStyle(tableHeader);
					celJiraUpdateComments.setCellValue("Jira Status Update Comments");
					celJiraUpdateComments.setCellStyle(tableHeader);
								
					// Create a split with the lower left side being the active quadrant
					//sheet.createFreezePane( 9, 1 );
					// If you require it to make the entire directory path including parents,use directory.mkdirs(); here instead.
					 File directory = new File(reportFile.getParent());
					    if (! directory.exists()){
					        directory.mkdirs();					        
					    }
					writeXLOutput = new FileOutputStream(ADDRESS_DATASHEET_CONSTANTS.REP_INPUT_FILE);
					book.write(writeXLOutput);
				}catch(Exception e){
					// Conversion into unchecked exception is also allowed
					Reporter.log(" The issue in Excel file creation is "+ e.toString());
					throw new IOException(e);
				}
				finally{
					//Close files when they are no longer needed
					book.close();
					if(writeXLOutput!=null){
						writeXLOutput.close();
					}
				}
				CONSTANTS.setREPORTXLS(new Xls_ReadWrite(ADDRESS_DATASHEET_CONSTANTS.REP_INPUT_FILE));
			
			}
	}
	
}

			
			
			

