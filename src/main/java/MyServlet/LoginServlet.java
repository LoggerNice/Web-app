package MyServlet;

import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import Database.ConnectionDB;
import Models.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }
    
    private ResultSet selectUserDB(String login) {
    	try {
			ConnectionDB connect = new ConnectionDB();
			
			String query = "SELECT login, password FROM users WHERE login = (?);";
			PreparedStatement statement = connect.dbConnector().prepareStatement(query);
			statement.setString(1, login);
			ResultSet rs = statement.executeQuery();
			statement.close();
			
			if (rs.getMetaData().getColumnCount() > 0) return rs;
			else return null;
		} 
		catch (SQLException e) {
			System.out.println("SQL запрос не выполнен!");
			e.printStackTrace();
			
			return null;
		}
    }
    
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
        
        String login = request.getParameter("Login");
        String password = request.getParameter("Password");
        
        ResultSet rs = selectUserDB(login);
        if (rs != null) {
        	try {
				while (rs.next()) {
					String hash = rs.getString("password");
					MessageDigest md = MessageDigest.getInstance("MD5");
					
				    md.update(password.getBytes());
				    byte[] digest = md.digest();
				    String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
				    
				    if (assertThat(myHash.equals(hash)).isTrue()) {
				    	HttpSession session = request.getSession();	
				    	session.setAttribute("Login", login);
				    	
				    	out.println("<html>");
			        	out.println("<head>");
			        	out.println("<title>MyServlet</title>");
			        	out.println("</head>");
			        	out.println("<body>");
			        	out.println("<h1>Information</h1>");
			        	out.println("Авторизация прошла успешно");
			        	out.println("</body>");
			        	out.println("</html>");
				    }
				    else {
			        	out.println("Пройдите регистрацию!");
				    }
				}
			} 
        	catch (SQLException e) {
				e.printStackTrace();
			}
        }
        out.close();
    }

}
