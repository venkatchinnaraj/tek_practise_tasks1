package practise_tasks;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ninzaHRM {
	@Test
	void hrm() {
		final Map<String, Object> chromePrefs = new HashMap();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver =new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8091/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("fire_");
		//driver.findElement(By.name("teamSize")).sendKeys("8");
		driver.findElement(By.name("createdBy")).sendKeys("venkat");
		WebElement status = driver.findElement(By.xpath("(//div[@class=\"form-group\"]/following-sibling::div/select)[2]"));
		Select st=new Select(status);
		st.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@value=\"Add Project\"]")).click();
		
		
	}

}
