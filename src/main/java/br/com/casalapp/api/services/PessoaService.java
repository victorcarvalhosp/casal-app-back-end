package br.com.casalapp.api.services;

import java.util.Optional;

import br.com.casalapp.api.entities.Pessoa;


public interface PessoaService extends CrudService<Pessoa> {
	
	/**
	 * Busca e retorna um funcionário dado um email.
	 * 
	 * @param email
	 * @return Optional<Pessoa>
	 */
	Optional<Pessoa> buscarPorEmail(String email);
	
}
