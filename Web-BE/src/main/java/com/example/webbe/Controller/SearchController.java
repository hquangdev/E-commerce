package com.example.webbe.Controller;


import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.Service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/home/search")
public class SearchController {

    private final SearchService searchService;

    //search product
    @GetMapping
    public ResponseEntity<ResponseDto<Object>> searchProduct(@RequestParam String keyword){
       return searchService.getProduct(keyword);
    }
}
