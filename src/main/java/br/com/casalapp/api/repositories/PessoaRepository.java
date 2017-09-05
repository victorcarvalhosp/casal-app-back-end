package br.com.casalapp.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casalapp.api.entities.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
	
	@Transactional(readOnly = true)
	Pessoa findByEmail(String email);
	
}
