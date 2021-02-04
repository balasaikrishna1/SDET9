package com.crm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.JavaUtils;

public class DynamicXpath_CalenderPopUP_DataProvider {
JavaUtils javalib = new JavaUtils();
	 
	
	@Test(dataProvider =  "getData")
	public void bookTicket(String srcLocation , String dstLocation) {
		

		String date = javalib.getDate();
		int month = javalib.getMonthInt();
		String year = javalib.getCurrentYear();
		
		 WebDriver driver = new FirefoxDriver(); 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("https://www.cleartrip.com");
		  
		  driver.findElement(By.id("FromTag")).sendKeys(srcLocation);
		  driver.findElement(By.xpath("//a[contains(text(),'"+srcLocation+"')]")).click();
		  
		  driver.findElement(By.id("ToTag")).sendKeys(dstLocation);
		  driver.findElement(By.xpath("//a[contains(text(),'"+dstLocation+"')]")).click();
		  
		  driver.findElement(By.xpath("//td[@data-month ="+month+" and @data-year='"+year+"']/a[text()='"+date+"']")).click();
		  
		  driver.close();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[5][2];
		
		objArr[0][0] = "BLR";
		objArr[0][1] = "GOI";
		
		objArr[1][0] = "BLR";
		objArr[1][1] = "NYC";
		
		
		objArr[2][0] = "BLR";
		objArr[2][1] = "NCL";
		
		
		objArr[3][0] = "BLR";
		objArr[3][1] = "NTL";
		
		objArr[4][0] = "BLR";
		objArr[4][1] = "EWR";
		return objArr;
				
	}
}
