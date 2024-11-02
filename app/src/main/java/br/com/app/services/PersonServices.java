package br.com.app.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.data.vo.v1.PersonVO;
import br.com.app.exceptions.ResourceNotFoundException;
import br.com.app.helpers.DozerMapper;
import br.com.app.model.Person;
import br.com.app.repositories.PersonRepository;

@Service
public class PersonServices {
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	private PersonRepository repository;
	
	public List<PersonVO> findAll() {
		logger.info("findAll");
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class); 
	}
	
	public PersonVO findById(Long id) {
		logger.info(String.format("findById: %s", id));
		var entity =   repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
		return DozerMapper.parseObject(entity, PersonVO.class); 
	}
	
	public PersonVO create(PersonVO person) {

		logger.info("create");
		var entity = DozerMapper.parseObject(person, Person.class); 
		entity = repository.save(entity);
		return DozerMapper.parseObject(entity, PersonVO.class); 
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("update!");
		var entity  = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		entity = repository.save(entity);
		return  DozerMapper.parseObject(entity, PersonVO.class); 
	}
	
	public void delete(Long id) {
		logger.info("delete");
		var entity  = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
		repository.delete(entity);
	}
	

}
