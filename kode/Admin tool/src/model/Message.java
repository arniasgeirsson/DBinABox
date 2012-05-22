package model;

public class Message
{
    private String creationDate;
    private String creationTime;
    private String creator;
    private String message;
    
    public Message(String date, String time, String creator, String message)
    {
        this.creationDate = date;
        this.creationTime = time;
        this.creator = creator;
        this.message = message;
    }
    
    public String getDate()
    {
        return this.creationDate;
    }
    
    public String getTime()
    {
        return this.creationTime;
    }
    
    public String getCreator()
    {
        return this.creator;
    }
    
    public String getMessage()
    {
        return this.message;
    }
}
