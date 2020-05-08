package application.view;

import application.controllers.LoginController;
import application.util.Constants;
import application.view.components.ExitButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class LoginView extends JFrame implements View, ActionListener {

    LoginController controller;

    public LoginView() {
        initComponents();
        setListeners();
        controller = new LoginController(this);
    }

    @Override
    public void initComponents() {
        setUndecorated(true);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Main panel
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(245, 245, 245));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mainPanel);
        mainPanel.setLayout(null);

        // Exit button
        btnExit = new ExitButton();
        btnExit.setBounds(552, 0, 48, 32);
        mainPanel.add(btnExit);

        // Initiate side panel
        sidePanel = new JPanel();
        sidePanel.setBackground(new Color(33, 150, 243));
        sidePanel.setBounds(0, 0, 200, 400);
        mainPanel.add(sidePanel);
        sidePanel.setLayout(null);

        // Logo text
        lblManagebank = new JLabel(Constants.MENU_LOGO_LABEL);
        lblManagebank.setHorizontalAlignment(SwingConstants.CENTER);
        lblManagebank.setHorizontalTextPosition(SwingConstants.CENTER);
        lblManagebank.setForeground(Color.WHITE);
        lblManagebank.setFont(new Font(Constants.APP_FONT, Font.BOLD | Font.ITALIC, 21));
        lblManagebank.setBounds(0, 183, 200, 29);
        sidePanel.add(lblManagebank);

        // Logo icon
        lblLogo = new JLabel();
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblLogo.setIcon(new ImageIcon(LoginView.class.getResource(Constants.LOGO_ICON)));
        lblLogo.setBounds(0, 137, 200, 52);
        sidePanel.add(lblLogo);

        // Signin label
        lblSignin = new JLabel(Constants.SIGNIN_LABEL);
        lblSignin.setForeground(Color.DARK_GRAY);
        lblSignin.setFont(new Font(Constants.APP_FONT, Font.BOLD, 24));
        lblSignin.setBounds(331, 36, 102, 32);
        mainPanel.add(lblSignin);

        // Username label
        lblUsername = new JLabel(Constants.USERNAME_LABEL);
        lblUsername.setFont(new Font(Constants.APP_FONT, Font.BOLD, 14));
        lblUsername.setForeground(Color.DARK_GRAY);
        lblUsername.setBounds(257, 118, 95, 15);
        mainPanel.add(lblUsername);

        // Username text
        tfUsername = new JTextField();
        tfUsername.setBackground(Color.WHITE);
        tfUsername.setBounds(257, 138, 237, 37);
        mainPanel.add(tfUsername);
        tfUsername.setColumns(10);

        // Password label
        lblPassword = new JLabel(Constants.PASSWORD_LABEL);
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font(Constants.APP_FONT, Font.BOLD, 14));
        lblPassword.setBounds(257, 197, 95, 15);
        mainPanel.add(lblPassword);

        // Password text
        passwordField = new JPasswordField();
        passwordField.setBounds(257, 215, 237, 37);
        mainPanel.add(passwordField);

        // Login button
        btnLogin = new JButton(Constants.LOGIN_LABEL);
        btnLogin.setBackground(new Color(33, 150, 243));
        btnLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnLogin.setForeground(new Color(33, 150, 243));
        btnLogin.setContentAreaFilled(false);
        btnLogin.setFont(new Font(Constants.APP_FONT, Font.BOLD, 16));
        btnLogin.setBounds(313, 331, 120, 32);
        mainPanel.add(btnLogin);
    }

    @Override
    public void setListeners() {
        btnLogin.addActionListener(this);
        btnLogin.setActionCommand(Constants.LOGIN_LABEL);
        btnExit.addActionListener(this);
        btnExit.setActionCommand(Constants.EXIT_LABEL);
    }


    public void displayMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void showHomeScreen(){
        dispose();
        new HomeView().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(Constants.EXIT_LABEL)) {
            System.exit(0);
        }
        if (event.getActionCommand().equals(Constants.LOGIN_LABEL)) {
            controller.login(tfUsername.getText(), String.valueOf(passwordField.getPassword()));
        }
    }

    private JPanel mainPanel;
    private JPanel sidePanel;
    private ExitButton btnExit;
    private JLabel lblSignin;
    private JLabel lblUsername;
    private JTextField tfUsername;
    private JLabel lblPassword;
    private JPasswordField passwordField;
    private JButton btnLogin;
    private JLabel lblManagebank;
    private JLabel lblLogo;
}
