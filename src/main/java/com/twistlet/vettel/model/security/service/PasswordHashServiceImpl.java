package com.twistlet.vettel.model.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordHashServiceImpl implements PasswordHashService {

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public PasswordHashServiceImpl(final PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public String hash(final String clearText) {
		return passwordEncoder.encode(clearText);
	}

}
