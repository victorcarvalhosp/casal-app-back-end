package br.com.casalapp.api.enums;

public enum PeriodoTarefaEnum {
	ATRASADA("Atrasada"),
	HOJE("Hoje"),
	AMANHA("Amanhã"),
	SEM_DATA("Sem data"),
	DEPOIS("Depois");
	
	private final String label;

	private PeriodoTarefaEnum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

}
