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
    public DataViewPanel(Object[][] allData, String[] attributes)
    {
        setLayout(null);
        this.setBounds(0, 0, 600, 455);
        
        JLabel lblAllDataOf = new JLabel("All Data of a specific tabel");
        lblAllDataOf.setBounds(0, 0, 600, 30);
        add(lblAllDataOf);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(allData, attributes));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane pane = new JScrollPane(this.table);
        pane.setBounds(0, 30, 600, 405);

        this.add(pane);
        
    }
}
