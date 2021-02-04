package com.crm.autodesk.contact;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.FileUtility;
import com.crm.autodesk.genericlib.WebDriverUtils;

@Listeners(ExtentReport.ItestListenerIMP.class)
public class CreateLead {

	FileUtility fillib=new FileUtility();
	WebDriverUtils wLib=new WebDriverUtils();
	 
@Test
public void createLeadTest() throws IOException, EncryptedDocumentException, InvalidFormatException {
	
	/* step 1 : login to APP */
	WebDriver driver = new ChromeDriver();
	wLib.waitForHTMLDOM(driver);
	driver.get(fillib.getPropertyValue("url"));

	driver.findElement(By.name("user_name")).sendKeys(fillib.getPropertyValue("username"));
	driver.findElement(By.name("user_password")).sendKeys(fillib.getPropertyValue("password"));
	driver.findElement(By.id("submitButton")).click();
	
	/* navigate to Lead page*/
	driver.findElement(By.xpath("//a[.='Leads']")).click();
	
	driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
	driver.findElement(By.name("lastname")).sendKeys(fillib.getExcelValue("LeadDetails", 1, 0));
	driver.findElement(By.name("company")).sendKeys(fillib.getExcelValue("LeadDetails", 1, 1));
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
	
	driver.close();
}
}
