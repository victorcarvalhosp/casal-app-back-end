package br.com.casalapp.api.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.casalapp.api.entities.Recompensa;

public interface RecompensaRepository extends CrudRepository<Recompensa, Long>{

	Iterable<Recompensa> findByModeloTrue();
	
}
