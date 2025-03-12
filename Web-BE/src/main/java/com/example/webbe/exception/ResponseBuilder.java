package com.example.webbe.exception;

import com.example.webbe.DTO.ResponseDto;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder  {
    // Phương thức tĩnh để xây dựng ResponseDto với dữ liệu trả về
    public static <T> ResponseEntity<ResponseDto<T>> okResponse(EnumCode enumCode, T data) {
        ResponseDto<T> responseDto = ResponseDto.<T>builder()
                .code(enumCode.getCode())
                .message(enumCode.getMess())
                .data(data)
                .build();

        return new ResponseEntity<>(responseDto, enumCode.getStatusCode());
    }

    public static <T> ResponseEntity<ResponseDto<T>> failedResponse(EnumCode enumCode) {
        ResponseDto<T> responseDto = ResponseDto.<T>builder()
                .code(enumCode.getCode())
                .message(enumCode.getMess())
                .build();

        return new ResponseEntity<>(responseDto, enumCode.getStatusCode());
    }
}
