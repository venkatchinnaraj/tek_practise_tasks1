package DataDriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class jdbcnonselect {
	@Test
	public void nonselect() throws SQLException {
		 Driver driverref=new Driver();
	     DriverManager.registerDriver(driverref);
	   Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
	  Statement stat = conn.createStatement();
	int result = stat.executeUpdate("insert into project values ('TY_008','VENKAT','06-08-2025','Avenger_1','ongoing','1'); ");
	System.out.println(result);
	}
	
	
}

