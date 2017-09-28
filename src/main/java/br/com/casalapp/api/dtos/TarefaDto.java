package br.com.casalapp.api.dtos;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class TarefaDto extends AbstractDto {

	private Long listaId;
	private String listaTitulo;
	private String listaIcone;
	private String recompensaIcone;
	private Long criadorId;
	private String titulo;
	private String detalhes;
	private Date dataPrevista;
	private Boolean finalizado;
	private Boolean finalizadoConfirmado;

	public TarefaDto() {
	}

	public Long getListaId() {
		return listaId;
	}

	public void setListaId(Long listaId) {
		this.listaId = listaId;
	}

	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public Date getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(Date dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Boolean getFinalizadoConfirmado() {
		return finalizadoConfirmado;
	}

	public void setFinalizadoConfirmado(Boolean finalizadoConfirmado) {
		this.finalizadoConfirmado = finalizadoConfirmado;
	}

	public String getListaTitulo() {
		return listaTitulo;
	}

	public void setListaTitulo(String listaTitulo) {
		this.listaTitulo = listaTitulo;
	}
	
	public String getListaIcone() {
		return listaIcone;
	}

	public void setListaIcone(String listaIcone) {
		this.listaIcone = listaIcone;
	}

	public String getRecompensaIcone() {
		return recompensaIcone;
	}

	public void setRecompensaIcone(String recompensaIcone) {
		this.recompensaIcone = recompensaIcone;
	}
	
	public Long getCriadorId() {
		return criadorId;
	}

	public void setCriadorId(Long criadorId) {
		this.criadorId = criadorId;
	}

	@Override
	public String toString() {
		return "TarefaDto [listaId=" + listaId + ", titulo=" + titulo + ", detalhes=" + detalhes + ", dataPrevista="
				+ dataPrevista + ", finalizado=" + finalizado + ", finalizadoConfirmado=" + finalizadoConfirmado + "]";
	}

	
	
}