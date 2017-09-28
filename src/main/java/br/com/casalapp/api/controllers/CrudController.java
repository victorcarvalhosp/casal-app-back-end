package br.com.casalapp.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.casalapp.api.controllers.interfaces.defaults.DeleteController;
import br.com.casalapp.api.controllers.interfaces.defaults.GetByIdController;
import br.com.casalapp.api.controllers.interfaces.defaults.GetController;
import br.com.casalapp.api.controllers.interfaces.defaults.PostController;
import br.com.casalapp.api.controllers.interfaces.defaults.PutController;
import br.com.casalapp.api.dtos.AbstractDto;
import br.com.casalapp.api.entities.AbstractBaseEntity;
import br.com.casalapp.api.security.services.JwtUserDetailsService;


public abstract class CrudController<T extends AbstractBaseEntity, D extends AbstractDto> implements PostController<T, D>,
PutController<T, D>, GetController<T, D>, GetByIdController<T, D>, DeleteController<T, D>{
	
	protected static final Logger log = LoggerFactory.getLogger(PessoaController.class);
	
	@Autowired
	protected JwtUserDetailsService jwtUserDetailsService;
	
	
}
