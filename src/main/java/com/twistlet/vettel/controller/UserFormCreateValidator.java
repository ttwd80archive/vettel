package com.twistlet.vettel.controller;

import static org.springframework.validation.ValidationUtils.*;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserFormCreateValidator implements Validator {

	@Override
	public boolean supports(final Class<?> clazz) {
		return UserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(final Object target, final Errors errors) {
		rejectIfEmptyOrWhitespace(errors, "username", "field.required", new Object[] { "Username" });
		rejectIfEmptyOrWhitespace(errors, "password", "field.required", new Object[] { "Password" });
		rejectIfEmptyOrWhitespace(errors, "confirmPassword", "field.required", new Object[] { "Password Confirmation" });
		final UserForm form = (UserForm) target;
		if (!StringUtils.equals(form.getPassword(), form.getConfirmPassword())) {
			errors.reject("field.mismatch.password");
		}
	}

}
