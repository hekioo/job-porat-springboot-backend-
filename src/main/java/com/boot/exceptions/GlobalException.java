package com.boot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalException 
{
	@ExceptionHandler
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex)
	{
		// getting the message thrown by the resource not found Class
		String message = ex.getMessage();
		
		
		// creating the object of the class and initializing the class
		ApiResponse response = new ApiResponse();
		
		
		
		// setting the values to the methods of the class whose object is created above
		response.setMesaage(message);
		response.setStatus(false);
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}
	

}
