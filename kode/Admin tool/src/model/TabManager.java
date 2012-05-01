package model;

import java.util.HashMap;

public class TabManager
{
    private static TabManager instance;
    private HashMap<Integer, Login> tabs;
    private int key;
     
    private TabManager(){
        this.tabs = new HashMap<Integer, Login>();
        this.key = 0;
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
            return true;
        }
        
        return false;
    }
    
    public int getKey(){
        return this.key;
    }
    
    public Login getLogin(int tab){
        return this.tabs.get(tab);
    }
}

