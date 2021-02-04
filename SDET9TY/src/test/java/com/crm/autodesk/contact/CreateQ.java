package com.crm.autodesk.contact;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.FileUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.genericlib.WebDriverUtils;

/**
 * 
 * @author baaluu
 *
 */
public class CreateQ {
	FileUtility fillib=new FileUtility();
	JavaUtils javalib = new JavaUtils();
	WebDriverUtils wLib = new WebDriverUtils();
	 
@Test
public void CreateContactWithOrgText() throws InterruptedException, IOException {
	
int RandomNumber = javalib.generateRandomNum();


/* test data*/

String OrgName="Qspiders"+RandomNumber;
String OrgType="Partner";
String OrgIndustry="Banking";
String OrgRating = "Active";
String ContactLastName="krishna"+RandomNumber;

String SubjectName="TestYantraSS"+RandomNumber;

String ProductName= "Yulu1"+RandomNumber;
/* login to APP */
WebDriver driver = new ChromeDriver();
wLib.waitForHTMLDOM(driver);
driver.get(fillib.getPropertyValue("url"));
driver.findElement(By.name("user_name")).sendKeys(fillib.getPropertyValue("username"));
driver.findElement(By.name("user_password")).sendKeys(fillib.getPropertyValue("password"));
driver.findElement(By.id("submitButton")).click();
/* navigate to Organization page */
driver.findElement(By.linkText("Organizations")).click();

/* navigate ot create Org Page */
wLib.waitforElementToBeClickable(driver, driver.findElement(By.xpath("//img[@alt='Create Organization...']")));
driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

/* create new Organization with inductry & type, rating */
driver.findElement(By.name("accountname")).sendKeys(OrgName);
wLib.select(driver.findElement(By.name("industry")), OrgIndustry);
wLib.select(driver.findElement(By.name("accounttype")), OrgType);
wLib.select(driver.findElement(By.name("rating")), OrgRating);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

/*verify the ORganization name */
String actOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
boolean actStatus = actOrgName.contains(OrgName);
// Assert.assertEquals(actStatus, true);
Assert.assertTrue(actStatus);

/* navigate to Contact page */
driver.findElement(By.linkText("Contacts")).click();

/* creat new Contact */
driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

/* create new contact with above Organization */
driver.findElement(By.name("lastname")).sendKeys(ContactLastName);
driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
Set<String> set = driver.getWindowHandles();
 Iterator<String> it = set.iterator();
 String paretntID = it.next();
 String chilID = it.next();

 System.out.println(paretntID);
 System.out.println(chilID);
  /* swicth to child Window */
  wLib.swicthToWindow(driver, "Account&action");
  
  wLib.waitforElementToBeClickable(driver,
  driver.findElement(By.id("search_txt")));
  driver.findElement(By.id("search_txt")).sendKeys(OrgName);
  driver.findElement(By.name("search")).click();
  driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
 
   /* SWicth Back to Parent Window */
   wLib.swicthToWindow(driver, "Contacts");
   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

 /* step 8 : verify */
   String actConatName =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
  boolean status = actConatName.contains(ContactLastName);
  Assert.assertTrue(actStatus);
  
  /* navigate to product page */

	driver.findElement(By.linkText("Products")).click();

	/* create new product */

	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

	/* create new Product with product name */

	driver.findElement(By.name("productname")).sendKeys(ProductName);

	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
  
  /*  navigate to more page */
  driver.findElement(By.xpath("//a[.='More']")).click();

  /* navigate to Quotes*/
  	driver.findElement(By.name("Quotes")).click();

  	/* Click on Create Quote*/
  driver.findElement(By.xpath("//img[@alt='Create Quote...']")).click();
/* Enter subject*/
  driver.findElement(By.name("subject")).sendKeys(SubjectName);
  /* Enter contact*/
 driver.findElement(By.name("contact_name"));
  driver.findElement(By.xpath("//input[@name='contact_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
  Set<String> set1 = driver.getWindowHandles();
  Iterator<String> it1 = set1.iterator();
  String paretntID1 = it1.next();
  String chilID1 = it1.next();

  System.out.println(paretntID1);
  System.out.println(chilID1);
  /*  swicth to child Window */
   wLib.swicthToWindow(driver, "Contacts&action");
   
   wLib.waitforElementToBeClickable(driver,
   driver.findElement(By.id("search_txt")));
   driver.findElement(By.id("search_txt")).sendKeys(ContactLastName);
   driver.findElement(By.name("search")).click();
   Thread.sleep(2000);
   driver.findElement(By.xpath("//a[contains(text()='"+ContactLastName+"')]")).click();
   Alert alert1= driver.switchTo().alert();
   alert1.dismiss();
  

  /* SWicth Back to Parent Window */
    wLib.swicthToWindow(driver, "Quotes");
    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

    /*  verify */
    String QConatName =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
   boolean Qstatus = QConatName.contains(ContactLastName);
   Assert.assertTrue(Qstatus);
   
   
   
   
   
   
   
   
   
   
   
   driver.findElement(By.name("account_name"));
   driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
   
   Set<String> set2 = driver.getWindowHandles();
 Iterator<String> it2 = set2.iterator();
 String paretntID2 = it2.next();
 String chilID2 = it2.next();

   
 System.out.println(paretntID2);
 System.out.println(chilID2);
  /* swicth to child Window */
  wLib.swicthToWindow(driver, "Accounts&action");
  
 wLib.waitforElementToBeClickable(driver,
  driver.findElement(By.id("search_txt")));
  driver.findElement(By.id("search_txt")).sendKeys(OrgName);
  driver.findElement(By.name("search")).click();
  driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
  driver.close();

   /* SWicth Back to Parent Window */
  wLib.swicthToWindow(driver, "Quotes");
  
  
   driver.findElement(By.name("bill_street")).sendKeys("BTM, BANGLORE");
   
   driver.findElement(By.name("ship_street")).sendKeys("Basavanagudi, BAnglore");
   
   driver.findElement(By.name("productName1"));
   driver.findElement(By.xpath("//input[@name='productName1']/following-sibling::img[@src='themes/images/products.gif']")).click();
   
   Set<String> set3 = driver.getWindowHandles();
   Iterator<String> it3 = set3.iterator();
   String paretntID3 = it3.next();
   String chilID3 = it3.next();

     
   System.out.println(paretntID3);
   System.out.println(chilID3);
    /* swicth to child Window */
    wLib.swicthToWindow(driver, "Products&action");
    
   wLib.waitforElementToBeClickable(driver,
    driver.findElement(By.id("search_txt")));
    driver.findElement(By.id("search_txt")).sendKeys(ProductName);
    driver.findElement(By.name("search")).click();
    driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
    driver.close();
   
   driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]"));
 }


  }