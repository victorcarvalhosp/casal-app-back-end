package br.com.casalapp.api.services;

import org.springframework.data.repository.query.Param;

import br.com.casalapp.api.entities.ListaTarefas;
import br.com.casalapp.api.entities.RecompensaPessoa;


public interface RecompensaPessoaService extends CrudService<RecompensaPessoa> {
	
	void darRecompensa(ListaTarefas lista);
	
	Iterable<RecompensaPessoa> buscarRecompensasNaoUtilizadas(@Param("pessoaId") Long pessoaId);
	
}
