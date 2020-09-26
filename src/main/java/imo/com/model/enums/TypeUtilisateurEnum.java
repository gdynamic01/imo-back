/**
 * 
 */
package imo.com.model.enums;

/**
 * @author mbalde
 *
 */
public enum TypeUtilisateurEnum {

	/** Entreprise */
	ENTREPRISE("Professionnel"), //

	/** Particulier */
	PARTICULIER("Particulier");

	/** Libelle enum */
	private String libelle;

	private TypeUtilisateurEnum(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
}
