package com.example.webbe.exception;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException{

    private final EnumCode enumCode;

    public AppException(EnumCode enumCode) {
        super(enumCode.getMess());
        this.enumCode = enumCode;
    }
}
