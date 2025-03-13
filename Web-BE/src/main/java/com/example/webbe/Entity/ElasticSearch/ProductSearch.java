package com.example.webbe.Entity.ElasticSearch;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "product")
public class ProductSearch {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String description;

    @Getter
    @Field(type = FieldType.Text)
    private String image;

    @Field(type = FieldType.Double)
    private Double price;

    @Field(type = FieldType.Integer)
    private int quantity;

    @Field(type = FieldType.Integer)
    private int status;

    @Field(type = FieldType.Date)
    private LocalDateTime createdAt;

    @Field(type = FieldType.Date)
    private LocalDateTime updatedAt;

    public void setImage(String image) {
        this.image = image;
    }
}
