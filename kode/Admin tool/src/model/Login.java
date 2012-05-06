package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Login
{
    private String username;
    private String password;
    private String port;
    private String URL;
    
    public Login()
    {
        
    }
       
    public boolean tryLogin(String id, String password, String port, String url)
    {
        Connection conn;
        
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:"+port+":xe", 
                                               id, password);
            conn.setAutoCommit(false);
            
            this.username = id;
            this.password = password;
            this.port = port;
            this.URL = url;
            
            conn.close();
            return true;
        } 
        
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
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getPort()
    {
        return this.port;
    }
    
    public String getURL()
    {
        return this.URL;
    }
}
