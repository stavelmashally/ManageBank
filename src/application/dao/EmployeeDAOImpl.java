package application.dao;

import application.model.Employee;
import application.util.DatabaseManager;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{


    @Override
    public List<Employee> getAllEmployees() {
        String query = "SELECT * FROM EMPLOYEE";
        return DatabaseManager.getInstance().executeQuery(query);
    }

    @Override
    public Employee findByEmail(String email) {
        String query = "SELECT * FROM EMPLOYEE WHERE email = email";
        return null;
    }
}
