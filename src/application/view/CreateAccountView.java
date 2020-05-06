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

	public MouseAdapter clearText(JTextField j){
		return new MouseAdapter(){
	        @Override
	        public void mouseClicked(MouseEvent e){
	        	if(j.getText().equals(j.getToolTipText()))
	        		j.setText("");
	        	}
	    };
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
		 
		
		

		tfFname = new JTextField(Constants.FNAME_LABEL);
		tfFname.setToolTipText(Constants.FNAME_LABEL);
		tfFname.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		tfFname.addMouseListener(clearText(tfFname));
		tfFname.setForeground(Color.GRAY);
		tfFname.setColumns(10);
		tfFname.setBounds(70, 100, 260, 30);
		add(tfFname);

		tfLname = new JTextField(Constants.LNAME_LABEL);
		tfLname.setToolTipText(Constants.LNAME_LABEL);
		tfLname.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		tfLname.addMouseListener(clearText(tfLname));
		tfLname.setForeground(Color.GRAY);	
		tfLname.setColumns(10);
		tfLname.setBounds(70, 150, 260, 30);
		add(tfLname);

		tfId = new JTextField(Constants.ID_LABEL);
		tfId.setToolTipText(Constants.ID_LABEL);
		tfId.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		tfId.addMouseListener(clearText(tfId));
		tfId.setForeground(Color.GRAY);
		tfId.setColumns(10);
		tfId.setBounds(70, 200, 260, 30);
		add(tfId);

		tfEmail = new JTextField(Constants.EMAIL_LABEL);
		tfEmail.setToolTipText(Constants.EMAIL_LABEL);
		tfEmail.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		tfEmail.addMouseListener(clearText(tfEmail));
		tfEmail.setForeground(Color.GRAY);
		tfEmail.setColumns(10);
		tfEmail.setBounds(70, 250, 260, 30);
		add(tfEmail);

		tfPhone = new JTextField(Constants.PHONE_LABEL);
		tfPhone.setToolTipText(Constants.PHONE_LABEL);
		tfPhone.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		tfPhone.addMouseListener(clearText(tfPhone));
		tfPhone.setForeground(Color.GRAY);
		tfPhone.setColumns(10);
		tfPhone.setBounds(70, 300, 260, 30);
		add(tfPhone);

		tfAddress = new JTextField(Constants.ADDRESS_LABEL);
		tfAddress.setToolTipText(Constants.ADDRESS_LABEL);
		tfAddress.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		tfAddress.addMouseListener(clearText(tfAddress));
		tfAddress.setForeground(Color.GRAY);
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
		rdbtnOverdraft.setActionCommand("Savings");
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
