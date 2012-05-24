package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The SQLManager class works as an manager for all the sql statements and database
 * connections that needs to be handled.
 */
public class SQLManager
{
    private static SQLManager instance;
    private final static String DATE_FORMAT = "yyyy-MM-dd";
    private final static String TIME_FORMAT = "HH:mm:ss";
    private SimpleDateFormat sdfDate = new SimpleDateFormat(DATE_FORMAT);
    private SimpleDateFormat sdfTime = new SimpleDateFormat(TIME_FORMAT);

    /**
     * Constructor, initiates a SQLManager object.
     */
    private SQLManager()
    {
        
    }
    
    /**
     * The SQLManager is a singleton, therefore getInstance returns
     * the SQLManager singleton.
     */
    public static SQLManager getInstance(){
        if (SQLManager.instance == null)
            SQLManager.instance = new SQLManager();
        return SQLManager.instance;
    }
    
    /**
     * openConnections tries to establish a connection to the
     * desired database.
     *
     * @param login it holds the specific login data from the user
     * @return      the connection to the database
     * @return      null: when no connection can be made        
     */
    private Connection openConnection(Login login)
    {
        Connection conn;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            conn = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@" + login.getURL() + ":" + login.getPort()+":xe", login.getUsername(), login.getPassword());
//                  "jdbc:oracle:thin:@" + login.getURL() + ":" + login.getPort(), login.getUsername(), login.getPassword());
                    "jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "CarharttDatabase");

//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://jaeger-net.org.mysql/jaeger_net_org:3306", "jaeger_net_org", "mGNaYgSY");
            
            return conn;
        } catch(SQLException e) {
            e.printStackTrace();
            this.sendMessage(login, e);
        } catch(ClassNotFoundException e) {
            model.MessageHandler.getInstance().addMessage(new model.Message(sdfDate.format(new Date()), 
                    sdfTime.format(new Date()), login.getUsername() + " - " + login.getURL(), e.getMessage()));
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * This method closes a given connection
     *
     * @param conn  the desired connection to be closed
     */
    private void closeConnection(Connection conn)
    {
        try
        {
            conn.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
            String error = e.getMessage();
            while((e = e.getNextException()) != null)
            {
                error = error.concat(e.getMessage());
            }
//            Creator?
            model.MessageHandler.getInstance().addMessage(new model.Message(sdfDate.format(new Date()), 
                    sdfTime.format(new Date()), "None", error));
        }
    }
    
    /**
     * This method fetches all the table names from a database
     *
     * @param  tab  the tab that contains the specific login information
     * @return      2d array with all the tablenames
     * @return      null: when an error happens
     */
    public String[][] getAllTables(Tab tab)
        {
        Connection conn = this.openConnection(tab.getLogin());
        if (conn == null)
            return null;
        
        try {
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
            resultset.close();
            ResultSet resultsetAttr;
            Connection connAttr = this.openConnection(tab.getLogin());
            String queryForAttr;
            PreparedStatement statement;
            int counter = 0;
            for (int i = 0; i < temp.size(); i++)
            {
                String tableTemp = temp.get(i);
                
                queryForAttr = "SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = ?";
                statement = connAttr.prepareStatement(queryForAttr);
                statement.setString(1, tableTemp);
                resultsetAttr = statement.executeQuery();

                ArrayList<String> tempAttr = new ArrayList<String>();
                while(resultsetAttr.next())
                {
                    System.out.println("Sker det?");
                    tempAttr.add(resultsetAttr.getString(1));
                }

                tableTemp = tableTemp.concat(" (");

                for (int j = 0; j < tempAttr.size(); j++)
                {
                    System.out.println("Sker det?");
                    tableTemp = tableTemp.concat(tempAttr.get(j));
                    if (j+1 < tempAttr.size())
                        tableTemp = tableTemp.concat(", ");
                }
                    
                tableTemp = tableTemp.concat(") ");
                temp.set(i, tableTemp);
                statement.close();
                resultsetAttr.close();
                counter++;
                System.out.println(counter);
            }
            this.closeConnection(connAttr);
            System.out.println("6");

            String[][] tableNames = new String[temp.size()][1];
            for (int i = 0; i < temp.size(); i++)
            {
                tableNames[i][0] = temp.get(i);
            }
            
            return tableNames;

        } catch(SQLException e) {
            e.printStackTrace();
            this.sendMessage(tab.getLogin(), e);
        } finally {
                this.closeConnection(conn);
        }
        
        return null;        
    }
    
    /**
     * getAllData fetches all the data in a given table
     * 
     * @param  tab       the tab that contains the specific login information
     * @param  tableName the name of the specific table
     * @return           all the data given in a 2d array of objects
     * @return           null: when an error happens
     */
    public Object[][] getAllData(Tab tab, String tableName)
    {
        Connection conn = this.openConnection(tab.getLogin());
        if (conn == null)
            return null;
        
        try {
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
                        // dårlig løsning?
                        break;
                    }
                }
                temp.add(temp2);
            }
            
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
            e.printStackTrace();
            this.sendMessage(tab.getLogin(), e);
        } finally {
            this.closeConnection(conn);
        }
        return null;        
    }
    
    /**
     * This method returns all the column names of a given table
     *
     * @param  tab       the tab that contains the specific login information
     * @param  tableName the name of the specific table
     * @return           an array containing the column names
     * @return           null: when an error happens
     */
    public String[] getColumnNames(Tab tab, String tableName)
    {
        Connection conn = this.openConnection(tab.getLogin());
        if (conn == null)
            return null;
        
        try {
            String query = "SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME = ?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, tableName);
            ResultSet resultset = stm.executeQuery();
            
            ArrayList<String> temp = new ArrayList<String>();
            while(resultset.next())
            {
                temp.add(resultset.getString(1));
            }
            
            String[] tableNames = new String[temp.size()];
            for (int i = 0; i < temp.size(); i++)
            {
                tableNames[i] = temp.get(i);
            }
            
            return tableNames;
    
        } catch(SQLException e) {
            e.printStackTrace();
            this.sendMessage(tab.getLogin(), e);
        } finally {
            this.closeConnection(conn);
        }
        return null;
    }
    
    /**
     * executeSql performs a SQL statement on a specific database
     *
     * @param  tab   the tab that contains the specific login information
     * @param  query the specific query to be executed
     */
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
            model.MessageHandler.getInstance().addMessage(new model.Message(sdfDate.format(new Date()), 
                    sdfTime.format(new Date()), tab.getLogin().getUsername() + " - " + tab.getLogin().getURL(), "SQL executed perfectly!"));
            
        } catch(SQLException e) {
            e.printStackTrace();
            this.sendMessage(tab.getLogin(), e);
        } finally {
            this.closeConnection(conn);
        }
    }
    
    /**
     * Determines if a connection can be made to a database with
     * the given login information
     * 
     * @param login it holds the specific login data from the user
     * @return      whether or not a connection can be established 
     */
    public boolean tryToLogin(Login login)
    {
        Connection conn = this.openConnection(login);
        if (conn == null)
            return false;
        
        model.MessageHandler.getInstance().addMessage(new model.Message(sdfDate.format(new Date()), 
                sdfTime.format(new Date()), login.getUsername() + " - " + login.getURL(), "Login succesfull!"));
        return true;
    }
    
    private void sendMessage(Login loginInfo, SQLException e)
    {
        String error = e.getMessage();
        while((e = e.getNextException()) != null)
        {
            error = error.concat(e.getMessage());
        }
        model.MessageHandler.getInstance().addMessage(new model.Message(sdfDate.format(new Date()), 
                sdfTime.format(new Date()), loginInfo.getUsername() + " - " + loginInfo.getURL(), error));
    }
}
