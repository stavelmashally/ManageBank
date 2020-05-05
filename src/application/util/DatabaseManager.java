package application.util;

import application.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static DatabaseManager instance;

    public static DatabaseManager getInstance() {
        if (instance == null){
            instance = new DatabaseManager();
        }
        return instance;
    }

    private DatabaseManager(){}

    public List<Employee> executeQuery(String sql){

        List<Employee> employeeList = new ArrayList<>();

        Employee employee1 = new Employee();
        employee1.setFirstName("stav");
        employee1.setPassword("123");

        Employee employee2 = new Employee();
        employee2.setFirstName("sara");
        employee2.setPassword("123");
        employeeList.add(employee1);
        employeeList.add(employee2);

        return employeeList;
    }
}
