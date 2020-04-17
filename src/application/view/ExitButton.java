package application.view;

import application.util.Constants;

import javax.swing.*;
import java.awt.*;

public class ExitButton extends JButton implements View {

    public ExitButton(){
        super(Constants.EXIT_LABEL);
        initComponents();
    }

    @Override
    public void initComponents() {
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFont(new Font(Constants.APP_FONT, Font.BOLD, 21));
        setForeground(new Color(33, 150, 243));
    }

    @Override
    public void setListeners() {

    }
}
