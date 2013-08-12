package com.twistlet.vettel.model.service;

import java.util.List;

import com.twistlet.vettel.model.entity.Person;

public interface UserService {
	List<Person> listPerson();

	void save(Person person);
}
