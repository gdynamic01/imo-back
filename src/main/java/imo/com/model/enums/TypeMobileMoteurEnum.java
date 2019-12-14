package imo.com.model.enums;

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
	VAPEUR("Vapeur"),

	/** PAS DE MOTEUR */
	SANS_MOTEUR("Sans moteur");

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
