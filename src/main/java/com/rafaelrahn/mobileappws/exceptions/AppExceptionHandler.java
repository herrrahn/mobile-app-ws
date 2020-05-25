package com.rafaelrahn.mobileappws.exceptions;

import com.rafaelrahn.mobileappws.models.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        String message = ex.getLocalizedMessage();
        if (message == null) {
            message = ex.toString();
        }
        ErrorMessage errorMessage = new ErrorMessage(new Date(), message);
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
    public ResponseEntity<Object> handleSpecificException(Exception ex, WebRequest request) {
        String message = ex.getLocalizedMessage();
        if (message == null) {
            message = ex.toString();
        }
        message =  "SE: " + message;
        ErrorMessage errorMessage = new ErrorMessage(new Date(), message);
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
