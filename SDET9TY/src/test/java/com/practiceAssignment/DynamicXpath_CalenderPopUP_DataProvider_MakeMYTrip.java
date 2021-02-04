package com.practiceAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.JavaUtils;

public class DynamicXpath_CalenderPopUP_DataProvider_MakeMYTrip {
JavaUtils javalib = new JavaUtils();
	 
	
	@Test(dataProvider =  "getData")
	public void bookTicket(String srcLocation , String dstLocation) {
		

		String date = javalib.getDate();
		String month = javalib.getMonth();
		String year = javalib.getCurrentYear();
		String day = javalib.getDay();
		
		 WebDriver driver = new FirefoxDriver(); 
		  driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get("https://www.makemytrip.com/");
			  WebDriverWait wait=new WebDriverWait(driver, 20);
			  
			  Actions act = new Actions(driver);
			  act.moveByOffset(10, 10).click().perform();
			  
			  
			  
			  
			  driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
			  
			  driver.findElement(By.xpath("//div[contains(@aria-label,'"+day+" "+month+" "+date+" "+year+"')]")).click();
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
