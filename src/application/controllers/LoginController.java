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

    public void login(String id, String password){

        if (id.isEmpty() || password.isEmpty()){
            return;
        }

        if (password.length() < 6 || id.length() < 3){
            view.displayMessage("Wrong Id or Password!");
            return;
        }

        Employee employee = employeeDao.findById(Integer.parseInt(id));

        if(employee != null && employee.getPassword().equals(password)){
            view.showHomeScreen();
        } else {
            view.displayMessage("Failed to Login");
        }

    }
}
