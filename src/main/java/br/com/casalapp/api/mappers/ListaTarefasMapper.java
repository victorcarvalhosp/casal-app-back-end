package br.com.casalapp.api.mappers;

import java.util.ArrayList;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.casalapp.api.dtos.ListaTarefasDto;
import br.com.casalapp.api.dtos.TarefaDto;
import br.com.casalapp.api.entities.ListaTarefas;
import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.entities.Tarefa;
import br.com.casalapp.api.enums.TipoListaEnum;

@Component
public class ListaTarefasMapper implements DefaultMapper<ListaTarefas, ListaTarefasDto>{
	
	@Autowired
	private TarefaMapper tarefaMapper;
	
	@Autowired
	private RecompensaMapper recompensaMapper;

	@Override
	public ListaTarefasDto toDto(ListaTarefas entidade) {
		ListaTarefasDto dto = new ListaTarefasDto();
		dto.setId(entidade.getId());
		dto.setCriadorId(entidade.getCriador().getId());
		dto.setTarefas(new ArrayList<>());
		dto.setTitulo(entidade.getTitulo());
		dto.setDescricao(entidade.getDescricao());
		dto.setTipo(entidade.getTipo().toString());
		if(entidade.getTarefas() != null) {
			for (Tarefa tarefa : entidade.getTarefas()) {
				dto.getTarefas().add(tarefaMapper.toDto(tarefa));
			}
		}
		if(entidade.getRecompensa() != null) {
			dto.setRecompensa(recompensaMapper.toDto(entidade.getRecompensa()));
		}

		return dto;
	}

	@Override
	public ListaTarefas toEntity(ListaTarefasDto dto) {
		ListaTarefas entidade = new ListaTarefas();
		entidade.setId(dto.getId());
		entidade.setTitulo(dto.getTitulo());
		entidade.setDescricao(dto.getDescricao());
		
		Pessoa criador = new Pessoa();
		criador.setId(dto.getCriadorId());
		entidade.setCriador(criador);
		entidade.setTarefas(new ArrayList<>());
		if(dto.getTarefas() != null) {
			for (TarefaDto tarefaDto : dto.getTarefas()) {
				Tarefa tarefa = new Tarefa();
				tarefa = tarefaMapper.toEntity(tarefaDto);
				tarefa.setLista(entidade);
				entidade.getTarefas().add(tarefa);
			}
		}
		if (EnumUtils.isValidEnum(TipoListaEnum.class, dto.getTipo())) {
			entidade.setTipo(TipoListaEnum.valueOf(dto.getTipo()));
		} 
		if(dto.getRecompensa() != null) {
			entidade.setRecompensa(recompensaMapper.toEntity(dto.getRecompensa()));
		}
		return entidade;
	}

}
