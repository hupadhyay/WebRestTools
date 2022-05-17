package in.himtech.test.demo.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import in.himtech.test.demo.utilities.InvalidInputException;
import in.himtech.test.demo.utilities.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundExp(ResourceNotFoundException exp, WebRequest req){
		ErrorDetails err = new ErrorDetails(new Date(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<?> invalidInputExp(InvalidInputException exp, WebRequest req){
		ErrorDetails err = new ErrorDetails(new Date(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> invalidInputExp(Exception exp, WebRequest req){
		ErrorDetails err = new ErrorDetails(new Date(), exp.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
