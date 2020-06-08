package test;

import application.controllers.TransactionController;
import application.model.BankAccount;
import application.model.dao.BankAccountDao;
import application.util.DatabaseManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionControllerTest {

    private MockView mockView;
    private TransactionController transactionController;
    private BankAccount testAccount;

    @Before
    public void setUp() throws Exception {
        mockView = new MockView();
        transactionController = new TransactionController(mockView);
    }



    @Test
    public void performDeposit() {
        transactionController.performDeposit(1111, 1111, -100, "Deposit");
        assertEquals(mockView.getMsg(), "Wrong amount!");

        transactionController.performDeposit(1111, 1111, 100, "Deposit");
        assertEquals(mockView.getMsg(), "Bank account does not exists!");
    }

    @Test
    public void performWithdraw() {
        transactionController.performWithdraw(1111, -100);
        assertEquals(mockView.getMsg(), "Wrong amount!");

        transactionController.performWithdraw(1111, 100);
        assertEquals(mockView.getMsg(), "Bank account does not exists!");
    }

    @After
    public void tearDown() throws Exception {
    }
}