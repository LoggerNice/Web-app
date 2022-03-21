package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.junit.Test;

import Database.ConnectionDB;

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
	
	private void SetCookie(HttpServletResponse response, String name, String surname, String gender) {
		Cookie cookieName = new Cookie("name", name); 
		Cookie cookieSurname = new Cookie("surname", surname);
		Cookie cookieGender = new Cookie("gender", gender);
		
		cookieName.setMaxAge(30 * 24 * 60 * 60);
		cookieSurname.setMaxAge(30 * 24 * 60 * 60);
		cookieGender.setMaxAge(30 * 24 * 60 * 60);
		
		response.addCookie(cookieName);
		response.addCookie(cookieSurname);
		response.addCookie(cookieGender);
	}

	private void GetCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("Cp1251");           
        response.setCharacterEncoding("Cp1251"); 
		
		PrintWriter out = response.getWriter();
		Cookie [] cookies = request.getCookies();
		
		out.println("<h1>");
		out.println("Привет, ");
		for (Cookie cookie : cookies) {
			if ("name".equals(cookie.getName()) || "surname".equals(cookie.getName())) {
				out.println(cookie.getValue() + " ");
			}
			if ("gender".equals(cookie.getName()))
				out.println("<br> Мой пол - " + cookie.getValue().toLowerCase());
		}
		out.println("</h1>");
	}
    
	private void SetSession(HttpServletRequest request, String login, String password) {
		HttpSession session = request.getSession();
		session.setAttribute("Login", login);
		session.setAttribute("Password", password);
	}
	
    @Test
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
					
					try {
						String hashUser;
						hashUser = RegistrationServlet.hushPass(password);
						
						if (hashUser.equals(hash)) {
							SetCookie(response, name, surname, gender);
							SetSession(request, login, password);
							GetCookie(request, response);
						}
						else {
							System.out.println("Password not equals!");
							response.sendRedirect(request.getContextPath() + "/LoginForm.html");
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
