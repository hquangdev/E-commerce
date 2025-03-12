package com.example.webbe.Mapper;

import com.example.webbe.DTO.Request.CategoryRequest;
import com.example.webbe.DTO.Response.CategoryResponse;
import com.example.webbe.Entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryRequest categoryRequest);

    CategoryResponse CategoryResponse(Category category);
}
