package application.model.dao;

import application.model.Customer;
import application.model.DatabaseManager;
import application.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements Dao<Customer>{

    @Override
    public Customer findByEmail(String email) {
        String query = "SELECT * FROM customers WHERE email='" + email + "'";
        return parse(DatabaseManager.getInstance().executeQuery(query));
    }

    @Override
    public Customer findById(int id) {
        String query = "SELECT * FROM customers WHERE id=" + id;
        return parse(DatabaseManager.getInstance().executeQuery(query));
    }

    @Override
    public List<Customer> findAll() {
        String query = "SELECT * FROM customers";
        return parseList(DatabaseManager.getInstance().executeQuery(query));
    }

    @Override
    public boolean save(Customer customer) {
        String query = "INSERT INTO customers (id,fname,lname,email,phone,address,city) VALUES (\n" +
                "" + customer.getId() + ",\n" +
                "'" + customer.getFirstName() + "',\n" +
                "'" + customer.getLastName() + "',\n" +
                "'" + customer.getEmail() + "',\n" +
                "'" + customer.getPhone() + "',\n" +
                "'" + customer.getAddress() + "',\n" +
                "'" + customer.getCity() + "'\n" + ");";
        return DatabaseManager.getInstance().executeInsert(query);
    }

    @Override
    public boolean update(Customer customer) {
        String query = "UPDATE customers SET"
                + " id=" + customer.getId()
                + ",fname='" + customer.getFirstName() + "'"
                + ",lname='" + customer.getLastName() + "'"
                + ",phone='" + customer.getPhone() + "'"
                + ",address='" + customer.getAddress()+ "'"
                + ",city='" + customer.getCity() + "'"
                + " WHERE id=" + customer.getId();
        return DatabaseManager.getInstance().executeUpdate(query);
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM customers WHERE id=" + id;
        return DatabaseManager.getInstance().executeUpdate(query);
    }

    private Customer parse(ResultSet resultSet){
        try {
            Customer customer = new Customer();
            customer.setId(resultSet.getInt("id"));
            customer.setFirstName(resultSet.getString("fname"));
            customer.setLastName(resultSet.getString("lname"));
            customer.setEmail(resultSet.getString("email"));
            customer.setPhone(resultSet.getString("phone"));
            customer.setAddress(resultSet.getString("address"));
            customer.setCity(resultSet.getString("city"));
            return customer;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private List<Customer> parseList(ResultSet resultSet){
        try {
            List<Customer> customers = new ArrayList<>();
            while (resultSet.next()){
                customers.add(parse(resultSet));
            }
            return customers;
        } catch (SQLException e){
            return null;
        }
    }
}
