package application.view;

import javax.swing.*;
import java.awt.*;

public class TransactionView extends JPanel implements View {

    JLabel lblTitle;

    public TransactionView() {
        setBackground(Color.WHITE);
        setLayout(null);
        initComponents();
        setListeners();
    }

    @Override
    public void initComponents() {
        lblTitle = new JLabel("Transactions");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setBounds(146, 121, 169, 38);
        add(lblTitle);
    }

    @Override
    public void setListeners() {

    }
}
