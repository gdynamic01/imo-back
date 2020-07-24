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
	private String libelle;

	private TypeOffreEnum(String libelle) {
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
