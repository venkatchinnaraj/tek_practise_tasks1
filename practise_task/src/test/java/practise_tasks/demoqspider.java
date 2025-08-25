package practise_tasks;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class demoqspider {
	
	@Test
	void test() throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/browser?sublist=0");
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//button[text()='Shop Now']")).click();
		switchto(driver,"product/1" );
		System.out.println(driver.findElement(By.xpath("//h1[text()='Luxury Watch']")).getText());
		
		switchto(driver,"product/2" );

		System.out.println(driver.findElement(By.xpath("//h1[text()='High-Performance Laptop']")).getText());
		
		switchto(driver,"product/3" );

		System.out.println(driver.findElement(By.xpath("//h1[text()='High-End Mobile Phone']")).getText());
				}

	public static void switchto(WebDriver driver, String expurl) {
		Set<String> allwindowid = driver.getWindowHandles();

		for (String id : allwindowid) {
			driver.switchTo().window(id);
			String acturl = driver.getCurrentUrl();

			if (acturl.contains(expurl)) {
				break;

		}

	// driver.quit();
 
		
		
	}
	}
}
