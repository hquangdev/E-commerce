package com.example.webbe.Service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.TextQueryType;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.webbe.DTO.Request.SlideRequest;
import com.example.webbe.DTO.Response.SlideResponse;
import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.Entity.Slide;
import com.example.webbe.Entity.SlideSearch;
import com.example.webbe.Mapper.SlideMapper;
import com.example.webbe.Repository.SlideRepository;
import com.example.webbe.exception.EnumCode;
import com.example.webbe.exception.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SlideService {

    private final SlideRepository slideRepository;
    private final SlideMapper slideMapper;
    private final ImageService imageService;

    private static final String image = "F:/web_edit/Web-BE/src/main/resources/static/images/slide/";

    private final ElasticsearchClient elasticsearchOperations;


    public ResponseEntity<ResponseDto<Object>> addSlide(SlideRequest slideRequest) {
        try {
            Slide slide = slideMapper.toSlide(slideRequest);

            MultipartFile img = slideRequest.getImage();

            String imagePath = imageService.saveImage(img, image);
            slide.setImage(imagePath);

            slideRepository.save(slide);

//            SlideSearch slideElasticsearch = new SlideSearch();
//            slideElasticsearch.setId(slide.getId());
//            slideElasticsearch.setTitle(slide.getTitle());
//            slideElasticsearch.setContent(slide.getContent());

            return ResponseBuilder.okResponse(EnumCode.ADD_SLIDE_SUCCESSFULLY, slide);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBuilder.failedResponse(EnumCode.ADD_SLIDE_FAILED);
        }
    }

    public ResponseEntity<ResponseDto<Object>> updateSlide(SlideRequest slideRequest, Long id) {
        Slide slide = slideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Slide với ID: " + id));
        try {
            slide.setTitle(slideRequest.getTitle());
            slide.setContent(slideRequest.getContent());

            MultipartFile img = slideRequest.getImage();
            if (img != null && !img.isEmpty()) {
                imageService.deleteImage(slide.getImage(), image);

                String imagePath = imageService.saveImage(img, image);
                slide.setImage(imagePath);
            }
            slideRepository.save(slide);

            return ResponseBuilder.okResponse(EnumCode.EDIT_SLIDE_SUCCESSFULLY, slide);
        } catch (Exception e){
            return  ResponseBuilder.failedResponse(EnumCode.EDIT_SLIDE_FAILED);
        }

    }

    public ResponseEntity<ResponseDto<Object>> deleteProduct(Long id) {
        Slide slide = slideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Slide với ID: " + id));
        slideRepository.delete(slide);
        return ResponseBuilder.okResponse(EnumCode.DELETE_SLIDE_SUCCESSFULLY, null);
    }

    public ResponseEntity<ResponseDto<Object>> getSlideById(Long id) {
        Slide slide = slideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Slide với ID: " + id));

        SlideResponse slideResponse = slideMapper.slideResponse(slide);
        return ResponseBuilder.okResponse(EnumCode.GET_SLIDE_SUCCESSFULLY, slideResponse);
    }


    public ResponseEntity<ResponseDto<Object>> getAllSLide() {
        var listSlide = slideRepository.findAll();

        return ResponseBuilder.okResponse(EnumCode.GET_ALL_SLIDE_SUCCESSFULLY, listSlide);
    }


}