package com.server.handler;

import com.server.api.ResponseDto;
import com.server.exception.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BadResponseHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDto MethodArgumentNotValidException(MethodArgumentNotValidException mx) {
        return new ResponseDto(mx.getMessage());
    }
}
