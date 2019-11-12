/**
 * 
 */
package imo.com.logic.utilisateur.dto;

import imo.com.model.utilisateur.SexeEnum;

/**
 * @author mbalde
 *
 */
public class RepresentantLegalDto {

	private String nom;

	/** poste occupé */
	private String posteOcupee;

	/** prenom representant legal (directeur ou PDG ou ....) */
	private String prenom;

	/** telephone */
	private String telephone;

	/** sexe */
	private SexeEnum sexe;

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the posteOcupee
	 */
	public String getPosteOcupee() {
		return posteOcupee;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param posteOcupee the posteOcupee to set
	 */
	public void setPosteOcupee(String posteOcupee) {
		this.posteOcupee = posteOcupee;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the sexe
	 */
	public SexeEnum getSexe() {
		return sexe;
	}

	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(SexeEnum sexe) {
		this.sexe = sexe;
	}

}
