package test;

import application.model.BankAccount;
import application.model.dao.BankAccountDao;
import application.util.DatabaseManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BankAccountDaoTest {

    private BankAccount testAccount1;
    private BankAccount testAccount2;
    private BankAccountDao bankAccountDao;

    @Before
    public void setup(){

        bankAccountDao = new BankAccountDao();

        testAccount1 = BankAccount.builder()
                .withCustomerId(1234)
                .withAccountType("Normal")
                .build();
        testAccount2 = BankAccount.builder()
                .withCustomerId(1235)
                .withAccountType("Business")
                .build();

        bankAccountDao.save(testAccount1);
        bankAccountDao.save(testAccount2);
    }

    @Test
    public void findAll() {
        List<BankAccount> bankAccounts = bankAccountDao.findAll();
        assertEquals(2, bankAccounts.size());
    }

    @After
    public void tearDown(){
        DatabaseManager.getInstance().executeUpdate("DELETE FROM accounts WHERE customerId=" +
                testAccount1.getCustomerId());
        DatabaseManager.getInstance().executeUpdate("DELETE FROM accounts WHERE customerId=" +
                testAccount2.getCustomerId());
    }
}