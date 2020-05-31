package test;

import application.model.BankAccount;
import application.model.Transaction;
import application.model.dao.BankAccountDao;
import application.model.dao.TransactionDao;
import application.util.DatabaseManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TransactionDaoTest {

    private Transaction testTransaction1;
    private Transaction testTransaction2;
    private TransactionDao transactionDao;

    @Before
    public void setup(){
        transactionDao = new TransactionDao();

        testTransaction1 = new Transaction(500, "deposit", 1111, 2222);
        testTransaction2 = new Transaction(100, "withdraw", 2222, 2222);

        transactionDao.save(testTransaction1);
        transactionDao.save(testTransaction2);
    }

    @Test
    public void findAll() {
        List<Transaction> transactions = transactionDao.findAll();
        assertEquals(2, transactions.size());
    }

    @After
    public void tearDown(){
        DatabaseManager.getInstance().executeUpdate("DELETE FROM transactions WHERE fromAccount=" +
                testTransaction1.getFromAccount());
        DatabaseManager.getInstance().executeUpdate("DELETE FROM transactions WHERE fromAccount=" +
                testTransaction2.getFromAccount());
    }

}