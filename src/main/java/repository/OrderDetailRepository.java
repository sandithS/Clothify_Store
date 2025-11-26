package repository;

import model.dto.OrderDetail;

import java.sql.ResultSet;

public interface OrderDetailRepository {

    ResultSet getAllOrderDetails();

    boolean addOrderDetails(OrderDetail orderDetails);
}
