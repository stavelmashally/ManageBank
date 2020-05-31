package test;

import application.model.Customer;
import application.model.dao.CustomerDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerDaoTest {

    private CustomerDao customerDao;
    private Customer testCustomer;

    @Before
    public void setup(){
        customerDao = new CustomerDao();
        testCustomer = new Customer(1111, "test", "test", "test@gmail.com",
                "05476454833", "rotchild", "tel-aviv");
        customerDao.save(testCustomer);
    }

    @Test
    public void findByEmail() {
        Customer customer = customerDao.findByEmail(testCustomer.getEmail());
        assertEquals(testCustomer.getEmail(), customer.getEmail());
    }

    @Test
    public void findById() {
        Customer customer = customerDao.findById(testCustomer.getId());
        assertEquals(testCustomer.getId(), customer.getId());
    }

    @After
    public void tearDown(){
        customerDao.delete(testCustomer.getId());
    }
}