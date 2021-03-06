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

    private BankAccountDao bankAccountDao;
    private CustomerDao customerDao;

    public CreateAccountController(View view){
        this.view = view;
        bankAccountDao = new BankAccountDao();
        customerDao = new CustomerDao();

    }

    public void createAccount(String id, String fname, String lname, String email, String phone,
                              String address, String city, String type){

        if(fname.isEmpty() || lname.isEmpty() || email.isEmpty() || phone.isEmpty() ||
                address.isEmpty() || city.isEmpty()){
            view.displayMessage("Wrong details!");
            return;
        }

        Customer customer = new Customer(Integer.parseInt(id), fname, lname, email, phone, address, city);
        customerDao.save(customer);

        BankAccount bankAccount = BankAccount.builder()
                .withCustomerId(Integer.parseInt(id))
                .withAccountType(type)
                .build();

        bankAccountDao.save(bankAccount);

        view.displayMessage("Account Created Successfully!");
    }

}