package com.twistlet.vettel.controller;

import static org.springframework.validation.ValidationUtils.*;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserFormUpdateValidator implements Validator {

	@Override
	public boolean supports(final Class<?> clazz) {
		return UserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(final Object target, final Errors errors) {
		rejectIfEmptyOrWhitespace(errors, "username", "field.required", new Object[] { "Username" });
	}

}
