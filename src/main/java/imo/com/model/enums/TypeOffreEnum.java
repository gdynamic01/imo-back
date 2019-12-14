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
	VOITURE("Voiture"), //

	/** Velo */
	VELO("Velo"), //

	/** Moto */
	MOTO("Moto"),

	/** Maison */
	APPARTEMENT("Appartement"), //

	/** Terrain */
	MAISON("Maison"), //

	/** Appartement */
	TERRAIN("Terrain");

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
