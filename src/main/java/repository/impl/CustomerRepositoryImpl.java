package repository.impl;

import db.DBConnection;
import model.dto.Customer;
import repository.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public void addCustomer(Customer customer) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customer VALUES(?,?,?,?)");

            preparedStatement.setObject(1, customer.getId());
            preparedStatement.setObject(2, customer.getName());
            preparedStatement.setObject(3, customer.getPhoneNumber());
            preparedStatement.setObject(4, customer.getEmail());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet getAllCustomers() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Customer");
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet searchCustomer(String custId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Customer WHERE id = ? ");
            preparedStatement.setObject(1,custId);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Customer SET name=?, phoneNumber=?, email=? WHERE id=?");

            preparedStatement.setObject(1, customer.getName());
            preparedStatement.setObject(2, customer.getPhoneNumber());
            preparedStatement.setObject(3, customer.getEmail());
            preparedStatement.setObject(4, customer.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCustomer(String custId) {
        try {
            DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM Customer WHERE id='" + custId + "'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
