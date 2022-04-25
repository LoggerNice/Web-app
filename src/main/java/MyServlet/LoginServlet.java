package MyServlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Database.ConnectionDB;
import Models.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ResultSet SelectUser(String login) throws SQLException {
		ResultSet rs = null;
		
		ConnectionDB connect = new ConnectionDB();
		
		String query = "SELECT * FROM users WHERE login = ?";
		PreparedStatement statement = connect.dbConnector().prepareStatement(query);
		statement.setString(1, login);
		rs = statement.executeQuery();
		
		return rs;
	}
	
	private void SetCookie(HttpServletResponse response, String id, String name, String surname, String gender) {
		Cookie cookieID = new Cookie("id", id);
		Cookie cookieName = new Cookie("name", name); 
		Cookie cookieSurname = new Cookie("surname", surname);
		Cookie cookieGender = new Cookie("gender", gender);
		
		cookieID.setMaxAge(30 * 24 * 60 * 60);
		cookieName.setMaxAge(30 * 24 * 60 * 60);
		cookieSurname.setMaxAge(30 * 24 * 60 * 60);
		cookieGender.setMaxAge(30 * 24 * 60 * 60);
		
		response.addCookie(cookieID);
		response.addCookie(cookieName);
		response.addCookie(cookieSurname);
		response.addCookie(cookieGender);
	}
    
	private void SetSession(HttpServletRequest request, String login, String password) {
		User user = new User(login, password);
		HttpSession session = request.getSession();
		session.setAttribute("currentUser", user);
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    	String login = request.getParameter("Login");
        String password = request.getParameter("Password");
        ResultSet rs = null;
        
        try {
			rs = SelectUser(login);
        	
			if (rs != null) {
				while (rs.next()) {
					System.out.println(rs.getString("login") + " " + rs.getString("password"));
					String hash = rs.getString("password");
					String name = rs.getString("name");
					String surname = rs.getString("surname");
					String gender = rs.getString("gender");
					int id = rs.getInt("ID");
					
					try {
						String hashUser;
						hashUser = RegistrationServlet.hushPass(password);
						
						if (hashUser.equals(hash)) {
							SetSession(request, login, password);
							SetCookie(response, String.valueOf(id), name, surname, gender);
							
							response.sendRedirect("index.jsp");
						}
						else {
							System.out.println("Password not equals!");
							response.sendRedirect(request.getContextPath() + "/loginForm.jsp");
						}
						
					} catch (NoSuchAlgorithmException e) {
						System.out.println("MD5 error!");
						e.printStackTrace();
					}
				}
			}
			else System.out.println("Not founded");
		}
        catch (SQLException e) {
			System.out.println("SQL dont query!");
			e.printStackTrace();
        }
    }
}
