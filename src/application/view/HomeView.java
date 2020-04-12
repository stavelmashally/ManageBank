package application.view;

import application.util.Constants;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HomeView extends JFrame implements View, MouseListener{

	private JPanel contentPane;
	private JPanel sidePanel;
	private JPanel titlePanel;
	private JLabel lblTitle;
	private JLabel lblPath;
	private JLabel lblHome;
	private JPanel cards;
	private JPanel itemAccounts;
	private JLabel IconAccounts;
	private JLabel lblAccounts;
	private JPanel itemCreateAccount;
	private JLabel IconAccountCreation;
	private JLabel lblCreateAccount;
	private JLabel lblManagebank;
	private JPanel itemTransaction;
	private JLabel IconTransaction;
	private JLabel lblTransaction;
	private JPanel itemLoans;
	private JLabel lblLoans;
	private JLabel IconLoans;
	private JLabel lblX;


	public HomeView() {
		setUndecorated(true);
		setSize(1000, 700);
		setLocationRelativeTo(null);
		initComponents();
		setListeners();
	}

	@Override
	public void initComponents() {

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// card view that shows the screens
		cards = new JPanel(new CardLayout(0, 0));
		cards.setBounds(220, 159, 780, 541);
		// adding the screens to the card view
		cards.add(new AccountBalanceView(), Constants.ACCOUNTS);
		cards.add(new AccountCreationView(), Constants.CREATE_ACCOUNT);
		cards.add(new TransactionsView(), Constants.TRANSACTION);
		cards.add(new LoansView(), Constants.LOANS);
		contentPane.add(cards, BorderLayout.CENTER);

		// home title
		titlePanel = new JPanel();
		titlePanel.setBounds(220, 43, 780, 116);
		titlePanel.setBackground(new Color(66,165,245));
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);

		lblTitle = new JLabel(Constants.ACCOUNTS_TITLE);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		lblTitle.setBounds(66, 57, 221, 32);
		titlePanel.add(lblTitle);

		lblHome = new JLabel("Home/");
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblHome.setBounds(66, 33, 58, 15);
		titlePanel.add(lblHome);

		lblPath = new JLabel(Constants.ACCOUNTS);
		lblPath.setForeground(Color.WHITE);
		lblPath.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPath.setBounds(119, 33, 135, 15);
		titlePanel.add(lblPath);

		// initiate Menu
		sidePanel = new JPanel();
		sidePanel.setBackground(new Color(33,150,243));
		sidePanel.setBounds(0, 0, 220, 700);
		sidePanel.setLayout(null);
		contentPane.add(sidePanel);

		// Exit label
		lblX = new JLabel(Constants.EXIT_LABEL);
		lblX.setFont(new Font("Dialog", Font.BOLD, 22));
		lblX.setForeground(new Color(33,150,243));
		lblX.setBackground(new Color(33,150,243));
		lblX.setBounds(971, 4, 17, 27);
		contentPane.add(lblX);

		// Menu logo
		lblManagebank = new JLabel(Constants.MENU_LOGO);
		lblManagebank.setForeground(Color.WHITE);
		lblManagebank.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 21));
		lblManagebank.setBounds(41, 34, 141, 38);
		sidePanel.add(lblManagebank);

		// Account Balance Menu item
		itemAccounts = new JPanel();
		itemAccounts.setBounds(0, 96, 220, 52);
		itemAccounts.setBackground(new Color(33,150,243));
		itemAccounts.setLayout(null);
		sidePanel.add(itemAccounts);
		
		IconAccounts = new JLabel();
		IconAccounts.setIcon(new ImageIcon(HomeView.class.getResource("/resources/accounts.png")));
		IconAccounts.setBounds(12, 8, 36, 34);
		itemAccounts.add(IconAccounts);
		
		lblAccounts = new JLabel(Constants.ACCOUNTS);
		lblAccounts.setForeground(new Color(255, 255, 255));
		lblAccounts.setBackground(new Color(255, 255, 255));
		lblAccounts.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAccounts.setBounds(59, 18, 149, 15);
		itemAccounts.add(lblAccounts);

		// Create Account Menu item
		itemCreateAccount = new JPanel();
		itemCreateAccount.setLayout(null);
		itemCreateAccount.setBackground(new Color(33,150,243));
		itemCreateAccount.setBounds(0, 148, 220, 52);
		sidePanel.add(itemCreateAccount);
		
		IconAccountCreation = new JLabel();
		IconAccountCreation.setIcon(new ImageIcon(HomeView.class.getResource("/resources/create_account.png")));
		IconAccountCreation.setBounds(12, 8, 36, 34);
		itemCreateAccount.add(IconAccountCreation);
		
		lblCreateAccount = new JLabel(Constants.CREATE_ACCOUNT);
		lblCreateAccount.setForeground(Color.WHITE);
		lblCreateAccount.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCreateAccount.setBackground(Color.WHITE);
		lblCreateAccount.setBounds(59, 18, 149, 15);
		itemCreateAccount.add(lblCreateAccount);

		// Transaction Menu item
		itemTransaction = new JPanel();
		itemTransaction.setLayout(null);
		itemTransaction.setBackground(new Color(33,150,243));
		itemTransaction.setBounds(0, 200, 220, 52);
		sidePanel.add(itemTransaction);
		
		IconTransaction = new JLabel();
		IconTransaction.setIcon(new ImageIcon(HomeView.class.getResource("/resources/transaction.png")));
		IconTransaction.setBounds(12, 8, 36, 34);
		itemTransaction.add(IconTransaction);
		
		lblTransaction = new JLabel(Constants.TRANSACTION);
		lblTransaction.setForeground(Color.WHITE);
		lblTransaction.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTransaction.setBackground(Color.WHITE);
		lblTransaction.setBounds(59, 18, 149, 15);
		itemTransaction.add(lblTransaction);

		// Loans Menu item
		itemLoans = new JPanel();
		itemLoans.setLayout(null);
		itemLoans.setBackground(new Color(33, 150, 243));
		itemLoans.setBounds(0, 252, 220, 52);
		sidePanel.add(itemLoans);
		
		IconLoans = new JLabel();
		IconLoans.setIcon(new ImageIcon(HomeView.class.getResource("/resources/loans.png")));
		IconLoans.setBounds(12, 8, 36, 34);
		itemLoans.add(IconLoans);
		
		lblLoans = new JLabel(Constants.LOANS);
		lblLoans.setForeground(Color.WHITE);
		lblLoans.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblLoans.setBackground(Color.WHITE);
		lblLoans.setBounds(59, 18, 149, 15);
		itemLoans.add(lblLoans);
	}

	@Override
	public void setListeners() {
		lblX.addMouseListener(this);
		itemAccounts.addMouseListener(this);
		itemCreateAccount.addMouseListener(this);
		itemTransaction.addMouseListener(this);
		itemLoans.addMouseListener(this);
	}

	private void changeScreen(String screen, String screenTitle){
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, screen);
		lblPath.setText(screen);
		lblTitle.setText(screenTitle);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent().equals(lblX)){
			System.exit(0);
		}
		if(e.getComponent().equals(itemAccounts)){
			changeScreen(Constants.ACCOUNTS, Constants.ACCOUNTS_TITLE);
		}
		if(e.getComponent().equals(itemCreateAccount)){
			changeScreen(Constants.CREATE_ACCOUNT, Constants.CREATE_ACCOUNT_TITLE);
		}
		if(e.getComponent().equals(itemTransaction)){
			changeScreen(Constants.TRANSACTION, Constants.TRANSACTION_TITLE);
		}
		if(e.getComponent().equals(itemLoans)){
			changeScreen(Constants.LOANS, Constants.LOANS_TITLE);
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
		if(e.getComponent() instanceof JPanel) {
			JPanel parent = (JPanel)e.getSource();
			parent.setBackground(new Color(144,202,249));
			parent.revalidate();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getComponent() instanceof JPanel) {
			JPanel parent = (JPanel)e.getSource();
			parent.setBackground(null);
			parent.revalidate();
		}
	}
}
