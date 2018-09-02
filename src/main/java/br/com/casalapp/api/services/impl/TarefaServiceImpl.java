package br.com.casalapp.api.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.casalapp.api.dtos.TarefaDto;
import br.com.casalapp.api.entities.Tarefa;
import br.com.casalapp.api.enums.PeriodoTarefaEnum;
import br.com.casalapp.api.mappers.TarefaMapper;
import br.com.casalapp.api.repositories.TarefaRepository;
import br.com.casalapp.api.services.ListaTarefasService;
import br.com.casalapp.api.services.RecompensaPessoaService;
import br.com.casalapp.api.services.RecompensaService;
import br.com.casalapp.api.services.TarefaService;


@Service
public class TarefaServiceImpl extends CrudServiceImpl<Tarefa> implements TarefaService {
	
	private static final Logger log = LoggerFactory.getLogger(TarefaServiceImpl.class);

	@Autowired
	private TarefaRepository repository;
	
	@Autowired
	private TarefaMapper tarefaMapper;
	
	@Autowired
	private RecompensaPessoaService recompensaPessoaService;
	
	@Autowired
	private ListaTarefasService listaTarefasService;
	
	public Iterable<Tarefa> buscarTarefasParceiroNaoFinalizadas(Long idPessoa){
		return repository.buscarTarefasParceiroNaoFinalizadas(idPessoa);
	}
	
	public Iterable<Tarefa> buscarTarefasPessoaNaoFinalizadas(Long idPessoa){
		return repository.buscarTarefasPessoaNaoFinalizadas(idPessoa);
	}
	
	public Iterable<Tarefa> buscarTarefasParceiroFinalizadas(Long idPessoa){
		return repository.buscarTarefasParceiroFinalizadas(idPessoa);
	}
	
	public Iterable<Tarefa> buscarTarefasPessoaFinalizadas(Long idPessoa){
		return repository.buscarTarefasPessoaFinalizadas(idPessoa);
	}
	
	public Iterable<Tarefa> buscarTarefasParceiroFinalizadasConfirmadas(Long idPessoa){
		return repository.buscarTarefasParceiroFinalizadasConfirmadas(idPessoa);
	}
	
	public Iterable<Tarefa> buscarTarefasPessoaFinalizadasConfirmadas(Long idPessoa){
		return repository.buscarTarefasPessoaFinalizadasConfirmadas(idPessoa);
	}

	@Override
	protected CrudRepository<Tarefa, Long> getRepository() {
		return repository;
	}

	@Override
	public TreeMap<PeriodoTarefaEnum, List<TarefaDto>> buscarTarefasParceiroOrdenadoPorPeriodo(Long pessoaId) {
		Iterable<Tarefa> list = buscarTarefasParceiroNaoFinalizadas(pessoaId);
			
		return agruparTarefasPorPeriodo(list);
	}
	
	@Override
	public TreeMap<PeriodoTarefaEnum, List<TarefaDto>> buscarTarefasPessoaOrdenadoPorPeriodo(Long pessoaId) {
		Iterable<Tarefa> list = buscarTarefasPessoaNaoFinalizadas(pessoaId);
			
		return agruparTarefasPorPeriodo(list);
	}

	private TreeMap<PeriodoTarefaEnum, List<TarefaDto>> agruparTarefasPorPeriodo(Iterable<Tarefa> list) {
		TreeMap<PeriodoTarefaEnum,List <TarefaDto>> hashMap = new TreeMap<>();
		hashMap.put(PeriodoTarefaEnum.ATRASADA, new ArrayList<>());
		hashMap.put(PeriodoTarefaEnum.HOJE, new ArrayList<>());
		hashMap.put(PeriodoTarefaEnum.AMANHA, new ArrayList<>());
		hashMap.put(PeriodoTarefaEnum.SEM_DATA, new ArrayList<>());
		hashMap.put(PeriodoTarefaEnum.DEPOIS, new ArrayList<>());
		
		for (Tarefa tarefa : list) {
			if(tarefa.getDataPrevista() == null) {
				hashMap.get(PeriodoTarefaEnum.SEM_DATA).add(tarefaMapper.toDto(tarefa));
			}else if(diferencaDiasDataAtual(tarefa.getDataPrevista()) < 0) {
				hashMap.get(PeriodoTarefaEnum.ATRASADA).add(tarefaMapper.toDto(tarefa));
			}else if(diferencaDiasDataAtual(tarefa.getDataPrevista()) == 0) {
				hashMap.get(PeriodoTarefaEnum.HOJE).add(tarefaMapper.toDto(tarefa));
			}else if(diferencaDiasDataAtual(tarefa.getDataPrevista()) == 1) {
				hashMap.get(PeriodoTarefaEnum.AMANHA).add(tarefaMapper.toDto(tarefa));
			}else if(diferencaDiasDataAtual(tarefa.getDataPrevista()) > 1) {
				hashMap.get(PeriodoTarefaEnum.DEPOIS).add(tarefaMapper.toDto(tarefa));
			}
		}
		return hashMap;
	}
	
	public int diferencaDiasDataAtual(Date dataTarefa) {
		LocalDate hoje = new LocalDate();
		LocalDate localDateTarefa = new LocalDate(dataTarefa);
		return Days.daysBetween(hoje, localDateTarefa).getDays();
	}

	@Override
	public Tarefa atualizarComoFinalizado(Long idTarefa) {
		Tarefa tarefa = findOne(idTarefa);
		tarefa.setFinalizado(true);
		return save(tarefa);
	}

	@Override
	public Iterable<Tarefa> buscarTarefasAguardandoConfirmacao(Long pessoaId) {
		return repository.buscarTarefasAguardandoConfirmacao(pessoaId);
	}

	@Override
	public Tarefa atualizarComoFinalizacaoConfirmada(Long idTarefa) {
		Tarefa tarefa = findOne(idTarefa);
		tarefa.setFinalizadoConfirmado(true);
		tarefa = save(tarefa);
		if(listaTarefasService.confirmouTodasTarefas(tarefa.getLista())) {
			recompensaPessoaService.darRecompensa(tarefa.getLista());
		}
		return tarefa;
	}

	@Override
	public Tarefa atualizarComoFinalizacaoNaoConfirmada(Long idTarefa) {
		Tarefa tarefa = findOne(idTarefa);
		tarefa.setFinalizado(false);
		tarefa.setFinalizadoConfirmado(false);
		tarefa = save(tarefa);
		return tarefa;
	}

}