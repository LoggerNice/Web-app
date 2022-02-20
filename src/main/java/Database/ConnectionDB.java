package Database;

import java.sql.*;

public class ConnectionDB {	
	String url = "jdbc:mysql://localhost:3306/design_studio";
	String user = "root";
	String password = "1";
	
	Connection con;

	public ConnectionDB() throws ClassNotFoundException {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
        	throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

	public Connection getConnection() {
		return con;
	}
}