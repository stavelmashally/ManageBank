package application.view;

import application.controllers.TransactionController;
import application.model.Transaction;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class WithdrawView extends JPanel implements View{

    TransactionController controller;
    private JTextField textField_2;
    private JTextField textField;

    public WithdrawView(){
    	setBackground(Color.WHITE);
        initComponents();
        setListeners();
        controller = new TransactionController(this);
        setLayout(null);
        
        JLabel lblNewLabel = new JLabel("From Account");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(30, 88, 131, 30);
        add(lblNewLabel);
        
        JLabel lblAmount = new JLabel("Amount");
        lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblAmount.setBounds(30, 141, 131, 28);
        add(lblAmount);
        
        JButton button = new JButton("OK");
        button.setForeground(Color.WHITE);
        button.setBorder(null);
        button.setBackground(new Color(33, 150, 243));
        button.setActionCommand("Create");
        button.setBounds(164, 218, 113, 38);
        add(button);
        
        JButton button_1 = new JButton("Clear");
        button_1.setForeground(Color.WHITE);
        button_1.setBackground(new Color(33, 150, 243));
        button_1.setActionCommand("Clear");
        button_1.setBounds(289, 218, 113, 38);
        add(button_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(161, 88, 244, 30);
        add(textField_2);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(161, 141, 244, 30);
        add(textField);
    }

    @Override
    public void initComponents() {
//    	   lblTitle = new JLabel("Withdeaw");
//         lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
//         lblTitle.setBounds(146, 121, 169, 38);
//         add(lblTitle);

    }

    @Override
    public void setListeners() {

    }
    public void displayMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

}
