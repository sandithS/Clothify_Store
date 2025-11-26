package service;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.Customer;
import model.dto.Order;
import model.dto.Product;

import java.sql.SQLException;

public interface PlaceOrderService {

    Customer getCustomer(String customerId);

    Product getProduct(String productId);

    void placeOrder(Order order, ObservableList<CartItem> cartItemObservableList) throws SQLException;
}
