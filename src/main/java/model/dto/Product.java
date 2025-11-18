package model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Product {

    private String productId;
    private String name;
    private String description;
    private String supplierId;
    private double price;
    private int quantity;
}
