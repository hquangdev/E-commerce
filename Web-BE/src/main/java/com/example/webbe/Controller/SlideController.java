package com.example.webbe.Controller;

import com.example.webbe.DTO.Request.SlideRequest;
import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.Entity.SlideSearch;
import com.example.webbe.Service.SlideService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slide")
@RequiredArgsConstructor
public class SlideController {

    private final SlideService slideService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ResponseDto<Object>> addSlide(@Valid @ModelAttribute SlideRequest slideRequest){
        return slideService.addSlide(slideRequest);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<Object>> updateSlide(@Valid @ModelAttribute SlideRequest slideRequest, @PathVariable  Long id){
        return slideService.updateSlide(slideRequest, id);
    }

    @GetMapping
    public ResponseEntity<ResponseDto<Object>> listAllSlide(){
        return slideService.getAllSLide();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<Object>> geSlide(@PathVariable  Long id){
        return slideService.getSlideById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Object>> deleteSlide(@PathVariable  Long id){
        return slideService.deleteProduct(id);
    }

}
