package com.example.webbe.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", columnDefinition = "VARCHAR(500)")
    private String name;

    @Column(name = "description", columnDefinition = "VARCHAR(500)")
    private String description;

    @Getter
    @Column(name = "image", columnDefinition = "VARCHAR(500)")
    private String image;

    @Column(name = "price", columnDefinition = "Double")
    private Double price;

    @Column(name = "quantity", columnDefinition = "INT")
    private int quantity;

    private int status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    public void setImage(String image) {
        this.image = image;
    }
}
