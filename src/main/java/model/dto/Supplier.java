package model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Supplier {

    private String supplierId;
    private String productId;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
}
