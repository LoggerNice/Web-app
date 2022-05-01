package Database;

import java.math.BigInteger;
import java.security.*;
import java.sql.*;

public class Users {
	ConnectionDB connect = new ConnectionDB();
	
	public ResultSet selectUser(String login) throws SQLException {
		ResultSet rs = null;
		
		String query = "SELECT * FROM users WHERE login = ?";
		PreparedStatement statement = connect.dbConnector().prepareStatement(query);
		statement.setString(1, login);
		rs = statement.executeQuery();
		
		return rs;
	}
	
	public void insertUser(String login, String password, String name, String surname, String gender, String city, String photo) throws SQLException {
		String query = "INSERT INTO users (name, surname, gender, login, password, city, photo) VALUES (?, ?, ?, ?, ?, ?, ?);";
		
		PreparedStatement statement = connect.dbConnector().prepareStatement(query);
		statement.setString(1, name);
		statement.setString(2, surname);
		statement.setString(3, gender);
		statement.setString(4, login);
		statement.setString(5, password);
		statement.setString(6, city);
		statement.setString(7, photo);
		statement.executeUpdate();
		statement.close();
	}
	
	public void updateUser(String name, String surname, String city, String photo, int id) throws SQLException {
		String query = "UPDATE users SET name=?, surname=?, city=?, photo=? WHERE ID = ?";
		
		PreparedStatement statement = connect.dbConnector().prepareStatement(query);
		statement.setString(1, name);
		statement.setString(2, surname);
		statement.setString(3, city);
		statement.setString(4, photo);
		statement.setInt(5, id);
		statement.executeUpdate();
		statement.close();
	}
	
	public String hushPass(String password) throws NoSuchAlgorithmException {
		MessageDigest messageDegist = MessageDigest.getInstance("MD5");
		messageDegist.update(password.getBytes(), 0, password.length());
		String hushPassword = new BigInteger(1, messageDegist.digest()).toString(16);
		
		return hushPassword;
	}
}