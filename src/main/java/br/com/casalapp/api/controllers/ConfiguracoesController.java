package br.com.casalapp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casalapp.api.dtos.ConfiguracoesDto;
import br.com.casalapp.api.entities.Configuracoes;
import br.com.casalapp.api.mappers.ConfiguracoesMapper;
import br.com.casalapp.api.services.ConfiguracoesService;
import br.com.casalapp.api.services.CrudService;


@RestController
@RequestMapping("/configuracoes")
@CrossOrigin(origins = "*")
public class ConfiguracoesController extends CrudController<Configuracoes, ConfiguracoesDto>{

	@Autowired
	private ConfiguracoesService configuracoesService;
	
	@Autowired
	private ConfiguracoesMapper configuracoesMapper;
	

	public ConfiguracoesController() {
	}
	
	@Override
	public ConfiguracoesDto convertEntityToDto(Configuracoes configuracoes) {
		return configuracoesMapper.toDto(configuracoes);
	}

	@Override
	public Configuracoes convertDtoToEntity(ConfiguracoesDto dto) {
		return configuracoesMapper.toEntity(dto);
	}

	@Override
	public CrudService<Configuracoes> getService() {
		return configuracoesService;
	}

}