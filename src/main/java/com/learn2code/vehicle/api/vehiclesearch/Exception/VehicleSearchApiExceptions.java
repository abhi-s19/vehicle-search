package com.learn2code.vehicle.api.vehiclesearch.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class VehicleSearchApiExceptions {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ManufacturerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleManufacturerNotFound(ManufacturerNotFoundException ex){
		
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
		
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,ex.getFieldError().getDefaultMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	   
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ModelNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleModelNotFound(ModelNotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(TrimTypeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleTrimTypeNotFound(TrimTypeNotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND,ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAccountNotFound(AccountNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }
	
}
