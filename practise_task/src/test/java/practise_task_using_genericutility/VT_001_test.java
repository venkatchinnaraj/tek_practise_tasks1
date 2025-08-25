package practise_task_using_genericutility;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenricUtility.Excelutility;
import GenricUtility.propertieutility;

public class VT_001_test {
	public propertieutility proutil=new propertieutility();
	Excelutility eutil=new Excelutility();
	
	
	@Test(groups="regression")
	
	public void tc1() throws IOException {
		
		String URL = proutil.getdatafromproperty("url");
		String BROWSER = proutil.getdatafromproperty("Browser");
		String USERNAME = proutil.getdatafromproperty("username");
		String PASSWORD = proutil.getdatafromproperty("password");
		
		WebDriver driver=null;
		
		if (BROWSER.equals("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else if(BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();
		
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get(URL);

String orgn = eutil.getdatafromexcel("org", 1, 2);


driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();
driver.findElement(By.xpath("//td[@class=\"tabUnSelected\"]//a[text()='Organizations']")).click();
driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgn);
driver.findElement(RelativeLocator.with(By.xpath("//input[@class=\"crmbutton small save\"]")).below(By.xpath("//td[text()=' Organization Information']"))).click();
String headerinfo = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
if(headerinfo.contains(orgn))
		System.out.println(orgn +"is created ===pass" );
else
	System.out.println(orgn +"is not created ===Fail" );


String orgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
Assert.assertEquals(orgname.equals(orgn), true,"orgname is not match");
Reporter.log("orgname is match",true);


driver.close();
/*
 * WebElement log =
 * driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))
 * ; Actions act=new Actions(driver); act.moveToElement(log);
 * driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
 */
		

		
		
		
	}

}
