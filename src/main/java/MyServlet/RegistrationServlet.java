package MyServlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import Database.Users;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String currentRes = request.getParameter("Kapcha");
		String userRes = request.getParameter("Result");
		
		if (!currentRes.equals(userRes))
			response.sendRedirect(request.getContextPath() + "/registration.jsp");
		else {
			String login = request.getParameter("Login");
	        String name = request.getParameter("Name");
	        String surname = request.getParameter("Surname");
	        String gender = request.getParameter("Gender");
	        String password = request.getParameter("Password");
	        String city = request.getParameter("City");
	        String photo = null;
	        
	        try {
				password = user.hushPass(password);
			} 
	        catch (NoSuchAlgorithmException ex) {
				System.out.println("Password not hushed!");
				ex.printStackTrace();
			}
	        
	        photo = gender.equals("Man") ? "user.svg" : "user-2.svg";
	        gender = gender.equals("Man") ? "Мужской" : "Женский";
	        		
			try {
				user.insertUser(login, password, name, surname, gender, city, photo);
			} 
			catch (SQLException e) {
				System.out.println("SQL query not work!");
				e.printStackTrace();
			}
			
			response.sendRedirect(request.getContextPath() + "/loginForm.jsp");
		}
	}
}