package MyServlet;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import Database.ConnectionDB;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Test
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
        
    	PrintWriter out = response.getWriter();
        String login = request.getParameter("Login");
        String password = request.getParameter("Password");
        ResultSet rs = null;
        
        try {
			ConnectionDB connect = new ConnectionDB();
			
			String query = "SELECT name, login, password FROM users WHERE login = ?";
			PreparedStatement statement = connect.dbConnector().prepareStatement(query);
			statement.setString(1, login);
			rs = statement.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					System.out.println(rs.getString("login") + " " + rs.getString("password"));
					String hash = rs.getString("password");
					String name = rs.getString("name");
					
					try {
						String hashUser;
						hashUser = RegistrationServlet.hushPass(password);
						
						if (hashUser.equals(hash)) {
							HttpSession session = request.getSession();
							session.setAttribute("Login", login);
							session.setAttribute("Password", password);
							
							out.println("<h1>");
					        out.println("Hello, " + name);
					        out.println("</h1>");
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
			else {
				System.out.println("Not founded");
			}
			
			statement.close();
		}
        catch (SQLException e) {
			System.out.println("SQL dont query!");
			e.printStackTrace();
        }
    }
}
