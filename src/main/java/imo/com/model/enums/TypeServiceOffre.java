/**
 * 
 */
package imo.com.model.enums;

/**
 * @author balde
 *
 */
public enum TypeServiceOffre {

	// Location
	LOCATION("Location"),

	// Vente
	VENTE("Vente");

	private String libelle;

	private TypeServiceOffre(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
}
