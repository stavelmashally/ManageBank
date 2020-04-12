package application.view;


import javax.swing.*;
import java.awt.*;

public class AccountBalanceView extends JPanel implements View{

    JLabel lblAccountCreation;

    public AccountBalanceView() {
        setBackground(Color.WHITE);
        setLayout(null);
        initComponents();
        setListeners();
    }

    @Override
    public void initComponents() {
        lblAccountCreation = new JLabel("Account Balance");
        lblAccountCreation.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblAccountCreation.setBounds(146, 121, 169, 38);
        add(lblAccountCreation);
    }

    @Override
    public void setListeners() {

    }
}
