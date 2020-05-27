package application.view;
import java.awt.event.MouseEvent;
import application.controllers.CreateAccountController;
import application.util.Constants;
import application.view.components.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class CreateAccountView extends JPanel implements View, ActionListener {

	private CreateAccountController controller;

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
		lblAccountDetails.setBounds(70, 10, 214, 38);
		add(lblAccountDetails);

		tfFname = createHintTextField(Constants.FNAME_LABEL, 60);
		tfLname = createHintTextField(Constants.LNAME_LABEL, 110);
		tfId = createHintTextField(Constants.ID_LABEL, 160);
		tfEmail = createHintTextField(Constants.EMAIL_LABEL, 210);
		tfPhone = createHintTextField(Constants.PHONE_LABEL, 260);
		tfAddress = createHintTextField(Constants.ADDRESS_LABEL, 310);
		tfCity = createHintTextField(Constants.CITY_LABEL, 360);
		add(tfId);
		add(tfEmail);
		add(tfFname);
		add(tfLname);
		add(tfPhone);
		add(tfAddress);
		add(tfCity);

		// Account type Radio Buttons
		rdbtnGroup = new ButtonGroup();

		rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		rdbtnNormal.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		rdbtnNormal.setSelected(true);
		rdbtnNormal.setBackground(Color.WHITE);
		rdbtnNormal.setBounds(70, 400, 75, 23);
		add(rdbtnNormal);
		
		rdbtnOverdraft = new JRadioButton("Savings");
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

    private HintTextField createHintTextField(String text, int pos){
		HintTextField hintTextField= new HintTextField(text);
		hintTextField.setToolTipText(text);
		hintTextField.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		hintTextField.setForeground(Color.GRAY);
		hintTextField.setColumns(10);
		hintTextField.setBounds(70, pos, 260, 30);
		return hintTextField;
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
		tfCity.addMouseListener(clearText(tfCity));
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

	@Override
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
			String city = tfCity.getText();
			String type = rdbtnGroup.getSelection().getActionCommand();
			controller.createAccount(id, fname, lname, email, phone, address, city, type);
		}
		if(event.getActionCommand().equals(Constants.CLEAR_BUTTON)){
			tfFname.setText(Constants.FNAME_LABEL);
			tfLname.setText(Constants.LNAME_LABEL);
			tfId.setText(Constants.ID_LABEL);
			tfEmail.setText(Constants.EMAIL_LABEL);
			tfPhone.setText(Constants.PHONE_LABEL);
			tfAddress.setText(Constants.ADDRESS_LABEL);
			tfCity.setText(Constants.CITY_LABEL);
		}
	}

	private JTextField tfFname;
	private JTextField tfLname;
	private JTextField tfId;
	private JTextField tfEmail;
	private JTextField tfPhone;
	private JTextField tfAddress;
	private JTextField tfCity;
	private JButton btnCreate;
	private JButton btnClear;
	private JLabel lblAccountDetails;
	private ButtonGroup rdbtnGroup;
	private JRadioButton rdbtnNormal;
	private JRadioButton rdbtnBusiness;
	private JRadioButton rdbtnOverdraft;
	private HintTextField hintTextField;
}
