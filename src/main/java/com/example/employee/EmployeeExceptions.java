package com.example.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class EmployeeExceptions {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> idCheck() {
		return new ResponseEntity<>("Employee Not found in this Id", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NameNotFoundException.class)
	public ResponseEntity<Object> namecheck() {
		return new ResponseEntity<>("Employee name not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SalaryNotFoundException.class)
	public ResponseEntity<Object> salarycheck() {
		return new ResponseEntity<>("Employee salary not found", HttpStatus.NOT_FOUND);
	}
}
