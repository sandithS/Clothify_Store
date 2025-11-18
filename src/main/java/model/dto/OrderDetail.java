package model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class OrderDetail {

    private String orderId;
    private String productId;
    private int quantity;
    private double total;
}
