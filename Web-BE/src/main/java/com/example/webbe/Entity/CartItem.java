package com.example.webbe.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String productId;
    private String name;
    private String image;
    private Double price;
    private Integer quantity;
    private  Double totalPrice;
}

