package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ExecuteSQLDialog extends JDialog
{

    private final JPanel contentPanel = new JPanel();
    private JTextArea sqlStatement;

    /**
     * Create the dialog.
     */
    public ExecuteSQLDialog()
    {
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JLabel lblNewLabel = new JLabel("Statement:");
            lblNewLabel.setBounds(10, 0, 414, 22);
            contentPanel.add(lblNewLabel);
        }
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 22, 414, 196);
        
        this.sqlStatement = new JTextArea();
        sqlStatement.setBounds(10, 22, 414, 196);
        scrollPane.getViewport().add(sqlStatement);
        contentPanel.add(scrollPane);

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton executeButton = new JButton("Execute");
                executeButton.setActionCommand("OK");
                executeButton.addActionListener(new controller.ExecuteListener());
                buttonPane.add(executeButton);
                getRootPane().setDefaultButton(executeButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new controller.CancelExecuteListener());
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
    
    public String getInput()
    {
        return this.sqlStatement.getText();
    }
}
