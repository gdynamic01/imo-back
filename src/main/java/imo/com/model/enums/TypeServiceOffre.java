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

	@SuppressWarnings("unused")
	private String libelle;

	private TypeServiceOffre(String libelle) {
		this.libelle = libelle;
	}
}
