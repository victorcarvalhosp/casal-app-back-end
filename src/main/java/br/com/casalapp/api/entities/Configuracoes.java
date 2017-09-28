package br.com.casalapp.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

	
@Entity
@Table(name = "configuracoes")
public class Configuracoes extends AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = -5754246207015712518L;
	
	private Pessoa pessoa;
	private String emailParceiroConvite;

	public Configuracoes() {
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@OneToOne(mappedBy="configuracoes")
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Column(name="email_parceiro_convite")
	public String getEmailParceiroConvite() {
		return emailParceiroConvite;
	}

	public void setEmailParceiroConvite(String emailParceiroConvite) {
		this.emailParceiroConvite = emailParceiroConvite;
	}

	@Override
	public String toString() {
		return "Configuracoes [pessoa=" + pessoa + ", emailParceiroConvite=" + emailParceiroConvite + "]";
	}
     
}