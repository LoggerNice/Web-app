package MyServlet;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.ConnectionDB;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static String hushPass(String password) throws NoSuchAlgorithmException {
		MessageDigest messageDegist = MessageDigest.getInstance("MD5");
		messageDegist.update(password.getBytes(), 0, password.length());
		String hushPassword = new BigInteger(1, messageDegist.digest()).toString(16);
		
		return hushPassword;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("Login");
        String name = request.getParameter("Name");
        String surname = request.getParameter("Surname");
        String gender = request.getParameter("Gender");
        String password = request.getParameter("Password");
        
        try {
			password = hushPass(password);
		} 
        catch (NoSuchAlgorithmException ex) {
			System.out.println("Password not hushed!");
			ex.printStackTrace();
		}
        
        gender = gender.equals("Man") ? "Мужской" : "Женский";
        		
		try {
			ConnectionDB connect = new ConnectionDB();
			String query = "INSERT INTO users (name, surname, gender, login, password) VALUES (?, ?, ?, ?, ?);";
			
			PreparedStatement statement = connect.dbConnector().prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, surname);
			statement.setString(3, gender);
			statement.setString(4, login);
			statement.setString(5, password);
			statement.executeUpdate();
			statement.close();
		} 
		catch (SQLException e) {
			System.out.println("SQL query not work!");
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/loginForm.jsp");
	}
}