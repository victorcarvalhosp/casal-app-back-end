package br.com.casalapp.api.controllers.interfaces;

import br.com.casalapp.api.entities.AbstractBaseEntity;
import br.com.casalapp.api.services.CrudService;

public interface HasService<T extends AbstractBaseEntity> {

	CrudService<T> getService();
}
