package application.view;


import application.controllers.TransactionController;
import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DepositView extends JPanel implements View{

    TransactionController controller;
    private JTextField from_acunt;
    private JTextField textField;
    private JTextField textField_1;
    private ButtonGroup rdbtnGroup;
    private JRadioButton rdbtnDeposit;
    private JRadioButton rdbtnTransfer;
    
    public DepositView(){
    	setBackground(Color.WHITE);
        initComponents();
        setListeners();
        controller = new TransactionController(this);
        setLayout(null);
        
        from_acunt = new JTextField();
        from_acunt.setBounds(159, 110, 244, 31);
        add(from_acunt);
        from_acunt.setColumns(10);
        
        textField = new JTextField();
        textField.setBounds(159, 151, 244, 30);
        add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("from account");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(49, 108, 123, 30);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("to account");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(53, 150, 119, 29);
        add(lblNewLabel_1);
        
        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnOk.setForeground(Color.WHITE);
        btnOk.setBorder(null);
        btnOk.setBackground(new Color(33, 150, 243));
        btnOk.setActionCommand("Create");
        btnOk.setBounds(159, 264, 113, 38);
        add(btnOk);
        
        JButton button_1 = new JButton("Clear");
        button_1.setForeground(Color.WHITE);
        button_1.setBackground(new Color(33, 150, 243));
        button_1.setActionCommand("Clear");
        button_1.setBounds(290, 264, 113, 38);
        add(button_1);
        
        textField_1 = new JTextField();
        textField_1.setBounds(159, 194, 134, 28);
        add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("amount");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_2.setBounds(53, 191, 123, 30);
        add(lblNewLabel_2);
    
        rdbtnGroup = new ButtonGroup();
		
		rdbtnTransfer = new JRadioButton("Transfer");
		rdbtnTransfer.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		rdbtnTransfer.setBackground(Color.WHITE);
		rdbtnTransfer.setBounds(159, 62, 106, 23);
		add(rdbtnTransfer);
		
		rdbtnDeposit = new JRadioButton("Deposit");
		rdbtnDeposit.setBackground(Color.WHITE);
		rdbtnDeposit.setBounds(269, 62, 134, 23);
		add(rdbtnDeposit);
		
		
		rdbtnGroup.add(rdbtnTransfer);
		rdbtnGroup.add(rdbtnDeposit);
		
    }

    @Override
    public void initComponents() {

    }

    @Override
    public void setListeners() {

    }

    public void displayMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}
