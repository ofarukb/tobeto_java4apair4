package com.tobeto.java4apair4.core.configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tobeto.java4apair4.core.utils.exceptions.problemdetails.BusinessProblemDetails;
import com.tobeto.java4apair4.core.utils.exceptions.problemdetails.ValidationProblemDetails;
import com.tobeto.java4apair4.core.utils.exceptions.types.BusinessException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public BusinessProblemDetails handleBusinessProblemDetails(BusinessException exception) {
		BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails(exception.getMessage());
		return businessProblemDetails;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationProblemDetails handleValidationProblemDetails(MethodArgumentNotValidException exception) {
		List<String> errorMessages = new ArrayList<>();
		List<FieldError> errors = exception.getFieldErrors();

		for (FieldError fieldError : errors) {
			errorMessages.add(fieldError.getDefaultMessage());
		}
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails(errorMessages);
		return validationProblemDetails;
	}
}
