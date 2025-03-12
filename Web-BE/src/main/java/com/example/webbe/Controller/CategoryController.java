package com.example.webbe.Controller;

import com.example.webbe.DTO.Request.CategoryRequest;
import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.Service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "add category", description = "add category")
    @PostMapping
    public ResponseEntity<ResponseDto<Object>> addCategory(@Valid @ModelAttribute CategoryRequest categoryRequest){
        return  categoryService.addCategory(categoryRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<Object>> editCategory(@PathVariable String id, @ModelAttribute CategoryRequest categoryRequest){
        return  categoryService.editCategory(id, categoryRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseDto<Object>> deleteCategory(@PathVariable String id){
        return  categoryService.deleteCategorỵ̣(id);
    }

    @GetMapping
    public ResponseEntity<ResponseDto<Object>> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseDto<Object>> getCategory(@PathVariable String id){
        return categoryService.getCategory(id);
    }
}
