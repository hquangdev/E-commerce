package com.example.webbe.Controller;

import com.example.webbe.DTO.Request.ProductRequest;
import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/product")
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseDto<Object>> addProduct(@ModelAttribute ProductRequest productRequest){
        return productService.addProduct(productRequest);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<ResponseDto<Object>> updateProduct(@PathVariable String id, @ModelAttribute ProductRequest productRequest){
        return productService.editProduct(id, productRequest);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseDto<Object>> deleteProduct(@PathVariable String id){
        return productService.deleteProduct(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseDto<Object>> getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }

    @GetMapping
    public ResponseEntity<ResponseDto<Object>> listProduct(){
        return productService.getAllProduct();
    }
}
