package practise_task_using_genericutility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

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

public class VT_008_test {
	public propertieutility proutil=new propertieutility();
	Excelutility eutil=new Excelutility();
	
	
	@Test(groups="Smoke")
	
	public void tc8() throws IOException {
		
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

String Lname = eutil.getdatafromexcel("org", 1, 7) ;


driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();
driver.findElement(By.xpath("//a[text()='Contacts']")).click();
driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();

Date dateobj=new Date() ;

SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
String startdate = sim.format(dateobj);

Calendar cal = sim.getCalendar();
cal.add(Calendar.DAY_OF_MONTH,30);
String enddate = sim.format(cal.getTime());
	
driver.findElement(By.name("lastname")).sendKeys(Lname);
driver.findElement(By.name("support_start_date")).clear();
driver.findElement(By.name("support_start_date")).sendKeys(startdate);

driver.findElement(By.name("support_end_date")).clear();
driver.findElement(By.name("support_end_date")).sendKeys(enddate);
driver.findElement(RelativeLocator.with(By.xpath("//input[@class=\"crmbutton small save\"]")).below(By.xpath("//td[@class=\"dvtSelectedCell\"]"))).click();

String Sdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
String Edate = driver.findElement(By.id("dtlview_Support End Date")).getText();

Assert.assertEquals(Sdate.equals(startdate), true," Startdate is not match");
Reporter.log(startdate+" Startdate is match",true);

Assert.assertEquals(Edate.equals(enddate), true,"EndDate is not match");
Reporter.log(enddate+" EndDate is match",true);

driver.close();

}
}
