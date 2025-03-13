package com.example.webbe.Service;

import com.example.webbe.DTO.Request.ProductRequest;
import com.example.webbe.DTO.Response.ProductResponse;
import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.Entity.Category;
import com.example.webbe.Entity.ElasticSearch.ProductSearch;
import com.example.webbe.Entity.Product;
import com.example.webbe.Entity.ProductCategory;
import com.example.webbe.Mapper.ProductMapper;
import com.example.webbe.Repository.CategoryRepository;
import com.example.webbe.Repository.ElasticSearch.SearchProductRepo;
import com.example.webbe.Repository.ProductCategoryRepository;
import com.example.webbe.Repository.ProductRepository;
import com.example.webbe.exception.EnumCode;
import com.example.webbe.exception.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;
    private final ImageService imageService;
    private final SearchProductRepo searchProductRepo;

    private static final String image = "F:/web_edit/Web-BE/src/main/resources/static/images/product/";

    public ResponseEntity<ResponseDto<Object>> addProduct(ProductRequest productRequest){
        try {
            Product product = productMapper.toProduct(productRequest);

            MultipartFile img = productRequest.getImage();
            String imgPath = imageService.saveImage(img, image);
            product.setImage(imgPath);

            Category category = categoryRepository.findById(productRequest.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            product.setCategory(category);

            Product saveProduct = productRepository.save(product);

            ProductSearch productSearch = productMapper.toProductSearch(saveProduct);
            searchProductRepo.save(productSearch);
            ProductResponse productResponse = productMapper.productResponse(saveProduct);

            return ResponseBuilder.okResponse(
                    EnumCode.SUCCESSFULLY,
                    productResponse
            );

        }catch (Exception e){
            return ResponseBuilder.failedResponse(
                    EnumCode.ADD_PRODUCT_FAILED
            );
        }
    }

    public ResponseEntity<ResponseDto<Object>> editProduct(String id, ProductRequest productRequest){

        Product product = findProductById(id);
        try{
            product.setName(productRequest.getName());
            product.setDescription(productRequest.getDescription());
            product.setPrice(productRequest.getPrice());
            product.setUpdatedAt(LocalDateTime.now());
            MultipartFile img = productRequest.getImage();;
            if(img.isEmpty()){
                imageService.deleteImage(product.getImage(), image);

                String imgPath = imageService.saveImage(img, image);
                product.setImage(imgPath);
            }

            if (productRequest.getCategoryId() != null) {
                Category category = categoryRepository.findById(productRequest.getCategoryId())
                        .orElseThrow(() -> new RuntimeException("Không tìm thấy danh mục với ID: " + productRequest.getCategoryId()));
                product.setCategory(category);
            }
            Product saveProduct = productRepository.save(product);

            ProductSearch productSearch = productMapper.toProductSearch(saveProduct);
            searchProductRepo.save(productSearch);
            return ResponseBuilder.okResponse(EnumCode.SUCCESSFULLY, product);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseBuilder.failedResponse(EnumCode.ADD_PRODUCT_FAILED);
        }

    }

    public ResponseEntity<ResponseDto<Object>> deleteProduct(String id){
        Product product = findProductById(id);
        productRepository.delete(product);
        return ResponseBuilder.okResponse(EnumCode.DELETE_SUC, null);
    }

    public ResponseEntity<ResponseDto<Object>> getProduct(String id){
        Optional<Product> product = productRepository.findProductById(id);

        return ResponseBuilder.okResponse(EnumCode.SUCCESSFULLY, product);
    }

    public ResponseEntity<ResponseDto<Object>> getAllProduct(){
        try{
            List<Product> p = productRepository.findAllProducts();

            return ResponseBuilder.okResponse(EnumCode.SUCCESSFULLY,p);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseBuilder.failedResponse(EnumCode.GET_ALL_PRODUCT_FAILED);
        }
    }

    private Product findProductById(String id){
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Không tìm thấy sản phẩm: " + id));
    }
}
