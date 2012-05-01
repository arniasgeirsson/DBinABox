package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        view.LoginFrame frame = view.MainFrameTest.getInstance().getLoginFrame();
        model.TabManager tabs =  model.TabManager.getInstance();
        System.out.println(tabs.addTab(frame.getUsername(), frame.getPassword(), "", 0));
    }

}
