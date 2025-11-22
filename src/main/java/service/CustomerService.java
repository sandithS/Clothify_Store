package service;

import javafx.collections.ObservableList;
import model.dto.Customer;

public interface CustomerService {

    void addCustomerDetails(Customer customer);

    ObservableList<Customer> getAllCustomerDetails();

    void updateCustomerDetails(Customer customer);

    void deleteCustomerDetails(String custId);

    Customer searchCustomer(String custId);
}
