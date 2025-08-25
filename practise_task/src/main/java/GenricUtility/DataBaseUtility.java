package GenricUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
Connection conn;
	
	public void getDBconnectionDemoOne(String url,String username,String password) {
		
	
	try {
		Class.forName("com.mysql.ci.jdbc.Driver");
		conn=DriverManager.getConnection(url, username, password);
		Statement statement=conn.createStatement();
		statement.execute("");
		conn.close();
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
				
	}
	public void getDBconnection(String url,String username,String password) throws SQLException {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection(url,username, password);
		}
		catch(Exception e) {}
		
	}
		
		public void closeDbconn() throws SQLException {
			conn.close();
			
		}
		
		
		public ResultSet executeSelectquery(String query) {
			ResultSet result=null;
			try {
				Statement stat = conn.createStatement();
				 result=stat.executeQuery(query);
			}
			catch(Exception e) {
				
			}
			return result;
		}
		
		public int executenonselectquery(String query) {
			int result=0;
			try {
				Statement stat = conn.createStatement();
				result=stat.executeUpdate(query);
			}
			catch(Exception e) {
				
			}
			
			return result;
			
		}
		
		
	}
	
	

