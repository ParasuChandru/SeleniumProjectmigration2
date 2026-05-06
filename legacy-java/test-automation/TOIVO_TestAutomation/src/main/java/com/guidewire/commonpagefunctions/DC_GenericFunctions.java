package com.guidewire.commonpagefunctions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.contentstream.operator.text.NextLine;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.guidewire.config.CONSTANTS;
import com.opencsv.CSVWriter;


public class DC_GenericFunctions extends GenericFunctions{

	public DC_GenericFunctions(WebDriver driver, ExtentTest test, ExtentReports extent) {
		super(driver, test, extent);
	}
	
	/**
	 * Function to simulate the curl to the server name with the input xml and get the output file
	 * @param XML_Name - the file name with extension
	 * @param OutPutFile_Name - the output file name with extension
	 * @param options
	 */
	public String curlconnect(String XML_Name, String OutPutFile_Name, String... options) { 
		String[] cURL_command = {CONSTANTS.CURL_EXE_LOCATION+"curl", "-d", "@"+XML_Name, "-X", "POST", CONSTANTS.DOCCREA_SERVER, "-o", OutPutFile_Name};
	    ProcessBuilder process = new ProcessBuilder(cURL_command); 
        Process p;
        try
        {
        p = process.start();
         BufferedReader reader =  new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ( (line = reader.readLine()) != null) {
                    builder.append(line);
                    builder.append(System.getProperty("line.separator"));
            }
            String result = builder.toString();
//            System.out.print(result);

        }
        catch (IOException e)
        {   System.out.print("error");
            e.printStackTrace();
        }
        test.info("DocCrea Server : " + CONSTANTS.DOCCREA_SERVER );
        testpass("The output pdf file '"+OutPutFile_Name+"' is generated using source xml file '"+XML_Name+"'." );
        return OutPutFile_Name;
       }
	
}
