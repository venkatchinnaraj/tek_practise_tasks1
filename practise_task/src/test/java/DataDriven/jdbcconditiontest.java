package DataDriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class jdbcconditiontest {
	@Test
	public void condition() throws SQLException {
		
		String projectname="Avenger";
		boolean flag=false;
		 Driver driverref=new Driver();
	     DriverManager.registerDriver(driverref);
	   Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
	  Statement stat = conn.createStatement();
	 ResultSet resultset = stat.executeQuery("select * from project");
	 while(resultset.next()) {
		// System.out.println(resultset.getString(1));
		 String actprojectname=resultset.getString(4);
		 if(projectname.equals(actprojectname)) {
			 flag=true;
			 System.out.println(projectname+" is availabel");
		 }
	 }
	     if(flag==false) {
	    	 System.out.println(projectname +"is not availabel");
	    	 Assert.fail();
	     }
	     conn.close();
		
		
	}

	}


