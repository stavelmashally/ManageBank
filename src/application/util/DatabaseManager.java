package application.util;

import application.model.Employee;

public class DatabaseManager {

    private static DatabaseManager instance;

    public static DatabaseManager getInstance() {
        if (instance == null){
            instance = new DatabaseManager();
        }
        return instance;
    }

    private DatabaseManager(){}

    public Employee executeQuery(String sql){

        Employee employee = new Employee();
        employee.setId(111);
        employee.setPassword("123456");

        return employee;
    }
}
