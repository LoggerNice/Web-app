package Database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class Image {
	private ConnectionDB connect = new ConnectionDB();
	private ArrayList<String> images = new ArrayList<String>();
	private ResultSet rs = null;
	
	public void addWorks(String filename, int id) throws SQLException {
		
		String query = "INSERT INTO works (image, user_id) VALUES (?, ?);";
		PreparedStatement statement = connect.dbConnector().prepareStatement(query);
		statement.setString(1, filename);
		statement.setInt(2, id);
		statement.executeUpdate();
		statement.close();
	}
	
	public void addAvatar(String filename, int id) throws SQLException {
		
		String query = "INSERT INTO users (photo) VALUES (?) WHERE ID = ?;";
		PreparedStatement statement = connect.dbConnector().prepareStatement(query);
		statement.setString(1, filename);
		statement.setInt(2, id);
		statement.executeUpdate();
		statement.close();
	}
	
	public void upload(String filename, String folder, Part part, HttpServletRequest request) throws IOException {
		InputStream is = part.getInputStream();
		byte []data = new byte[is.available()];
		
		is.read(data);
		String path = request.getRealPath("/") + folder + File.separator + filename;
		
		FileOutputStream fos = new FileOutputStream(path);
		fos.write(data);
		fos.close();
		System.out.println("Аватарка загружена!");
	}
	
	public ArrayList<String> getWorks(int id) throws SQLException {
		
		String query = "SELECT image FROM works WHERE user_id = ?";
		PreparedStatement statement = connect.dbConnector().prepareStatement(query);
		statement.setInt(1, id);
		rs = statement.executeQuery();
		
		if (rs != null) {
			while (rs.next()) {
				String filename = rs.getString("image");
				images.add(filename);
			}
		}
		
		statement.close();
		connect.conn.close();
		
		return images;
	}
}	