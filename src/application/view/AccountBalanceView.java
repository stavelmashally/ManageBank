package application.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class AccountBalanceView extends JPanel implements View, ActionListener{

	private JTextField tfSearch;
	private JButton  btnSearch;
	private JLabel lblSearchIcon;
	private JScrollPane scrollPane;
	private JTable table;

	public AccountBalanceView() {
		setBackground(Color.WHITE);
		setLayout(null);
		initComponents();
		setListeners();
	}

	@Override
	public void initComponents() {

		
		tfSearch = new JTextField();
		tfSearch.setText("Enter Account Number");
		tfSearch.setBounds(42, 44, 361, 25);
		add(tfSearch);
		tfSearch.setColumns(10);
		
		lblSearchIcon = new JLabel("");
		lblSearchIcon.setIcon(new ImageIcon(AccountCreationView.class.getResource("/resources/search.png")));
		lblSearchIcon.setBounds(22, 44, 18, 25);
		add(lblSearchIcon);
		
		btnSearch = new JButton("Search");

		btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnSearch.setBackground(new Color(245, 245, 245));
		btnSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSearch.setBounds(415, 44, 122, 25);
		add(btnSearch);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 98, 691, 414);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"123", "Sara", new Integer(-1500)},
				{"1234", "Stav", new Integer(1500)},
			},//return table,
			new String[] {
				"Id", "Name", "Balance"
			}
		));
		scrollPane.setViewportView(table);
	}

	@Override
	public void setListeners() {
		btnSearch.addActionListener(this);
		btnSearch.setActionCommand("search");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("search")) {
			String searchText = tfSearch.getText();
			tfSearch.setText("");
		}
		
	}
}
