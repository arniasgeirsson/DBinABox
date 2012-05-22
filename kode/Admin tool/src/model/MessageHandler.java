package model;

import java.util.ArrayList;

public class MessageHandler
{
    private Message newestMessage;
    private ArrayList<Message> allMessages;    
    
    private static MessageHandler instance;
    
    public static MessageHandler getInstance(){
        if(MessageHandler.instance == null)
            MessageHandler.instance = new MessageHandler();
        return MessageHandler.instance;
    }
    
    private MessageHandler()
    {
        this.newestMessage = new Message("", "", "", "");
        this.allMessages = new ArrayList<Message>();
    }
    
    public void addMessage(Message newMessage)
    {
        this.newestMessage = newMessage;
        this.allMessages.add(newMessage);
    }
    
    public Message getNewestMessage()
    {
        return this.newestMessage;
    }
    
    public ArrayList<Message> getAllMessage()
    {
        return this.allMessages;
    }
}
