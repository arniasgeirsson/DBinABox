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
        table = new JTable(){
            private static final long serialVersionUID = -1776467914450089355L;

            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        table.setModel(new DefaultTableModel(tables, new String[] {"Tables"}));
        
        JScrollPane pane = new JScrollPane(this.table);
        pane.setBounds(0, 30, 600, 425);

        add(pane);
        JLabel lblNewLabel = new JLabel("List of all Tables (attributes)");
        lblNewLabel.setBounds(0, 0, 600, 30);
        add(lblNewLabel);
    }
    
    public String getSelectedTablename()
    {
        int row = this.table.getSelectionModel().getLeadSelectionIndex();
        int column = this.table.getColumnModel().getSelectionModel().getLeadSelectionIndex();
        if (row >= 0 && column >= 0)
            return (String) this.table.getModel().getValueAt(row, column);
        else
            return null;
    }
    
}
