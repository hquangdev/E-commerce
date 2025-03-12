package com.example.webbe.Entity;

import co.elastic.clients.elasticsearch._types.query_dsl.TextQueryType;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName = "slide")
public class SlideSearch {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private String content;

    @Field(type = FieldType.Integer)
    private Integer releaseYear;
//
//    public ResponseEntity<ResponseDto<Object>> searchAll(String keyword) {
//        try {
//            SearchResponse<Object> response = elasticsearchOperations.search(s -> s
//                            .index("albums", "songs", "artist", "playlists")
//                            .query(q -> q.multiMatch(m -> m
//                                    .fields("name")
//                                    .query(keyword)
//                                    .fuzziness("AUTO")
//                                    .type(TextQueryType.BoolPrefix)
//                            )),
//                    Object.class
//            );
//
//            List<Map<String, Object>> results = response.hits().hits().stream()
//                    .map(hit -> {
//                        Map<String, Object> result = new HashMap<>();
//                        result.put("index", hit.index());
//                        result.put("data", hit.source());
//                        return result;
//                    })
//                    .collect(Collectors.toList());
//
//            return ResponseBuilder.okResponse(
//                    languageService.getMessage("success"),
//                    results,
//                    StatusCodeEnum.SUCCESS200
//            );
//
//        } catch (Exception e) {
//            return ResponseBuilder.badRequestResponse(
//                    languageService.getMessage("no.content.found"),
//                    StatusCodeEnum.NO_CONTENT204
//            );
//        }
//    }
}
