package br.com.app.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.app.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
