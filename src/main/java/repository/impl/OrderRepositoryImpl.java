package repository.impl;

import db.DBConnection;
import model.dto.Order;
import repository.OrderRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public boolean placeOrder(Order order) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Orders VALUES(?,?,?)");

            preparedStatement.setObject(1, order.getOrderID());
            preparedStatement.setObject(2, order.getDate());
            preparedStatement.setObject(3, order.getCustomerID());

            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet getAllOrders() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Orders");
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
