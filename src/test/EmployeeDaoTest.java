package test;

import application.model.Employee;
import application.model.dao.EmployeeDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeDaoTest {

    private Employee testEmployee;
    private EmployeeDao employeeDao;

    @Before
    public void setup(){
        employeeDao = new EmployeeDao();
        testEmployee = new Employee(1111, "test", "test", "test@gmail.com",
                "password", "manager", "A");
        employeeDao.save(testEmployee);
    }

    @Test
    public void findByEmail() {
        Employee employee = employeeDao.findByEmail(testEmployee.getEmail());
        assertEquals(testEmployee.getEmail(), employee.getEmail());
    }

    @Test
    public void findById() {
        Employee employee = employeeDao.findById(testEmployee.getId());
        assertEquals(testEmployee.getId(), employee.getId());
    }

    @After
    public void tearDown(){
        employeeDao.delete(testEmployee.getId());
    }
}