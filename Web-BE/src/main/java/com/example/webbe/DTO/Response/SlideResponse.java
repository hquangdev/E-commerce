package com.example.webbe.DTO.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SlideResponse {

    private String image;
    private String title;
    private String content;

}
