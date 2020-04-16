package application.view;

import application.util.Constants;

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
    private JLabel lblManagebank;
    private JLabel lblLogo;

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
        contentPane.setBackground(new Color(245, 245, 245));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        sidePanel = new JPanel();
        sidePanel.setBackground(new Color(33, 150, 243));
        sidePanel.setBounds(0, 0, 200, 400);
        contentPane.add(sidePanel);
        sidePanel.setLayout(null);
        
        lblManagebank = new JLabel(Constants.MENU_LOGO_LABEL);
        lblManagebank.setHorizontalAlignment(SwingConstants.CENTER);
        lblManagebank.setHorizontalTextPosition(SwingConstants.CENTER);
        lblManagebank.setForeground(Color.WHITE);
        lblManagebank.setFont(new Font(Constants.APP_FONT, Font.BOLD | Font.ITALIC, 21));
        lblManagebank.setBounds(0, 183, 200, 29);
        sidePanel.add(lblManagebank);
        
        lblLogo = new JLabel();
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblLogo.setIcon(new ImageIcon(LoginView.class.getResource(Constants.LOGO_ICON)));
        lblLogo.setBounds(0, 137, 200, 52);
        sidePanel.add(lblLogo);

        lblExit = new JLabel(Constants.EXIT_LABEL);
        lblExit.setForeground(new Color(33, 150, 243));
        lblExit.setBackground(new Color(33, 150, 243));
        lblExit.setFont(new Font(Constants.APP_FONT, Font.BOLD, 22));
        lblExit.setBounds(577, 0, 23, 37);
        contentPane.add(lblExit);

        lblSignin = new JLabel(Constants.SIGNIN_LABEL);
        lblSignin.setForeground(Color.DARK_GRAY);
        lblSignin.setFont(new Font(Constants.APP_FONT, Font.BOLD, 24));
        lblSignin.setBounds(331, 36, 102, 32);
        contentPane.add(lblSignin);

        lblUsername = new JLabel(Constants.USERNAME_LABEL);
        lblUsername.setFont(new Font(Constants.APP_FONT, Font.BOLD, 14));
        lblUsername.setForeground(Color.DARK_GRAY);
        lblUsername.setBounds(257, 118, 95, 15);
        contentPane.add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBackground(Color.WHITE);
        tfUsername.setBounds(257, 138, 237, 37);
        contentPane.add(tfUsername);
        tfUsername.setColumns(10);

        lblPassword = new JLabel(Constants.PASSWORD_LABEL);
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font(Constants.APP_FONT, Font.BOLD, 14));
        lblPassword.setBounds(257, 197, 95, 15);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(257, 215, 237, 37);
        contentPane.add(passwordField);

        btnLogin = new JButton(Constants.LOGIN_LABEL);
        btnLogin.setBackground(new Color(33, 150, 243));
        btnLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnLogin.setForeground(new Color(33, 150, 243));
        btnLogin.setContentAreaFilled(false);
        btnLogin.setFont(new Font(Constants.APP_FONT, Font.BOLD, 16));
        btnLogin.setBounds(313, 331, 120, 32);
        contentPane.add(btnLogin);
    }

    @Override
    public void setListeners() {
        lblExit.addMouseListener(this);
        btnLogin.addActionListener(this);
        btnLogin.setActionCommand(Constants.LOGIN_LABEL);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(Constants.LOGIN_LABEL)) {
            new HomeView().setVisible(true);
            dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if (event.getComponent().equals(lblExit)) {
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
