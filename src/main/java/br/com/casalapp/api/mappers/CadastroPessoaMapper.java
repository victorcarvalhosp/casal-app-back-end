package br.com.casalapp.api.mappers;

import org.springframework.stereotype.Component;

import br.com.casalapp.api.dtos.CadastroPessoaDto;
import br.com.casalapp.api.entities.Configuracoes;
import br.com.casalapp.api.entities.Pessoa;
import br.com.casalapp.api.enums.PerfilEnum;
import br.com.casalapp.api.utils.PasswordUtils;

@Component
public class CadastroPessoaMapper implements DefaultMapper<Pessoa, CadastroPessoaDto>{

	@Override
	public CadastroPessoaDto toDto(Pessoa pessoa) {
		CadastroPessoaDto pessoaDto = new CadastroPessoaDto();
		pessoaDto.setId(pessoa.getId());
		pessoaDto.setEmail(pessoa.getEmail());
		pessoaDto.setNome(pessoa.getNome());

		return pessoaDto;
	}

	@Override
	public Pessoa toEntity(CadastroPessoaDto dto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(dto.getId());
		pessoa.setNome(dto.getNome());
		pessoa.setEmail(dto.getEmail());
		pessoa.setSenha(PasswordUtils.gerarBCrypt(dto.getSenha().get()));
		pessoa.setPerfil(PerfilEnum.ROLE_USUARIO);
		Configuracoes config = new Configuracoes();
		config.setPessoa(pessoa);
		pessoa.setConfiguracoes(config);
		return pessoa;
	}

}
