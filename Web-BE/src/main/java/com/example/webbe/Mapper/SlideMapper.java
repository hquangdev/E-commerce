package com.example.webbe.Mapper;

import com.example.webbe.DTO.Request.SlideRequest;
import com.example.webbe.DTO.Response.SlideResponse;
import com.example.webbe.Entity.Slide;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SlideMapper {

    @Mapping(target = "image", ignore = true)
    Slide toSlide(SlideRequest slideRequest);

    SlideResponse slideResponse(Slide slide);
}
