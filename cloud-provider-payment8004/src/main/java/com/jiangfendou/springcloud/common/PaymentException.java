package com.jiangfendou.springcloud.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class PaymentException extends RuntimeException {

    private static final long serialVersionUID = 1321372647800456847L;

    /** error code */
    protected ApiError apiError;

    /** error message */
    protected HttpStatus httpStatus;

    /**
     * Constructor.
     *
     */
    public PaymentException(HttpStatus httpStatus, ApiError apiError) {
        this.httpStatus = httpStatus;
        this.apiError = apiError;
    }

}
