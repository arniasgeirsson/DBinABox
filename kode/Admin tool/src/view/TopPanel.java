package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TopPanel extends JPanel
{
    private JButton backArrow;
    private JButton forwardArrow;
    private JButton plusButton;
    private ArrayList<PaneButton> allPaneButtons;
    
    public TopPanel()
    {
        super();
        
        this.setBackground(Color.blue);
        this.setLayout(new BoxLayout(this, 0));
        
        this.backArrow = new JButton("Back");
        this.forwardArrow = new JButton("Forward");
        this.plusButton = new JButton("+");
        this.allPaneButtons = new ArrayList<PaneButton>();
        
        this.add(this.backArrow);
        this.add(this.forwardArrow);
        this.addPane("Database 1");
        this.add(this.plusButton);
        this.addAllPanes();
    }
    
    public void addAllPanes()
    {
        this.remove(this.plusButton);
        for(PaneButton temp : this.allPaneButtons)
        {
            this.add(temp);
        }
        this.add(this.plusButton);
    }
    
    public void addPane(String text)
    {
        this.allPaneButtons.add(new PaneButton(text));
    }
}
