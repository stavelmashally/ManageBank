package application.controllers;

import application.model.BankAccount;
import application.model.dao.BankAccountDao;
import application.view.AccountsView;
import application.view.View;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class AccountsController extends Controller{

    private BankAccountDao bankAccountDao;

    public AccountsController(View accountsView){
        this.view = accountsView;
        bankAccountDao = new BankAccountDao();
    }

    public List<BankAccount> getBankAccounts(){
        return bankAccountDao.findAll();
    }

}
