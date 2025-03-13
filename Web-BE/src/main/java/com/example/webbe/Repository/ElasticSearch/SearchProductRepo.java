package com.example.webbe.Repository.ElasticSearch;

import com.example.webbe.Entity.ElasticSearch.ProductSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchProductRepo extends ElasticsearchRepository<ProductSearch, String> {
}
