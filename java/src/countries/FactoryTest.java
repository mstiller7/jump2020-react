package countries;

import com.mysql.jdbc.Driver;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;


public class FactoryTest {
	
	
	public static final String URL = "jdbc:mysql:/empdb";
	
	public static final String USER = "root";
	
	public static final String PASS = "root";
	
	
	public static Connection getConnection()
	
	{
		
		try {
			
			DriverManager.registerDriver(new Driver());
			
			return DriverManager.getConnection(URL, USER, PASS);
			
		} catch (SQLException ex) {
			
			throw new RuntimeException("Error connecting to the database", ex);
			
		}
		
	}
	
}