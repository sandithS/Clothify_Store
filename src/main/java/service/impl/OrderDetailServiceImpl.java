package service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.Order;
import model.dto.OrderDetail;
import repository.impl.OrderDetailRepositoryImpl;
import service.OrderDetailService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailServiceImpl implements OrderDetailService {

    OrderDetailRepositoryImpl orderDetailRepository = new OrderDetailRepositoryImpl();

    @Override
    public ObservableList<OrderDetail> getAllOrderDetails() {
        ObservableList<OrderDetail> orderDetailsList = FXCollections.observableArrayList();

        ResultSet resultSet = orderDetailRepository.getAllOrderDetails();

        try {
            while (resultSet.next()) {
                OrderDetail orderDetail = new OrderDetail(
                        resultSet.getString("OrderID"),
                        resultSet.getString("productId"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("total")
                );
                orderDetailsList.add(orderDetail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetailsList;
    }

    @Override
    public boolean addOrderDetails(Order order, ObservableList<CartItem> cartItems) {
        boolean isAdd = false;

        for (CartItem cartItem: cartItems){
            isAdd = orderDetailRepository.addOrderDetails(
                    new OrderDetail(
                            order.getOrderID(),
                            cartItem.getProductId(),
                            cartItem.getQuantity(),
                            cartItem.getTotalPrice()
                    )
            );
            if (isAdd == false){
                break;
            }
        }
        return isAdd;
    }
}
