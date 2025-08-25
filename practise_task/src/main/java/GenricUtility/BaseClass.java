package GenricUtility;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import objectRepository.Loginpage;

public class BaseClass {
	public  WebDriver driver;
	public static WebDriver sdriver;
	
	public DataBaseUtility db=new DataBaseUtility();
	public	Excelutility eutil=new Excelutility();
	public javautil jutil=new javautil();
	public	propertieutility putil=new propertieutility();
	public	WebdriverUtility wutil=new WebdriverUtility();
	public Loginpage lp;
	
	
	
	
	
	@BeforeSuite
	public void DBconn() throws SQLException {
		db.getDBconnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root@%", "root");
		System.out.println("DataBase Connected");
		
	}
	@BeforeTest
	public void object() {
		System.out.println("Before test Executed");
		
	}
	//@Parameters("BROWSER")
	@BeforeClass
	public void openbrowser() throws IOException {
		String URL = putil.getdatafromproperty("url");
		
	//	String BROWSER=browser;
		
		
		
		String BROWSER =  putil.getdatafromproperty("Browser");
		
		
		
		
		if (BROWSER.equals("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else if(BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();
		
		sdriver=driver;
		
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get(URL);
		
       
	}
	
	@BeforeMethod
	public void login() throws EncryptedDocumentException, IOException {
		String USERNAME = putil.getdatafromproperty("username");
		System.out.println(USERNAME);
		String PASSWORD = putil.getdatafromproperty("password");
		System.out.println(PASSWORD);
		 lp=new Loginpage(driver);
	     lp.logintoapp(USERNAME, PASSWORD);
		
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("logout done");
	}
	
	
	@AfterClass
	public void closebrowser() {
		System.out.println("After class Executed");
		//driver.quit();
		
	}
	
	
	
	@AfterTest
	public void objectClose() {
		System.out.println("After Test Executed");
	}
	
	
	@AfterSuite
	public void Dbclode() throws SQLException {
		
		db.closeDbconn();
		System.out.println("DataBase Closed");
		System.out.println("Report Backup Done");
	}
	
	
	
	
	

}
