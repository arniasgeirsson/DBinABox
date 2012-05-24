package view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class TabPanel extends JPanel
{
    private JButton btnNewTabButton;
    
    private int heightOfTabs = 40;
    private int maxWidthOfTabs = 150;
    private int minWidthOfTabs = 10;
    private int currentWidthOfTabs;
    
    private int numberOfTabs;
    
    /**
     * Create the panel.
     */
    public TabPanel()
    {
        setLayout(null);
        
        this.btnNewTabButton = new JButton("+");
        this.btnNewTabButton.setBounds(0, 0, 40, 40);
        this.btnNewTabButton.addActionListener(new controller.NewTabListener());
        add(btnNewTabButton);
        this.numberOfTabs = 0;
        this.currentWidthOfTabs = this.maxWidthOfTabs;
    }
    
    public int getNumberOfTabs()
    {
        return this.numberOfTabs;
    }
    
    public JButton getTabButtonAt(int index)
    {
        return (JButton) this.getComponent(index);
    }
    
    public void removeTab(int index)
    {
        this.numberOfTabs--;
        this.remove(this.btnNewTabButton);
        this.remove(index);
        this.updateCurrentWidth();
        this.updateAllTabs();
        this.updateNewTabBtn();
        this.add(this.btnNewTabButton);
    }
    
    public void addNewTab(String name)
    {
        this.numberOfTabs++;
        this.remove(this.btnNewTabButton);
        this.updateCurrentWidth();
        this.updateAllTabs();
        
        JButton newTabButton = new JButton(name);
        newTabButton.setToolTipText(name);
        newTabButton.setBounds(((this.numberOfTabs-1)*this.currentWidthOfTabs), 0, this.currentWidthOfTabs, this.heightOfTabs);
        newTabButton.addActionListener(new controller.TabListener());

        this.add(newTabButton);
        this.updateNewTabBtn();
        this.add(this.btnNewTabButton);
    }
    
    private void updateCurrentWidth()
    {
        int numberOfPossibleTabsWithMaxWidth = (this.getWidth()-this.btnNewTabButton.getWidth())/this.maxWidthOfTabs;
        
        if (this.numberOfTabs <= numberOfPossibleTabsWithMaxWidth)
        {
            return;
        } else {
            int workingSpace = this.getWidth()-this.btnNewTabButton.getWidth();
            this.currentWidthOfTabs = (int) Math.floor(workingSpace/this.numberOfTabs);
        }
    }
    
    private void updateAllTabs()
    {
        for (int i = 0; i < this.getComponentCount(); i++)
        {
            Component temp = this.getComponent(i);
            temp.setBounds(i*this.currentWidthOfTabs, temp.getY(), this.currentWidthOfTabs, temp.getHeight());
        }
    }
    
    private void updateNewTabBtn()
    {
        this.btnNewTabButton.setBounds(this.numberOfTabs*this.currentWidthOfTabs, 
                this.btnNewTabButton.getY(), this.btnNewTabButton.getWidth(), this.btnNewTabButton.getHeight());
    }
}
