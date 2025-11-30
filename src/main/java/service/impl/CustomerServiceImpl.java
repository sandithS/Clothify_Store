package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.Customer;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();

    @Override
    public void addCustomerDetails(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @Override
    public ObservableList<Customer> getAllCustomerDetails() {
        ObservableList<Customer> customerList = FXCollections.observableArrayList();

        ResultSet resultSet = customerRepository.getAllCustomers();

        try {
            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("email")
                );
                customerList.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }

    @Override
    public void updateCustomerDetails(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    @Override
    public void deleteCustomerDetails(String custId) {
        customerRepository.deleteCustomer(custId);
    }

    @Override
    public Customer searchCustomer(String custId) {
        ResultSet resultSet = customerRepository.searchCustomer(custId);

        try {
            resultSet.next();
            return new Customer(
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getString("email")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
