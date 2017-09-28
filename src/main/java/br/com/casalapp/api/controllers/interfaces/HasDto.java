package br.com.casalapp.api.controllers.interfaces;

import br.com.casalapp.api.dtos.AbstractDto;
import br.com.casalapp.api.dtos.Dto;
import br.com.casalapp.api.entities.AbstractBaseEntity;
import br.com.casalapp.api.services.CrudService;

public interface HasDto<T extends AbstractBaseEntity, D extends AbstractDto> {

	T convertDtoToEntity(D cadastroDto);
	D convertEntityToDto(T entidade);
}
