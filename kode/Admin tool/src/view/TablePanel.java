package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class TablePanel extends JPanel
{
    private JTable table;

    /**
     * Create the panel.
     */
    public TablePanel(String[][] tables)
    {
        setLayout(null);
        this.setBounds(0, 0, 600, 455);
        table = new JTable();
        table.setModel(new DefaultTableModel(tables, new String[] {"Tables"}));
        
        JScrollPane pane = new JScrollPane(this.table);
        pane.setBounds(0, 30, 600, 405);

        add(pane);
        JLabel lblNewLabel = new JLabel("List of all Tables (attributes)");
        lblNewLabel.setBounds(0, 0, 600, 30);
        add(lblNewLabel);
    }
}
