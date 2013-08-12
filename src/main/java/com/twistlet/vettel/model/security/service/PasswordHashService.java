package com.twistlet.vettel.model.security.service;

public interface PasswordHashService {
	String hash(String clearText);
}
