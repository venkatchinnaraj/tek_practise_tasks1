package DataDriven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class cmdtest {
	@Test
	public void cmd() {
		String BROWSER = System.getProperty("Browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		//crossbrowser 
				WebDriver driver = null;
				System.out.println("B:"+BROWSER+" url:"+URL+" un:"+ USERNAME+" pwd:"+PASSWORD);
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

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.xpath("//td[@class=\"tabUnSelected\"]//a[text()='Organizations']")).click();
        driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		
		
		
	}

}
