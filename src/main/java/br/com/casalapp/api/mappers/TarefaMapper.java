package br.com.casalapp.api.mappers;

import org.springframework.stereotype.Component;

import br.com.casalapp.api.dtos.TarefaDto;
import br.com.casalapp.api.entities.ListaTarefas;
import br.com.casalapp.api.entities.Tarefa;

@Component
public class TarefaMapper implements DefaultMapper<Tarefa, TarefaDto>{

	@Override
	public TarefaDto toDto(Tarefa entidade) {
		TarefaDto dto = new TarefaDto();
		dto.setId(entidade.getId());
		dto.setDataPrevista(entidade.getDataPrevista());
		dto.setDetalhes(entidade.getDetalhes());
		dto.setFinalizado(entidade.getFinalizado());
		dto.setFinalizadoConfirmado(entidade.getFinalizadoConfirmado());
		dto.setTitulo(entidade.getTitulo());
		dto.setListaId(entidade.getLista().getId());
		dto.setListaTitulo(entidade.getLista().getTitulo());
		dto.setListaIcone(entidade.getLista().getTipo().getImg());
		if(entidade.getLista().getRecompensa() != null) {
			dto.setRecompensaIcone(entidade.getLista().getRecompensa().getIcone());
		}
		dto.setCriadorId(entidade.getLista().getCriador().getId());
		return dto;
	}

	@Override
	public Tarefa toEntity(TarefaDto dto) {
		Tarefa tarefa = new Tarefa();
		tarefa.setId(dto.getId());
		tarefa.setDataPrevista(dto.getDataPrevista());
		tarefa.setDetalhes(dto.getDetalhes());
		tarefa.setFinalizado(dto.getFinalizado());
		tarefa.setFinalizadoConfirmado(dto.getFinalizadoConfirmado());
		tarefa.setTitulo(dto.getTitulo());
		
		ListaTarefas listaTarefas = new ListaTarefas();
		listaTarefas.setId(dto.getListaId());
		tarefa.setLista(listaTarefas);
		
		return tarefa;
	}

}
