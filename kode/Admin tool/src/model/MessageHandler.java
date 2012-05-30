package model;

import java.util.ArrayList;

import model.Message.MessageStatus;

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
        this.newestMessage = new Message("", "", "", "", MessageStatus.NEUTRAL);
        this.allMessages = new ArrayList<Message>();
    }
    
    public void addMessage(Message newMessage)
    {
        this.newestMessage = newMessage;
        this.allMessages.add(newMessage);
        controller.NewMessageListener.getInstance().newMessageAdded();
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
