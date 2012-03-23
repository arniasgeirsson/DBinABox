package view;

import java.awt.FlowLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JFrame;

public class MainFrame extends JFrame
{
    public static final int FRAME_LOGIN_PREF_WIDTH = 500;
    public static final int FRAME_LOGIN_PREF_HEIGHT = 300;
    public static final int FRAME_PREF_WIDTH = 800;
    public static final int FRAME_PREF_HEIGHT = 600;
    
    private Insets insets;
    
    private ButtonPanel buttonPanel;
    private LogLinePanel logLinePanel;
    private TopPanel topPanel;
    private ArrayList<WindowPanel> allWindows;
    private int currentWindowPanel;
    
    private LogPanel logPanel;
    private TablePanel tablePanel;
    private DatabasePanel databasePanel;
    private DataPanel dataPanel;
    
    public static void main(String args[])
    {
        new MainFrame();
    }
    
    public MainFrame()
    {
        super();
        
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
//        this.setLocationRelativeTo(null);
//        this.setLayout(new FlowLayout());
        this.setLayout(null);
        this.setVisible(true);
        
//        this.goToLogin();
        this.goFromLogin();
    }
    
    public void goFromLogin()
    {
        this.insets = this.getInsets();
        this.setSize(FRAME_PREF_WIDTH+this.insets.right+this.insets.left, 
                FRAME_PREF_HEIGHT+this.insets.top+this.insets.bottom);
        
        this.getContentPane().removeAll();
        this.createMainFramePanels();
        
        this.validate();
        this.repaint();
    }
    
    public void goToLogin()
    {
        this.insets = this.getInsets();
        this.setSize(FRAME_LOGIN_PREF_WIDTH+this.insets.right+this.insets.left, 
                FRAME_LOGIN_PREF_HEIGHT+this.insets.top+this.insets.bottom);
        
        this.getContentPane().removeAll();
        LoginPanel loginPanel = new LoginPanel();
        loginPanel.setSize(FRAME_LOGIN_PREF_WIDTH, FRAME_LOGIN_PREF_HEIGHT);
        this.getContentPane().add(loginPanel);
        
        this.validate();
        this.repaint();
    }
    
    private void createMainFramePanels()
    {
        int topPanelHeight = (FRAME_PREF_HEIGHT/12);
        int logLineHeight = (FRAME_PREF_HEIGHT/20);
        int windowPanelHeight = (FRAME_PREF_HEIGHT-topPanelHeight-logLineHeight);
        int windowPanelWidth = (FRAME_PREF_WIDTH-(FRAME_PREF_WIDTH/6));
        
        if (this.topPanel == null)
        {
            this.topPanel = new TopPanel();
            this.topPanel.setBounds(0, 0, windowPanelWidth, topPanelHeight);
        }
        if (this.buttonPanel == null)
        {
            this.buttonPanel = new ButtonPanel();
            this.buttonPanel.setBounds(windowPanelWidth, 0, (FRAME_PREF_WIDTH - windowPanelWidth), FRAME_PREF_HEIGHT);
        }
        
        if (this.allWindows == null)
        {
            this.allWindows = new ArrayList<WindowPanel>();
            this.allWindows.add(this.createWindowPanel());
            this.currentWindowPanel = 0;
        }
        
        if (this.logLinePanel == null)
        {
            this.logLinePanel = new LogLinePanel();
            this.logLinePanel.setBounds(0, topPanelHeight+windowPanelHeight, windowPanelWidth, logLineHeight);
        }
        
        this.getContentPane().add(this.topPanel);
        this.getContentPane().add(this.buttonPanel);
        for (WindowPanel temp : this.allWindows)
        {
            this.getContentPane().add(temp);
        }
        this.makeWindowPanelVisible();
        this.getContentPane().add(this.logLinePanel);
    }
    
    public void makeWindowPanelVisible()
    {
        for (int i = 0; i < this.allWindows.size(); i++)
        {
            if (this.currentWindowPanel != i)
            {
                this.allWindows.get(i).setVisible(false);
            } else {
                this.allWindows.get(i).setVisible(true);
            }
        }
    }
    
    public void setCurrentWindowPanel(int nextWindowPanel)
    {
        this.currentWindowPanel = nextWindowPanel;
    }
    
    public WindowPanel createWindowPanel()
    {
        int topPanelHeight = (FRAME_PREF_HEIGHT/12);
        int logLineHeight = (FRAME_PREF_HEIGHT/20);
        int windowPanelHeight = (FRAME_PREF_HEIGHT-topPanelHeight-logLineHeight);
        int windowPanelWidth = (FRAME_PREF_WIDTH-(FRAME_PREF_WIDTH/6));
        
        WindowPanel newWindowPanel = new WindowPanel();
        newWindowPanel.setBounds(0, topPanelHeight, windowPanelWidth, windowPanelHeight);
        newWindowPanel.setVisible(false);
        return newWindowPanel;
    }
    
    public void changePane()
    {
        
    }
  
}
