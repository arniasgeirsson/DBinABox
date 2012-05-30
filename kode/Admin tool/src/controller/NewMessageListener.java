package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.Timer;

import model.Message.MessageStatus;

public class NewMessageListener implements ActionListener
{
    private Timer flashTimer;
    private int timerCounter;
    private JTextField txtHistorikLine;
    
    private static NewMessageListener instance;
    
    public static NewMessageListener getInstance(){
        if(NewMessageListener.instance == null)
            NewMessageListener.instance = new NewMessageListener();
        return NewMessageListener.instance;
    }
    
    private NewMessageListener()
    {
        flashTimer = new Timer(0, this);
        this.txtHistorikLine = view.MainFrame.getInstance().getTxtHistorikLine();
    }
    
    
    public void newMessageAdded()
    {
        if (flashTimer.isRunning())
            flashTimer.stop();
        
        view.MainFrame.getInstance().updateMessage();
        if (model.MessageHandler.getInstance().getNewestMessage().getMessageStatus().equals(MessageStatus.BAD))
        {
            timerCounter = 0;
            flashTimer.setDelay(1000);
            flashTimer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        timerCounter++;
        
        if (timerCounter % 2 == 0)
            txtHistorikLine.setBackground(Color.white);
        else 
            txtHistorikLine.setBackground(new Color(255,0,0));

        if (timerCounter >= 5)
        {
            txtHistorikLine.setBackground(Color.white);
            flashTimer.stop();
        }
    }
    
}
