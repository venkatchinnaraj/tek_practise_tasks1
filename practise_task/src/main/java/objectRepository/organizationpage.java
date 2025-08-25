package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationpage {
	
	@FindBy(xpath = "//img[@title=\"Create Organization...\"]")
	private WebElement createorgLink;
	
	public organizationpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
	}

	public WebElement getCreateorgLink() {
		return createorgLink;
	}

}
