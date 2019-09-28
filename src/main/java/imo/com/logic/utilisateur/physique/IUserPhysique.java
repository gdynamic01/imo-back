/**
 * 
 */
package imo.com.logic.utilisateur.physique;

import imo.com.logic.utilisateur.physique.dto.UserPhysiqueDto;
import imo.com.response.ImoResponse;

/**
 * @author mbalde
 *
 */
public interface IUserPhysique {

	/**
	 * @param dto donnee utilisateur physique
	 * @return userPhysiqueDto
	 */
	public ImoResponse<UserPhysiqueDto> registration(UserPhysiqueDto dto);
}
