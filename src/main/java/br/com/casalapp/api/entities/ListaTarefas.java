package br.com.casalapp.api.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.casalapp.api.enums.TipoListaEnum;

	
@Entity
@Table(name = "lista_tarefas")
public class ListaTarefas extends AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = -5754246207015712518L;
	
	private List<Tarefa> tarefas;
	private Pessoa criador;
	private Boolean modelo;
	private String titulo;
	private String descricao;
	private TipoListaEnum tipo;
	private Recompensa recompensa;
	private Integer diasRepeticao;

	public ListaTarefas() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	@OneToMany(mappedBy = "lista", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	@ManyToOne
	@JoinColumn(name="criador_id")
	public Pessoa getCriador() {
		return criador;
	}

	public void setCriador(Pessoa criador) {
		this.criador = criador;
	}
	
	@Column
	public Boolean getModelo() {
		return modelo;
	}

	public void setModelo(Boolean modelo) {
		this.modelo = modelo;
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
	
	@Column(name="tipo_lista", nullable=false)
	@Enumerated(EnumType.STRING)
	public TipoListaEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoListaEnum tipo) {
		this.tipo = tipo;
	}

	@ManyToOne
	@JoinColumn(name="recompensa_id")
	public Recompensa getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(Recompensa recompensa) {
		this.recompensa = recompensa;
	}

	@Column(name="dias_repeticao", nullable=true)
	public Integer getDiasRepeticao() {
		return diasRepeticao;
	}

	public void setDiasRepeticao(Integer diasRepeticao) {
		this.diasRepeticao = diasRepeticao;
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		ListaTarefas clone = (ListaTarefas) super.clone();
		List<Tarefa> cloneTarefas = new ArrayList<>();
		if(clone.getTarefas() != null) {
			for (Tarefa tarefa : clone.getTarefas()) {
				Tarefa tarefaClone = (Tarefa) tarefa.clone();
				tarefaClone.setLista(clone);
				cloneTarefas.add(tarefaClone);
			}
		}
		clone.setTarefas(cloneTarefas);
		return clone;
	}
}