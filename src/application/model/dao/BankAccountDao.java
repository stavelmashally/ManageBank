package application.model.dao;

import application.model.BankAccount;
import application.util.DatabaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDao implements Dao<BankAccount> {

    @Override
    public BankAccount findByEmail(String email) {
        return null;
    }

    @Override
    public BankAccount findById(int id) {
        String query = "SELECT * FROM accounts WHERE accountNo=" + id;
        System.out.println(query);
        return parse(DatabaseManager.getInstance().executeQuery(query));
    }

    @Override
    public List<BankAccount> findAll() {
        String query = "SELECT * FROM accounts";
        return parseList(DatabaseManager.getInstance().executeQuery(query));
    }

    @Override
    public boolean save(BankAccount bankAccount) {
        String query = "INSERT INTO accounts (customerId,balance,accountType) VALUES (\n" +
                "" + bankAccount.getCustomerId() + ",\n" +
                "" + bankAccount.getBalance() + ",\n" +
                "'" +  bankAccount.getAccountType() + "'\n" + ");";
        return DatabaseManager.getInstance().executeInsert(query);
    }

    @Override
    public boolean update(BankAccount bankAccount) {
        String query = "UPDATE accounts SET"
                + " customerId=" + bankAccount.getCustomerId()
                + ",balance=" + bankAccount.getBalance()
                + ",accountType='" + bankAccount.getAccountType() + "'"
                + " WHERE accountNo=" + bankAccount.getAccountNo();
        return DatabaseManager.getInstance().executeUpdate(query);
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM accounts WHERE accountNo=" + id;
        return DatabaseManager.getInstance().executeUpdate(query);
    }

    private BankAccount parse(ResultSet resultSet){
        try {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setAccountNo(resultSet.getInt("accountNo"));
            bankAccount.setCustomerId(resultSet.getInt("customerId"));
            bankAccount.setBalance(resultSet.getDouble("balance"));
            bankAccount.setAccountType(resultSet.getString("accountType"));
            return bankAccount;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private List<BankAccount> parseList(ResultSet resultSet){
        try {
            List<BankAccount> bankAccounts = new ArrayList<>();
            while (resultSet.next()){
                bankAccounts.add(parse(resultSet));
            }
            return bankAccounts;
        } catch (SQLException e){
            return null;
        }
    }
}
