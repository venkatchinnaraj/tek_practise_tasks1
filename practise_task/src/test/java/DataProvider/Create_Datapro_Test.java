package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Create_Datapro_Test{
	
	@Test(dataProvider="getdata")
	public void demo_test(String name, String profile) {
		System.out.println("Name "+name +"== Profile "+profile);
		
	}
	@DataProvider
	
	public Object[][] getdata(){
		Object[][] obj=new Object[3][2];
		obj[0][0]="venkat";
		obj[0][1]="hd";
		
		obj[1][0]="sharvah";
		obj[1][1]="TL";
		
		obj[2][0]="sam";
		obj[2][1]="hr";
		
		
		return obj;
	}

}
