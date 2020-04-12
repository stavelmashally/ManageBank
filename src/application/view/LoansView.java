package application.view;

import application.util.Constants;

import javax.swing.*;
import java.awt.*;

public class LoansView extends JPanel implements View{

    JLabel lblLoans;

    public LoansView() {
        setBackground(Color.WHITE);
        setLayout(null);
        initComponents();
        setListeners();
    }

    @Override
    public void initComponents() {
        lblLoans = new JLabel(Constants.LOANS);
        lblLoans.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblLoans.setBounds(146, 121, 169, 38);
        add(lblLoans);
    }

    @Override
    public void setListeners() {

    }
}
