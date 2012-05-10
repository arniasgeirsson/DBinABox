package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistorikListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.MainFrame mainFrame = view.MainFrame.getInstance();
        
        if (mainFrame.isHistorikActive())
        {
            mainFrame.closeHistorik();
        } else {
            mainFrame.openHistorik();
        }
    }

}
