package model;

public class Login
{
    private String username;
    private String password;
    private String port;
    private String URL;
    
    public Login()
    {
        
    }
       
    public boolean tryLogin(String username, String password, String port, String url)
    {
        this.username = username;
        this.password = password;
        this.port = port;
        this.URL = url;
        
        return SQLManager.getInstance().tryToLogin(username, password, port, url);
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
