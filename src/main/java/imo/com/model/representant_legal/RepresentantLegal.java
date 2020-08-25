/**
 * 
 */
package imo.com.model.representant_legal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import imo.com.model.utilisateur.SexeEnum;

/**
 * @author mbalde
 *
 */
@Embeddable
public class RepresentantLegal implements Serializable {

	/** Serial ID */
	private static final long serialVersionUID = 4030719305856082105L;

	/** nom representant legal (directeur ou PDG ou ....) */
	@Column(name = "nom", nullable = false)
	private String nom;

	/** poste occupé */
	@Column(name = "poste_occupe")
	private String posteOcupee;

	/** prenom representant legal (directeur ou PDG ou ....) */
	@Column(name = "prenom", nullable = false)
	private String prenom;

	/** Sexe **/
	@Column(name = "sexe", nullable = false)
	@Enumerated(EnumType.STRING)
	private SexeEnum sexe;

	/** telephone */
	@Column(name = "telephone")
	private String telephone;

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
	 * @param sexe
	 *             the sexe to set
	 */
	public void setSexe(SexeEnum sexe) {
		this.sexe = sexe;
	}
}
