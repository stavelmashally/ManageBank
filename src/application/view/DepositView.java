package application.view;


import application.controllers.TransactionController;
import application.util.Constants;
import application.view.components.HintTextField;
import javax.swing.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DepositView extends JPanel implements View, ActionListener {

    private TransactionController controller;
    
    public DepositView(){
        initComponents();
        setListeners();
        controller = new TransactionController(this);
    }

    @Override
    public void initComponents() {
        setLayout(null);
        setBackground(Color.WHITE);

        tfFromAccount = new HintTextField("Account Number");
        tfFromAccount.setBounds(170, 110, 244, 31);
        tfFromAccount.setColumns(10);
        add(tfFromAccount);

        tfToAccount = new HintTextField("Account Number");
        tfToAccount.setBounds(170, 151, 244, 30);
        tfToAccount.setColumns(10);
        add(tfToAccount);

        lblFromAccount = new JLabel("From Account");
        lblFromAccount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblFromAccount.setBounds(49, 108, 123, 30);
        add(lblFromAccount);

        lblToAccount = new JLabel("to account");
        lblToAccount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblToAccount.setBounds(53, 150, 119, 29);
        add(lblToAccount);

        btnOk = new JButton("OK");
        btnOk.setForeground(Color.WHITE);
        btnOk.setBorder(null);
        btnOk.setBackground(new Color(33, 150, 243));
        btnOk.setBounds(159, 264, 113, 38);
        add(btnOk);

        btnClear = new JButton("Clear");
        btnClear.setForeground(Color.WHITE);
        btnClear.setBackground(new Color(33, 150, 243));
        btnClear.setActionCommand("btnClear");
        btnClear.setBounds(290, 264, 113, 38);
        add(btnClear);

        tfAmount = new HintTextField("Insert Amount");
        tfAmount.setBounds(170, 194, 134, 28);
        tfAmount.setColumns(10);
        add(tfAmount);

        lblAmount = new JLabel("Amount");
        lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblAmount.setBounds(53, 191, 123, 30);
        add(lblAmount);

        rdbtnGroup = new ButtonGroup();

        rdbtnDeposit = new JRadioButton("Deposit");
        rdbtnDeposit.setBackground(Color.WHITE);
        rdbtnDeposit.setSelected(true);
        rdbtnDeposit.setBounds(170, 62, 106, 23);
        add(rdbtnDeposit);

        rdbtnTransfer = new JRadioButton("Transfer");
        rdbtnTransfer.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        rdbtnTransfer.setBackground(Color.WHITE);
        rdbtnTransfer.setBounds(275, 62, 134, 23);
        add(rdbtnTransfer);

        rdbtnGroup.add(rdbtnTransfer);
        rdbtnGroup.add(rdbtnDeposit);
    }

    @Override
    public void setListeners() {
        btnOk.addActionListener(this);
        btnClear.addActionListener(this);
        btnClear.setActionCommand(Constants.CLEAR_BUTTON);
        btnOk.setActionCommand(Constants.OK_BUTTON);
        rdbtnDeposit.setActionCommand(Constants.DEPOSIT);
        rdbtnTransfer.setActionCommand(Constants.TRANSFER);
    }

    public void displayMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals(Constants.OK_BUTTON)){
            String type = rdbtnGroup.getSelection().getActionCommand();
            if (type.equals(Constants.DEPOSIT)) {
                tfFromAccount.setText(tfToAccount.getText());
            }
            int fromAccount = Integer.parseInt(tfFromAccount.getText());
            int toAccount = Integer.parseInt(tfToAccount.getText());
            double amount = Double.parseDouble(tfAmount.getText());
            controller.performDeposit(fromAccount, toAccount, amount, type);
            clearText();
        }
        if(event.getActionCommand().equals(Constants.CLEAR_BUTTON)){
            clearText();
        }
    }

    private void clearText(){
        tfFromAccount.setText("Account Number");
        tfToAccount.setText("Account Number");
        tfAmount.setText("Insert Amount");
    }

    private HintTextField tfFromAccount;
    private HintTextField tfToAccount;
    private HintTextField tfAmount;
    private JLabel lblFromAccount;
    private JLabel lblAmount;
    private JLabel lblToAccount;
    private JButton btnClear;
    private JButton btnOk;
    private ButtonGroup rdbtnGroup;
    private JRadioButton rdbtnDeposit;
    private JRadioButton rdbtnTransfer;
}
