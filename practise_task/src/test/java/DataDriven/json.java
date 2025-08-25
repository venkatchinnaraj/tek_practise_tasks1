package DataDriven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class json {
	@Test
	public void js() throws FileNotFoundException, IOException, ParseException
	{
		//step1:  parse json physical file in to java object using JSONParser class
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(new FileReader("./src/test/resources/testdata/common.json"));
		//step2:Convert java object in to JSONObject using down casting
		JSONObject map=(JSONObject)obj;
		//get the value from json using key
		String BROWSER = map.get("Browser").toString();
		String URL = map.get("url").toString();
		String USERNAME = map.get("username").toString();
		String PASSWORD = map.get("password").toString();
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
			driver=new ChromeDriver();
		else if(BROWSER.equals("edge"))
			driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();
		
		
		
	}
}
