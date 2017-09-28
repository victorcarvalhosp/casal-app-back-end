package br.com.casalapp.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	
@Entity
@Table(name = "recompensa")
public class Recompensa extends AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = -5754246207015712518L;
	
	private String titulo;
	private String descricao;
	private String icone;
	private Boolean modelo;

	public Recompensa() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	@Column
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column
	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}
	
	@Column
	public Boolean getModelo() {
		return modelo;
	}

	public void setModelo(Boolean modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}