package application.dao;

import application.model.BankAccount;

public class BankAccountDAOImpl implements BankAccountDAO {


    @Override
    public void addBankAccount(BankAccount account) {
        String query = "INSERT INTO accounts VALUES(account)";

    }
}
