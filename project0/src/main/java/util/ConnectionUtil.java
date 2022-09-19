package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection c;
	
	public static Connection getLocalConnection() throws SQLException{
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "";
		
		if (c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
		}
		return c;
	}
	
	
}
