package application;

import application.view.HomeView;
import application.view.LoginView;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginView frame = new LoginView();
            frame.setVisible(true);
//            HomeView homeView = new HomeView();
//            homeView.setVisible(true);
        });
    }
}
