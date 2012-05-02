package model;

import java.util.ArrayList;
import java.util.HashMap;

public class TabManager
{
    private static TabManager instance;
    private HashMap<Integer, Login> tabs;
    private int key;
    
    
    private ArrayList<Tab> allTabs;
    private int currentTab;
    
    
    private TabManager(){
        this.tabs = new HashMap<Integer, Login>();
        this.key = 0;
        
        
        this.currentTab = -1;
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
            this.currentTab++;
            
            
            return true;
        }
        
        return false;
    }
    
    public void removeCurrentTab()
    {
        this.allTabs.remove(this.currentTab);
        if (this.currentTab > this.allTabs.size())
            this.currentTab--;
    }
    
    public int getKey(){
        return this.key;
    }
    
    public Login getLogin(int tab){
        return this.tabs.get(tab);
    }
    
    public void switchTab(int nextSelectedTab)
    {
        this.currentTab = nextSelectedTab;
    }
    
    public Tab getCurrentTab()
    {
        return this.allTabs.get(this.currentTab);
    }
    
    public int getCurrentTabIndex()
    {
        return this.currentTab;
    }
}
