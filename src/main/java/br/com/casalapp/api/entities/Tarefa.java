package br.com.casalapp.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

	
@Entity
@Table(name = "tarefa")
public class Tarefa extends AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = -5754246207015712518L;
	
	private ListaTarefas lista;
	private String titulo;
	private String detalhes;
	private Date dataPrevista;
	private Boolean finalizado;
	private Boolean finalizadoConfirmado;

	public Tarefa() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	@ManyToOne
    @JoinColumn(name = "lista_tarefas_id", nullable=false)
	public ListaTarefas getLista() {
		return lista;
	}

	public void setLista(ListaTarefas lista) {
		this.lista = lista;
	}

	@Column(nullable=false)
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column
	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	@Column(name="data_prevista")
    @Temporal(TemporalType.DATE)
	public Date getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(Date dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	@Column
	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	@Column
	public Boolean getFinalizadoConfirmado() {
		return finalizadoConfirmado;
	}

	public void setFinalizadoConfirmado(Boolean finalizadoConfirmado) {
		this.finalizadoConfirmado = finalizadoConfirmado;
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