package br.com.casalapp.api.dtos;

import java.io.Serializable;

	
public class RecompensaDto extends AbstractDto implements Serializable {

	private static final long serialVersionUID = -5754246207015712518L;
	
	private String titulo;
	private String descricao;
	private String icone;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String detalhes) {
		this.descricao = detalhes;
	}
	public String getIcone() {
		return icone;
	}
	public void setIcone(String icone) {
		this.icone = icone;
	}
	
}