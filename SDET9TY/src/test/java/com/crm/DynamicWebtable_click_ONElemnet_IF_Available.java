package com.crm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicWebtable_click_ONElemnet_IF_Available {
public static void main(String[] args) throws InterruptedException {
		
		ArrayList<String> lst1 = new ArrayList<String>();
		ArrayList<String> lst2 = new ArrayList<String>();
		
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MICROSECONDS);
		
		driver.get("http://localhost:8888");
          //login
		  driver.findElement(By.name("user_name")).sendKeys("admin");
		  driver.findElement(By.name("user_password")).sendKeys("admin");
		  driver.findElement(By.id("submitButton")).click();
		  
		  //navigate to Organizations Page
		  driver.findElement(By.linkText("Organizations")).click();
		  
		  WebDriverWait wait = new WebDriverWait(driver, 20);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']")));
		  
		  
		  //capture all the Organizations name aviable in dynamic webtables & display in console
		  List<WebElement> l1 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
		  
		  for(WebElement wb : l1) {
			  lst1.add(wb.getText().toLowerCase());
		  }
		
		  Collections.sort(lst1);
		  
		  //click Sort link in application
		  driver.findElement(By.linkText("Organization Name")).click();
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='themes/images/arrow_down.gif']")));

		  //capture all the Organizations name aviable in dynamic webtables & after sort
		  List<WebElement> l2 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
		  
		  for(WebElement wb : l2) {
			  lst2.add(wb.getText().toLowerCase());
		  }
		  
		 Assert.assertEquals(lst1, lst2);
		 
         
	}

}
