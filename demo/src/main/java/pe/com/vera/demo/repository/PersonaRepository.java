package pe.com.vera.demo.repository;

import org.springframework.data.repository.CrudRepository;

import pe.com.vera.demo.entity.Person;

public interface PersonaRepository extends CrudRepository<Person, Long>{

	
}
