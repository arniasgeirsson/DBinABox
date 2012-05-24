package model;

import java.util.ArrayList;

public class TabManager
{
    private static TabManager instance;
    private ArrayList<Tab> allTabs;
    private int activeTab;
    
    
    private TabManager(){
        this.activeTab = -1;
        this.allTabs = new ArrayList<Tab>();
    }
    
    public static TabManager getInstance(){
        if (TabManager.instance == null)
            TabManager.instance = new TabManager();
        return TabManager.instance;
    }
    
    public boolean addTab(String username, String password, String port, String url){
        Login login = new Login();
        
        if(login.tryLogin(username, password, port, url)){
            this.allTabs.add(new Tab(login));
            if (this.activeTab >= 0)
                this.activeTab = view.MainFrame.getInstance().getTabPanel().getNumberOfTabs();
            else 
                this.activeTab = 0;
            return true;
        }
        return false;
    }
    
    public void removeActiveTab()
    {
        this.allTabs.remove(this.activeTab);
        if (this.activeTab >= this.allTabs.size())
            this.activeTab--;
    }
    
    public void switchTab(int nextSelectedTab)
    {
        this.activeTab = nextSelectedTab;
    }
    
    public Tab getActiveTab()
    {
        return this.allTabs.get(this.activeTab);
    }
    
    public int getActiveTabIndex()
    {
        return this.activeTab;
    }
}
