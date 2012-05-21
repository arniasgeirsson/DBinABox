package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LoginFrame extends JFrame
{

    private JPanel contentPane;
    private JPasswordField password;
    private JTextField username;
    private JTextField port;
    private JTextField url;
    private JLabel lblWrongLoginInfo;
    
    /**
     * Create the frame.
     */
    public LoginFrame()
    {
        setResizable(false);
        setTitle("Login");
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        this.setBackground(Color.white);
        contentPane.setLayout(null);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(319, 228, 89, 23);
        contentPane.add(btnLogin);
        btnLogin.addActionListener(new controller.LoginListener());
        
        password = new JPasswordField();
        password.setBounds(161, 76, 235, 23);
        contentPane.add(password);
        
        username = new JTextField();
        username.setBounds(161, 42, 235, 23);
        contentPane.add(username);
        username.setColumns(10);
        
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
        
        port = new JTextField();
        port.setBounds(161, 110, 235, 23);
        port.setColumns(10);
        contentPane.add(port);
        
        url = new JTextField();
        url.setBounds(161, 144, 235, 23);
        url.setColumns(10);
        contentPane.add(url);
        
        this.lblWrongLoginInfo = new JLabel("");
        lblWrongLoginInfo.setHorizontalAlignment(SwingConstants.LEFT);
        lblWrongLoginInfo.setBounds(40, 178, 356, 39);
        contentPane.add(lblWrongLoginInfo);
    }
    
    public String getPassword(){
        return new String(this.password.getPassword());
    }
    
    public String getUsername(){
        return this.username.getText();
    }
    
    public String getPort()
    {
        return this.port.getText();
    }
    
    public String getURL()
    {
        return this.url.getText();
    }
    
    public void setWrongLoginInfo(String error)
    {
        this.lblWrongLoginInfo.setText(error);
        this.lblWrongLoginInfo.setToolTipText(error);
    }
}
