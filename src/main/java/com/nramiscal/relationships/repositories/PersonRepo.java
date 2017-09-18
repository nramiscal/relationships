package com.nramiscal.relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nramiscal.relationships.models.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {

}
