package Database;

import java.sql.*;

public class ConnectionDB {	
	Connection conn = null;
	String url = "jdbc:sqlite:C:\\Users\\�����\\Documents\\GitHub\\Web-app\\Design_Studio.db";
	
	public Connection dbConnector() throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(url);
			return conn;
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("���� ������ �� ���� ����������!");
			return null;
		}
	}
}