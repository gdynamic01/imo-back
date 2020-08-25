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
	ROLE_ADMIN ("Administrateur"), //
	/** client user moral */
	ROLE_USER_MORAL ("entreprise"), //
	/** Role promotteur immobilier */
	ROLE_USER_PHYSIQUE ("particulier");

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
