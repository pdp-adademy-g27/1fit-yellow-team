package com.example.demo.common.exceptions;


import com.example.demo.common.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class OneFitExceptionHandler {
    @ExceptionHandler(OtpException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse handleEarlyResentException(OtpException e) {
        return new CommonResponse(e.getMessage(), LocalDateTime.now(), HttpStatus.BAD_REQUEST.value());
    }
}
