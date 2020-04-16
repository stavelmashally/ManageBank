package application.view;

import application.util.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HomeView extends JFrame implements View, MouseListener {

    private JPanel contentPane;
    private JPanel menuIPanel;
    private JPanel titlePanel;
    private JLabel lblTitle;
    private JLabel lblPath;
    private JLabel lblHome;
    private JPanel cards;
    private MenuItem accountsItem;
    private MenuItem createAccountItem;
    private MenuItem transactionItem;
    private MenuItem loansItem;
    private JLabel lblManagebank;
    private JLabel lblExit;

    public HomeView() {
        setUndecorated(true);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        initComponents();
        setListeners();
    }

    @Override
    public void initComponents() {

        // Main panel
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // home title
        titlePanel = new JPanel(null);
        titlePanel.setBounds(220, 43, 780, 116);
        titlePanel.setBackground(new Color(66, 165, 245));
        contentPane.add(titlePanel);

        lblTitle = new JLabel(Constants.ACCOUNTS_TITLE);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font(Constants.APP_FONT, Font.PLAIN, 21));
        lblTitle.setBounds(66, 57, 221, 32);
        titlePanel.add(lblTitle);

        lblHome = new JLabel(Constants.BASE_PATH);
        lblHome.setForeground(Color.WHITE);
        lblHome.setFont(new Font(Constants.APP_FONT, Font.BOLD, 16));
        lblHome.setBounds(66, 33, 58, 15);
        titlePanel.add(lblHome);

        lblPath = new JLabel(Constants.ACCOUNTS);
        lblPath.setForeground(Color.WHITE);
        lblPath.setFont(new Font(Constants.APP_FONT, Font.BOLD, 16));
        lblPath.setBounds(119, 33, 135, 15);
        titlePanel.add(lblPath);

        // Exit label
        lblExit = new JLabel(Constants.EXIT_LABEL);
        lblExit.setFont(new Font(Constants.APP_FONT, Font.BOLD, 22));
        lblExit.setForeground(new Color(33, 150, 243));
        lblExit.setBounds(971, 4, 17, 27);
        contentPane.add(lblExit);

        createMenu();
        createScreens();
    }

    @Override
    public void setListeners() {
        lblExit.addMouseListener(this);
        accountsItem.addMouseListener(this);
        createAccountItem.addMouseListener(this);
        transactionItem.addMouseListener(this);
        loansItem.addMouseListener(this);
    }

    private void createMenu() {
        // Initiate menu panel
        menuIPanel = new JPanel();
        menuIPanel.setLayout(null);
        menuIPanel.setBackground(new Color(33, 150, 243));
        menuIPanel.setBounds(0, 0, 220, 700);
        contentPane.add(menuIPanel);

        // Menu logo
        JLabel lblLogo = new JLabel();
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setIcon(new ImageIcon(HomeView.class.getResource(Constants.LOGO_ICON)));
        lblLogo.setBounds(0, 12, 220, 63);
        menuIPanel.add(lblLogo);
        
        lblManagebank = new JLabel(Constants.MENU_LOGO_LABEL);
        lblManagebank.setHorizontalAlignment(SwingConstants.CENTER);
        lblManagebank.setBounds(0, 54, 220, 44);
        lblManagebank.setForeground(Color.WHITE);
        lblManagebank.setFont(new Font(Constants.APP_FONT, Font.BOLD | Font.ITALIC, 21));
        menuIPanel.add(lblManagebank);

        // Create menu items
        accountsItem = new MenuItem(Constants.ACCOUNTS, Constants.ACCOUNTS_ICON, 100);
        createAccountItem = new MenuItem(Constants.CREATE_ACCOUNT, Constants.CREATE_ACCOUNT_ICON, 170);
        transactionItem = new MenuItem(Constants.TRANSACTION, Constants.TRANSACTION_ICON, 240);
        loansItem = new MenuItem(Constants.LOANS, Constants.LOANS_ICON, 310);
        menuIPanel.add(accountsItem);
        menuIPanel.add(createAccountItem);
        menuIPanel.add(transactionItem);
        menuIPanel.add(loansItem);
    }

    private void createScreens() {
        // Card view that shows the screens
        cards = new JPanel(new CardLayout(0, 0));
        cards.setBounds(220, 159, 780, 541);

        // Adding the screens to the card view
        cards.add(new AccountsView(), Constants.ACCOUNTS);
        cards.add(new CreateAccountView(), Constants.CREATE_ACCOUNT);
        cards.add(new TransactionView(), Constants.TRANSACTION);
        cards.add(new LoansView(), Constants.LOANS);
        contentPane.add(cards, BorderLayout.CENTER);
    }

    private void changeScreen(String screen, String screenTitle) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, screen);
        lblPath.setText(screen);
        lblTitle.setText(screenTitle);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent().equals(lblExit)) {
            System.exit(0);
        }
        switch (e.getComponent().getName()) {
            case Constants.ACCOUNTS:
                changeScreen(Constants.ACCOUNTS, Constants.ACCOUNTS_TITLE);
                break;
            case Constants.CREATE_ACCOUNT:
                changeScreen(Constants.CREATE_ACCOUNT, Constants.CREATE_ACCOUNT_TITLE);
                break;
            case Constants.TRANSACTION:
                changeScreen(Constants.TRANSACTION, Constants.TRANSACTION_TITLE);
                break;
            case Constants.LOANS:
                changeScreen(Constants.LOANS, Constants.LOANS_TITLE);
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getComponent() instanceof MenuItem) {
            JPanel parent = (JPanel) e.getSource();
            parent.setBackground(new Color(144, 202, 249));
            parent.revalidate();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getComponent() instanceof MenuItem) {
            JPanel parent = (JPanel) e.getSource();
            parent.setBackground(null);
            parent.revalidate();
        }
    }
}
