package application.view.components;

import application.util.Constants;

import javax.swing.*;
import java.awt.*;

public class ExitButton extends JButton{

    public ExitButton(){
        super(Constants.EXIT_LABEL);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFont(new Font(Constants.APP_FONT, Font.BOLD, 21));
        setForeground(new Color(33, 150, 243));
    }

}
