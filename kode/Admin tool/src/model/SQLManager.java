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
        int port = 1521;
        Login login = tab.getLogin();
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:"+port+":xe", login.getUsername(), login.getPassword());
            conn.setAutoCommit(false);
            
            String query = "SELECT TABLE_NAME FROM ALL_TABLES";
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
}
