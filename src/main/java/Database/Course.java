package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Course {
	ConnectionDB connect = new ConnectionDB();
	
	public int getCount() throws SQLException {	
		String query = "SELECT COUNT(*) AS recordCount FROM course";
		Statement statement = connect.dbConnector().createStatement();
		ResultSet rs = statement.executeQuery(query);
		
		rs.next();
		int count = rs.getInt("recordCount");
		rs.close();
		
		return count;
	}
	
	public void addUser(String id) throws SQLException {
		String query = "INSERT INTO course (user_id) VALUES (?);";
		
		PreparedStatement statement = connect.dbConnector().prepareStatement(query);
		statement.setString(1, id);
		statement.executeUpdate();
		statement.close();
	}
}