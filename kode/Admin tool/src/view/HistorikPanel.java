package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

public class HistorikPanel extends JPanel
{

    /**
     * Create the panel.
     */
    public HistorikPanel(ArrayList<String> allMessages)
    {
        this.setBounds(0, 0, 600, 455);
        setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 30, 600, 425);
        
        JTextArea messageArea = new JTextArea();
        messageArea.setEditable(false);
        scrollPane.setViewportView(messageArea);
        add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("Current Historik:");
        lblNewLabel.setBounds(0, 0, 600, 30);
        add(lblNewLabel);
    }
}
