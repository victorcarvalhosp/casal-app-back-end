package br.com.casalapp.api.dtos;

import java.util.Optional;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class PessoaDto extends AbstractDto {

	private String nome;
	private String email;
	private Optional<Long> parceiroId = Optional.empty();
	private ConfiguracoesDto configuracoes;

	public PessoaDto() {
	}

	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotEmpty(message = "Email não pode ser vazio.")
	@Length(min = 5, max = 200, message = "Email deve conter entre 5 e 200 caracteres.")
	@Email(message = "Email inválido.")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Optional<Long> getParceiroId() {
		return parceiroId;
	}

	public void setParceiroId(Optional<Long> parceiroId) {
		this.parceiroId = parceiroId;
	}

	public ConfiguracoesDto getConfiguracoes() {
		return configuracoes;
	}

	public void setConfiguracoes(ConfiguracoesDto configuracoes) {
		this.configuracoes = configuracoes;
	}

	@Override
	public String toString() {
		return "FuncionarioDto [id=" + id + ", nome=" + nome + ", email=" + email;
	}
}