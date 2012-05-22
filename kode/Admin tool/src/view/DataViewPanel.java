package view;

import java.awt.Color;

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
    public DataViewPanel(Object[][] allData, String[] attributes, String tableName)
    {
        setLayout(null);
        this.setBounds(0, 0, 600, 455);
        
        JLabel lblAllDataOf = new JLabel("All Data of a specific tabel: "+tableName);
        lblAllDataOf.setBounds(0, 0, 600, 30);
        add(lblAllDataOf);
        
        table = new JTable(){
            private static final long serialVersionUID = 4187721687527079795L;

            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        table.setModel(new DefaultTableModel(allData, attributes));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane pane = new JScrollPane(this.table);
        pane.setBounds(0, 30, 600, 425);

        this.add(pane);
        
    }
}
