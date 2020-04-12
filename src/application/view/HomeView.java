package application.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HomeView extends JFrame implements View, MouseListener{

	final static String ACCOUNT_BALANCE = "Account Balance";
	final static String CREATE_ACCOUNT = "Create Account";
	final static String TRANSACTION = "Transaction";
	
	private JPanel contentPane;
	private JPanel sidePanel;
	private JPanel cards;
	private JPanel itemAccountBalance;
	private JLabel IconAccountBalance;
	private JLabel lblAccountBalance;
	private JPanel itemCreateAccount;
	private JLabel IconAccountCreation;
	private JLabel lblCreateAccount;
	private JLabel lblManagebank;
	private JPanel itemTransaction;
	private JLabel IconTransaction;
	private JLabel lblTransaction;
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

		// initiate Menu
		sidePanel = new JPanel();
		sidePanel.setBackground(new Color(33,150,243));
		sidePanel.setBounds(0, 0, 220, 700);
		sidePanel.setLayout(null);
		contentPane.add(sidePanel);

		// Exit label
		lblX = new JLabel("X");
		lblX.setFont(new Font("Dialog", Font.BOLD, 22));
		lblX.setForeground(new Color(33,150,243));
		lblX.setBackground(new Color(33,150,243));
		lblX.setBounds(971, 4, 17, 27);
		contentPane.add(lblX);

		// Menu logo
		lblManagebank = new JLabel("ManageBank");
		lblManagebank.setForeground(Color.WHITE);
		lblManagebank.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 21));
		lblManagebank.setBounds(41, 23, 141, 38);
		sidePanel.add(lblManagebank);

		// Account Balance Menu item
		itemAccountBalance = new JPanel();
		itemAccountBalance.setBounds(0, 87, 220, 52);
		itemAccountBalance.setBackground(new Color(33,150,243));
		itemAccountBalance.setLayout(null);
		sidePanel.add(itemAccountBalance);
		
		IconAccountBalance = new JLabel("icon");
		IconAccountBalance.setIcon(new ImageIcon(HomeView.class.getResource("/resources/account_balance.png")));
		IconAccountBalance.setBounds(12, 8, 36, 34);
		itemAccountBalance.add(IconAccountBalance);
		
		lblAccountBalance = new JLabel(ACCOUNT_BALANCE);
		lblAccountBalance.setForeground(new Color(255, 255, 255));
		lblAccountBalance.setBackground(new Color(255, 255, 255));
		lblAccountBalance.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAccountBalance.setBounds(59, 18, 149, 15);
		itemAccountBalance.add(lblAccountBalance);

		// Create Account Menu item
		itemCreateAccount = new JPanel();
		itemCreateAccount.setLayout(null);
		itemCreateAccount.setBackground(new Color(33,150,243));
		itemCreateAccount.setBounds(0, 138, 220, 52);
		sidePanel.add(itemCreateAccount);
		
		IconAccountCreation = new JLabel("icon");
		IconAccountCreation.setIcon(new ImageIcon(HomeView.class.getResource("/resources/create_account.png")));
		IconAccountCreation.setBounds(12, 8, 36, 34);
		itemCreateAccount.add(IconAccountCreation);
		
		lblCreateAccount = new JLabel(CREATE_ACCOUNT);
		lblCreateAccount.setForeground(Color.WHITE);
		lblCreateAccount.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCreateAccount.setBackground(Color.WHITE);
		lblCreateAccount.setBounds(59, 18, 149, 15);
		itemCreateAccount.add(lblCreateAccount);

		// Transaction Menu item
		itemTransaction = new JPanel();
		itemTransaction.setLayout(null);
		itemTransaction.setBackground(new Color(33,150,243));
		itemTransaction.setBounds(0, 189, 220, 52);
		sidePanel.add(itemTransaction);
		
		IconTransaction = new JLabel("icon");
		IconTransaction.setIcon(new ImageIcon(HomeView.class.getResource("/resources/transaction.png")));
		IconTransaction.setBounds(12, 8, 36, 34);
		itemTransaction.add(IconTransaction);
		
		lblTransaction = new JLabel(TRANSACTION);
		lblTransaction.setForeground(Color.WHITE);
		lblTransaction.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTransaction.setBackground(Color.WHITE);
		lblTransaction.setBounds(59, 18, 149, 15);
		itemTransaction.add(lblTransaction);

		// card view that shows the screens
		cards = new JPanel(new CardLayout(0, 0));
		cards.setBounds(220, 31, 780, 669);

		// adding the screens to the card view
		cards.add(new AccountBalanceView(), ACCOUNT_BALANCE);
		cards.add(new AccountCreationView(), CREATE_ACCOUNT);
		cards.add(new TransactionsView(), TRANSACTION);
		contentPane.add(cards, BorderLayout.CENTER);
		
	}

	@Override
	public void setListeners() {
		lblX.addMouseListener(this);
		itemAccountBalance.addMouseListener(this);
		itemCreateAccount.addMouseListener(this);
		itemTransaction.addMouseListener(this);
	}

	private void changeScreen(String screen){
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, screen);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent().equals(lblX)){
			System.exit(0);
		}
		if(e.getComponent().equals(itemAccountBalance)){
			changeScreen(ACCOUNT_BALANCE);
		}
		if(e.getComponent().equals(itemCreateAccount)){
			changeScreen(CREATE_ACCOUNT);
		}
		if(e.getComponent().equals(itemTransaction)){
			changeScreen(TRANSACTION);
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
