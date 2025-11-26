package service.impl;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.Customer;
import model.dto.Order;
import model.dto.Product;
import service.*;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaceOrderServiceImpl implements PlaceOrderService {

    CustomerService customerService = new CustomerServiceImpl();
    ProductService productService = new ProductServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    OrderDetailService orderDetailService = new OrderDetailServiceImpl();

    @Override
    public Customer getCustomer(String customerId) {
        return customerService.searchCustomer(customerId);
    }

    @Override
    public Product getProduct(String productId) {
        return productService.searchProduct(productId,null);
    }

    @Override
    public void placeOrder(Order order, ObservableList<CartItem> cartItemObservableList) throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);

            boolean isAddOrder = orderService.placeOrders(order);

            if (isAddOrder){
                boolean isAddOrderDetails = orderDetailService.addOrderDetails(order, cartItemObservableList);
                if (isAddOrderDetails){
                    if(productService.updateProductQuantity(cartItemObservableList)){
                        // JOptionPane.showMessageDialog(null,"Order Placed..");
                        connection.commit();
                    }
                }
            }
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }finally {
            connection.setAutoCommit(true);
        }
    }
}
