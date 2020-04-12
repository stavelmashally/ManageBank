package application.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class AccountCreationView extends JPanel implements View{

	JLabel lblAccountCreation;

	public AccountCreationView() {
		setBackground(Color.WHITE);
		setLayout(null);
		initComponents();
		setListeners();
	}

	@Override
	public void initComponents() {
		lblAccountCreation = new JLabel("Account Creation");
		lblAccountCreation.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblAccountCreation.setBounds(146, 121, 169, 38);
		add(lblAccountCreation);
	}

	@Override
	public void setListeners() {

	}
}
