package application.model.dao;

import application.model.Employee;
import application.util.DatabaseManager;

import java.util.List;

public class EmployeeDao implements Dao<Employee>{

    @Override
    public Employee findById(int id) {
        String query = "SELECT * FROM EMPLOYEE WHERE id = id";
        return DatabaseManager.getInstance().executeQuery(query);
    }

    @Override
    public List<Employee> findAll() {
        String query = "SELECT * FROM EMPLOYEE";
        return null;
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {

    }
}
