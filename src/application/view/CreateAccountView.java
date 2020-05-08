package application.view;
import java.awt.event.MouseEvent;
import application.controllers.CreateAccountController;
import application.util.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class CreateAccountView extends JPanel implements View, ActionListener {

	CreateAccountController controller;

	public CreateAccountView() {
		initComponents();
		setListeners();
		controller = new CreateAccountController(this);
	}


    @Override
    public void initComponents() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setLayout(null);
		setBackground(Color.WHITE);

		lblAccountDetails = new JLabel(Constants.ACCOUNT_DETAILS_LABEL);
		lblAccountDetails.setFont(new Font(Constants.APP_FONT, Font.PLAIN, 24));
		lblAccountDetails.setBounds(70, 40, 214, 38);
		add(lblAccountDetails);

		tfFname = createTextField(Constants.FNAME_LABEL, 100);
		tfLname = createTextField(Constants.LNAME_LABEL, 150);
		tfId = createTextField(Constants.ID_LABEL, 200);
		tfEmail = createTextField(Constants.EMAIL_LABEL, 250);
		tfPhone = createTextField(Constants.PHONE_LABEL, 300);
		tfAddress = createTextField(Constants.ADDRESS_LABEL, 350);
		add(tfId);
		add(tfEmail);
		add(tfFname);
		add(tfLname);
		add(tfPhone);
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

    private JTextField createTextField(String text, int pos){
		JTextField textField = new JTextField(text);
		textField.setToolTipText(text);
		textField.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		textField.setForeground(Color.GRAY);
		textField.setColumns(10);
		textField.setBounds(70, pos, 260, 30);
		return textField;
	}

    @Override
    public void setListeners() {
		btnCreate.addActionListener(this);
		btnCreate.setActionCommand(Constants.CREATE_BUTTON);
		btnClear.addActionListener(this);
		btnClear.setActionCommand(Constants.CLEAR_BUTTON);
		rdbtnBusiness.setActionCommand("Business");
		rdbtnNormal.setActionCommand("Normal");
		rdbtnOverdraft.setActionCommand("Savings");
		tfEmail.addMouseListener(clearText(tfEmail));
		tfPhone.addMouseListener(clearText(tfPhone));
		tfAddress.addMouseListener(clearText(tfAddress));
		tfFname.addMouseListener(clearText(tfFname));
		tfLname.addMouseListener(clearText(tfLname));
		tfId.addMouseListener(clearText(tfId));

    }

	public MouseAdapter clearText(JTextField textField){
		return new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if(textField.getText().equals(textField.getToolTipText()))
					textField.setText("");
			}
		};
	}

	public void displayMessage(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals(Constants.CREATE_BUTTON)){
			String id = tfId.getText();
			String fname = tfFname.getText();
			String lname = tfLname.getText();
			String email = tfEmail.getText();
			String phone = tfPhone.getText();
			String address = tfAddress.getText();
			String type = rdbtnGroup.getSelection().getActionCommand();
			controller.createAccount(id, fname, lname, email, phone, address, type);
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
}
