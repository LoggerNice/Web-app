package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.Comment;

public class Comments {
	private ConnectionDB connect = new ConnectionDB();
	private ArrayList<Comment> comment = new ArrayList<Comment>(); 
	
	public void add(int id, String text) throws SQLException {
		String query = "INSERT INTO comment (text, user_id, date) VALUES (?,?,date())";
		
		PreparedStatement statement = connect.dbConnector().prepareStatement(query);
		statement.setString(1, text);
		statement.setInt(2, id);
		statement.executeUpdate();
		statement.close();
	}
	
	public ArrayList<Comment> select() throws SQLException {
		
		ResultSet rs = null;
		
		String query = "SELECT comment.text, comment.date, users.name, users.surname FROM comment JOIN users ON users.ID = comment.user_id;";
		Statement statement = connect.dbConnector().createStatement();
		rs = statement.executeQuery(query);
		
		rs.getFetchSize();
		
		if (rs != null) {
			while (rs.next()) {
				String text = rs.getString("text");
				String date = rs.getString("date");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				comment.add(new Comment(text, date, name, surname));
			}
		}
		
		return comment;
	}
}