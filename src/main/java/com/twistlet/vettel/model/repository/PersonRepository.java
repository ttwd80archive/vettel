package com.twistlet.vettel.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.twistlet.vettel.model.entity.Person;

@Component("personRepository")
public interface PersonRepository extends JpaRepository<Person, String> {

}
