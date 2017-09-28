package br.com.casalapp.api.services;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.springframework.data.repository.query.Param;

import br.com.casalapp.api.dtos.TarefaDto;
import br.com.casalapp.api.entities.Tarefa;
import br.com.casalapp.api.enums.PeriodoTarefaEnum;


public interface TarefaService extends CrudService<Tarefa> {
	
	Iterable<Tarefa> buscarTarefasParceiroNaoFinalizadas(Long idPessoa);
	
	Iterable<Tarefa> buscarTarefasPessoaNaoFinalizadas(Long idPessoa);
	
	Iterable<Tarefa> buscarTarefasParceiroFinalizadas(Long idPessoa);

	Iterable<Tarefa> buscarTarefasPessoaFinalizadas(Long idPessoa);
	
	Iterable<Tarefa> buscarTarefasParceiroFinalizadasConfirmadas(Long idPessoa);

	Iterable<Tarefa> buscarTarefasPessoaFinalizadasConfirmadas(Long idPessoa);

	TreeMap<PeriodoTarefaEnum,List <TarefaDto>> buscarTarefasParceiroOrdenadoPorPeriodo(Long pessoaId);
	
	TreeMap<PeriodoTarefaEnum, List<TarefaDto>> buscarTarefasPessoaOrdenadoPorPeriodo(Long pessoaId);

	Iterable<Tarefa> buscarTarefasAguardandoConfirmacao(Long pessoaId);
	
	Tarefa atualizarComoFinalizado(Long idTarefa);
	
	Tarefa atualizarComoFinalizacaoConfirmada(Long idTarefa);

	
}
