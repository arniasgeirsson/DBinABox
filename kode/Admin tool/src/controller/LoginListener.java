package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        model.MainManager mainManager = model.MainManager.getInstance();
        view.LoginFrame loginFrame = mainManager.getCurrentLoginFrame();
        model.TabManager tabs = model.TabManager.getInstance();
        
        if (tabs.addTab(loginFrame.getUsername(), loginFrame.getPassword(), "", 0))
        {
            mainManager.addTab();
        } else {
            mainManager.wrongLogin();
        }
    }
}
