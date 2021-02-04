package com.practiceAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CalenderPopUpMakeMyTrip {
	
	@Test
	public void bookTicket() {
		

	
		 WebDriver  driver = new FirefoxDriver(); 
		  driver.get("https://www.makemytrip.com/");
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  WebDriverWait wait=new WebDriverWait(driver, 20);
		  
		  Actions act = new Actions(driver);
		  act.moveByOffset(10, 10).click().perform();
		  //driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		  //driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		  
		  driver.findElement(By.xpath("//span[.='From']")).click();
		  driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("JFK");
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[.='JFK']")));
		  driver.findElement(By.xpath("//div[text()='JFK']")).click();
		  
		  
		  driver.findElement(By.xpath("//span[.='To']")).click();
		  driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("MYQ");
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[.='MYQ']")));
		  driver.findElement(By.xpath("//div[text()='MYQ']")).click();
		  
		  driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		  

     int count =0;
     while(count <24) {
		   try {
		     driver.findElement(By.xpath("//div[contains(@aria-label='Sat Dec 25 2021')]")).click();
		     break;
		   }catch (Exception e) {
			   driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click(); 
			   count++;
		  }
}  
     driver.close();
	 
	}}
