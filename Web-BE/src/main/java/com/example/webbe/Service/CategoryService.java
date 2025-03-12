package com.example.webbe.Service;

import com.example.webbe.DTO.Request.CategoryRequest;
import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.Entity.Category;
import com.example.webbe.Mapper.CategoryMapper;
import com.example.webbe.Repository.CategoryRepository;
import com.example.webbe.exception.EnumCode;
import com.example.webbe.exception.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public ResponseEntity<ResponseDto<Object>> addCategory(CategoryRequest categoryRequest){
        try{
            Category category = categoryMapper.toCategory(categoryRequest);

            categoryRepository.save(category);
            return ResponseBuilder.okResponse(EnumCode.SUCCESSFULLY,category);
        }catch (Exception e){
            return ResponseBuilder.failedResponse(EnumCode.ADD_CATEGORY_FAILED);
        }
    }

    public ResponseEntity<ResponseDto<Object>> editCategory(String id, CategoryRequest categoryRequest){

        Category categoryId = categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Category not found with id: " + id));
        try{
            categoryId.setName(categoryRequest.getName());
            categoryId.setDescription(categoryRequest.getDescription());

            categoryRepository.save(categoryId);

            return ResponseBuilder.okResponse(EnumCode.SUCCESSFULLY, categoryId);
        }catch (Exception e){
            return ResponseBuilder.failedResponse(EnumCode.EDIT_CATEGORY_FAILED);
        }
    }

    public ResponseEntity<ResponseDto<Object>> getAllCategory(){
        var list = categoryRepository.findAll();

        return ResponseBuilder.okResponse(EnumCode.SUCCESSFULLY, list);
    }

    public ResponseEntity<ResponseDto<Object>> deleteCategorỵ̣(String id){
        Category categoryId = categoryRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("Category not found with id: " + id));

       categoryRepository.deleteById(id);
        return ResponseBuilder.okResponse(EnumCode.SUCCESSFULLY, null);
    }

    public ResponseEntity<ResponseDto<Object>> getCategory(String id){
        Category categoryId = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ko thấy id danh mục" + id));
        return ResponseBuilder.okResponse(EnumCode.SUCCESSFULLY,categoryId);
    }
}
