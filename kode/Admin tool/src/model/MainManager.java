package model;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainManager
{
    private view.LoginFrame currentLoginFrame;
    private boolean wrongLogin;
    
    private static MainManager instance;
    
    public static MainManager getInstance(){
        if(MainManager.instance == null)
            MainManager.instance = new MainManager();
        return MainManager.instance;
    }
    
    private MainManager()
    {
        this.newLogin();
    }
    
    public view.LoginFrame getCurrentLoginFrame()
    {
        return this.currentLoginFrame;
    }
    
    public void newLogin()
    {
        view.LoginFrame loginFrame = new view.LoginFrame();
        loginFrame.setVisible(true);
        if (TabManager.getInstance().getActiveTabIndex() == -1)
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        else 
            loginFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.currentLoginFrame = loginFrame;
    }
    
    public void addTab()
    {
        this.currentLoginFrame.setVisible(false);
        view.MainFrame mainFrame = view.MainFrame.getInstance();
        mainFrame.setVisible(true);
        mainFrame.addTab();
    }
    
    public void wrongLogin()
    {
        this.currentLoginFrame.setWrongLoginInfo("Error - wrong login");
    }
    
    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    MainManager.getInstance();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
