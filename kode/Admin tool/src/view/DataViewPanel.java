package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataViewPanel extends JPanel
{
    private JTable table;

    /**
     * Create the panel.
     */
    public DataViewPanel()
    {
        setLayout(null);
        this.setBounds(0, 0, 600, 455);
        
        JLabel lblAllDataOf = new JLabel("All Data of a specific tabel");
        lblAllDataOf.setBounds(0, 0, 600, 30);
        add(lblAllDataOf);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {1, 2, "Test"},
                {4, null, "assa"},
                {null, null, null},
                {null, 5, null},
                {"123", null, null},
            },
            new String[] {
                "New column", "New column", "New column"
            }
        ));
        JScrollPane pane = new JScrollPane(this.table);
        pane.setBounds(0, 30, 600, 405);

        this.add(pane);
        
    }
}
