package view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LogLinePanel extends JPanel
{
    private String currentMessage;
    private JButton arrowButton;
    private JTextArea messageArea;
    
    public LogLinePanel()
    {
        super();
        this.setBackground(Color.orange);
        this.setLayout(new BoxLayout(this,0));
        
        this.currentMessage = "This is a fatal error! Selfdestruct in 5.. 4.. 3.. 2.. 1..";
        this.messageArea = new JTextArea();
//        this.messageArea.setBackground(Color.orange);
        this.arrowButton = new JButton("up");
        
        this.changeMessage(this.currentMessage);
        
        this.add(this.messageArea);
        this.add(this.arrowButton);
    }
    
    public void changeMessage(String message)
    {
        this.currentMessage = message;
        this.messageArea.setText(message);
    }
    
}
