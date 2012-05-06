package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExecuteListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.MainFrame mainFrame = view.MainFrame.getInstance();
        String query = mainFrame.getExecuteSQLDialog().getInput();
        model.SQLManager.getInstance().ExecuteSql(model.TabManager.getInstance().getActiveTab(), query);
        mainFrame.updateWindowPanel();
        mainFrame.closeExecuteSQLDialog();
    }

}
