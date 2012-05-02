package view;

import javax.swing.JButton;

public class TabButton extends JButton
{
    /**
     * Creates a new paneButton with no title
     */
    public TabButton()
    {
        super();
    }
    
    /**
     * Creates a new paneButton with the desired title
     * @param title the desired title
     */
    public TabButton(String title)
    {
        super(title);
    }
}
