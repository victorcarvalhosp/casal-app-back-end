package br.com.casalapp.api.dtos;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class ConfiguracoesDto extends AbstractDto {

	private Long pessoaId;
	private String emailParceiroConvite;

	public ConfiguracoesDto() {
	}

	@NotNull
	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}

	@NotEmpty(message = "Email não pode ser vazio.")
	@Length(min = 5, max = 200, message = "Email deve conter entre 5 e 200 caracteres.")
	@Email(message = "Email inválido.")
	public String getEmailParceiroConvite() {
		return emailParceiroConvite;
	}

	public void setEmailParceiroConvite(String emailParceiroConvite) {
		this.emailParceiroConvite = emailParceiroConvite;
	}

	@Override
	public String toString() {
		return "ConfiguracoesDto [pessoaId=" + pessoaId + ", emailParceiroConvite=" + emailParceiroConvite + "]";
	}
	
}