package br.com.casalapp.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.repositories.PessoaRepository;
import br.com.casalapp.api.services.PessoaService;


@Service
public class PessoaServiceImpl extends CrudServiceImpl<Pessoa> implements PessoaService {
	
	private static final Logger log = LoggerFactory.getLogger(PessoaServiceImpl.class);

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Optional<Pessoa> buscarPorEmail(String email) {
		log.info("Buscando funcionário pelo email {}", email);
		return Optional.ofNullable(this.pessoaRepository.findByEmail(email));
	}
	
	@Override
	protected CrudRepository<Pessoa, Long> getRepository() {
		return pessoaRepository;
	}

}