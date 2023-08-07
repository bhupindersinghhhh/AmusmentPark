package com.sirion.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionAdvice {

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler({CustomerNotFound.class})
	public ErrorMapper handleException(Exception ex, HttpServletRequest request) {
		String msg = ex.getMessage();
		String url = request.getRequestURI().toString();
		return new ErrorMapper(url, msg, new Date());
	}
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	@ExceptionHandler({TicketNotValid.class})
	public ErrorMapper handleForbiddenException(Exception ex, HttpServletRequest request) {
		String msg = ex.getMessage();
		String url = request.getRequestURI().toString();
		return new ErrorMapper(url, msg, new Date());
	}
}
