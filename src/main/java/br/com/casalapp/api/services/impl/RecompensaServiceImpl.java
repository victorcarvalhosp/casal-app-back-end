package br.com.casalapp.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.casalapp.api.entities.ListaTarefas;
import br.com.casalapp.api.entities.Recompensa;
import br.com.casalapp.api.entities.RecompensaPessoa;
import br.com.casalapp.api.repositories.RecompensaPessoaRepository;
import br.com.casalapp.api.repositories.RecompensaRepository;
import br.com.casalapp.api.services.RecompensaService;


@Service
public class RecompensaServiceImpl extends CrudServiceImpl<Recompensa> implements RecompensaService {
	
	private static final Logger log = LoggerFactory.getLogger(RecompensaServiceImpl.class);

	@Autowired
	private RecompensaRepository repository;
	
	public Iterable<Recompensa> buscarModelos(){
		return repository.findByModeloTrue();
	}

	@Override
	protected CrudRepository<Recompensa, Long> getRepository() {
		return repository;
	}

}