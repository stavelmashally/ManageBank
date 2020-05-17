package application.controllers;

import application.model.BankAccount;
import application.model.Customer;
import application.model.dao.BankAccountDao;
import application.model.dao.CustomerDao;
import application.view.CreateAccountView;
import application.view.View;

import java.util.Calendar;
import java.util.Date;

public class CreateAccountController extends Controller{

    BankAccountDao bankAccountDao;
    CustomerDao customerDao;

    public CreateAccountController(View view){
        this.view = view;
        bankAccountDao = new BankAccountDao();
        customerDao = new CustomerDao();

    }
    public void createAccount(int id, String fname, String lname, String email, String phone,
                              String address, String city, String type){

        if(fname.isEmpty() || lname.isEmpty() || email.isEmpty() || phone.isEmpty() ||
                address.isEmpty() || city.isEmpty()){
            view.displayMessage("Wrong details!");
            return;
        }

        Customer customer = new Customer(id, fname, lname, email, phone, address, city);
        customerDao.save(customer);

        BankAccount bankAccount = new BankAccount(id, type);
        bankAccountDao.save(bankAccount);

        view.displayMessage("Account Created Successfully!");
    }

}