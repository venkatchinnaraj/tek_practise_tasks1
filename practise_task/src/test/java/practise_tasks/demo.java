package practise_tasks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class demo {
	@Test
	void demo() throws IOException, InterruptedException  {
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
		driver.findElement(By.xpath("(//input[@class=\"button-2 product-box-add-to-cart-button\"])[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@data-productid=\"74\"]/..//input")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@id=\"add-to-cart-button-74\"]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ss/prod.png");
         FileHandler.copy(temp, dest);
}
}
