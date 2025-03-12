package com.example.webbe.Entity.ElasticSearch;


import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "product")
public class Product {
    private String id;
    private String name;
}
