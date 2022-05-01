package Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Quest {
	private ConnectionDB connect = new ConnectionDB();
	
	public void add(String text, String phone, String mail) throws SQLException {
		String query = "INSERT INTO quests (text, phone, mail) VALUES (?, ?, ?);";
		
		PreparedStatement statement = connect.dbConnector().prepareStatement(query);
		statement.setString(1, text);
		statement.setString(2, phone);
		statement.setString(3, mail);
		statement.executeUpdate();
		statement.close();
	}
}