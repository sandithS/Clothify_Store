package model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Order {

    private String OrderID;
    private String Date;
    private String customerID;
}
