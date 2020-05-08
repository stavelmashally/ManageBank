package application.model.dao;

import application.model.Employee;
import application.model.DatabaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EmployeeDao implements Dao<Employee>{

    @Override
    public Employee findByEmail(String email){
        String query = "SELECT * FROM employees WHERE email='" + email + "'";
        return parse(DatabaseManager.getInstance().executeQuery(query));
    }

    @Override
    public Employee findById(int id) {
        return null;
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

    private Employee parse(ResultSet resultSet){
        try {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("ID"));
            employee.setFirstName(resultSet.getString("fname"));
            employee.setLastName(resultSet.getString("lname"));
            employee.setEmail(resultSet.getString("email"));
            employee.setPassword(resultSet.getString("password"));
            employee.setRole(resultSet.getString("role"));
            employee.setPrivileges(resultSet.getString("privileges"));
            return employee;
        } catch (SQLException e) {
            return null;
        }
    }
}
