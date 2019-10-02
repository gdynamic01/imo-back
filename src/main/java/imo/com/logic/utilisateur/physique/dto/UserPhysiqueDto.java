/**
 * 
 */
package imo.com.logic.utilisateur.physique.dto;

import imo.com.logic.utilisateur.UserDto;
import imo.com.model.adresse.Adresse;
import imo.com.model.info.RepresentantLegal;
import imo.com.model.utilisateur.SexeEnum;

/**
 * @author mbalde
 *
 */
public class UserPhysiqueDto extends UserDto {

	/** adresse */
	private Adresse adresse;

	/** representant legal */
	private RepresentantLegal representantLegal;

	/** sexe */
	private SexeEnum sexe;

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @return the representantLegal
	 */
	public RepresentantLegal getRepresentantLegal() {
		return representantLegal;
	}

	/**
	 * @return the sex
	 */
	public SexeEnum getSexe() {
		return sexe;
	}

	/**
	 * @param adresse
	 *                the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @param representantLegal
	 *                          the representantLegal to set
	 */
	public void setRepresentantLegal(RepresentantLegal representantLegal) {
		this.representantLegal = representantLegal;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSexe(SexeEnum sex) {
		this.sexe = sex;
	}
}
