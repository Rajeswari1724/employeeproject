package com.te.employeeproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.employeeproject.controlleradvice.EmployeeException;

@ControllerAdvice
public class EmployeeControllerAdvice {
	@ExceptionHandler(EmployeeException.class)
	public String handleExcp(EmployeeException exception,HttpServletRequest request) {
		request.setAttribute("err",exception.getMessage());
		return "errPage";
		
	}

}
