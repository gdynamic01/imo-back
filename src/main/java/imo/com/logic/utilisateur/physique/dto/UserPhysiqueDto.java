/**
 * 
 */
package imo.com.logic.utilisateur.physique.dto;

import imo.com.logic.utilisateur.UserDto;
import imo.com.model.utilisateur.SexeEnum;

/**
 * @author mbalde
 *
 */
public class UserPhysiqueDto extends UserDto {

	/** sexe */
	private SexeEnum sexe;

	/**
	 * @return the sex
	 */
	public SexeEnum getSexe() {
		return sexe;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSexe(SexeEnum sex) {
		this.sexe = sex;
	}
}
