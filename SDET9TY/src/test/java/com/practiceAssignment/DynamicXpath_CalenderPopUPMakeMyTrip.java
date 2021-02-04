package com.practiceAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.JavaUtils;

public class DynamicXpath_CalenderPopUPMakeMyTrip {
	JavaUtils javalib = new JavaUtils();

	@Test
	public void bookTicket() throws InterruptedException
	{

		String date = javalib.getDate();
		String month = javalib.getMonth();
		String year = javalib.getCurrentYear();
		String day = javalib.getDay();
	
	WebDriver driver= new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/");
	  WebDriverWait wait=new WebDriverWait(driver, 20);
	  
	  Actions act = new Actions(driver);
	  act.moveByOffset(10, 10).click().perform();
	  
	/*driver.findElement(By.xpath("//label[@for='fromCity']")).sendKeys("BLR");
	driver.findElement(By.xpath("//ul//li//div[text()='BLR']")).click();
	
	driver.findElement(By.xpath("//label[@for='toCity']")).sendKeys("DEL");
	driver.findElement(By.xpath("//ul//li//div[text()='DEL']")).click();*/
	  
	  driver.findElement(By.xpath("//span[.='From']")).click();
	  driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("JFK");
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[.='JFK']")));
	  driver.findElement(By.xpath("//div[text()='JFK']")).click();
	  
	  
	  driver.findElement(By.xpath("//span[.='To']")).click();
	  driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("MYQ");
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[.='MYQ']")));
	  driver.findElement(By.xpath("//div[text()='MYQ']")).click();
	  
	  driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	  
	//  driver.findElement(By.xpath("//td[@data-month ="+month+" and @data-year='"+year+"']/a[text()='"+date+"']")).click();
	
	  driver.findElement(By.xpath("//div[contains(@aria-label,'"+day+" "+month+" "+date+" "+year+"')]")).click();
	
	driver.close();
	
	
	}
	
	
}
