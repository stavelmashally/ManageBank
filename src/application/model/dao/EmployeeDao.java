package application.model.dao;

import application.model.Employee;
import application.model.DatabaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String query = "SELECT * FROM employees WHERE id=" + id;
        return parse(DatabaseManager.getInstance().executeQuery(query));
    }

    @Override
    public List<Employee> findAll() {
        String query = "SELECT * FROM employees";
        return parseList(DatabaseManager.getInstance().executeQuery(query));
    }

    @Override
    public boolean save(Employee employee) {
        String query = "INSERT INTO employees (id,fname,lname,email,password,role,privileges) VALUES (\n" +
                "" + employee.getId() + ",\n" +
                "'" + employee.getFirstName() + "',\n" +
                "'" + employee.getLastName() + "',\n" +
                "'" + employee.getEmail() + "',\n" +
                "'" + employee.getPassword() + "',\n" +
                "'" + employee.getRole() + "',\n" +
                "'" + employee.getPrivileges() + "'\n" + ");";
        return DatabaseManager.getInstance().executeInsert(query);
    }

    @Override
    public boolean update(Employee employee) {
        String query = "UPDATE employees SET"
                + " id=" + employee.getId()
                + ",fname='" + employee.getFirstName() + "'"
                + ",lname='" + employee.getLastName() + "'"
                + ",email='" + employee.getEmail() + "'"
                + ",password='" + employee.getPassword() + "'"
                + " ,role='" + employee.getRole() + "'"
                + ",privileges='" + employee.getPrivileges() + "'"
                + " WHERE id=" + employee.getId();
        return DatabaseManager.getInstance().executeUpdate(query);
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM employees WHERE id=" + id;
        return DatabaseManager.getInstance().executeUpdate(query);
    }

    private Employee parse(ResultSet resultSet){
        try {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
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

    private List<Employee> parseList(ResultSet resultSet){
        try {
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()){
                employees.add(parse(resultSet));
            }
            return employees;
        } catch (SQLException e){
            return null;
        }
    }
}
