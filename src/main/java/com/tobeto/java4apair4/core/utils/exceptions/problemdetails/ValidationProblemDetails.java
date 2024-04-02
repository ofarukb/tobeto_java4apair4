package com.tobeto.java4apair4.core.utils.exceptions.problemdetails;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails {

	private List<String> errors;

	public ValidationProblemDetails(List<String> errors) {
		setDetail("One or more validation errors.");
		setTitle("Validation Rule Violation");
		setType("ValidationException");
		this.errors = errors;
	}
}
