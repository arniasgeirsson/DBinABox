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

    private SQLManager()
    {
        
    }
    
    public static SQLManager getInstance(){
        if (SQLManager.instance == null)
            SQLManager.instance = new SQLManager();
        return SQLManager.instance;
    }
    
    private Connection openConnection(Login login)
    {
        Connection conn;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:"+login.getPort()+":xe", login.getUsername(), login.getPassword());
            /*
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "Arniermysql");
            */
            return conn;
        } catch(SQLException e) {
            System.out.println(e);
        } catch(ClassNotFoundException e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    private void closeConnection(Connection conn)
    {
        try
        {
            conn.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    
    public String[][] getAllTables(Tab tab)
        {
        Connection conn = this.openConnection(tab.getLogin());
        if (conn == null)
            return null;
        
        try {
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
            
            this.closeConnection(conn);
            
            String[][] tableNames = new String[temp.size()][1];
            for (int i = 0; i < temp.size(); i++)
            {
                tableNames[i][0] = temp.get(i);
            }
            
            return tableNames;

        } catch(SQLException e) {
            System.out.println(e);
        }
        
        return null;        
    }
    
    public Object[][] getAllData(Tab tab, String tableName)
    {
        Connection conn = this.openConnection(tab.getLogin());
        if (conn == null)
            return null;
        
        try {
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
            
            this.closeConnection(conn);
            
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
        }
        return null;        
    }
    
    public String[] getColumnNames(Tab tab, String tableName)
    {
        Connection conn = this.openConnection(tab.getLogin());
        if (conn == null)
            return null;
        
        try {
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
            
            this.closeConnection(conn);
                
            String[] tableNames = new String[temp.size()];
            for (int i = 0; i < temp.size(); i++)
            {
                tableNames[i] = temp.get(i);
            }
            
            return tableNames;
    
        } catch(SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void executeSql(Tab tab, String query)
    {
        Connection conn = this.openConnection(tab.getLogin());
        if (conn == null)
            return;
        
        try {
            conn.setAutoCommit(false);
            
            PreparedStatement stm = conn.prepareStatement(query);
            stm.executeQuery();
            conn.commit();
            this.closeConnection(conn);
                
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
    
    public boolean tryToLogin(Login login)
    {
        Connection conn = this.openConnection(login);
        if (conn != null)
            return true;
        
        return false;
    }
}
