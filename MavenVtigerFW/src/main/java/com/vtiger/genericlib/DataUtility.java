package com.vtiger.genericlib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {
	
	 public String  getDataFromProperties(String Key) throws IOException
	 {
		 String propertiespath="./src/test/resources/commondata.properties";
		 
		 FileInputStream fis= new FileInputStream(propertiespath);
		 Properties p= new Properties();
		 p.load(fis);
		 String value= p.getProperty(Key);
		 return value;
		 
	 }
	 public String  getDataFromExcel(String sheetName, int rownum,int cellnum) throws EncryptedDocumentException, IOException
	 {
		 String excelpath="./src/test/resources/TestData.xlsx";
		 FileInputStream fis1= new FileInputStream(excelpath);
			Workbook w= WorkbookFactory.create(fis1);
			String value=w.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
			return value;
		
	 }

}
