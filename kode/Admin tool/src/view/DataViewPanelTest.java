package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;

public class DataViewPanelTest extends JPanel
{
    private JTable table;

    /**
     * Create the panel.
     */
    public DataViewPanelTest()
    {
        setLayout(null);
        
        JLabel lblAllDataOf = new JLabel("All Data of a specific tabel");
        lblAllDataOf.setBounds(0, 0, 600, 30);
        add(lblAllDataOf);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
            },
            new String[] {
                "New column", "New column", "New column"
            }
        ));
        table.setBounds(0, 30, 580, 405);
        add(table);
        
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBounds(580, 30, 20, 425);
        add(scrollBar);
        
        JScrollBar scrollBar_1 = new JScrollBar();
        scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
        scrollBar_1.setBounds(0, 435, 580, 20);
        add(scrollBar_1);

    }
}
