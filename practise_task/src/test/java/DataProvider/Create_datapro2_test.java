package DataProvider;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenricUtility.Excelutility;

public class Create_datapro2_test {
	@Test(dataProvider="getdata")
	public void getproductinfo(String productname,String brandname) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.name("q")).sendKeys( brandname,Keys.ENTER);
		String x="//div[contains(text(),'"+productname+"')]/../..//div[@class=\"Nx9bqj _4b5DiR\"]";
		String price=driver.findElement(By.xpath(x)).getText();
		Reporter.log(price,true);
		driver.close();
		}
	
@DataProvider
	
	public Object[][] getdata() throws EncryptedDocumentException, IOException{
	Excelutility eutil=new Excelutility();
	int rowcount = eutil.getrowcount("prod");
	
		Object[][] obj=new Object[rowcount][2];
		
		for(int i=0;i<rowcount;i++) {
			obj[i][0]=eutil.getdatafromexcel("prod", i+1, 0);
			obj[i][1]=eutil.getdatafromexcel("prod", i+1, 1);
			
		}
		
		
		
		return obj;
	}

}
