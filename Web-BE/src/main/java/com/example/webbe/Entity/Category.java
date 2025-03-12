package com.example.webbe.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", columnDefinition = "VARCHAR(500)")
    private String name;

    @Column(name = "description", columnDefinition = "VARCHAR(500)")
    private String description;
}
