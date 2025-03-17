package com.destination.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();
	        
	        ex.getBindingResult().getFieldErrors().forEach(error -> 
	            errors.put(error.getField(), error.getDefaultMessage())
	        );

	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }

	 
	 
	    @ExceptionHandler(DestinationIdNotFoundException.class)
	    ResponseEntity<ApiResponse>DestinationIdNotFoundExceptionHandler(DestinationIdNotFoundException ex){
	    
	    	        String message= ex.getMessage();
	    	        
	    	        ApiResponse response=new ApiResponse(message, false);
	    	
	    	return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	    	
	    	
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
