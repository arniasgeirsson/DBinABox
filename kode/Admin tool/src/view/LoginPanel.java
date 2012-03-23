package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginPanel extends JPanel
{
    private JButton loginButton;
    private JTextArea usernameText;
    private JTextArea passwordText;
    private JTextField username;
    private JTextField password;

    /**
     * Creates a new loginPanel
     */
    public LoginPanel()
    {
        super();

        this.loginButton = new JButton("Login");
        this.usernameText = new JTextArea("Username");
        this.passwordText = new JTextArea("Password");
        this.username = new JTextField(20);
        this.password = new JTextField(20);
        
        this.add(this.loginButton);
        this.add(this.usernameText);
        this.add(this.username);
        this.add(this.passwordText);
        this.add(this.password);
    }
}
