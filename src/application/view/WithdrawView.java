package application.view;

import application.controllers.WithdrawController;

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

    }

    @Override
    public void setListeners() {

    }
    public void displayMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

}
