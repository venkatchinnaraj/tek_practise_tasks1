package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class excel {
	@Test
	public void xlsx() throws IOException {

		//to read data in propertie file
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata/commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("url");
		String Username = prop.getProperty("username");
		String Password = prop.getProperty("password");
		
		//crossbrowser 
		WebDriver driver = null;
		System.out.println("B:"+BROWSER+" url:"+URL+" un:"+Username+" pwd:"+Password);
		if (BROWSER.equals("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else if(BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();
		
		//to read data in Excel file
		FileInputStream Fis = new FileInputStream("./src/test/resources/testdata/tek.xlsx");
		Workbook wb=WorkbookFactory.create(Fis);
		Sheet sh = wb.getSheet("products");
		Row row = sh.getRow(1);
		String org = row.getCell(2).toString();
		
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
        driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.xpath("//td[@class=\"tabUnSelected\"]//a[text()='Organizations']")).click();
        driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(org);
        
        
		
	}

}
