package TestNG_practise;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenricUtility.BaseClass;

import objectRepository.createneworgpage;
import objectRepository.homepage;
import objectRepository.organizationpage;

public class Baseclassusestest extends BaseClass {

	@Test(groups="Smoke")
	public void openorg() throws EncryptedDocumentException, IOException {

		String orgn = eutil.getdatafromexcel("org", 1, 2) + jutil.getrandom();

		homepage hp = new homepage(driver);
		hp.getOrganizationlink().click();

		organizationpage op = new organizationpage(driver);
		op.getCreateorgLink().click();

		createneworgpage orgpg = new createneworgpage(driver);
		orgpg.getOrgNametextfield().sendKeys(orgn);

		orgpg.getSavebtn().click();

		String headinfo = orgpg.getHeaderinfo().getText();

		Assert.assertEquals(headinfo.contains(orgn), true, "Header name is not match");
		Reporter.log("Header name is  match", true);

		String saveorgname = orgpg.getOrginfo().getText();

		Assert.assertEquals(saveorgname.contains(orgn), true, "orgname is not match");
		Reporter.log("orgname is match", true);
		
		driver.switchTo().newWindow(WindowType.TAB);
	}
	
	
	

}
