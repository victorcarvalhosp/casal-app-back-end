package br.com.casalapp.api.mappers;

import org.springframework.stereotype.Component;

import br.com.casalapp.api.dtos.RecompensaDto;
import br.com.casalapp.api.entities.Recompensa;

@Component
public class RecompensaMapper implements DefaultMapper<Recompensa, RecompensaDto>{
	
	@Override
	public RecompensaDto toDto(Recompensa entidade) {
		RecompensaDto dto = new RecompensaDto();
		dto.setId(entidade.getId());
		dto.setTitulo(entidade.getTitulo());
		dto.setDescricao(entidade.getDescricao());
		dto.setIcone(entidade.getIcone());

		return dto;
	}

	@Override
	public Recompensa toEntity(RecompensaDto dto) {
		Recompensa entidade = new Recompensa();
		entidade.setId(dto.getId());
		entidade.setTitulo(dto.getTitulo());
		entidade.setDescricao(dto.getDescricao());
		entidade.setIcone(dto.getIcone());
		entidade.setModelo(false);
		return entidade;
	}

}
