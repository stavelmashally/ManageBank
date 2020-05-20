package application.controllers;

import application.model.BankAccount;
import application.model.Transaction;
import application.model.dao.BankAccountDao;
import application.model.dao.TransactionDao;
import application.util.Constants;
import application.view.View;

public class TransactionController extends Controller{

    private TransactionDao transactionDao;
    private BankAccountDao bankAccountDao;

    public TransactionController(View view){
        this.view = view;
        transactionDao = new TransactionDao();
        bankAccountDao = new BankAccountDao();
    }

    public void performDeposit(int fromAccount, int toAccount, double amount, String type){

        if (amount <= 0) {
            view.displayMessage("Wrong amount!");
            return;
        }

        if (type.equals(Constants.TRANSFER)){
            performWithdraw(fromAccount, amount);
        } else {
            toAccount = fromAccount;
        }


        BankAccount toBankAccount = bankAccountDao.findById(toAccount);

        if(toBankAccount == null){
            view.displayMessage("Bank account does not exists!");
            return;
        }

        double newBalance = toBankAccount.getBalance() + amount;
        toBankAccount.setBalance(newBalance);
        bankAccountDao.update(toBankAccount);

        // Store the transaction in DB
        Transaction transaction = new Transaction(amount, "deposit", fromAccount, toAccount);
        transactionDao.save(transaction);

        view.displayMessage("Deposit Successful!");
    }

    public void performWithdraw(int fromAccount, double amount){

        if (amount <= 0) {
            view.displayMessage("Wrong amount!");
            return;
        }

        BankAccount bankAccount = bankAccountDao.findById(fromAccount);

        if(bankAccount == null){
            view.displayMessage("Bank account does not exists!");
            return;
        }

        double newBalance = bankAccount.getBalance() - amount;
        bankAccount.setBalance(newBalance);
        bankAccountDao.update(bankAccount);

        // Store the transaction in DB
        Transaction transaction = new Transaction(amount, "withdraw", fromAccount, fromAccount);
        transactionDao.save(transaction);

        view.displayMessage("Withdraw Successful!");
    }
}
