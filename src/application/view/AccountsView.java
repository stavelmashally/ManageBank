package application.view;

import application.controllers.AccountsController;
import application.util.Constants;
import application.view.components.AccountTableModel;
import application.view.components.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class AccountsView extends JPanel implements View, ActionListener {

    private AccountsController controller;

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
        tfSearch = new HintTextField("Enter Account Number");
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

    @Override
    public void displayMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Constants.SEARCH_BUTTON)) {
            if (!tfSearch.getText().isEmpty()){
                int accountNumber = Integer.parseInt(tfSearch.getText());
                int row = tableModel.find(accountNumber);
                if(row != -1){
                    table.addRowSelectionInterval(row, row);
                }
            }
            tfSearch.setText("Enter Account Number");
        }
    }

    private HintTextField tfSearch;
    private JButton btnSearch;
    private JLabel lblSearchIcon;
    private JScrollPane tablePane;
    private JTable table;
    private AccountTableModel tableModel;
}
