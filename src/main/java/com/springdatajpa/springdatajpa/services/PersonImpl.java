package com.springdatajpa.springdatajpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatajpa.springdatajpa.models.Person;

@Service
public class PersonImpl{
	
	@Autowired
	PersonRepository personRepository;
	
	public List<Person> getAll(){
		return personRepository.findAll();
	}
	
	public Optional<Person> findById(Long id) {
		return personRepository.findById(id);
	}
	
	public void save(Person person) {
		personRepository.save(person);
	}
	
	public boolean update(Person person) {
		Optional<Person> personOld = personRepository.findById(person.getId());
		if(personOld == null) {
			return false;
		}else {
			personRepository.save(person);
			return true;
		}
	}
	
	public boolean delete(Long id) {
		Optional<Person> personOld = personRepository.findById(id);
		if(personOld == null) {
			return false;
		}else {
			personRepository.deleteById(id);
			return true;
		}
		
	}
	
}
