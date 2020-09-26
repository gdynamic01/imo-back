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
	@SuppressWarnings("unused")
	private String libelle;

	private TypeMobileMoteurEnum(String libelle) {
		this.libelle = libelle;
	}
}
