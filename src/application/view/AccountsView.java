package application.view;

import application.util.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class AccountsView extends JPanel implements View, ActionListener {

    private JTextField tfSearch;
    private JButton btnSearch;
    private JLabel lblSearchIcon;
    private JScrollPane tablePane;
    private JTable table;
    private AccountTableModel tableModel;

    public AccountsView() {
        setBackground(Color.WHITE);
        setLayout(null);
        initComponents();
        setListeners();
        showAccounts();
    }

    @Override
    public void initComponents() {
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

    private void showAccounts(){
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1234, "David", "10/10/2010","Normal", 6700));
        accounts.add(new Account(1235, "Moshe", "11/11/2011","Overdraft", -700));
        accounts.add(new Account(1236, "Yossi", "20/10/2019","Business", 15000));
        tableModel.setList(accounts);
    }

    @Override
    public void setListeners() {
        btnSearch.addActionListener(this);
        btnSearch.setActionCommand(Constants.SEARCH_BUTTON);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Constants.SEARCH_BUTTON)) {
            String name = tfSearch.getText().trim();
            tfSearch.setText("");
        }
    }
}
