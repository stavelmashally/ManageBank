package test;

import application.controllers.AccountsController;
import application.controllers.CreateAccountController;
import application.util.DatabaseManager;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateAccountControllerTest {

    private MockView mockView;
    private CreateAccountController createAccountController;
    private String id;

    @Before
    public void setUp() throws Exception {
        mockView = new MockView();
        createAccountController = new CreateAccountController(mockView);
        id = "1234";
    }

    @Test
    public void createAccount() {
        createAccountController.createAccount(id, "", "", "", "",
                "", "", "");
        assertEquals(mockView.getMsg(), "Wrong details!");

        createAccountController.createAccount(id, "test", "test", "test", "test",
                "test", "test", "Business");
        assertEquals(mockView.getMsg(), "Account Created Successfully!");
    }

    @After
    public void tearDown() throws Exception {
        DatabaseManager.getInstance().executeUpdate("DELETE FROM accounts WHERE customerId=" + id);
    }
}