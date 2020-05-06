package application.model.dao;

import application.model.Customer;

import java.util.List;

public class CustomerDao implements Dao<Customer>{

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void save(Customer customer) {
        String query = "INSERT INTO customers VALUES(customer)";
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }
}
