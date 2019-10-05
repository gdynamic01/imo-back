/**
 * 
 */
package imo.com.model.utilisateur;

/**
 * @author mbalde
 *
 */
public enum RoleUserEnum {

	/** Administateur */
	ADMIN ("Administrateur"), //
	/** client user moral */
	USER_MORAL ("entreprise"), //
	/** Role promotteur immobilier */
	USER_PHYSIQUE ("particulier");

	private String libelle;

	private RoleUserEnum(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return Libelle
	 */
	public String getLibelle() {
		return this.libelle;
	}

}
