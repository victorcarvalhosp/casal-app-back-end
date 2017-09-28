package br.com.casalapp.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.casalapp.api.entities.Configuracoes;
import br.com.casalapp.api.repositories.ConfiguracoesRepository;
import br.com.casalapp.api.services.ConfiguracoesService;


@Service
public class ConfiguracoesServiceImpl extends CrudServiceImpl<Configuracoes> implements ConfiguracoesService {
	
	private static final Logger log = LoggerFactory.getLogger(ConfiguracoesServiceImpl.class);

	@Autowired
	private ConfiguracoesRepository repository;
	
	
	@Override
	protected CrudRepository<Configuracoes, Long> getRepository() {
		return repository;
	}

}