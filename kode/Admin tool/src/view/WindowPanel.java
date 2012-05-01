package view;

import java.awt.Color;

import javax.swing.JPanel;

public class WindowPanel extends JPanel
{
    private DatabasePanel databasePanel;
    private TablePanel tablePanel;
    private DataPanel dataPanel;
    private LogPanel logPanel;
    
    /**
     * Creates a new windowPanel
     */
    public WindowPanel()
    {
        super();
        this.setBackground(Color.red);
    }
    
    /**
     * Changes the current view to a databasePanel
     */
    public void showDatabasePanel()
    {
        this.removeAll();
        this.add(new DatabasePanel());
    }
    
    /**
     * Changes the current view to a tabelPanel
     */
    public void showTablePanel()
    {
        this.removeAll();
        this.add(new TablePanel());
    }
    
    /**
     * Changes the current view to a dataPanel
     */
    public void showDataPanel()
    {
        this.removeAll();
        this.add(new DataPanel());
    }
    
    /**
     * Changes the current view to a logPanel
     */
    public void showLogPanel()
    {
        this.removeAll();
        this.add(new LogPanel());
    }
}
