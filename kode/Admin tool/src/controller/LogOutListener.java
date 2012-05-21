package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogOutListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.MainFrame mainFrame = view.MainFrame.getInstance();
        model.TabManager tabManager = model.TabManager.getInstance();
        mainFrame.removeTab(tabManager.getActiveTabIndex());
        
        tabManager.removeActiveTab();
        if (tabManager.getActiveTabIndex() >= 0)
            mainFrame.updateWindowPanel();
        else {
            mainFrame.setVisible(false);
            model.MainManager.getInstance().newLogin();
        }
    }

}
