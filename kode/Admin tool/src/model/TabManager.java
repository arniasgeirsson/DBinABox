package model;

import java.util.ArrayList;
import java.util.HashMap;

public class TabManager
{
    private static TabManager instance;
    private HashMap<Integer, Login> tabs;
    private int key;
    
    
    private ArrayList<Tab> allTabs;
    private int activeTab;
    
    
    private TabManager(){
        this.tabs = new HashMap<Integer, Login>();
        this.key = 0;
        
        
        this.activeTab = -1;
        this.allTabs = new ArrayList<Tab>();
    }
    
    public static TabManager getInstance(){
        if (TabManager.instance == null)
            TabManager.instance = new TabManager();
        return TabManager.instance;
    }
    
    public boolean addTab(String username, String password, String url, int port){
        Login login = new Login();
        
        if(login.tryLogin(username, password)){
            key++;
            this.tabs.put(key, login);
            
            
            this.allTabs.add(new Tab(login));
            this.activeTab++;
            
            
            return true;
        }
        
        return false;
    }
    
    public void removeCurrentTab()
    {
        this.allTabs.remove(this.activeTab);
        if (this.activeTab > this.allTabs.size())
            this.activeTab--;
    }
    
    public int getKey(){
        return this.key;
    }
    
    public Login getLogin(int tab){
        return this.tabs.get(tab);
    }
    
    public void switchTab(int nextSelectedTab)
    {
        this.activeTab = nextSelectedTab;
    }
    
    public Tab getCurrentTab()
    {
        return this.allTabs.get(this.activeTab);
    }
    
    public int getCurrentTabIndex()
    {
        return this.activeTab;
    }
}
