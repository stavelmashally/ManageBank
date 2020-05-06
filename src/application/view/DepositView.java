package application.view;

import application.controllers.DepositController;

import javax.swing.*;

public class DepositView extends JPanel implements View{

    DepositController controller;

    public DepositView(){
        initComponents();
        setListeners();
        controller = new DepositController(this);
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
