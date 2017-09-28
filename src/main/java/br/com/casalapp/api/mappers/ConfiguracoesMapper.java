package br.com.casalapp.api.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.casalapp.api.dtos.ConfiguracoesDto;
import br.com.casalapp.api.entities.Configuracoes;
import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.services.ConfiguracoesService;
import br.com.casalapp.api.services.PessoaService;

@Component
public class ConfiguracoesMapper implements DefaultMapper<Configuracoes, ConfiguracoesDto>{

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private ConfiguracoesService configuracoesService;
	
	@Override
	public ConfiguracoesDto toDto(Configuracoes entidade) {
		ConfiguracoesDto dto = new ConfiguracoesDto();
		dto.setId(entidade.getId());
		dto.setEmailParceiroConvite(entidade.getEmailParceiroConvite());

		return dto;
	}

	@Override
	public Configuracoes toEntity(ConfiguracoesDto dto) {
		Configuracoes entidade = new Configuracoes();
		if(dto.getId() != null) {
			entidade = configuracoesService.findOne(dto.getId());
		}
		entidade.setId(dto.getId());
		entidade.setEmailParceiroConvite(dto.getEmailParceiroConvite());
//		Pessoa pessoa = pessoaService.findOne(dto.getPessoaId());
		Pessoa pessoa = new Pessoa();
		pessoa.setId(dto.getId());
		entidade.setPessoa(pessoa);
		return entidade;
	}

}
