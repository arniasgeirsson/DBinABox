package view;

import javax.swing.JButton;

public class PaneButton extends JButton
{
    /**
     * Creates a new paneButton with no title
     */
    public PaneButton()
    {
        super();
    }
    
    /**
     * Creates a new paneButton with the desired title
     * @param title the desired title
     */
    public PaneButton(String title)
    {
        super(title);
    }
}
