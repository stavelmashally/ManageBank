package application.view;

import application.util.Constants;

import javax.swing.*;
import java.awt.*;

public class MenuItem extends JPanel implements View {

	private String text;
	private String icon;
	private JLabel lblIcon;
	private JLabel lblText;

	public MenuItem(String text, String icon, int pos) {
		this.text = text;
		this.icon = icon;
		setBounds(0, pos, 220, 70);
		setLayout(null);
		setBackground(new Color(33, 150, 243));
		setName(text);
		initComponents();
	}

	@Override
	public void initComponents() {
		lblIcon = new JLabel();
		lblIcon.setIcon(new ImageIcon(MenuItem.class.getResource(icon)));
		lblIcon.setBounds(12, 25, 36, 30);
		add(lblIcon);

		lblText = new JLabel(text);
		lblText.setForeground(Color.WHITE);
		lblText.setFont(new Font(Constants.APP_FONT, Font.BOLD, 16));
		lblText.setBounds(60, 30, 150, 20);
		add(lblText);
	}

	@Override
	public void setListeners() {

	}

}
