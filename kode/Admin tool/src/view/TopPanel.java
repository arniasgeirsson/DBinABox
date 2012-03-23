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
    
    /**
     * Creates a new topPanel.
     */
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
    
    /**
     * Adds all the created panes to the topPanel
     */
    public void addAllPanes()
    {
        this.remove(this.plusButton);
        for(PaneButton temp : this.allPaneButtons)
        {
            this.add(temp);
        }
        this.add(this.plusButton);
    }
    
    /**
     * Creates a new pane with the desired title
     * @param title the desired title to be shown in the pane itself
     */
    public void addPane(String title)
    {
        this.allPaneButtons.add(new PaneButton(title));
    }
}
