package DataDriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class jdbcselectTest {
	@Test
	public void jdbc() throws SQLException {
    
		Connection conn=null;
		
     try{
    	 Driver driverref=new Driver();
     DriverManager.registerDriver(driverref);
   conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root@%", "root");
  Statement stat = conn.createStatement();
 ResultSet resultset = stat.executeQuery("select * from project");
 while(resultset.next()) {
	 System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3));
 }
     }
     catch(Exception e) {
    	 System.out.println("Exception handeled");
    	 }
     finally {
    	 System.out.println("========Data Base closed=========");
     conn.close();
     }
	}
	

}
