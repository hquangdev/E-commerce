package com.example.webbe.Service;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.webbe.DTO.ResponseDto;
import com.example.webbe.exception.EnumCode;
import com.example.webbe.exception.ResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SearchService {

    private final ElasticsearchOperations elasticsearchOperations;

//    public ResponseEntity<ResponseDto<Object>> getProduct(String keyword) {
//        try {
//            SearchResponse<Object> response = elasticsearchOperations.search(searchRequest -> searchRequest
//                    .index("product")
//                    .query(queryBuilder -> queryBuilder.bool(boolQuery -> boolQuery
//                            .should(phraseQuery -> phraseQuery.matchPhrase(matchPhrase -> matchPhrase
//                                    .field("name")
//                                    .query(keyword)
//                            ))
//                            .should(matchQuery -> matchQuery.match(match -> match
//                                    .field("name")
//                                    .query(keyword)
//                                    .fuzziness("1")
//                                    .minimumShouldMatch("50%")
//                            ))
//                            .should(prefixQuery -> prefixQuery.prefix(prefix -> prefix
//                                    .field("name")
//                                    .value(keyword)
//                            ))
//                    )),Object.class
//            );
//
//            List<Object> results = response.hits().hits().stream()
//                    .map(Hit::source)
//                    .collect(Collectors.toList());
//
//            return ResponseBuilder.okResponse(EnumCode.SUCCESSFULLY, results);
//
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//        return null;
//    }

}
