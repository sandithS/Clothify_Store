package model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Customer {

    private String id;
    private String name;
    private String phoneNumber;
    private String email;

}
