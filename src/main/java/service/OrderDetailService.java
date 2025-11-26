package service;

import javafx.collections.ObservableList;
import model.dto.CartItem;
import model.dto.Order;
import model.dto.OrderDetail;

public interface OrderDetailService {

    ObservableList<OrderDetail> getAllOrderDetails();

    boolean addOrderDetails(Order order, ObservableList<CartItem> cartItems);
}
