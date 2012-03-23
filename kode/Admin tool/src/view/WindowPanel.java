package view;

import java.awt.Color;

import javax.swing.JPanel;

public class WindowPanel extends JPanel
{
    public WindowPanel()
    {
        super();
        this.setBackground(Color.red);
    }
    
    
    public void showDatabasePanel()
    {
        this.add(new DatabasePanel());
    }
    
    public void showTabelPanel()
    {
        this.add(new TablePanel());
    }
    
    public void showDataPanel()
    {
        this.add(new DataPanel());
    }
    
    public void showLogPanel()
    {
        this.add(new LogPanel());
    }
}
