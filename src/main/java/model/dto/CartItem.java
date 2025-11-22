package model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class CartItem {

    private String productId;
    private String productName;
    private int quantity;
    private double price;
    private double totalPrice;
}
