package application.dao;

import application.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    Employee findByEmail(String email);
}
