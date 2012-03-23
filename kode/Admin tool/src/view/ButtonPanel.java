package view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel
{
    private JButton logoutButton;
    private JButton executeButton;
    private JButton pushImageButton;
    
    public ButtonPanel()
    {
        super();
        this.setBackground(Color.green);
        this.setLayout(new BoxLayout(this, 1));
        
        this.logoutButton = new JButton("Logout");
        this.executeButton = new JButton("Execute SQL");
        this.pushImageButton = new JButton("Push Image");
        
        this.add(this.logoutButton);
        this.add(this.executeButton);
        this.add(this.pushImageButton);
    }
}
