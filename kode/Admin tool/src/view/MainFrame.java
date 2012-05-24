package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

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
    private ExecuteSQLDialog dialog;
    private JPanel currentShowingPanel;
    
    private JButton btnOpenTable;
    private JButton btnCloseTable;
    private boolean isHistorikActive;
    private JButton btnHistorik;
    
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
        setResizable(false);
        setTitle("DB in a box - Admin Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel(){    
            @Override
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(4));
                g2.setColor(new Color(176, 176, 245));
//                g2.setColor(new Color(31, 127, 191));

                int winX = windowPanel.getX();
                int winY = windowPanel.getY();
                int winWidth = windowPanel.getWidth();
                int winHeight = windowPanel.getHeight();
                
                if (MainFrame.getInstance().isHistorikActive)
                {
//                    Horizontal l r
                    g2.drawLine(winX-3, winY-3, winX-3, txtHistorikLine.getY()+txtHistorikLine.getHeight()+3);
                    g2.drawLine(winX+3+winWidth, winY-3, winX+3+winWidth, txtHistorikLine.getY()+txtHistorikLine.getHeight()+3);
    
//                    Vertical t b
                    g2.drawLine(winX, winY-3, winX+winWidth, winY-3);
                    g2.drawLine(winX, txtHistorikLine.getY()+txtHistorikLine.getHeight()+3, winX+winWidth, txtHistorikLine.getY()+txtHistorikLine.getHeight()+3);
    
                } else {
//                  Horizontal l r
                    g2.drawLine(winX-3, tabPanel.getY()+tabPanel.getHeight()+2, winX-3, winY+winHeight+3);
                    g2.drawLine(winX+3+winWidth, tabPanel.getY()+tabPanel.getHeight()+2, winX+3+winWidth, winY+winHeight+3);
                    
//                  Vertical t b
                    g2.drawLine(winX, tabPanel.getY()+tabPanel.getHeight()+2, winX+winWidth, tabPanel.getY()+tabPanel.getHeight()+2);
                    g2.drawLine(winX, winY+3+winHeight, winX+winWidth, winY+3+winHeight);
                }
                
                g2.setStroke(new BasicStroke(1));
            }};
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnExecuteSql = new JButton("Execute SQL");
        btnExecuteSql.setBounds(624, 61, 120, 40);
        btnExecuteSql.addActionListener(new controller.OpenExecuteListener());
        contentPane.add(btnExecuteSql);
        
        this.btnOpenTable = new JButton("Open Table");
        btnOpenTable.setBounds(624, 122, 120, 40);
        btnOpenTable.addActionListener(new controller.OpenTableListener());
        contentPane.add(btnOpenTable);
        
        this.btnCloseTable = new JButton("Close Table");
        btnCloseTable.setBounds(624, 122, 120, 40);
        btnCloseTable.addActionListener(new controller.CloseTableListener());
        
        JButton btnPushImage = new JButton("Push image");
        btnPushImage.setBounds(624, 183, 120, 40);
        contentPane.add(btnPushImage);
        
        JLabel versionLabel = new JLabel("Admin Tool - Version 0.1");
        versionLabel.setBounds(639, 537, 135, 14);
        contentPane.add(versionLabel);
        
        txtHistorikLine = new JTextField();
        txtHistorikLine.setText("");
        txtHistorikLine.setBounds(10, 527, 580, 24);
        contentPane.add(txtHistorikLine);
        txtHistorikLine.setColumns(10);
        
        this.btnHistorik = new JButton("UP");
        btnHistorik.setBounds(589, 527, 20, 24);
        this.btnHistorik.addActionListener(new controller.HistorikListener());
        contentPane.add(btnHistorik);
        
        this.tabPanel = new TabPanel();
        tabPanel.setBounds(10, 11, 600, 40);
        contentPane.add(tabPanel);
        
        this.windowPanel = new JPanel();
        windowPanel.setBackground(Color.WHITE);
        windowPanel.setBounds(10, 61, 600, 455);
        this.windowPanel.setLayout(null);
        contentPane.add(windowPanel);
        
        JButton btnLogOut = new JButton("Log out");
        btnLogOut.setBounds(624, 234, 120, 40);
        btnLogOut.addActionListener(new controller.LogOutListener());
        contentPane.add(btnLogOut);
        
        this.isHistorikActive = false;
        this.updateWindowPanel();
    }
    
    public void addTab(String name)
    {
        this.tabPanel.addNewTab(name);
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
        this.currentShowingPanel = tabManager.getActiveTab().getActivePanel();
        this.windowPanel.add(this.currentShowingPanel);
        
        // d�rlig l�sning?
        if (this.currentShowingPanel.getClass() == view.TablePanel.class)
        {
            this.getContentPane().remove(this.btnCloseTable);
            this.getContentPane().add(this.btnOpenTable);
        } else if (this.currentShowingPanel.getClass() == view.DataViewPanel.class)
        {
            this.getContentPane().add(this.btnCloseTable);
            this.getContentPane().remove(this.btnOpenTable);
        }
        
        this.txtHistorikLine.setText("- " + model.MessageHandler.getInstance().getNewestMessage().getMessage());
        this.giveActiveTabColor();
        this.validate();
        this.repaint();
    }
    
    public void switchTooTablePanel()
    {
        model.TabManager tabManager = model.TabManager.getInstance();
        tabManager.getActiveTab().switchToTableView();
        this.updateWindowPanel();
    }
    
    public void switchTooDataViewPanel()
    {
        model.TabManager tabManager = model.TabManager.getInstance();
        tabManager.getActiveTab().switchToDataView();
        this.updateWindowPanel();
    }
    
    public void openHistorik()
    {
        this.windowPanel.removeAll();
        this.windowPanel.add(new HistorikPanel(model.MessageHandler.getInstance().getAllMessage()));
        this.isHistorikActive = true;
        this.btnHistorik.setText("D");
        this.removeActiveTabColor();
        this.validate();
        this.repaint();
    }
    
    public void closeHistorik()
    {
        this.isHistorikActive = false;
        this.btnHistorik.setText("U");
        this.updateWindowPanel();
    }
    
    public void showExecuteSQLDialog()
    {
        this.dialog = new ExecuteSQLDialog();
        dialog.setVisible(true);
    }
    
    public void closeExecuteSQLDialog()
    {
        dialog.setVisible(false);
    }
    
    public ExecuteSQLDialog getExecuteSQLDialog()
    {
        return this.dialog;
    }
    
    public String getSelectedTableName()
    {
        TablePanel tablePanel = (TablePanel) this.currentShowingPanel;
        return tablePanel.getSelectedTablename();
    }
    
    public boolean isHistorikActive()
    {
        return this.isHistorikActive;
    }
    
    public void giveActiveTabColor()
    {
        model.TabManager tabManager = model.TabManager.getInstance();
        int activeIndex = tabManager.getActiveTabIndex();
        
        for (int i = 0; i < this.tabPanel.getNumberOfTabs(); i++)
        {
            this.tabPanel.getTabButtonAt(i).setBackground(null);
            if (i == activeIndex)
                this.tabPanel.getTabButtonAt(i).setBackground(new Color(176, 176, 245));
        }
    }
    
    public void removeActiveTabColor()
    {
        for (int i = 0; i < this.tabPanel.getNumberOfTabs(); i++)
        {
            this.tabPanel.getTabButtonAt(i).setBackground(null);
        }
    }
}
