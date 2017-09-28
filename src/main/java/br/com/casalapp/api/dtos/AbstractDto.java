package br.com.casalapp.api.dtos;

public abstract class AbstractDto implements Dto {
	
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

}