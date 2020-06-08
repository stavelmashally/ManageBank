package test;

import application.controllers.LoginController;
import application.model.Employee;
import application.model.dao.BankAccountDao;
import application.model.dao.EmployeeDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginControllerTest {

    private LoginController loginController;
    private MockView mockView;
    private Employee testEmployee;
    private EmployeeDao employeeDao;

    @Before
    public void setUp() throws Exception {
        mockView = new MockView();
        employeeDao = new EmployeeDao();
        testEmployee = new Employee(1111, "test", "test", "test@gmail.com",
                "password", "manager", "A");
        employeeDao.save(testEmployee);
        loginController = new LoginController(mockView);

    }

    @Test
    public void login() {
        assertFalse(loginController.login("",""));

        loginController.login("sa","11");
        assertEquals(mockView.getMsg(), "Wrong Email or Password!");

        loginController.login("test@com","111111");
        assertEquals(mockView.getMsg(), "Email does not exists!");

        loginController.login("test@gmail.com","1111");
        assertEquals(mockView.getMsg(), "Wrong Email or Password!");

        assertTrue(loginController.login("test@gmail.com", "password"));
    }

    @After
    public void tearDown() throws Exception {
        employeeDao.delete(testEmployee.getId());
    }

}