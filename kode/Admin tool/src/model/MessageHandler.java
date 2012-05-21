package model;

import java.util.ArrayList;

public class MessageHandler
{
    private String newestMessage;
    private ArrayList<String> allMessages;    
    
    private static MessageHandler instance;
    
    public static MessageHandler getInstance(){
        if(MessageHandler.instance == null)
            MessageHandler.instance = new MessageHandler();
        return MessageHandler.instance;
    }
    
    private MessageHandler()
    {
        
    }
    
    public void addMessage(String newMessage)
    {
        this.newestMessage = newMessage;
        this.allMessages.add(newMessage);
    }
}
