package br.com.casalapp.api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.casalapp.api.entities.ListaTarefas;

public interface ListaTarefasRepository extends CrudRepository<ListaTarefas, Long>{

	Iterable<ListaTarefas> findByModeloTrue();
	
	@Query("SELECT count(l) FROM ListaTarefas l WHERE l.criador.parceiro.id  = :pessoaId OR l.criador.id  = :pessoaId")
	Long verificarCadastroLista(@Param("pessoaId") Long pessoaId);
	
}
