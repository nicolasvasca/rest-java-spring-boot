package br.com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.exceptions.ResourceNotFoundException;
import br.com.app.model.Person;
import br.com.app.repositories.PersonRepository;

@Service
public class PersonServices {
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	private PersonRepository repository;
	
	public List<Person> findAll() {
		logger.info("findAll");
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		logger.info(String.format("findById: %s", id));
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
	}
	
	public Person create(Person person) {

		logger.info("create");
		
		return repository.save(person);
	}
	
	public Person update(Person person) {
		
		logger.info("update!");
		var entity  = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(person);
	}
	
	public void delete(Long id) {
		logger.info("delete");
		var entity  = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
		repository.delete(entity);
		
	
	}
	

}
