package br.com.casalapp.api.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.casalapp.api.enums.PerfilEnum;

	
@Entity
@Table(name = "pessoa")
public class Pessoa extends AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = -5754246207015712518L;
	
	private String nome;
	private String email;
	private String senha;
	private PerfilEnum perfil;
	private Pessoa parceiro;
	private Configuracoes configuracoes;
	

	public Pessoa() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@Column(name = "nome", nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	@Column(name = "senha", nullable = true)
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	@OneToOne
    @JoinColumn(name = "parceiro_id")
	public Pessoa getParceiro() {
		return parceiro;
	}

	public void setParceiro(Pessoa parceiro) {
		this.parceiro = parceiro;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(nullable=false, name = "configuracoes_id")
	public Configuracoes getConfiguracoes() {
		return configuracoes;
	}

	public void setConfiguracoes(Configuracoes configuracoes) {
		this.configuracoes = configuracoes;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha;
	}

}