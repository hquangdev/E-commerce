package com.example.webbe.Service;

import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchHit;
import java.util.List;
import java.util.stream.Collectors;
import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.exception.EnumCode;
import com.example.webbe.exception.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class SearchService {

    private final ElasticsearchOperations elasticsearchOperations;

    public ResponseEntity<ResponseDto<Object>> getProduct(String keyword) {
        try {
            Query query = NativeQuery.builder()
                    .withQuery(q -> q
                            .bool(b -> b
                                    .should(s -> s.matchPhrase(mp -> mp
                                            .field("name")
                                            .query(keyword)
                                    ))
                                    .should(s -> s.match(m -> m
                                            .field("name")
                                            .query(keyword)
                                            .fuzziness("1")
                                            .minimumShouldMatch("50%")
                                    ))
                                    .should(s -> s.prefix(p -> p
                                            .field("name")
                                            .value(keyword)
                                    ))
                            )
                    )
                    .build();

            SearchHits<Object> searchHits = elasticsearchOperations.search(query, Object.class);

            List<Object> results = searchHits.getSearchHits().stream()
                    .map(SearchHit::getContent)
                    .collect(Collectors.toList());

            return ResponseBuilder.okResponse(EnumCode.SEARCH_SUCCESSFULLY, results);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBuilder.failedResponse(EnumCode.NO_CONTENT);
        }
    }

}
