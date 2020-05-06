package application.model.dao;

import application.model.BankAccount;

import java.util.List;

public class BankAccountDao implements Dao<BankAccount> {

    @Override
    public BankAccount findById(int id) {
        return null;
    }

    @Override
    public List<BankAccount> findAll() {
        String query = "SELECT * FROM accounts";
        return null;
    }

    @Override
    public void save(BankAccount bankAccount) {
        String query = "INSERT INTO accounts VALUES(account)";
    }

    @Override
    public void update(BankAccount bankAccount) {

    }

    @Override
    public void delete(BankAccount bankAccount) {

    }
}
