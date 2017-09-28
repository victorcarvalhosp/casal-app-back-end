package br.com.casalapp.api.services;

import br.com.casalapp.api.entities.ListaTarefas;
import br.com.casalapp.api.entities.Recompensa;


public interface RecompensaService extends CrudService<Recompensa> {
	
	Iterable<Recompensa> buscarModelos();

}
