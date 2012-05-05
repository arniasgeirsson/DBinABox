package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelExecuteListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.MainFrame.getInstance().closeExecuteSQLDialog();
    }

}
