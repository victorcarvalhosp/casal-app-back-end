package br.com.casalapp.api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.casalapp.api.entities.Tarefa;


public interface TarefaRepository extends CrudRepository<Tarefa, Long>{

	@Query("SELECT t FROM Tarefa t WHERE t.lista.criador.id  = :pessoaId AND t.finalizado = false ORDER BY t.dataPrevista, t.id ")
	Iterable<Tarefa> buscarTarefasParceiroNaoFinalizadas(@Param("pessoaId") Long pessoaId);
	
	@Query("SELECT t FROM Tarefa t WHERE t.lista.criador.parceiro.id  = :pessoaId AND t.finalizado = false ORDER BY t.dataPrevista, t.id")
	Iterable<Tarefa> buscarTarefasPessoaNaoFinalizadas(@Param("pessoaId") Long pessoaId);
	
	@Query("SELECT t FROM Tarefa t WHERE t.lista.criador.id  = :pessoaId AND t.finalizado = true ORDER BY t.dataPrevista, t.id")
	Iterable<Tarefa> buscarTarefasParceiroFinalizadas(@Param("pessoaId") Long pessoaId);
	
	@Query("SELECT t FROM Tarefa t WHERE t.lista.criador.parceiro.id  = :pessoaId AND t.finalizado = true ORDER BY t.dataPrevista, t.id")
	Iterable<Tarefa> buscarTarefasPessoaFinalizadas(@Param("pessoaId") Long pessoaId);
	
	@Query("SELECT t FROM Tarefa t WHERE t.lista.criador.id  = :pessoaId AND t.finalizado = true AND t.finalizadoConfirmado = true ORDER BY t.dataPrevista, t.id")
	Iterable<Tarefa> buscarTarefasParceiroFinalizadasConfirmadas(@Param("pessoaId") Long pessoaId);
	
	@Query("SELECT t FROM Tarefa t WHERE t.lista.criador.parceiro.id  = :pessoaId AND t.finalizado = true AND t.finalizadoConfirmado = true ORDER BY t.dataPrevista, t.id")
	Iterable<Tarefa> buscarTarefasPessoaFinalizadasConfirmadas(@Param("pessoaId") Long pessoaId);
	
	@Query("SELECT t FROM Tarefa t WHERE t.lista.criador.id  = :pessoaId AND t.finalizado = true AND t.finalizadoConfirmado = false ORDER BY t.dataPrevista, t.id")
	Iterable<Tarefa> buscarTarefasAguardandoConfirmacao(@Param("pessoaId") Long pessoaId);

}
