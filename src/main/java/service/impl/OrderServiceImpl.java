package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.Order;
import repository.impl.OrderRepositoryImpl;
import service.OrderService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {

    OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();

    @Override
    public boolean placeOrders(Order order) {
        return orderRepository.placeOrder(order);
    }

    @Override
    public ObservableList<Order> getAllOrders() {
        ObservableList<Order> orderList = FXCollections.observableArrayList();

        ResultSet resultSet = orderRepository.getAllOrders();

        try {
            while (resultSet.next()) {
                Order order = new Order(
                        resultSet.getString("OrderID"),
                        resultSet.getString("Date"),
                        resultSet.getString("customerID")
                );
                orderList.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderList;
    }
}
