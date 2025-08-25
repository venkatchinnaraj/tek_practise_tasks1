package TestNG_practise;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenricUtility.BaseClass;
import objectRepository.contactpage;
import objectRepository.homepage;

public class demotest extends BaseClass {
@Test(groups = "regression")
	
	public void contactlastnametest() throws EncryptedDocumentException, IOException  {
		
			
			


	String Lname = eutil.getdatafromexcel("org", 1, 7) ;

	homepage hp = new homepage(driver);
	hp.getContactlink().click();
	
	
	contactpage cp=new contactpage(driver);
	cp.getCreatecontactlink().click();
	
	cp.getLastnametextfield().sendKeys(Lname);
	
	cp.getSavebtn().click();
	
	
	String lastname = cp.getLastnamesavefield().getText();

	Assert.assertEquals(lastname.equals(Lname), true,"Lastname is not match");
	Reporter.log("Lastname is match",true);

	

	}

}
