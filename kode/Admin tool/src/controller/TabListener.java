package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int selectedTab = 0;
        view.MainFrame mainFrame = view.MainFrame.getInstance();
        view.TabPanel tabPanel = mainFrame.getTabPanel();
        
        for (int i = 0; i < tabPanel.getNumberOfTabs(); i++)
        {
            if (e.getSource() == tabPanel.getTabButtonAt(i))
                selectedTab = i;
        }
        
        model.TabManager tabManager = model.TabManager.getInstance();
        tabManager.switchTab(selectedTab);
        
        mainFrame.updateWindowPanel();
        
    }

}
