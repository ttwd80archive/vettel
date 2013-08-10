package com.twistlet.vettel.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twistlet.vettel.model.entity.Person;

public interface PersonRepository extends JpaRepository<Person, String> {

}
