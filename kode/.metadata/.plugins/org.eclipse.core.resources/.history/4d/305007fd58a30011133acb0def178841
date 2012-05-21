package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener
{

    @Override
    public void keyPressed(KeyEvent e)
    {
        System.out.println("1");

        e.consume();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        System.out.println("2");
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            model.MainManager mainManager = model.MainManager.getInstance();
            view.LoginFrame loginFrame = mainManager.getCurrentLoginFrame();
            model.TabManager tabManager = model.TabManager.getInstance();
            
            if (tabManager.addTab(loginFrame.getUsername(), loginFrame.getPassword(), loginFrame.getPort(), loginFrame.getURL()))
            {
                mainManager.addTab();
            } else {
                mainManager.wrongLogin();
            }
        }
        e.consume();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        System.out.println("3");

        e.consume();
    }

}
