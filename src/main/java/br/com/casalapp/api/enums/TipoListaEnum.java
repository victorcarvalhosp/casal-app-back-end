package br.com.casalapp.api.enums;

public enum TipoListaEnum {
	LOUCA("Louças", "002-wash.svg"),
	LAVAR_ROUPAS("Roupas", "043-laundry.svg"),
	PASSAR_ROUPAS("Passar roupas", "011-ironing.svg"),
	LIXO("Lixo", "034-garbage-1.svg"),
	VARRER_CASA("Varrer casa", "050-broom.svg"),
	CASA("Cuidados com a casa", "012-house.svg"),
	CONSERTO_ITENS("Conserto de itens","005-briefcase.svg"),
	LAVAR_ITEM("Lavar item", "023-gloves.svg"),
	BONS_MODOS("Bons modos", "gentleman.svg"),
	HIGIENE("Higiene", "higiene.svg");
	
	private final String label;
	private final String img;


	private TipoListaEnum(String label, String img) {
		this.label = label;
		this.img = img;
	}

	public String getLabel() {
		return this.label;
	}

	public String getImg() {
		return img;
	}
	
}
