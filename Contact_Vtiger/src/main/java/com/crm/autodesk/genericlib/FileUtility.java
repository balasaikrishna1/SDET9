package com.crm.autodesk.genericlib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author baaluu
 *
 */
public class FileUtility {
	/**
	 *    used to get data from property file based on key
	 * @param key
	 * @return value
	 * @throws IOException
	 */

	
	public  String getPropertyValue(String key) throws IOException {
		 FileInputStream fis=new FileInputStream("./VtigerCommonData.property");
		 Properties p=new Properties();
		 p.load(fis);
		 String value = p.getProperty(key);
		 return value;
		 }
	public String getExcelValue(String sheetname,int rownum,int cellnum) throws IOException, EncryptedDocumentException, InvalidFormatException{
		 FileInputStream fis=new FileInputStream("./Vtiger.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		 String value = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
		 return value;
		 }

}
