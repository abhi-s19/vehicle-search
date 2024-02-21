package com.learn2code.vehicle.api.vehiclesearch.Exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private HttpStatus httpStatus;
	private String message;
	
	
	public ErrorResponse(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}
	
	
	public ErrorResponse() {
		super();
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ErrorResponse [httpStatus=" + httpStatus + ", message=" + message + "]";
	}
	
}
