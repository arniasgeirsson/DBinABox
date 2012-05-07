package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLManager
{
    private static SQLManager instance;

    public static SQLManager getInstance(){
        if (SQLManager.instance == null)
            SQLManager.instance = new SQLManager();
        return SQLManager.instance;
    }

    public String[][] getAllTables(Tab tab)
        {
        Connection conn;
        Login login = tab.getLogin();
        
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:"+login.getPort()+":xe", login.getUsername(), login.getPassword());
            /*
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Arniermysql");
            */
            conn.setAutoCommit(false);
            
            String query = "SELECT TABLE_NAME FROM ALL_TABLES";
//            String query = "show databases";
            PreparedStatement stm = conn.prepareStatement(query);
            
            ResultSet resultset = stm.executeQuery();
            
            ArrayList<String> temp = new ArrayList<String>();
            String name = "";
            while(resultset.next())
            {
                name = resultset.getString(1);
                temp.add(name);
            }
            
            conn.close();
                
            String[][] tableNames = new String[temp.size()][1];
            for (int i = 0; i < temp.size(); i++)
            {
                tableNames[i][0] = temp.get(i);
            }
            
            return tableNames;

        } catch(SQLException e) {
            System.out.println(e);
        } catch(ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;        
    }
    
    public Object[][] getAllData(Tab tab, String tableName)
    {
        Connection conn;
        Login login = tab.getLogin();
        
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:"+login.getPort()+":xe", login.getUsername(), login.getPassword());
            
            /*
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/World", "root", "Arniermysql");
            */
            conn.setAutoCommit(false);
            
            String query = "SELECT * FROM "+tableName;
            PreparedStatement stm = conn.prepareStatement(query);
//            stm.setString(1, tableName);
            ResultSet resultset = stm.executeQuery();
            
            ArrayList<ArrayList<Object>> temp = new ArrayList<ArrayList<Object>>();
            while (resultset.next())
            {
                int index = 1;
                ArrayList<Object> temp2 = new ArrayList<Object>();
                while (true)
                {
                    try
                    {
                        String data = resultset.getString(index);
                        if (data == null)
                            data = "Null";
                        temp2.add(data);
                        index++;
                    } catch(SQLException e) {
                        System.out.println(e);
                        // d�rlig l�sning?
                        break;
                    }
                }
                temp.add(temp2);
            }
            conn.close();
            
            if (temp.size() < 1)
                return null;
            
            Object[][] allData = new Object[temp.size()][temp.get(0).size()];
            for (int i = 0; i < temp.size(); i++)
            {
                for (int y = 0; y < temp.get(i).size(); y++)
                {
                    allData[i][y] = temp.get(i).get(y);
                }
            }
            
            return allData;
    
        } catch(SQLException e) {
            System.out.println(e);
        } catch(ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;        
    }
    
    public String[] getColumnNames(Tab tab, String tableName)
    {
        Connection conn;
        Login login = tab.getLogin();
        
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:"+login.getPort()+":xe", login.getUsername(), login.getPassword());
            
           
            /*
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/World", "root", "Arniermysql");
            */
            
            conn.setAutoCommit(false);
            
            String query = "SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = ?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, tableName);
            ResultSet resultset = stm.executeQuery();
            
            ArrayList<String> temp = new ArrayList<String>();
            while(resultset.next())
            {
                temp.add(resultset.getString(1));
            }
            
            conn.close();
                
            String[] tableNames = new String[temp.size()];
            for (int i = 0; i < temp.size(); i++)
            {
                tableNames[i] = temp.get(i);
            }
            
            return tableNames;
    
        } catch(SQLException e) {
            System.out.println(e);
        } catch(ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void executeSql(Tab tab, String query)
    {
        Connection conn;
        Login login = tab.getLogin();
        
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:"+login.getPort()+":xe", login.getUsername(), login.getPassword());
            
            /*
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/World", "root", "Arniermysql");
            */
            
            conn.setAutoCommit(false);
            
            PreparedStatement stm = conn.prepareStatement(query);
            stm.executeQuery();
            conn.commit();
            conn.close();
                
        } catch(SQLException e) {
            System.out.println(e);
        } catch(ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    
    public boolean tryToLogin(String username, String password, String port, String url)
    {
        Connection conn;
        
        try 
        {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:"+port+":xe", 
                                               username, password);
            
            /*
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Arniermysql");
            */
            conn.setAutoCommit(false);
            
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
}
