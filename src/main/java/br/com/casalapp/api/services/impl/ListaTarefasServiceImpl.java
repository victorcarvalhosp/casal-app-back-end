package br.com.casalapp.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.casalapp.api.entities.ListaTarefas;
import br.com.casalapp.api.entities.Tarefa;
import br.com.casalapp.api.repositories.ListaTarefasRepository;
import br.com.casalapp.api.services.ListaTarefasService;


@Service
public class ListaTarefasServiceImpl extends CrudServiceImpl<ListaTarefas> implements ListaTarefasService {
	
	private static final Logger log = LoggerFactory.getLogger(ListaTarefasServiceImpl.class);

	@Autowired
	private ListaTarefasRepository repository;
	
	public Iterable<ListaTarefas> buscarModelos(){
		return repository.findByModeloTrue();
	}

	@Override
	public Boolean verificarSeJahRealizouAlgumCadastro(Long idPessoa) {
		Long count = repository.verificarCadastroLista(idPessoa);
		return count > 0;
	}

	@Override
	public Boolean confirmouTodasTarefas(ListaTarefas lista) {
		for (Tarefa tarefa : lista.getTarefas()) {
			if(!tarefa.getFinalizadoConfirmado()) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	protected CrudRepository<ListaTarefas, Long> getRepository() {
		return repository;
	}


}