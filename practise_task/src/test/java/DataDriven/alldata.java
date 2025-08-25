package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class alldata {
	@Test
	public void data() throws EncryptedDocumentException, IOException {

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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		//driver.get(URL);
		
		
		

		
		//to read data in Excel file
				FileInputStream Fis = new FileInputStream("./src/test/resources/testdata/tek.xlsx");
				Workbook wb=WorkbookFactory.create(Fis);
				Sheet sh = wb.getSheet("products");
				int rownum = sh.getLastRowNum();
				
				for(int i=0;i<=rownum;i++) {
					Row row = sh.getRow(i);
					String data1 = row.getCell(0).toString();
					String data2 = row.getCell(3).toString();
					System.out.println(data1+"\t"+data2);
				}
           wb.close();
	}

}
