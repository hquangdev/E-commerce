package com.example.webbe.Repository.ElasticSearch;

import com.example.webbe.Entity.ElasticSearch.ProductSearch;
import com.example.webbe.Entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchProductRepo extends ElasticsearchRepository<ProductSearch, String> {

    //xóa lan 3
    void delete(Product product);
}
