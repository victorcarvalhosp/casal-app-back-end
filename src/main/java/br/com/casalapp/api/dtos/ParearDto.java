package br.com.casalapp.api.dtos;

import javax.validation.constraints.NotNull;

public class ParearDto extends AbstractDto {

	private Long idParceiro;

	public ParearDto() {
	}

	@NotNull
	public Long getIdParceiro() {
		return idParceiro;
	}

	public void setIdParceiro(Long idParceiro) {
		this.idParceiro = idParceiro;
	}

	@Override
	public String toString() {
		return "ParearDto [idParceiro=" + idParceiro + "]";
	}
	
}