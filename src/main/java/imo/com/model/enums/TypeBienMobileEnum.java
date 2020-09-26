package imo.com.model.enums;

public enum TypeBienMobileEnum {
	
	VOITURE("Voiture"), //
	VELO("Velo"), //
	MOTO("Moto");
	
	@SuppressWarnings("unused")
	private String libelle;
	
	private TypeBienMobileEnum(String libelle) {
		this.libelle = libelle;
	}

}
