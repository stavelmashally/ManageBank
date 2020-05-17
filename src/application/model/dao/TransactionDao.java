package application.model.dao;

import application.model.DatabaseManager;
import application.model.Transaction;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao implements Dao<Transaction> {

    @Override
    public Transaction findByEmail(String email) {
        return null;
    }

    @Override
    public Transaction findById(int id) {
        String query = "SELECT * FROM transactions WHERE transactionId=" + id;
        return parse(DatabaseManager.getInstance().executeQuery(query));
    }

    @Override
    public List<Transaction> findAll() {
        String query = "SELECT * FROM transactions";
        return parseList(DatabaseManager.getInstance().executeQuery(query));
    }

    @Override
    public boolean save(Transaction transaction) {
        String query = "INSERT INTO transactions (amount,transactionType,fromAccount,toAccount) VALUES (\n" +
                "" + transaction.getAmount() + ",\n" +
                "'" + transaction.getTransactionType() + "',\n" +
                "" + transaction.getFromAccount() + ",\n" +
                "" +  transaction.getToAccount() + "\n" + ");";
        System.out.println(query);
        return DatabaseManager.getInstance().executeInsert(query);
    }

    @Override
    public boolean update(Transaction transaction) {
        String query = "UPDATE transactions SET"
                + ",amount=" + transaction.getAmount()
                + ",transactionType='" + transaction.getTransactionType() + "'"
                + ",fromAccount=" + transaction.getFromAccount()
                + ",toAccount=" + transaction.getToAccount()
                + " WHERE transactionId=" + transaction.getTransactionId();
        System.out.println(query);
        return DatabaseManager.getInstance().executeUpdate(query);
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM transactions WHERE transactionId=" + id;
        return DatabaseManager.getInstance().executeUpdate(query);
    }

    private Transaction parse(ResultSet resultSet){
        try {
            Transaction transaction = new Transaction();
            transaction.setTransactionId(resultSet.getInt("transactionId"));
            transaction.setAmount(resultSet.getDouble("amount"));
            transaction.setTransactionType(resultSet.getString("transactionType"));
            transaction.setFromAccount(resultSet.getInt("fromAccount"));
            transaction.setToAccount(resultSet.getInt("toAccount"));
            return transaction;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private List<Transaction> parseList(ResultSet resultSet){
        try {
            List<Transaction> transactions = new ArrayList<>();
            while (resultSet.next()){
                transactions.add(parse(resultSet));
            }
            return transactions;
        } catch (SQLException e){
            return null;
        }
    }
}
