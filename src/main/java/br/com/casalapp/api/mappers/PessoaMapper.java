package br.com.casalapp.api.mappers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.casalapp.api.dtos.PessoaDto;
import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.enums.PerfilEnum;
import br.com.casalapp.api.services.PessoaService;

@Component
public class PessoaMapper implements DefaultMapper<Pessoa, PessoaDto>{

	@Autowired
	private ConfiguracoesMapper configuracoesMapper;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Override
	public PessoaDto toDto(Pessoa entidade) {
		PessoaDto dto = new PessoaDto();
		dto.setId(entidade.getId());
		dto.setEmail(entidade.getEmail());
		dto.setNome(entidade.getNome());
		dto.setConfiguracoes(configuracoesMapper.toDto(entidade.getConfiguracoes()));
		Optional<Pessoa> parceiro = Optional.ofNullable(entidade.getParceiro());
		if(parceiro.isPresent()) {
			Optional<Long> idParceiro = Optional.ofNullable(parceiro.get().getId());
			if(idParceiro.isPresent()) {
				dto.setParceiroId(idParceiro);
			}
		}

		return dto;
	}

	@Override
	public Pessoa toEntity(PessoaDto dto) {
		Pessoa pessoa = new Pessoa();
		if(dto.getId() != null) {
			pessoa = pessoaService.findOne(dto.getId());
			pessoa.setId(dto.getId());
		}else {
			pessoa.setPerfil(PerfilEnum.ROLE_USUARIO);
		}
		pessoa.setNome(dto.getNome());
		pessoa.setEmail(dto.getEmail());
		pessoa.setConfiguracoes(configuracoesMapper.toEntity(dto.getConfiguracoes()));
		return pessoa;
	}

}
