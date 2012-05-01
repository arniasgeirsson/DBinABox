package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JLabel;

public class TablePanel extends JPanel
{
    private JTable table;

    /**
     * Create the panel.
     */
    public TablePanel()
    {
        setLayout(null);
        
        table = new JTable();
        table.setBounds(0, 30, 580, 405);
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"Test 1 2 3j"},
                {"TestafdsfdTestafdsfdsfihsdakfjhsadkjfhsadkljfhsdakljfhskldjahfsjdkafnksdljafnjsdkanfjlanTestafdsfdsfihsdakfjhsadkjfhsadkljfhsdakljfhskldjahfsjdkafnksdljafnjsdkanfjlanTestafdsfdsfihsdakfjhsadkjfhsadkljfhsdakljfhskldjahfsjdkafnksdljafnjsdkanfjlansadTestafdsfdsfihsdakfjhsadkjfhsadkljfhsdakljfhskldjahfsjdkafnksdljafnjsdkanfjlansfihsdakfjhsadkjfhsadkljfhsdakljfhskldjahfsjdkafnksdljafnjsdkanfjlan"},
                {"ij"},
                {"kljn"},
                {"lkjn"},
                {"kljn"},
                {"kjln"},
                {"jkln"},
                {"kljn"},
                {"jkn"},
                {"jnj"},
                {"5555555"},
                {null},
                {"jn"},
                {"jn"},
                {null},
                {"in"},
                {"ij"},
                {"i"},
                {"i"},
            },
            new String[] {
                "Tables"
            }
        ));
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(119);
        table.getColumnModel().getColumn(0).setMinWidth(40);
        add(table);
        
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBounds(580, 30, 20, 425);
        add(scrollBar);
        
        JScrollBar scrollBar_1 = new JScrollBar();
        scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
        scrollBar_1.setBounds(0, 435, 580, 20);
        add(scrollBar_1);
        
        JLabel lblNewLabel = new JLabel("List of all Tables (attributes)");
        lblNewLabel.setBounds(0, 0, 600, 30);
        add(lblNewLabel);

    }
}
