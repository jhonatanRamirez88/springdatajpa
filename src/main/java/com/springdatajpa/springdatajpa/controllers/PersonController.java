package com.springdatajpa.springdatajpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdatajpa.springdatajpa.models.Person;
import com.springdatajpa.springdatajpa.services.PersonImpl;

@RestController
@RequestMapping(value="/persons")
public class PersonController {

	@Autowired
	PersonImpl personImpl;
	
	@RequestMapping("/")
	public List<Person> index() {
		return personImpl.getAll();
	}
	
	@RequestMapping("/save")
	public String save(@RequestBody Person person) {
		personImpl.save(person);
		return "Se guardo con exito";
	}
	
	
}
