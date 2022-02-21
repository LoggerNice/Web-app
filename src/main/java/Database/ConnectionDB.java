package Database;

import java.sql.*;

public class ConnectionDB {	
	Connection conn = null;
	String url = "jdbc:sqlite:C:\\Users\\Вадим\\Documents\\GitHub\\Web-app\\Design_Studio.db";
	
	public Connection dbConnector() throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(url);
			return conn;
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("База данных не была подключена!");
			return null;
		}
	}
}