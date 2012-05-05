package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExecuteListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.MainFrame mainFrame = view.MainFrame.getInstance();
        String statement = mainFrame.getExecuteSQLDialog().getInput();
        System.out.println(statement);
        
        mainFrame.closeExecuteSQLDialog();
    }

}
