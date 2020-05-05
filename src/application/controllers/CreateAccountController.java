package application.controllers;

import application.dao.BankAccountDAO;
import application.dao.BankAccountDAOImpl;
import application.dao.CustomerDAO;
import application.dao.CustomerDAOImpl;
import application.view.CreateAccountView;

public class CreateAccountController {
    CreateAccountView view;
    BankAccountDAO bankAccountDAO;
    CustomerDAO customerDAO;

    public CreateAccountController(CreateAccountView view){
        this.view = view;
        bankAccountDAO = new BankAccountDAOImpl();
        customerDAO = new CustomerDAOImpl();

    }
    public void createAccount(){

    }

}