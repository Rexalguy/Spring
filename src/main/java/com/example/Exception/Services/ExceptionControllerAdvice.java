package com.example.Exception.Services;

import com.example.Exception.Models.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyException(){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not Enough Money");
        return ResponseEntity.badRequest().body(errorDetails);
    }
}
