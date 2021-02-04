import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.genericlib.WebDriverUtils;

	/**
	 * 
	 * @author baaluu
	 *
	 */
public class Contact {

		JavaUtils javalib = new JavaUtils();
		WebDriverUtils wLib = new WebDriverUtils();
		 
	@Test
	public void CreateContactWithOrgText() throws InterruptedException {
		/* common data */
	int RandomNumber = javalib.generateRandomNum();
	String username = "admin";
	String password="manager";
	String url="http://localhost:8888/";
	String browser="firefox";

	/* test data*/

	String OrgName="Qspiders"+RandomNumber;
	String OrgType="Partner";
	String OrgIndustry="Banking";
	String OrgRating = "Active";
	String ContactLastName="krishna"+RandomNumber;



	/* step 1 : login to APP */
	WebDriver driver = new ChromeDriver();
	wLib.waitForHTMLDOM(driver);
	driver.get(url);

	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();

	/* step 2 : navigate to Organization page */
	driver.findElement(By.linkText("Organizations")).click();

	/* step 3 : navigate ot create Org Page */
	wLib.waitforElementToBeClickable(driver, driver.findElement(By.xpath("//img[@alt='Create Organization...']")));
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

	/* step 4 : create new Organization with inductry & type, rating */
	driver.findElement(By.name("accountname")).sendKeys(OrgName);
	wLib.select(driver.findElement(By.name("industry")), OrgIndustry);
	wLib.select(driver.findElement(By.name("accounttype")), OrgType);
	wLib.select(driver.findElement(By.name("rating")), OrgRating);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	/* step 5 : verify the ORganization name */
	String actOrgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	boolean actStatus = actOrgName.contains(OrgName);
	// Assert.assertEquals(actStatus, true);
	Assert.assertTrue(actStatus);

	/* step 6 : navigate to Contact page */
	driver.findElement(By.linkText("Contacts")).click();

	/* step 7 : creat new Contact */
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	Thread.sleep(20000);
	/* step 7 : create new contact with above Organization */
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
	  
	 /* step 9 : logout & close */
	 wLib.moveToExpectedElemnet(driver,
	  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
	  driver.findElement(By.linkText("Sign Out")).click(); driver.close();
	 

	}
	}

