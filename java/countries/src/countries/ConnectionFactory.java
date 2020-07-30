package countries;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String URL = "jdbc:mysql://localhost:3306/world";
	private static final String USER = "root";
	private static final String PW = "admin";
	
	public static Connection connect() {
		try {
			return DriverManager.getConnection(URL, USER, PW);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
