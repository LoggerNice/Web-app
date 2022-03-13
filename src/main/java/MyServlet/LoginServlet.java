package MyServlet;

import static org.junit.Assert.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

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
        
        String login = request.getParameter("Login");
        String password = request.getParameter("Password");
        ResultSet rs = null;
        
        try {
			ConnectionDB connect = new ConnectionDB();
			
			String query = "SELECT login, password FROM users WHERE login = ?";
			PreparedStatement statement = connect.dbConnector().prepareStatement(query);
			statement.setString(1, login);
			rs = statement.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					System.out.println(rs.getString("login") + " " + rs.getString("password"));
					String hash = rs.getString("password");
					
					try {
						String hashUser;
						hashUser = RegistrationServlet.hushPass(password);
						assertEquals("Password are not equal", hashUser, hash);
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
