package application.view;

import application.controllers.TransactionController;
import application.model.Transaction;
import application.util.Constants;
import application.view.components.HintTextField;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WithdrawView extends JPanel implements View, ActionListener {

    private TransactionController controller;

    public WithdrawView(){

        initComponents();
        setListeners();
        controller = new TransactionController(this);

    }

    @Override
    public void initComponents() {
        setBackground(Color.WHITE);
        setLayout(null);

        lblFromAccount = new JLabel("From Account");
        lblFromAccount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblFromAccount.setBounds(30, 88, 131, 30);
        add(lblFromAccount);

        lblAmount = new JLabel("Amount");
        lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblAmount.setBounds(30, 141, 131, 28);
        add(lblAmount);

        btnOK = new JButton("OK");
        btnOK.setForeground(Color.WHITE);
        btnOK.setBorder(null);
        btnOK.setBackground(new Color(33, 150, 243));
        btnOK.setActionCommand("Create");
        btnOK.setBounds(164, 218, 113, 38);
        add(btnOK);

        btnClear = new JButton("Clear");
        btnClear.setForeground(Color.WHITE);
        btnClear.setBackground(new Color(33, 150, 243));
        btnClear.setActionCommand("Clear");
        btnClear.setBounds(289, 218, 113, 38);
        add(btnClear);

        tfFromAccount = new HintTextField("Account Number");
        tfFromAccount.setColumns(10);
        tfFromAccount.setBounds(161, 88, 244, 30);
        add(tfFromAccount);

        tfAmount = new HintTextField("Insert Amount");
        tfAmount.setColumns(10);
        tfAmount.setBounds(161, 141, 244, 30);
        add(tfAmount);
    }

    @Override
    public void setListeners() {
        btnOK.addActionListener(this);
        btnClear.addActionListener(this);
        btnClear.setActionCommand(Constants.CLEAR_BUTTON);
        btnOK.setActionCommand(Constants.OK_BUTTON);
    }
    public void displayMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals(Constants.OK_BUTTON)){
            try {
                int fromAccount = Integer.parseInt(tfFromAccount.getText());
                double amount = Double.parseDouble(tfAmount.getText());
                controller.performWithdraw(fromAccount, amount);
            } catch (NumberFormatException e){
                displayMessage("Wrong details!");
            }
        }
        if(event.getActionCommand().equals(Constants.CLEAR_BUTTON)){
            tfFromAccount.setText("Account Number");
            tfAmount.setText("Insert Amount");
        }
    }

    private HintTextField tfFromAccount;
    private HintTextField tfAmount;
    private JLabel lblFromAccount;
    private JLabel lblAmount;
    private JButton btnClear;
    private JButton btnOK;
}
