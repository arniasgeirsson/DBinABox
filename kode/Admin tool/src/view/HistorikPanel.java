package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class HistorikPanel extends JPanel
{

    /**
     * Create the panel.
     */
    public HistorikPanel()
    {
        setBackground(Color.BLACK);
        this.setBounds(0, 0, 600, 455);

        setLayout(null);
        
        JLabel lblHistorik = new JLabel("Current historik:");
        lblHistorik.setFont(new Font("Tahoma", Font.ITALIC, 18));
        lblHistorik.setForeground(Color.GREEN);
        lblHistorik.setBackground(Color.YELLOW);
        lblHistorik.setBounds(0, 0, 600, 30);
        add(lblHistorik);

    }

}
