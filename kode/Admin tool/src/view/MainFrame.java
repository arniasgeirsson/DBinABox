package view;

import java.awt.Insets;

import javax.swing.JFrame;

public class MainFrame extends JFrame
{
    public static final int FRAME_LOGIN_PREF_WIDTH = 500;
    public static final int FRAME_LOGIN_PREF_HEIGHT = 300;
    public static final int FRAME_PREF_WIDTH = 800;
    public static final int FRAME_PREF_HEIGHT = 800;
    public Insets insets;
    
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
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.goToLogin();
    }
    
    public void goFromLogin()
    {
        this.createMainFramePanels();
        
        this.insets = this.getInsets();
        this.setSize(FRAME_PREF_WIDTH+this.insets.right+this.insets.left, 
                FRAME_PREF_HEIGHT+this.insets.top+this.insets.bottom);
        this.getContentPane().add(new LoginPanel());
        this.validate();
        this.repaint();
    }
    
    public void goToLogin()
    {
        this.insets = this.getInsets();
        this.setSize(FRAME_LOGIN_PREF_WIDTH+this.insets.right+this.insets.left, 
                FRAME_LOGIN_PREF_HEIGHT+this.insets.top+this.insets.bottom);
        this.getContentPane().add(new LoginPanel());
        this.validate();
        this.repaint();
    }
    
    private void createMainFramePanels()
    {
        
    }
}
