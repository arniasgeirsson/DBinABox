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
    
    public static void main(String args[])
    {
        new MainFrame();
    }
    
    /**
     * Creates a new frame that starts with a LoginPanel.
     */
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
    
    /**
     * Changes the state of the frame to main state.
     */
    public void goFromLogin()
    {
        this.insets = this.getInsets();
        this.setSize(FRAME_PREF_WIDTH+this.insets.right+this.insets.left, 
                FRAME_PREF_HEIGHT+this.insets.top+this.insets.bottom);
        
        this.getContentPane().removeAll();
        this.createMainFramePanels();
        this.addAllMainPanels();
        this.validate();
        this.repaint();
    }
    
    /**
     * Changes the state of the frame to login state.
     */
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
    
    /**
     * Creates all the panels for the main state of the frame.
     */
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
    }
    
    /**
     * Adds all the main panels to the frame.
     */
    public void addAllMainPanels()
    {
        this.getContentPane().add(this.topPanel);
        this.getContentPane().add(this.buttonPanel);
        for (WindowPanel temp : this.allWindows)
        {
            this.getContentPane().add(temp);
        }
        this.makeWindowPanelVisible();
        this.getContentPane().add(this.logLinePanel);
    }
    
    /**
     * Makes the active windowPanel visible and the rest invisible.
     */
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
    
    /**
     * Changes the active windowPanel
     * Note: It does not make it visible
     * @param nextWindowPanel index of the next windowPanel
     */
    public void setCurrentWindowPanel(int nextWindowPanel)
    {
        this.currentWindowPanel = nextWindowPanel;
    }
    
    /**
     * Creates a new windowPanel
     * @return the newly created windowPanel
     */
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
    
    /**
     * Changes the current active pane.
     * @param nextCurrentWindow the index of the next active window
     */
    public void changePane(int nextCurrentWindow)
    {
//        Nødvendig?
        this.setCurrentWindowPanel(nextCurrentWindow);
        this.makeWindowPanelVisible();
    }
  
}
