package com.example.ExceptionHandling;

import com.example.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.MovieNotFoundException.class)
    public ResponseEntity<Response> handleMovieNotFoundException(CustomException.MovieNotFoundException ex) {
        return new ResponseEntity<>(new Response(404, ex.getMessage(), null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomException.GeneralException.class)
    public ResponseEntity<Response> handleGeneralException(CustomException.GeneralException ex) {
        return new ResponseEntity<>(new Response(500, ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleOtherExceptions(Exception ex) {
        return new ResponseEntity<>(new Response(500, "An unexpected error occurred: " + ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
