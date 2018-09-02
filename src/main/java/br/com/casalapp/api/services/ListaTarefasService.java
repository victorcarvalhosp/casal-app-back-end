package br.com.casalapp.api.services;

import br.com.casalapp.api.entities.ListaTarefas;


public interface ListaTarefasService extends CrudService<ListaTarefas> {
	
	Iterable<ListaTarefas> buscarModelos();
	
	Boolean verificarSeJahRealizouAlgumCadastro(Long idPessoa);

	Boolean confirmouTodasTarefas(ListaTarefas lista);

	Integer totalTarefasRestantesParaConclusao(Long idLista);

	Integer totalTarefasRestantesParaConclusaoSemConfirmacao(Long idLista);

}
