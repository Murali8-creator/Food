package org.foodorder.backend.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "order")
@Getter
@Setter
@ToString
public class Order {

    @Id
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private String email;

    private long sequence;

    private List<CartItem> cartItems;
}