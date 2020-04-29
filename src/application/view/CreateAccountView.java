package application.view;

import application.util.Constants;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.DebugGraphics;

public class CreateAccountView extends JPanel implements View, ActionListener {

	private JTextField tfFname;
	private JTextField tfLname;
	private JTextField tfId;
	private JTextField tfEmail;
	private JTextField tfPhone;
	private JTextField tfAddress;
	private JButton btnCreate;
	private JButton btnClear;
	private JLabel lblAccountDetails;
	private ButtonGroup rdbtnGroup;
	private JRadioButton rdbtnNormal;
	private JRadioButton rdbtnBusiness;
	private JRadioButton rdbtnOverdraft;

	public CreateAccountView() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setLayout(null);
		setBackground(Color.WHITE);
		initComponents();
		setListeners();
	}


    @Override
    public void initComponents() {
		lblAccountDetails = new JLabel(Constants.ACCOUNT_DETAILS_LABEL);
		lblAccountDetails.setFont(new Font(Constants.APP_FONT, Font.PLAIN, 24));
		lblAccountDetails.setBounds(70, 40, 214, 38);
		add(lblAccountDetails);

		tfFname = new JTextField();
		tfFname.setBorder(new LineBorder(new Color(192, 192, 192), 1));
		tfFname.setForeground(Color.GRAY);
		tfFname.setText(Constants.FNAME_LABEL);
		tfFname.setBounds(70, 100, 260, 30);
		add(tfFname);

		tfLname = new JTextField();
		tfLname.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		tfLname.setForeground(Color.GRAY);
		tfLname.setText(Constants.LNAME_LABEL);
		tfLname.setColumns(10);
		tfLname.setBounds(70, 150, 260, 30);
		add(tfLname);

		tfId = new JTextField();
		tfId.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		tfId.setForeground(Color.GRAY);
		tfId.setText(Constants.ID_LABEL);
		tfId.setColumns(10);
		tfId.setBounds(70, 200, 260, 30);
		add(tfId);

		tfEmail = new JTextField();
		tfEmail.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		tfEmail.setForeground(Color.GRAY);
		tfEmail.setText(Constants.EMAIL_LABEL);
		tfEmail.setColumns(10);
		tfEmail.setBounds(70, 250, 260, 30);
		add(tfEmail);

		tfPhone = new JTextField();
		tfPhone.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		tfPhone.setForeground(Color.GRAY);
		tfPhone.setText(Constants.PHONE_LABEL);
		tfPhone.setColumns(10);
		tfPhone.setBounds(70, 300, 260, 30);
		add(tfPhone);

		tfAddress = new JTextField();
		tfAddress.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		tfAddress.setForeground(Color.GRAY);
		tfAddress.setText(Constants.ADDRESS_LABEL);
		tfAddress.setColumns(10);
		tfAddress.setBounds(70, 350, 260, 30);
		add(tfAddress);

		// Account type Radio Buttons
		rdbtnGroup = new ButtonGroup();
		
		rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		rdbtnNormal.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		rdbtnNormal.setSelected(true);
		rdbtnNormal.setBackground(Color.WHITE);
		rdbtnNormal.setBounds(70, 400, 75, 23);
		add(rdbtnNormal);
		
		rdbtnOverdraft = new JRadioButton("Overdraft");
		rdbtnOverdraft.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		rdbtnOverdraft.setBackground(Color.WHITE);
		rdbtnOverdraft.setBounds(145, 400, 95, 23);
		add(rdbtnOverdraft);
		
		rdbtnBusiness = new JRadioButton("Business");
		rdbtnBusiness.setBackground(Color.WHITE);
		rdbtnBusiness.setBounds(240, 400, 95, 23);
		add(rdbtnBusiness);
		
		rdbtnGroup.add(rdbtnNormal);
		rdbtnGroup.add(rdbtnOverdraft);
		rdbtnGroup.add(rdbtnBusiness);
		
		btnCreate = new JButton(Constants.CREATE_BUTTON);
		btnCreate.setBorder(null);
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setBackground(new Color(33, 150, 243));
		btnCreate.setBounds(70, 450, 120, 38);
		add(btnCreate);

		btnClear = new JButton(Constants.CLEAR_BUTTON);
		btnClear.setForeground(Color.WHITE);
		btnClear.setBackground(new Color(33, 150, 243));
		btnClear.setBounds(210, 450, 120, 38);
		add(btnClear);
    }

    @Override
    public void setListeners() {
		btnCreate.addActionListener(this);
		btnCreate.setActionCommand(Constants.CREATE_BUTTON);
		btnClear.addActionListener(this);
		btnClear.setActionCommand(Constants.CLEAR_BUTTON);
		rdbtnBusiness.setActionCommand("Business");
		rdbtnNormal.setActionCommand("Normal");
		rdbtnOverdraft.setActionCommand("Overdraft");
    }

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals(Constants.CREATE_BUTTON)){
			String fname = tfFname.getText();
			String lname = tfLname.getText();
			String email = tfEmail.getText();
			String phone = tfPhone.getText();
			String address = tfAddress.getText();
			String type = rdbtnGroup.getSelection().getActionCommand();
			Account account = new Account(123, fname, "10/10/2010", type, 6700);
			System.out.println(fname + " " + type + " " + email);
		}
		if(event.getActionCommand().equals(Constants.CLEAR_BUTTON)){
			tfFname.setText(Constants.FNAME_LABEL);
			tfLname.setText(Constants.LNAME_LABEL);
			tfId.setText(Constants.ID_LABEL);
			tfEmail.setText(Constants.EMAIL_LABEL);
			tfPhone.setText(Constants.PHONE_LABEL);
			tfAddress.setText(Constants.ADDRESS_LABEL);
		}
	}
}
