package com.example.webbe.exception;

import com.example.webbe.DTO.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ResponseDto> handlingRuntimeException(RuntimeException exception){
        ResponseDto responseDto = new ResponseDto<>();

        responseDto.setCode(1001);
        responseDto.setMessage(exception.getMessage());

        return ResponseEntity.badRequest().body(responseDto);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ResponseDto> handlingAppException(AppException exception){
        EnumCode enumCode = exception.getEnumCode();
        ResponseDto responseDto = new ResponseDto<>();

        responseDto.setCode(exception.getEnumCode().getCode());
        responseDto.setMessage(exception.getEnumCode().getMess());

        return ResponseEntity.status(enumCode.getStatusCode())
                                .body(responseDto);
    }


    @ExceptionHandler(value = AccessDeniedException.class)
    ResponseEntity<ResponseDto> handlingAccessDeniedException(AccessDeniedException exception){
        EnumCode enumCode = EnumCode.UNAUTHORIZED;

        return ResponseEntity.status(enumCode.getStatusCode()).body(
                ResponseDto.builder()
                        .code(enumCode.getCode())
                        .message(enumCode.getMess())
                        .build()
        );
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
        ResponseEntity<ResponseDto> handlingValidation(MethodArgumentNotValidException exception){
        String enumKey = exception.getFieldError().getDefaultMessage();

        EnumCode enumCode = EnumCode.valueOf(enumKey);
        ResponseDto responseDto = new ResponseDto();

        responseDto.setMessage(enumCode.getMess());
        responseDto.setCode(enumCode.getCode());

        return ResponseEntity.badRequest().body(responseDto);
    }


}
