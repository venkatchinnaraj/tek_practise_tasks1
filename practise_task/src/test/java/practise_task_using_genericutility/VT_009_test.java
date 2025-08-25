package practise_task_using_genericutility;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenricUtility.Excelutility;
import GenricUtility.propertieutility;

public class VT_009_test {
	public propertieutility proutil=new propertieutility();
	Excelutility eutil=new Excelutility();
	
	
	@Test
	
	public void tc9() throws IOException {
		
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
Random random=new Random();
int randint = random.nextInt(1000);

String orgn = eutil.getdatafromexcel("org", 1, 2) +randint;
String Lname = eutil.getdatafromexcel("org", 1, 7) ;


driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();

driver.findElement(By.xpath("//td[@class=\"tabUnSelected\"]//a[text()='Organizations']")).click();
driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgn);
driver.findElement(RelativeLocator.with(By.xpath("//input[@class=\"crmbutton small save\"]")).below(By.xpath("//td[text()=' Organization Information']"))).click();
String headerinfo = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();

Assert.assertEquals(headerinfo.contains(orgn), true,"orgname is not match");
Reporter.log(orgn+" orgname is match",true);


driver.findElement(By.xpath("//a[text()='Contacts']")).click();
driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
driver.findElement(By.name("lastname")).sendKeys(Lname);
driver.findElement(By.xpath("//input[@name=\"account_id\"]/following-sibling::img")).click();
Set<String> allid = driver.getWindowHandles();
for(String id:allid) {
	driver.switchTo().window(id);
	String url = driver.getCurrentUrl();
	if(url.contains("module=Accounts"))
		break;
}

driver.findElement(By.id("search_txt")).sendKeys(orgn);
driver.findElement(By.name("search")).click();
driver.findElement(By.xpath("//a[text()='"+orgn+"']")).click();
for(String id:allid) {
	driver.switchTo().window(id);
	String url = driver.getCurrentUrl();
	if(url.contains("Contacts&action"))
		break;
}

driver.findElement(RelativeLocator.with(By.xpath("//input[@class=\"crmbutton small save\"]")).below(By.xpath("//td[@class=\"dvtSelectedCell\"]"))).click();


driver.quit();

}
}