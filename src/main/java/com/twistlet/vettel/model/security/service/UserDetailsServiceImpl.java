package com.twistlet.vettel.model.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.twistlet.vettel.model.entity.Person;
import com.twistlet.vettel.model.repository.PersonRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	private PersonRepository personRepository;

	@Autowired
	public UserDetailsServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Person person = personRepository.findOne(username);
		if (person == null) {
			throw new UsernameNotFoundException(username);
		}
		// TODO Auto-generated method stub
		return null;
	}

}
