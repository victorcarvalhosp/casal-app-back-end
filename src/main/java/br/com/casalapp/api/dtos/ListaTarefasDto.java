package br.com.casalapp.api.dtos;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class ListaTarefasDto extends AbstractDto {

	private List<TarefaDto> tarefas;
	private Long criadorId;
	private String titulo;
	private String descricao;
	private String tipo;
	private RecompensaDto recompensa;

	public ListaTarefasDto() {
	}

	public List<TarefaDto> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<TarefaDto> tarefas) {
		this.tarefas = tarefas;
	}

	public Long getCriadorId() {
		return criadorId;
	}

	public void setCriadorId(Long criadorId) {
		this.criadorId = criadorId;
	}
	
	@NotEmpty(message = "Título não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@NotEmpty(message = "Tipo não pode ser vazio.")
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public RecompensaDto getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(RecompensaDto recompensa) {
		this.recompensa = recompensa;
	}

	public ListaTarefasDto(List<TarefaDto> tarefas, Long criadorId) {
		super();
		this.tarefas = tarefas;
		this.criadorId = criadorId;
	}
	
}