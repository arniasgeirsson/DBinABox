package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LoginPanel extends JFrame
{

    private JPanel contentPane;
    private JPasswordField passwordField;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

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
                    LoginPanel frame = new LoginPanel();
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
    public LoginPanel()
    {
        setResizable(false);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        this.setBackground(Color.white);
        contentPane.setLayout(null);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(319, 228, 89, 23);
        contentPane.add(btnLogin);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(161, 76, 235, 23);
        contentPane.add(passwordField);
        
        textField = new JTextField();
        textField.setBounds(161, 42, 235, 23);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(40, 42, 89, 23);
        lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblUsername);
        
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(40, 76, 89, 23);
        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblPassword);
        
        JLabel lblPort = new JLabel("Port:");
        lblPort.setBounds(40, 110, 89, 23);
        lblPort.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblPort);
        
        JLabel lblUrl = new JLabel("URL:");
        lblUrl.setBounds(40, 144, 89, 30);
        lblUrl.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblUrl);
        
        textField_1 = new JTextField();
        textField_1.setBounds(161, 110, 235, 23);
        textField_1.setColumns(10);
        contentPane.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setBounds(161, 144, 235, 23);
        textField_2.setColumns(10);
        contentPane.add(textField_2);
    }
}
