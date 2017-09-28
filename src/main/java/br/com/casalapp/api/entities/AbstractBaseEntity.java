package br.com.casalapp.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractBaseEntity implements BaseEntity, Cloneable {
	
	private static final long serialVersionUID = 1L;
	protected Long id;
	protected Date dataCriacao;
	
	@JsonIgnore
    public boolean hasId() {
        return getId() != null;
    }
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public abstract Long getId();

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "data_criacao", nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dataCriacao = atual;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractBaseEntity other = (AbstractBaseEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		AbstractBaseEntity clone = (AbstractBaseEntity) super.clone();
		clone.setId(null);
		return clone;
	}
	
	

}
