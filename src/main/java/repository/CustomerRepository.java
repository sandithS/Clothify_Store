package repository;

import model.dto.Customer;

import java.sql.ResultSet;

public interface CustomerRepository {

    void addCustomer(Customer customer);

    ResultSet getAllCustomers();

    ResultSet searchCustomer(String custId);

    void updateCustomer(Customer customer);

    void deleteCustomer(String custId);
}
