package com.server.handler;

import com.server.api.ResponseDto;
import com.server.exception.ExistenceException;
import com.server.exception.MethodArgumentNotValidException;
import com.server.exception.VerifyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BadResponseHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDto MethodArgumentNotValidException(MethodArgumentNotValidException mx) {
        return new ResponseDto(mx.getMessage());
    }

    @ExceptionHandler(ExistenceException.class)
    public ResponseDto ExistenceException(ExistenceException ex) {
        return new ResponseDto(ex.getMessage());
    }

    @ExceptionHandler(VerifyException.class)
    public ResponseDto VerifyException(VerifyException vx) { return new ResponseDto(vx.getMessage()); }
}
