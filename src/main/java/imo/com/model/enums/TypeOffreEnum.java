/**
 * 
 */
package imo.com.model.enums;

/**
 * @author balde
 *
 */
public enum TypeOffreEnum {

	/** Voiture */
	MOBILE("Mobile"), //

	/** Velo */
	IMMOBILIER("Immobilier");

	/** Libelle enum */
	@SuppressWarnings("unused")
	private String libelle;

	private TypeOffreEnum(String libelle) {
		this.libelle = libelle;
	}
}
