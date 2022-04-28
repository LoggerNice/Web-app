package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Course {
	private ConnectionDB connect = new ConnectionDB();
	
	public int getCount() throws SQLException {	
		String query = "SELECT COUNT(*) AS recordCount FROM course";
		Statement statement = connect.dbConnector().createStatement();
		ResultSet rs = statement.executeQuery(query);
		
		rs.next();
		int count = rs.getInt("recordCount");
		rs.close();
		statement.close();
		
		return count;
	}
	
	public void add(int id) throws SQLException {
		String query = "INSERT INTO course (user_id) VALUES (?);";
		
		PreparedStatement statement = connect.dbConnector().prepareStatement(query);
		statement.setInt(1, id);
		statement.executeUpdate();
		statement.close();
	}
	
	public boolean check(int id) throws SQLException {
		String query = "SELECT COUNT(id) FROM course WHERE user_id = " + id;
		Statement statement = connect.dbConnector().createStatement();
		ResultSet rs = statement.executeQuery(query);
		
		rs.next();
		int count = rs.getInt(1);
		rs.close();
		statement.close();
		
		if (count == 1) 
			return true;
		else 
			return false;
	}
}