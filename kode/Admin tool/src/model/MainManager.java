package model;

import java.awt.EventQueue;

public class MainManager
{
    private view.LoginFrame currentLoginFrame;
    
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
        this.currentLoginFrame = loginFrame;
    }
    
    public void addTab()
    {
        this.currentLoginFrame.setVisible(false);
        view.MainFrameTest mainFrame = view.MainFrameTest.getInstance();
        mainFrame.setVisible(true);
        mainFrame.addTab();
    }
    
    public void wrongLogin()
    {
        
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
