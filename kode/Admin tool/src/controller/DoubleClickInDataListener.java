package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DoubleClickInDataListener implements MouseListener
{

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (e.getClickCount() > 1)
            view.MainFrame.getInstance().switchTooTablePanel();
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

}
