package br.com.casalapp.api.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.casalapp.api.dtos.RecompensaPessoaDto;
import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.entities.RecompensaPessoa;

@Component
public class RecompensaPessoaMapper implements DefaultMapper<RecompensaPessoa, RecompensaPessoaDto>{
	
	@Autowired
	private RecompensaMapper recompensaMapper;
	
	@Override
	public RecompensaPessoaDto toDto(RecompensaPessoa entidade) {
		RecompensaPessoaDto dto = new RecompensaPessoaDto();
		dto.setId(entidade.getId());
		dto.setRecompensa(recompensaMapper.toDto(entidade.getRecompensa()));
		dto.setPessoaId(entidade.getPessoa().getId());
		dto.setUtilizado(entidade.getUtilizado());

		return dto;
	}

	@Override
	public RecompensaPessoa toEntity(RecompensaPessoaDto dto) {
		RecompensaPessoa entidade = new RecompensaPessoa();
		entidade.setId(dto.getId());
		entidade.setRecompensa(recompensaMapper.toEntity(dto.getRecompensa()));
		Pessoa pessoa = new Pessoa();
		pessoa.setId(dto.getPessoaId());
		entidade.setPessoa(pessoa);
		entidade.setUtilizado(dto.getUtilizado());
		return entidade;
	}

}
