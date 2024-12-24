package com.example.ExceptionHandling;

public class CustomException extends RuntimeException {

    public static class MovieNotFoundException extends RuntimeException {
        public MovieNotFoundException(String message) {
            super(message);
        }
    }

    public static class GeneralException extends RuntimeException {
        public GeneralException(String message) {
            super(message);
        }
    }
}
