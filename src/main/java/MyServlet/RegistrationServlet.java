package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("Login");
        String password = request.getParameter("Password");
        String name = request.getParameter("Name");
        String surname = request.getParameter("Surname");
        String gender = request.getParameter("Gender");
        
        if (gender.equals("Man"))
        	gender = "Man";
        else
        	gender = "Woman";
        		
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
			System.out.println("SQL запрос не выполнен!");
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>MyServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Users add!</h1>");
        out.println("</body>");
        out.println("</html>");
	}
}