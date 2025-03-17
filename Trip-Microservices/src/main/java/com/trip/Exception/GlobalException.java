package com.trip.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	  // Handle specific exception (e.g., ResourceNotFoundException)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
	 
	 
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
	        StringBuilder errorMessage = new StringBuilder();
	        ex.getBindingResult().getAllErrors().forEach(error -> 
	            errorMessage.append(error.getDefaultMessage()).append("\n")
	        );
	        return new ResponseEntity<>(errorMessage.toString(), HttpStatus.BAD_REQUEST);
	    }

}
