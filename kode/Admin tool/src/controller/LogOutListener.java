package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogOutListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.MainFrame mainFrame = view.MainFrame.getInstance();
        mainFrame.removeTab(model.TabManager.getInstance().getCurrentTabIndex());
        
        model.TabManager.getInstance().removeCurrentTab();
        mainFrame.updateWindowPanel();
    }

}
