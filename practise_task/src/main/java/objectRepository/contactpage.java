package objectRepository;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactpage {
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactlink;
	
	@FindBy(xpath="//img[@alt=\"Create Contact...\"]")	
	private WebElement Createcontactlink;
	
	@FindBy(name="lastname")
	private WebElement Lastnametextfield;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement Savebtn;
	

	@FindBy(id = "mobile")
	private WebElement Mobiletextfield;
	
	public contactpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getCreatecontactlink() {
		return Createcontactlink;
	}

	public WebElement getLastnametextfield() {
		return Lastnametextfield;
	}

	public WebElement getSavebtn() {
		return Savebtn;
	}

	public WebElement getMobiletextfield() {
		return Mobiletextfield;
	}
	
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastnamesavefield;

	public WebElement getLastnamesavefield() {
		return lastnamesavefield;
	}
	
	

}
