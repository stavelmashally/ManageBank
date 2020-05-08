package application.view;


import application.controllers.TransactionController;

import javax.swing.*;

public class DepositView extends JPanel implements View{

    TransactionController controller;

    public DepositView(){
        initComponents();
        setListeners();
        controller = new TransactionController(this);
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
