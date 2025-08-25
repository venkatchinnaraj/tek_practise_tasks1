package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
	
	@FindBy(xpath = "//a[text()='Organizations']")
     private WebElement organizationlink;
	
	
	public homepage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//a[text()='Contacts']")
    private WebElement contactlink;
	
	
	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	
	
}
