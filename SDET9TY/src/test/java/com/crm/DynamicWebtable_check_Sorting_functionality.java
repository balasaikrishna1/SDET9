package com.crm;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicWebtable_check_Sorting_functionality {
public static void main(String[] args) {
		
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
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a")));
		  
		  
		  //capture all the Organizations name aviable in dynamic webtables & display in console
		  List<WebElement> lst = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		  
		  for(WebElement wb : lst) {
			  if(wb.getText().equals("EDFG Group Limited")) {
				  wb.click();
				  break;
			  }
		  }
		

	}

}
