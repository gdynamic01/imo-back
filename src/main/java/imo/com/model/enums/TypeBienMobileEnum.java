package imo.com.model.enums;

public enum TypeBienMobileEnum {
	
	VOITURE("Voiture"), //
	VELO("Velo"), //
	MOTO("Moto");
	
	private String libelle;
	
	private TypeBienMobileEnum(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

}
