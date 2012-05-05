package model;

import javax.swing.JPanel;

public class Tab
{
    private Login login;
    
    private boolean tableView;
    private boolean dataView;
    
    public Tab(Login theLogin)
    {
        this.login = theLogin;
        this.switchToTableView();
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
    
    public JPanel getActivePanel()
    {
        if (this.tableView)
            return new view.TablePanel();
        if (this.dataView)
            return new view.DataViewPanel();
        
        return null;
    }
}