package application.controllers;

import application.model.dao.EmployeeDao;
import application.model.Employee;
import application.view.LoginView;

public class LoginController{

    LoginView view;
    EmployeeDao employeeDao;

    public LoginController(LoginView loginView){
        this.view = loginView;
        employeeDao = new EmployeeDao();
    }

    public void login(String email, String password){

        if (email.isEmpty() || password.isEmpty()){
            return;
        }

        if (password.length() < 6 || email.length() < 7){
            view.displayMessage("Wrong Email or Password!");
            return;
        }

        Employee employee = employeeDao.findByEmail(email);

        if(employee == null){
            view.displayMessage("Email does not exists!");
            return;
        }

        if(employee.getPassword().equals(password)){
            view.showHomeScreen();
        } else {
            view.displayMessage("Wrong Email or Password!");
        }

    }
}
