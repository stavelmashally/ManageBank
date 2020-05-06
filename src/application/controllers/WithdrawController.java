package application.controllers;

import application.model.dao.BankAccountDao;
import application.view.WithdrawView;

public class WithdrawController {

    WithdrawView view;
    BankAccountDao bankAccountDao;

    public WithdrawController(WithdrawView withdrawView){
        this.view = withdrawView;
        bankAccountDao = new BankAccountDao();
    }

    public void makeWithdraw(String accountNo, double amount){

    }
}
