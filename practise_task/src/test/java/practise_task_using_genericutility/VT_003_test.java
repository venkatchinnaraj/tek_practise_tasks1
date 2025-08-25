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
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import GenricUtility.Excelutility;
import GenricUtility.propertieutility;

public class VT_003_test {
	public propertieutility proutil=new propertieutility();
	Excelutility eutil=new Excelutility();
	
	
	@Test(groups="regression")
	
	public void tc3() throws IOException {
		
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
String industy=eutil.getdatafromexcel("org", 1, 3);
String typee=eutil.getdatafromexcel("org", 1, 4);


driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();
driver.findElement(By.xpath("//td[@class=\"tabUnSelected\"]//a[text()='Organizations']")).click();
driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgn);
WebElement industry = driver.findElement(By.name("industry"));
Select st=new Select(industry);
st.selectByContainsVisibleText(industy);
WebElement type = driver.findElement(By.name("accounttype"));
Select stt=new Select(type);
stt.selectByContainsVisibleText(typee);
driver.findElement(RelativeLocator.with(By.xpath("//input[@class=\"crmbutton small save\"]")).below(By.xpath("//td[text()=' Organization Information']"))).click();


String indus = driver.findElement(By.id("dtlview_Industry")).getText();
if(indus.equals(industy))
		System.out.println(industy +" is created ===pass" );
else
	System.out.println(industy +"is not created ===Fail" );

String ty = driver.findElement(By.id("dtlview_Type")).getText();
if(ty.equals(typee))
	System.out.println(typee +" is created ===pass" );
else
System.out.println(typee +"is not created ===Fail" );

	}
	

}
