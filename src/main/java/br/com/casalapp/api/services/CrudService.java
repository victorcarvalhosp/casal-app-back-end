package br.com.casalapp.api.services;

import java.util.List;
import java.util.Optional;


import br.com.casalapp.api.entities.AbstractBaseEntity;

public interface CrudService<T extends AbstractBaseEntity> {

	/**
	 * Busca e retorna um funcionário por ID.
	 * 
	 * @param id
	 * @return Optional<Pessoa>
	 */
	Optional<T> buscarPorId(Long id);
	
	Iterable<T> findAll();

	T save(T entity);

	void deleteById(Long id);

	void deleteAllById(List<Long> ids);

	void delete(T entity);

	void deleteAll(List<Long> entities);

	T findOne(Long id);

}
