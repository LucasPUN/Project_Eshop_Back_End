package com.fsse2309.project_backend.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PayTransactionException extends RuntimeException {
    public PayTransactionException(String message) {
        super(message);
    }
}
