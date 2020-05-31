package application.controllers;

import application.model.dao.EmployeeDao;
import application.model.Employee;
import application.view.LoginView;
import application.view.View;

public class LoginController extends Controller{

    private EmployeeDao employeeDao;

    public LoginController(View view){
        this.view = view;
        employeeDao = new EmployeeDao();
    }

    public boolean login(String email, String password){

        if (email.isEmpty() || password.isEmpty()){
            return false;
        }

        if (password.length() < 5 || email.length() < 7){
            view.displayMessage("Wrong Email or Password!");
            return false;
        }

        Employee employee = employeeDao.findByEmail(email);

        if(employee == null){
            view.displayMessage("Email does not exists!");
            return false;
        }

        if(employee.getPassword().equals(password)){
            return true;
        } else {
            view.displayMessage("Wrong Email or Password!");
            return false;
        }

    }
}
