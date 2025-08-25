package practise_tasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class clinique {
	@Test
	void skincare() {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.clinique.in/");
	WebElement skincare = driver.findElement(By.xpath("(//div[@class=\"gnav-desktop-nav-item\"])[4]"));
	Actions act=new Actions(driver);
	act.moveToElement(skincare).perform();
		
}
}
