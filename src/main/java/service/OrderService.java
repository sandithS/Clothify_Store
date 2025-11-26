package service;

import javafx.collections.ObservableList;
import model.dto.Order;

public interface OrderService {

    boolean placeOrders(Order order);

    ObservableList<Order> getAllOrders();
}
