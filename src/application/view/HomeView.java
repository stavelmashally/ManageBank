package application.view;

import application.util.Constants;
import application.view.components.ExitButton;
import application.view.components.MenuItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HomeView extends JFrame implements View, MouseListener, ActionListener {


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

        // Exit button
        btnExit = new ExitButton();
        btnExit.setBounds(952, 0, 48, 25);
        contentPane.add(btnExit);

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

        createMenu();
        createScreens();
    }

    @Override
    public void setListeners() {
        btnExit.addActionListener(this);
        btnExit.setActionCommand(Constants.EXIT_LABEL);
        accountsItem.addMouseListener(this);
        createAccountItem.addMouseListener(this);
        withdrawItem.addMouseListener(this);
        depositItem.addMouseListener(this);
    }

    @Override
    public void displayMessage(String msg) {

    }

    private void createMenu() {
        // Initiate menu panel
        menuIPanel = new JPanel();
        menuIPanel.setLayout(null);
        menuIPanel.setBackground(new Color(33, 150, 243));
        menuIPanel.setBounds(0, 0, 220, 700);
        contentPane.add(menuIPanel);

        // Menu logo
        lblLogo = new JLabel();
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
        accountsItem = new application.view.components.MenuItem(Constants.ACCOUNTS, Constants.ACCOUNTS_ICON, 100);
        createAccountItem = new application.view.components.MenuItem(Constants.CREATE_ACCOUNT, Constants.CREATE_ACCOUNT_ICON, 170);
        withdrawItem = new application.view.components.MenuItem(Constants.WITHDRAW, Constants.WITHDRAW_ICON, 240);
        depositItem = new application.view.components.MenuItem(Constants.DEPOSIT, Constants.DEPOSIT_ICON, 310);
        menuIPanel.add(accountsItem);
        menuIPanel.add(createAccountItem);
        menuIPanel.add(withdrawItem);
        menuIPanel.add(depositItem);
        

      
    }

    private void createScreens() {
        // Card view that shows the screens
        cards = new JPanel(new CardLayout(0, 0));
        cards.setBounds(220, 159, 780, 541);

        accountsView = new AccountsView();
        createAccountView = new CreateAccountView();
        withdrawView = new WithdrawView();
        depositView = new DepositView();

        // Adding the screens to the card view
        cards.add(accountsView, Constants.ACCOUNTS);
        cards.add(createAccountView, Constants.CREATE_ACCOUNT);
        cards.add(withdrawView, Constants.WITHDRAW);
        cards.add(depositView, Constants.DEPOSIT);
        contentPane.add(cards, BorderLayout.CENTER);
    }

    private void changeScreen(String screen, String screenTitle) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, screen);
        lblPath.setText(screen);
        lblTitle.setText(screenTitle);
        if (screen.equals(Constants.ACCOUNTS)){
            accountsView.showAccounts();
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(Constants.EXIT_LABEL)) {
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if (event.getComponent().equals(btnExit)) {
            System.exit(0);
        }
        switch (event.getComponent().getName()) {
            case Constants.ACCOUNTS:
                changeScreen(Constants.ACCOUNTS, Constants.ACCOUNTS_TITLE);
                break;
            case Constants.CREATE_ACCOUNT:
                changeScreen(Constants.CREATE_ACCOUNT, Constants.CREATE_ACCOUNT_TITLE);
                break;
            case Constants.WITHDRAW:
                changeScreen(Constants.WITHDRAW, Constants.WITHDRAW_TITLE);
                break;
            case Constants.DEPOSIT:
                changeScreen(Constants.DEPOSIT, Constants.DEPOSIT_TITLE);
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        if (event.getComponent() instanceof application.view.components.MenuItem) {
            JPanel parent = (JPanel) event.getSource();
            parent.setBackground(new Color(144, 202, 249));
            parent.revalidate();
        }
    }

    @Override
    public void mouseExited(MouseEvent event) {
        if (event.getComponent() instanceof MenuItem) {
            JPanel parent = (JPanel) event.getSource();
            parent.setBackground(null);
            parent.revalidate();
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
    }

    @Override
    public void mouseReleased(MouseEvent event) {
    }

    private AccountsView accountsView;
    private CreateAccountView createAccountView;
    private DepositView depositView;
    private WithdrawView withdrawView;
    private JPanel contentPane;
    private JPanel menuIPanel;
    private ExitButton btnExit;
    private JPanel titlePanel;
    private JLabel lblTitle;
    private JLabel lblPath;
    private JLabel lblHome;
    private JPanel cards;
    private application.view.components.MenuItem accountsItem;
    private application.view.components.MenuItem createAccountItem;
    private application.view.components.MenuItem withdrawItem;
    private application.view.components.MenuItem depositItem;
    private JLabel lblLogo;
    private JLabel lblManagebank;
}
