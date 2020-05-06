package application.controllers;

import application.model.BankAccount;
import application.model.Customer;
import application.model.dao.BankAccountDao;
import application.model.dao.CustomerDao;
import application.view.CreateAccountView;

import java.util.Calendar;
import java.util.Date;

public class CreateAccountController {

    CreateAccountView view;
    BankAccountDao bankAccountDao;
    CustomerDao customerDao;

    public CreateAccountController(CreateAccountView view){
        this.view = view;
        bankAccountDao = new BankAccountDao();
        customerDao = new CustomerDao();

    }
    public void createAccount(String id, String fname, String lname, String email, String phone, String address, String type){

        if(fname.isEmpty()){
            view.displayMessage("Wrong details!");
            return;
        }

        Customer customer = new Customer();
        customerDao.save(customer);

        Date today = Calendar.getInstance().getTime();
        BankAccount bankAccount = new BankAccount(Integer.parseInt(id), today, type);
        bankAccountDao.save(bankAccount);

        view.displayMessage("Account Created Successfully!");
    }

}