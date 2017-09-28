package br.com.casalapp.api.dtos;

import java.io.Serializable;

	
public class RecompensaPessoaDto extends AbstractDto implements Serializable {

	private static final long serialVersionUID = -5754246207015712518L;
	
	private RecompensaDto recompensa;
	private Boolean utilizado;
	private Long pessoaId;
	
	public RecompensaDto getRecompensa() {
		return recompensa;
	}
	public void setRecompensa(RecompensaDto recompensa) {
		this.recompensa = recompensa;
	}
	public Boolean getUtilizado() {
		return utilizado;
	}
	public void setUtilizado(Boolean utilizado) {
		this.utilizado = utilizado;
	}
	public Long getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}

}