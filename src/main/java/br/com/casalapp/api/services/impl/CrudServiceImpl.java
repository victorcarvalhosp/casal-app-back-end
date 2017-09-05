package br.com.casalapp.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.casalapp.api.entities.AbstractBaseEntity;
import br.com.casalapp.api.services.CrudService;


@Service
public abstract class CrudServiceImpl<T extends AbstractBaseEntity> implements CrudService<T> {
	
	private static final Logger log = LoggerFactory.getLogger(CrudServiceImpl.class);
	
	public Optional<T> buscarPorId(Long id) {
		log.info("Buscando funcionário pelo IDl {}", id);
		return Optional.ofNullable(getRepository().findOne(id));
	}

	@Override
	public Iterable<T> findAll() {
		return getRepository().findAll();
	}

	@Override
	public T save(T entity) {
		return getRepository().save(entity);
	}

	@Override
	public void deleteById(Long id) {
		getRepository().delete(id);
	}

	@Override
	public void deleteAllById(List<Long> ids) {
		ids.forEach(this::deleteById);
	}

	@Override
	public void delete(T entity) {
		getRepository().delete(entity);
	}

	@Override
	public void deleteAll(List<Long> entities) {
		getRepository().deleteAll();
	}

	@Override
	public T findOne(Long id) {
		// TODO Auto-generated method stub
		return getRepository().findOne(id);
	}
	
    protected abstract CrudRepository<T, Long> getRepository();


}