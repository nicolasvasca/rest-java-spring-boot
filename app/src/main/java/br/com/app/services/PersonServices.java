package br.com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.app.model.Person;

@Service
public class PersonServices {
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		logger.info("findAll");
		List<Person> personList = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			personList.add(person);
		}
		return personList;
	}
	
	public Person findById(String id) {
		logger.info(String.format("findById: %s", id));
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Leandro");
		person.setLastName("Costa");
		person.setAddress("Uberlândia - Minas Gerais - Brasil");
		person.setGender("Male");
		return person;
	}
	
	public Person create(Person person) {

		logger.info("create");
		
		return person;
	}
	
	public Person update(Person person) {
		
		logger.info("update!");
		
		return person;
	}
	
	public void delete(String id) {
		
		logger.info("delete");
	}
	
	
	private Person mockPerson(int i) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Some address in Brasil " + i);
		person.setGender("Male");
		return person;
	}

}
