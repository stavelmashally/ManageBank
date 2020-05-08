package application.controllers;

import application.model.BankAccount;
import application.model.Transaction;
import application.model.dao.BankAccountDao;
import application.model.dao.TransactionDao;
import application.view.View;

public class TransactionController extends Controller{

    TransactionDao transactionDao;
    BankAccountDao bankAccountDao;

    public TransactionController(View view){
        this.view = view;
        transactionDao = new TransactionDao();
        bankAccountDao = new BankAccountDao();
    }

    public void performDeposit(int fromAccount, int toAccount, double amount){

        if (amount <= 0) {
            view.displayMessage("Wrong amount!");
            return;
        }

        BankAccount bankAccount = bankAccountDao.findById(toAccount);

        if(bankAccount != null){
            double newBalance = bankAccount.getBalance() + amount;
            bankAccount.setBalance(newBalance);
            bankAccountDao.update(bankAccount);

            // Store the transaction in DB
            Transaction transaction = new Transaction(amount, "deposit", fromAccount, toAccount);
            transactionDao.save(transaction);
        }

    }

    public void performWithdraw(int fromAccount, double amount){

        if (amount <= 0) {
            view.displayMessage("Wrong amount!");
            return;
        }

        BankAccount bankAccount = bankAccountDao.findById(fromAccount);

        if (bankAccount != null){
            double newBalance = bankAccount.getBalance() - amount;
            bankAccount.setBalance(newBalance);
            bankAccountDao.update(bankAccount);

            // Store the transaction in DB
            Transaction transaction = new Transaction(amount, "withdraw", fromAccount, fromAccount);
            transactionDao.save(transaction);
        }
    }
}
