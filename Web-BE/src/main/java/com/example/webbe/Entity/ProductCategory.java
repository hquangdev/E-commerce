package com.example.webbe.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "productCategory")
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "product_id", columnDefinition = "VARCHAR(64)")
    private String productId;

    @Column(name = "category_id", columnDefinition = "VARCHAR(64)")
    private String categoryId;
}
