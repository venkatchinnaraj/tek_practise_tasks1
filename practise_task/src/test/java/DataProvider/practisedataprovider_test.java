package DataProvider;

import java.lang.reflect.Array;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class practisedataprovider_test {
	
	@Test(dataProvider="getdata")
	
	public void testscript (String firstname,String profile,long phn) {
		
		
		//System.out.println(firstname +"firstname"+profile +"lastname"+phn +"phonenumber");
		
	}
	
	
	@DataProvider
	
	public Object[][] getdata() {
		
		Object[][] objarr=new Object[3][3];
	
		
		
		objarr[0][0]="venkat";
		objarr[0][1]="MD";
		objarr[0][2]=8870097787l;
		
		objarr[1][0]="sharvah";
		objarr[1][1]="TL";
		objarr[1][2]=8870097757l;
		
		objarr[2][0]="Adhithya";
		objarr[2][1]="TS";
		objarr[2][2]=8870097777l;
		
		return objarr;
		

		
		
	}
	
	

}
