package imo.com.model;

/**
 * 
 * @author balde
 *
 */
public enum TypeMobileMoteurEnum {

	/** Electrique */
	ELECTRIQUE("Electrique"), //

	/** Electrique */
	HYBRIDE("Hybride"), //

	/** Vapeur */
	VAPEUR("Vapeur");

	/** Libelle enum */
	private String libelle;

	private TypeMobileMoteurEnum(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * retourne le libelle
	 * @return libelle
	 */
	public String getLibelle() {
		return this.libelle;
	}
}
