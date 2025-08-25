package practise_tasks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class automationpractise {
	
	@Test
	void practise() {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://testautomationpractice.blogspot.com/");
		 WebElement scroll=driver.findElement(By.xpath("//h2[text()='Slider']"));
		Actions act=new Actions(driver);
		act.moveToElement(scroll).perform();
		WebElement drag=driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement drop=driver.findElement(By.id("droppable"));
		act.dragAndDrop(drag, drop).perform();
		driver.findElement(By.xpath("//form//input[@type='file' and @id='singleFileInput' ]")).sendKeys("C:\\Users\\Admin\\OneDrive\\Desktop\\invoice-38978.pdf");
		 driver.findElement(By.xpath("//input[@id=\"comboBox\"]")).click();
		String op =  driver.findElement(By.xpath("//div[text()='Item 3']")).getText();
		Reporter.log(op,true);
		
	}

}
