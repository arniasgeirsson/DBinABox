package view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class PanePanel extends JPanel
{

    /**
     * Create the panel.
     */
    public PanePanel()
    {
        setLayout(null);
        
        JButton btnNewButton = new JButton("+");
        btnNewButton.setBounds(0, 0, 40, 40);
        add(btnNewButton);

    }

}
