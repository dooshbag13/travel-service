package com.example.demo.errors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Errors;

public class TravelRequestException extends RuntimeException {
	private final Errors errors;

	public TravelRequestException(Errors errors) {
		this.errors = errors;
	}

	public List<String> getErrors() {
		List<String> err = new ArrayList<>();
		if (errors.getAllErrors() != null) {
			errors.getAllErrors().forEach(e -> err.add(e.toString()));
		}
		return err;
	}

	private static final long serialVersionUID = 1L;
}
