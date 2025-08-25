package practise_tasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class cliniquex {
	@Test
	void xpath() {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.clinique.in/");
		
		driver.findElement(By.xpath("//*[local-name()='svg' and @class=\"ufc-cart-icon-svg\"]")).click();
	}
}
