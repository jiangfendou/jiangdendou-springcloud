package com.jiangfendou.springcloud.common;

import com.jiangfendou.springcloud.type.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class PaymentExceptionHandler  {


    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<ApiResponse> handleException(PaymentException e) {
        return new ResponseEntity<>(ApiResponse.failed(e.getHttpStatus(), e.getApiError()), e.getHttpStatus());
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ApiResponse> handleException(ArithmeticException e) {
        log.info("***********ArithmeticException Exception");
        return new ResponseEntity<>(ApiResponse.failed(HttpStatus.INTERNAL_SERVER_ERROR, new ApiError(ErrorCode.CREAT_ERROR.getCode(), ErrorCode.CREAT_ERROR.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
