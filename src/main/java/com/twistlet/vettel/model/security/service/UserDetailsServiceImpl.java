package com.twistlet.vettel.model.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.twistlet.vettel.model.entity.Authority;
import com.twistlet.vettel.model.entity.Person;
import com.twistlet.vettel.model.entity.PersonAuthority;
import com.twistlet.vettel.model.repository.PersonAuthorityRepository;
import com.twistlet.vettel.model.repository.PersonRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	private final PersonRepository personRepository;
	private final PersonAuthorityRepository personAuthorityRepository;

	public UserDetailsServiceImpl(final PersonRepository personRepository, final PersonAuthorityRepository personAuthorityRepository) {
		this.personRepository = personRepository;
		this.personAuthorityRepository = personAuthorityRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final Person person = personRepository.findOne(username);
		if (person == null) {
			throw new UsernameNotFoundException(username);
		}

		final List<PersonAuthority> list = personAuthorityRepository.findByPersonUsername(username);
		final List<GrantedAuthority> authorities = new ArrayList<>();
		for (final PersonAuthority personAuthority : list) {
			final Authority authority = personAuthority.getAuthority();
			authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
		}
		final User user = new User(person.getUsername(), person.getPassword(), authorities);
		return user;
	}

}
