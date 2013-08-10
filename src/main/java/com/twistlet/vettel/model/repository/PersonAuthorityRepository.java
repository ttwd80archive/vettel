package com.twistlet.vettel.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twistlet.vettel.model.entity.PersonAuthority;

public interface PersonAuthorityRepository extends JpaRepository<PersonAuthority, Integer> {

	List<PersonAuthority> findByPersonUsername(String username);
}
