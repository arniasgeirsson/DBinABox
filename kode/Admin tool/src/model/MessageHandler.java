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
        this.newestMessage = "";
        this.allMessages = new ArrayList<String>();
    }
    
    public void addMessage(String newMessage)
    {
        this.newestMessage = newMessage;
        this.allMessages.add(newMessage);
    }
    
    public String getNewestMessage()
    {
        return this.newestMessage;
    }
    
    public ArrayList<String> getAllMessage()
    {
        return this.allMessages;
    }
}
