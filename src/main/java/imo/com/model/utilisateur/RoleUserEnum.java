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
	USER_MORAL ("client qui recherche une offre"), //
	/** Role promotteur immobilier */
	USER_PHYSIQUE ("offre de propositon (entreprise, particulier)");

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
