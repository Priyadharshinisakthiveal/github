package com.demo;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
	//it handles illegal exception  ,no such element exception,empty result ;
	
	@ExceptionHandler(value= {IllegalArgumentException.class, NoSuchElementException.class, EmptyResultDataAccessException.class,EntityNotFoundException.class})
	public ResponseEntity<Object> IAExceptionHandler(Exception e , WebRequest request){
		String msg = "Error in input\n" + e.getMessage();
		return handleExceptionInternal(e,msg,new HttpHeaders(),HttpStatus.CONFLICT, request);
	}
	
	
	//it used to handle exceptions thrown by validation
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,HttpStatus status,WebRequest request){
		List<String> errorlist = e.getBindingResult().getAllErrors().stream()
				.map(fieldError -> fieldError.getDefaultMessage())
				.collect(Collectors.toList());
		System.out.println("in exception " + errorlist);
		return handleExceptionInternal(e,errorlist,headers,HttpStatus.BAD_REQUEST,request);
	}
}
