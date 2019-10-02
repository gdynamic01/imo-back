/**
 * 
 */
package imo.com.model.typeutilisateur;

/**
 * @author mbalde
 *
 */
public enum TypeUtilisateurEnum {

	/** Entreprise */
	ENTREPRISE("Entreprise"), //
	/** Particulier */
	PARTICULIER("Particulier");

	/** Libelle enum */
	private String libelle;

	private TypeUtilisateurEnum(String libelle) {
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
