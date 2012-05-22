package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class OpenTableListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.MainFrame mainFrame = view.MainFrame.getInstance();
        String tableName = mainFrame.getSelectedTableName();
        if (tableName != null)
        {
            model.TabManager.getInstance().getActiveTab().setTableName(tableName);
            mainFrame.switchTooDataViewPanel();
        } else {
            JOptionPane.showMessageDialog(mainFrame, "No table selected!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
