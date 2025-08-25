package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createneworgpage {

	@FindBy(name = "accountname")
	private WebElement orgNametextfield;
	
	public createneworgpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebtn;

	public WebElement getOrgNametextfield() {
		return orgNametextfield;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement headerinfo;
	
	public WebElement getHeaderinfo() {
		return headerinfo;
	}

	

	public WebElement getOrginfo() {
		return orginfo;
	}

	

	@FindBy(id = "dtlview_Organization Name")
	private WebElement orginfo;
	
	
}
