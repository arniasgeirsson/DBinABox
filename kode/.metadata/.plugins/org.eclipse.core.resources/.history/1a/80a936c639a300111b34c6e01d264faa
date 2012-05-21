package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Edit
{    
    public Edit(String query, int tab)
    {
        Connection conn;
        int port = 1521;
        Login login = TabManager.getInstance().getLogin(tab);
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:"+port+":dbwc", login.getUsername(), login.getPassword());
            conn.setAutoCommit(false);
            
        PreparedStatement s = conn.prepareStatement(query);
        
        ResultSet rs = s.executeQuery();
        
        } catch(SQLException e) {
            System.out.println(e);
        } catch(ClassNotFoundException e) {
            System.out.println(e);
        }        
    }
}
