/**
 * 
 */
package imo.com.logic.utilisateur.moral;

import imo.com.logic.utilisateur.moral.dto.UserMoralDto;
import imo.com.response.ImoResponse;

/**
 * @author mbalde
 *
 */
public interface IUserMoral {

	/**
	 * @param dto
	 * @return userMoralDto
	 */
	public ImoResponse<UserMoralDto> registration(UserMoralDto dto);
}
