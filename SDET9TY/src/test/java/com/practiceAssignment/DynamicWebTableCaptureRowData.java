package com.practiceAssignment;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicWebTableCaptureRowData {
public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the organization record to be printed : ");
		String str =sc.nextLine();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MICROSECONDS);
		
		driver.get("http://localhost:8888");
	
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();

	
		driver.findElement(By.linkText("Organizations")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']")));

		
		List<WebElement> lst = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		int count=0;


		for(WebElement wb : lst) {
			count++;
		
			if(wb.getText().equalsIgnoreCase(str)) {
				count++;
			 List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr["+count+"]/td[*]"));
				
			 for(WebElement data:list) {
				 System.out.println(data.getText());
			 }
				
				
			}
		
		}
		
		//driver.close();

	}
}
