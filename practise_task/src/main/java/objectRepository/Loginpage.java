package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	
	@FindAll({@FindBy(xpath = "//input[@type='text']"),@FindBy(name = "user_name")})
     private WebElement usrlink;
	
	
	public Loginpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(name = "user_password")
	private WebElement passwordlink;
	
	@FindBy(id = "submitButton")
	private WebElement submitbtn;
	
	public void logintoapp(String USERNAME, String PASSWORD ) {
		usrlink.sendKeys(USERNAME);
		passwordlink.sendKeys(PASSWORD);
		submitbtn.click();
		
	}

	public WebElement getUsrlink() {
		return usrlink;
	}

	public WebElement getPasswordlink() {
		return passwordlink;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	
	
	
}