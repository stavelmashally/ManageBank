package application.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.LineBorder;

public class LoginView extends JFrame implements View, ActionListener, MouseListener {

	private JPanel contentPane;
	private JPanel sidePanel;
	private JLabel lblExit;
	private JLabel lblSignin;
	private JLabel lblUsername;
	private JTextField tfUsername;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JButton btnLogin;

	public LoginView() {
		setUndecorated(true);
		setSize(600, 400);
		setLocationRelativeTo(null);
		initComponents();
		setListeners();
	}

	
	@Override
	public void initComponents() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245,245,245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		sidePanel = new JPanel();
		sidePanel.setBackground(new Color(33,150,243));
		sidePanel.setBounds(0, 0, 200, 400);
		contentPane.add(sidePanel);

		lblExit = new JLabel("X");
		lblExit.setForeground(new Color(33,150,243));
		lblExit.setBackground(new Color(33,150,243));
		lblExit.setFont(new Font("Dialog", Font.BOLD, 22));
		lblExit.setBounds(577, 0, 23, 37);
		contentPane.add(lblExit);

		lblSignin = new JLabel("Signin");
		lblSignin.setForeground(Color.DARK_GRAY);
		lblSignin.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblSignin.setBounds(331, 36, 102, 32);
		contentPane.add(lblSignin);

		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblUsername.setForeground(Color.DARK_GRAY);
		lblUsername.setBounds(257, 118, 95, 15);
		contentPane.add(lblUsername);

		tfUsername = new JTextField();
		tfUsername.setBackground(Color.WHITE);
		tfUsername.setBounds(257, 138, 237, 37);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.DARK_GRAY);
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPassword.setBounds(257, 197, 95, 15);
		contentPane.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(257, 215, 237, 37);
		contentPane.add(passwordField);

		btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(33,150,243));
		btnLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLogin.setForeground(new Color(33,150,243));
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnLogin.setBounds(313, 331, 120, 32);
		contentPane.add(btnLogin);
	}

	@Override
	public void setListeners() {
		lblExit.addMouseListener(this);
		btnLogin.addActionListener(this);
		btnLogin.setActionCommand("login");
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("login")){
			new HomeView().setVisible(true);
			dispose();
		}
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if(event.getComponent().equals(lblExit)){
			System.exit(0);
		}
	}

	@Override
	public void mousePressed(MouseEvent event) {

	}

	@Override
	public void mouseReleased(MouseEvent event) {

	}

	@Override
	public void mouseEntered(MouseEvent event) {
	}

	@Override
	public void mouseExited(MouseEvent event) {

	}
}
