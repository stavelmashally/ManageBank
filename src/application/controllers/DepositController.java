package application.controllers;

import application.model.BankAccount;
import application.model.dao.BankAccountDao;
import application.view.DepositView;

public class DepositController {

    DepositView view;
    BankAccountDao bankAccountDao;

    public DepositController(DepositView depositView){
        this.view = depositView;
        bankAccountDao = new BankAccountDao();
    }

    public void makeDeposit(String accountNo, double amount){

        if (amount <= 0){
            view.displayMessage("Wrong amount!");
        }

        BankAccount bankAccount = bankAccountDao.findById(Integer.parseInt(accountNo));
        if(bankAccount != null){
            double newBalance = bankAccount.getBalance() + amount;
            bankAccount.setBalance(newBalance);
            bankAccountDao.update(bankAccount);
            view.displayMessage("Deposit Successful!");
        }
    }
}
