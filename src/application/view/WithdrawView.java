package application.view;

import application.controllers.TransactionController;
import application.model.Transaction;

import javax.swing.*;

public class WithdrawView extends JPanel implements View{

    TransactionController controller;

    public WithdrawView(){
        initComponents();
        setListeners();
        controller = new TransactionController(this);
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
