package com.twistlet.vettel.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.twistlet.vettel.model.entity.Person;
import com.twistlet.vettel.model.repository.PersonRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	private final PersonRepository personRepository;

	@Autowired
	public UserServiceImpl(final PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Person> listPerson() {
		return personRepository.findAll();
	}

}
