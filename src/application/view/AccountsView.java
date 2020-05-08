package application.view;

import application.controllers.AccountsController;
import application.model.BankAccount;
import application.util.Constants;
import application.view.components.AccountTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.border.LineBorder;

public class AccountsView extends JPanel implements View, ActionListener {

    AccountsController controller;

    public AccountsView() {
        initComponents();
        setListeners();
        controller = new AccountsController(this);
        showAccounts();
    }

    @Override
    public void initComponents() {

        setBackground(Color.WHITE);
        setLayout(null);

        // Search bar
        tfSearch = new JTextField();
        tfSearch.setBounds(68, 44, 361, 25);
        add(tfSearch);

        // Search icon
        lblSearchIcon = new JLabel();
        lblSearchIcon.setIcon(new ImageIcon(AccountsView.class.getResource("/resources/search.png")));
        lblSearchIcon.setBounds(46, 44, 18, 25);
        add(lblSearchIcon);

        // Search button
        btnSearch = new JButton(Constants.SEARCH_BUTTON);
        btnSearch.setFont(new Font(Constants.APP_FONT, Font.PLAIN, 14));
        btnSearch.setBackground(new Color(245, 245, 245));
        btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
        btnSearch.setBounds(436, 44, 122, 25);
        add(btnSearch);

        initTable();
    }

    private void initTable(){
        tablePane = new JScrollPane();
        tablePane.setBounds(46, 105, 673, 374);

        tableModel = new AccountTableModel();
        table = new JTable(tableModel);

        tablePane.setViewportView(table);
        add(tablePane);
    }

    public void showAccounts(){
        tableModel.setList(controller.getBankAccounts());
    }

    @Override
    public void setListeners() {
        btnSearch.addActionListener(this);
        btnSearch.setActionCommand(Constants.SEARCH_BUTTON);
    }


    public void displayMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Constants.SEARCH_BUTTON)) {
            String name = tfSearch.getText().trim();
            tfSearch.setText("");
        }
    }

    private JTextField tfSearch;
    private JButton btnSearch;
    private JLabel lblSearchIcon;
    private JScrollPane tablePane;
    private JTable table;
    private AccountTableModel tableModel;
}
