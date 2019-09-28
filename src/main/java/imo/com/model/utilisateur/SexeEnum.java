/**
 * 
 */
package imo.com.model.utilisateur;

/**
 * @author mbalde
 *
 */
public enum SexeEnum {

	/** Sexe femme */
	F ("Femme"), //
	/** Sexe masculin */
	M ("Masculin");

	private String libelle;

	private SexeEnum(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return libelle
	 */
	public String getLibelle() {
		return this.libelle;
	}

}
