package model;

public class Message
{
    
    public enum MessageStatus {
        GOOD, BAD, NEUTRAL
    }
    
    private String creationDate;
    private String creationTime;
    private String creator;
    private String message;
    private MessageStatus status;
    private String uniqeId;
    
    public Message(String date, String time, String creator, String message, MessageStatus status)
    {
        this.creationDate = date;
        this.creationTime = time;
        this.creator = creator;
        this.message = message;
        this.status = status;
        this.uniqeId = date+time;
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
    
    public MessageStatus getMessageStatus()
    {
        return this.status;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uniqeId == null) ? 0 : uniqeId.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Message other = (Message) obj;
        if (uniqeId == null)
        {
            if (other.uniqeId != null)
                return false;
        } else if (!uniqeId.equals(other.uniqeId))
            return false;
        return true;
    }
}
