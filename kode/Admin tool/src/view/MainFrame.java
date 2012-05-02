package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame extends JFrame
{

    private JPanel contentPane;
    private JTextField txtHistorikLine;
    private TabPanel tabPanel;
    private JPanel windowPanel;
    
    private static MainFrame instance;
    
    public static MainFrame getInstance(){
        if(MainFrame.instance == null)
            MainFrame.instance = new MainFrame();
        return MainFrame.instance;
    }

    /**
     * Create the frame.
     */
    private MainFrame()
    {
        setTitle("DB in a box - Admin Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnExecuteSql = new JButton("Execute SQL");
        btnExecuteSql.setBounds(624, 61, 120, 40);
        contentPane.add(btnExecuteSql);
        
        JButton btnOpen = new JButton("Open");
        btnOpen.setBounds(624, 122, 120, 40);
        btnOpen.addActionListener(new controller.OpenListener());
        contentPane.add(btnOpen);
        
        JButton btnPushImage = new JButton("Push image");
        btnPushImage.setBounds(624, 183, 120, 40);
        contentPane.add(btnPushImage);
        
        JLabel versionLabel = new JLabel("Admin Tool - Version 0.1");
        versionLabel.setBounds(639, 537, 135, 14);
        contentPane.add(versionLabel);
        
        txtHistorikLine = new JTextField();
        txtHistorikLine.setText("- Table \"Test1\" created");
        txtHistorikLine.setBounds(10, 527, 580, 24);
        contentPane.add(txtHistorikLine);
        txtHistorikLine.setColumns(10);
        
        JButton btnHistorik = new JButton("UP");
        btnHistorik.setBounds(589, 527, 20, 24);
        contentPane.add(btnHistorik);
        
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(10, 11, 50, 40);
        contentPane.add(btnBack);
        
        JButton btnForward = new JButton("Forward");
        btnForward.setBounds(70, 11, 50, 40);
        contentPane.add(btnForward);
        
        this.tabPanel = new TabPanel();
        tabPanel.setBounds(130, 11, 480, 40);
        contentPane.add(tabPanel);
        
        this.windowPanel = new JPanel();
        //windowPanel.setBackground(Color.WHITE);
        windowPanel.setBounds(10, 61, 600, 455);
        this.windowPanel.setLayout(null);
        contentPane.add(windowPanel);
        
        JButton btnLogOut = new JButton("Log out");
        btnLogOut.setBounds(624, 234, 120, 40);
        btnLogOut.addActionListener(new controller.LogOutListener());
        contentPane.add(btnLogOut);
        
        this.updateWindowPanel();
    }
    
    public void addTab()
    {
        this.tabPanel.addNewTab();
        this.updateWindowPanel();
    }
    
    public void removeTab(int index)
    {
        this.tabPanel.removeTab(index);
    }
    
    public TabPanel getTabPanel()
    {
        return this.tabPanel;
    }
    
    public void updateWindowPanel()
    {
        this.windowPanel.removeAll();
        model.TabManager tabManager = model.TabManager.getInstance();
        this.windowPanel.add(tabManager.getCurrentTab().getActivePanel());
        this.validate();
        this.repaint();
    }
    
    public void switchTooTablePanel()
    {
        model.TabManager tabManager = model.TabManager.getInstance();
        tabManager.getCurrentTab().switchToTableView();
        this.updateWindowPanel();
    }
    
    public void switchTooDataViewPanel()
    {
        model.TabManager tabManager = model.TabManager.getInstance();
        tabManager.getCurrentTab().switchToDataView();
        this.updateWindowPanel();
    }
    
    public void openHistorik()
    {
        this.windowPanel.removeAll();
        this.windowPanel.add(new HistorikPanel());
        this.validate();
        this.repaint();
    }
    
    public void closeHistorik()
    {
        this.windowPanel.removeAll();
        this.updateWindowPanel();
    }
}
