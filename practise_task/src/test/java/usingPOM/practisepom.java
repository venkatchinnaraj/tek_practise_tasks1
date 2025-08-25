package usingPOM;

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
import GenricUtility.javautil;
import GenricUtility.propertieutility;
import objectRepository.Loginpage;
import objectRepository.createneworgpage;
import objectRepository.homepage;
import objectRepository.organizationpage;

public class practisepom {
	public propertieutility proutil=new propertieutility();
	Excelutility eutil=new Excelutility();
	javautil jutil=new javautil();
	
	
	
	
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

String orgn = eutil.getdatafromexcel("org", 1, 2)+jutil.getrandom() ;

Loginpage lp=new Loginpage(driver);
lp.logintoapp(USERNAME, PASSWORD);


homepage hp=new homepage(driver);
 hp.getOrganizationlink().click();

organizationpage op=new organizationpage(driver);
op.getCreateorgLink().click();

createneworgpage orgpg=new createneworgpage(driver);
orgpg.getOrgNametextfield().sendKeys(orgn);

orgpg.getSavebtn().click();

String headinfo = orgpg.getHeaderinfo().getText();

Assert.assertEquals(headinfo.contains(orgn),true, "Header name is not match");
Reporter.log("Header name is  match",true);


String saveorgname = orgpg.getOrginfo().getText();


Assert.assertEquals(saveorgname.contains(orgn), true,"orgname is not match");
Reporter.log("orgname is match",true);


driver.close();


		
		
		
	}

}
