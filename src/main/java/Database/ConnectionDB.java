package Database;

import java.sql.*;

public class ConnectionDB {    
    public Connection conn = null;
    private String url = "jdbc:mysql://mysql104.1gb.ru/gb_x_des_s1a6?user=gb_x_des_s1a6&password=G-yje3w7KycM";
    
    public Connection dbConnector() throws SQLException {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        	conn = DriverManager.getConnection(url);
            return conn;
        } 
        catch (Exception e) {
            System.out.println("SQL connection DB error!");
            e.printStackTrace();
            return null;
        }
    }
}