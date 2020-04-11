package com.example.demo.errors;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = TravelRequestException.class)
	public ResponseEntity<Object> exception(TravelRequestException exception) {
		ErrorDescription errorDescription = new ErrorDescription();
        errorDescription.setErrorCode(HttpStatus.I_AM_A_TEAPOT.value());
        errorDescription.setErrorMessage("Travel Request Exception");
        errorDescription.setTimestamp(Long.toString(Instant.now().toEpochMilli()));
        errorDescription.setMessages(exception.getErrors());
        
		return new ResponseEntity<>(errorDescription, HttpStatus.I_AM_A_TEAPOT);
	}

}
