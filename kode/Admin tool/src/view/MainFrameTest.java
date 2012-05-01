package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrameTest extends JFrame
{

    private JPanel contentPane;
    private JTextField txtTabletest;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    MainFrameTest frame = new MainFrameTest();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainFrameTest()
    {
        setTitle("DB in a box - Admin Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnExecuteSql = new JButton("Execute SQL");
        btnExecuteSql.setBounds(624, 61, 120, 40);
        contentPane.add(btnExecuteSql);
        
        JButton btnOpen = new JButton("Open");
        btnOpen.setBounds(624, 122, 120, 40);
        contentPane.add(btnOpen);
        
        JButton btnPushImage = new JButton("Push image");
        btnPushImage.setBounds(624, 183, 120, 40);
        contentPane.add(btnPushImage);
        
        TablePanelTest tablePanelTest = new TablePanelTest();
        tablePanelTest.setBounds(10, 61, 600, 455);
        contentPane.add(tablePanelTest);
        
        JLabel lblAdminTool = new JLabel("Admin Tool - Version 0.1");
        lblAdminTool.setBounds(639, 537, 135, 14);
        contentPane.add(lblAdminTool);
        
        txtTabletest = new JTextField();
        txtTabletest.setText("- Table \"Test1\" created");
        txtTabletest.setBounds(10, 527, 580, 24);
        contentPane.add(txtTabletest);
        txtTabletest.setColumns(10);
        
        JButton btnNewButton = new JButton("UP");
        btnNewButton.setBounds(589, 527, 20, 24);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.setBounds(10, 11, 50, 40);
        contentPane.add(btnNewButton_1);
        
        JButton btnForward = new JButton("Forward");
        btnForward.setBounds(70, 11, 50, 40);
        contentPane.add(btnForward);
        
        PanePanelTest panePanelTest = new PanePanelTest();
        panePanelTest.setBounds(130, 11, 480, 40);
        contentPane.add(panePanelTest);
    }
}
