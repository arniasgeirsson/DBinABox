package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenTableListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.MainFrame mainFrame = view.MainFrame.getInstance();
        model.TabManager.getInstance().getActiveTab().setTableName(mainFrame.getSelectedTableName());                
        mainFrame.switchTooDataViewPanel();        
    }

}
