package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.FontMetrics;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HistorikPanel extends JPanel
{

    private int widthOfDateTimeArea;
    private int widthOfCreatorArea;
    private int widthOfTextArea;
    
//    Rigtig dårlig løsning!!!!!!
    private int widthOfOneChar = 8;
    
    /**
     * Create the panel.
     */
    public HistorikPanel(ArrayList<model.Message> allMessages)
    {
        this.setBounds(0, 0, 600, 455);
        setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 30, 600, 425);
        
        this.widthOfDateTimeArea = scrollPane.getWidth()/5;
        this.widthOfCreatorArea = this.widthOfDateTimeArea;
        this.widthOfTextArea = scrollPane.getWidth()-this.widthOfDateTimeArea-this.widthOfCreatorArea;
        
        JTextArea messageArea = new JTextArea();
        messageArea.setEditable(false);
        
        String messages = "";
        for (model.Message messageTemp : allMessages)
        {
            messages = messages.concat(this.createString(messageTemp));
        }
        messageArea.setText(messages);

        scrollPane.setViewportView(messageArea);
        add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("Current Historik:");
        lblNewLabel.setBounds(0, 0, 600, 30);
        add(lblNewLabel);
    }
    
    private String createString(model.Message message)
    {
        String build = "";
        String date = message.getDate();
        String time = message.getTime();
        String creator = message.getCreator();
        String text = message.getMessage();
        boolean done = false;
        
        while (!done)
        {
            if (date.length() > 0)
            {
                int endIndex = this.widthOfDateTimeArea/this.widthOfOneChar;
                if (endIndex > date.length())
                {
                    date = date + this.copyValueOf(" ", endIndex-date.length());
                }
                String temp = date.substring(0, endIndex);
                build = build.concat(temp);
                date = date.substring(endIndex);
            }
            else if (time.length() > 0)
            {
                int endIndex = this.widthOfDateTimeArea/this.widthOfOneChar;
                if (endIndex > time.length())
                {
                    time = time + this.copyValueOf(" ", endIndex-time.length());
                }
                String temp = time.substring(0, endIndex);
                build = build.concat(temp);
                time = time.substring(endIndex);
            }
            if (creator.length() > 0)
            {
                int endIndex = this.widthOfCreatorArea/this.widthOfOneChar;
                if (endIndex > creator.length())
                {
                    creator = creator + this.copyValueOf(" ", endIndex-creator.length());
                }
                String temp = creator.substring(0, endIndex);
                build = build.concat(temp);
                creator = creator.substring(endIndex);
            }
            if (text.length() > 0)
            {
                int endIndex = this.widthOfTextArea/this.widthOfOneChar;
                if (endIndex > text.length())
                {
                    text = text + this.copyValueOf(" ", endIndex-text.length());
                }
                String temp = text.substring(0, endIndex);
                build = build.concat(temp);
                text = text.substring(endIndex);
                
                build = build.concat("\n");
            }
            
            if (date.length() == 0 && time.length() == 0 && creator.length() == 0 && text.length() == 0)
                done = true;
        }
        build = build + "\n\n";
        return build;
    }

    private String copyValueOf(String string, int i)
    {
        String copied = "";
        for (int j = 0; j < i; j++)
            copied = copied + string;
        return copied;
    }
}
