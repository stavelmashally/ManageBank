package application.view;

import application.controllers.WithdrawController;

import java.awt.Font;

import javax.swing.*;

public class WithdrawView extends JPanel implements View{

    WithdrawController controller;

    public WithdrawView(){
        initComponents();
        setListeners();
        controller = new WithdrawController(this);
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
