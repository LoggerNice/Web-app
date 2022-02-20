package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.ConnectionDB;
import Models.User;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("Login");
        String password = request.getParameter("Password");
        String name = request.getParameter("Name");
        String surname = request.getParameter("Surname");
        String gender = request.getParameter("Gender");
        
		String query = "INSERT INTO users (name, surname, login, password, gender) VALUES (" + name + ", " + surname + "," + login + "," + password + "," + gender + ")";
		
		try {
			ConnectionDB connect = new ConnectionDB();
			Statement statement = connect.getConnection().createStatement();
			statement.executeQuery(query);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
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