package pe.com.vera.demo.service;

import java.util.List;
import java.util.Optional;

public interface AbstractDao<T> {

	public void addOrUpdate(T t);
	public void remove(long id);
	public Optional<T> findById(long id);
	public List<T> finAll();
}
