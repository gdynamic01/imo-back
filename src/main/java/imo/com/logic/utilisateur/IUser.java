/**
 * 
 */
package imo.com.logic.utilisateur;

import org.springframework.http.ResponseEntity;

import imo.com.logic.utilisateur.dto.UserDto;
import imo.com.logic.utilisateur.dto.UserMoralDto;
import imo.com.response.ImoResponse;
import imo.com.response.JwtTokenResponse;

/**
 * @author balde
 *
 */
public interface IUser {

	/**
	 * authentification
	 * @param userDto
	 * @return ResponseEntity token
	 */
	public ResponseEntity<JwtTokenResponse> authentification(UserDto userDto) throws Exception;

	/**
	 * @param dto
	 * @return userMoralDto
	 */
	public ImoResponse<UserMoralDto> registration(UserMoralDto dto);

	/**
	 * @param dto donnee utilisateur physique
	 * @return userPhysiqueDto
	 */
	public ImoResponse<UserDto> registration(UserDto dto);
}
