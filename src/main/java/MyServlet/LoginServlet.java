package MyServlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Database.*;
import Server.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	private Sessions session = new Sessions();
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    	
    	String login = request.getParameter("Login");
        String password = request.getParameter("Password");
        ResultSet rs = null;
        
        try {
			rs = user.selectUser(login);
        	
			if (rs != null) {
				while (rs.next()) {
					System.out.println(rs.getString("login") + " " + rs.getString("password"));
					String hash = rs.getString("password");
					String name = rs.getString("name");
					String surname = rs.getString("surname");
					String gender = rs.getString("gender");
					String city = rs.getString("city");
					int id = rs.getInt("ID");
					
					try {
						String hashUser;
						hashUser = user.hushPass(password);
						
						if (hashUser.equals(hash)) {
							session.setSession(request, id, login, password, name, surname, gender, city);
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
