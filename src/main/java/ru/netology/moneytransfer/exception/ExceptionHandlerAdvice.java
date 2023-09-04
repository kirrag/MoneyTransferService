package ru.netology.moneytransfer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestControllerAdvice
public class ExceptionHandlerAdvice {

	@ResponseBody
	@ExceptionHandler(CardNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String cardNotFoundHandler(CardNotFoundException ex) {
		return ex.getMessage();
	}

	@ExceptionHandler(ErrorInputData.class)
	public ResponseEntity<AppError> eidHandler(ErrorInputData e) {
		return new ResponseEntity<>(new AppError(e.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ErrorTransfer.class)
	public ResponseEntity<AppError> etHandler(ErrorTransfer e) {
		return new ResponseEntity<>(new AppError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(ErrorConfirmation.class)
	public ResponseEntity<AppError> ecHandler(ErrorConfirmation e) {
		return new ResponseEntity<>(new AppError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
