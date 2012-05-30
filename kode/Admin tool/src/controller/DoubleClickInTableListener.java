package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class DoubleClickInTableListener implements MouseListener
{

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (e.getClickCount() > 1)
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
        e.consume();
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        e.consume();
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        e.consume();        
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        e.consume();        
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        e.consume();        
    }

}
