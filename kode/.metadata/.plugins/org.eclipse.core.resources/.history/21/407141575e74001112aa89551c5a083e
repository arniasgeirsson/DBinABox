package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Login
{
    private Login()
    {
        
    }
    
    public boolean tryLogin(String id, String password)
    {
        Connection conn;
        int port = 1521;
        
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:"+port+":xe", 
                                               id, password);
            conn.setAutoCommit(false);
            
            return true;
        } 
        
        //TODO: ?? :P 
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        
        return false;
    }
}
