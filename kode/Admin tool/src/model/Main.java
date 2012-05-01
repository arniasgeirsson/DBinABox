package model;

import java.awt.EventQueue;

public class Main
{
    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        model.Login login = new model.Login();
        boolean bla = login.tryLogin("SYSTEM", "CarharttDatabase");
        System.out.println(bla);
        
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    view.LoginFrame frame = new view.LoginFrame();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
