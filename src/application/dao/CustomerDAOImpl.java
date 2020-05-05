package application.dao;

import application.model.Customer;

public class CustomerDAOImpl implements CustomerDAO{

    public void addCustomer(Customer customer){
        String query = "INSERT INTO customers VALUES(customer)";
    }

}
