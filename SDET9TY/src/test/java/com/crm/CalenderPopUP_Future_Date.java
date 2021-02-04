package com.crm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.JavaUtils;

public class CalenderPopUP_Future_Date {
JavaUtils javalib = new JavaUtils();
	 
	
	@Test
	public void bookTicket() {
		

	
		 WebDriver  driver = new FirefoxDriver(); 
		  driver.get("https://www.cleartrip.com");

		  driver.findElement(By.id("DepartDate")).click();
		  
	

     int count =0;
		  
      while(count <24) {
			   try {
			     driver.findElement(By.xpath("//td[@data-month ='1' and @data-year='2021']/a[text()='24']")).click();
			     break;
			   }catch (Exception e) {
				   driver.findElement(By.xpath("//a[@class='nextMonth ' and @title='Next']")).click(); 
				   count++;
			  }
      }  
		 
		
	}
	

}
