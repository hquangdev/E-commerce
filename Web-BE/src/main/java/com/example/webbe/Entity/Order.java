//package com.example.webbe.Entity;
//
//import jakarta.persistence.*;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Entity(name = "orders")
//@Builder
//@Data
//@NoArgsConstructor
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String id;
//
//    @Column(name = "user_id", columnDefinition = "VARCHAR(500)")
//    private String userId;
//
//    @Column(name = "product_id", columnDefinition = "VARCHAR(500)")
//    private String productId;
//
//    @Column(name = "total_price", columnDefinition = "DOUBLE")
//    private double totalPrice;
//
//    private LocalDateTime createdAt;
//
//    @PrePersist
//    protected void onCreate() {
//        createdAt = LocalDateTime.now();
//    }
//
//}
