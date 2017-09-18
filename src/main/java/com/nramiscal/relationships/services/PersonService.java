package com.nramiscal.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nramiscal.relationships.models.Person;
import com.nramiscal.relationships.repositories.PersonRepo;

@Service
public class PersonService {
	
	private PersonRepo personRepo;
	
	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	
	public void addPerson(Person person) {
		personRepo.save(person);
	}
	
	public List<Person> allPersons(){
		List<Person> persons = (List<Person>) personRepo.findAll();
		return persons;
	}
	
	public Person findPersonByIndex(long id){
		return personRepo.findOne(id);
	}

}
