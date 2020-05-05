package application.controllers;

import application.dao.EmployeeDAO;
import application.dao.EmployeeDAOImpl;
import application.model.Employee;
import application.view.LoginView;

public class LoginController{

    LoginView view;
    EmployeeDAO employeeDAO;

    public LoginController(LoginView loginView){
        this.view = loginView;
        employeeDAO = new EmployeeDAOImpl();
    }

    public void login(String firstName, String password){

        if (firstName.isEmpty() || password.isEmpty()){
            return;
        }

        if (password.length() < 3){
            view.displayError("Password to short!");
            return;
        }

        for (Employee emp : employeeDAO.getAllEmployees()) {
            if(emp.getFirstName().equals(firstName) && emp.getPassword().equals(password)){
                view.showHomeScreen();
                return;
            }
        }
        view.displayError("Failed to Login");
    }
}
