package practise_tasks;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Durations;

public class demoweb {
	
	@Test
	void demo() throws InterruptedException {
		final Map<String, Object> chromePrefs = new HashMap();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver =new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.xpath("//input[@id=\"Email\" ]")).sendKeys("abhis1234@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("abhis@1234");
		driver.findElement(By.xpath("//input[@class=\"button-1 login-button\"]")).click();
		
		driver.findElement(By.xpath("(//input[@class=\"button-2 product-box-add-to-cart-button\"])[1]")).click();
		
		/*
		 * WebElement ele =
		 * driver.findElement(By.xpath("//input[@class=\"recipient-name valid\"]"));
		 * ele.sendKeys("abhi"); WebDriverWait wait=new WebDriverWait(driver,
		 * Duration.ofSeconds(15));
		 * wait.until(ExpectedConditions.elementToBeSelected(ele));
		 */
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@class=\"recipient-name valid\"]"));
		driver.findElement(By.xpath("//input[@class=\"recipient-email valid\"]")).sendKeys("abhis1234@gmail.com");
	}

}
