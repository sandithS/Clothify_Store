package repository.impl;

import db.DBConnection;
import model.dto.OrderDetail;
import repository.OrderDetailRepository;
import repository.OrderRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailRepositoryImpl implements OrderDetailRepository {
    @Override
    public ResultSet getAllOrderDetails() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM OrderDetail");
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addOrderDetails(OrderDetail orderDetails) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO OrderDetail VALUES(?,?,?,?)");

            preparedStatement.setObject(1, orderDetails.getOrderId());
            preparedStatement.setObject(2, orderDetails.getProductId());
            preparedStatement.setObject(3, orderDetails.getQuantity());
            preparedStatement.setObject(4, orderDetails.getTotal());

            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
