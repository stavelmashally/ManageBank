package application.controllers;

import application.model.dao.BankAccountDao;
import application.view.AccountsView;

public class AccountsController {

    AccountsView view;
    BankAccountDao bankAccountDao;

    public AccountsController(AccountsView accountsView){
        this.view = accountsView;
        bankAccountDao = new BankAccountDao();
    }

    public void getBankAccounts(){
        view.showAccounts(bankAccountDao.findAll());
    }
}
