package model;

import javax.swing.JPanel;

public class Tab
{
    private Login login;
    
    private boolean tableView;
    private boolean dataView;
    private String tableName;
    
    public Tab(Login theLogin)
    {
        this.login = theLogin;
        this.switchToTableView();
    }
    
    public Login getLogin()
    {
        return this.login;
    }
    
    public void switchToTableView()
    {
        this.tableView = true;
        this.dataView = false;
    }
    
    public void switchToDataView()
    {
        this.tableView = false;
        this.dataView = true;
    }
    
    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }
    
    public JPanel getActivePanel()
    {
        SQLManager sqlManager = SQLManager.getInstance();
        if (this.tableView)
            return new view.TablePanel(sqlManager.getAllTables(this));
        if (this.dataView)
            return new view.DataViewPanel(sqlManager.getAllData(this, this.tableName), 
                    sqlManager.getColumnNames(this, this.tableName), this.tableName);
        
        return null;
    }
}
