package com.example.webbe.Mapper;

import com.example.webbe.DTO.Request.ProductRequest;
import com.example.webbe.DTO.Response.ProductResponse;
import com.example.webbe.Entity.ElasticSearch.ProductSearch;
import com.example.webbe.Entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "image", ignore = true)
    Product toProduct(ProductRequest productRequest);

    ProductResponse productResponse(Product product);

  //search
  @Mapping(target = "image", ignore = true)
  ProductSearch toProductSearch(Product product);
}
