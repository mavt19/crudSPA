package pe.com.vera.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.vera.demo.entity.Person;
import pe.com.vera.demo.repository.PersonaRepository;

@Service
@Transactional
public class PersonaService implements AbstractDao<Person> {

	@Autowired
	PersonaRepository _repository;
	@Override
	public void addOrUpdate(Person t) {
		// TODO Auto-generated method stub
		_repository.save(t);
	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		_repository.deleteById(id);
	}

	@Override
	public Optional<Person> findById(long id) {
		// TODO Auto-generated method stub
		return _repository.findById(id);
	}

	@Override
	public List<Person> finAll() {
		// TODO Auto-generated method stub
		List<Person> list=new ArrayList<>();
		_repository.findAll().forEach(list::add);
		return list;
	}

}
