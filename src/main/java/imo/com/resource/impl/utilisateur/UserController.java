/**
 * 
 */
package imo.com.resource.impl.utilisateur;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import imo.com.logic.utilisateur.IUser;
import imo.com.logic.utilisateur.dto.UserDto;
import imo.com.logic.utilisateur.dto.UserMoralDto;
import imo.com.resource.api.utilisateur.IUserApi;
import imo.com.response.ImoResponse;
import imo.com.response.JwtTokenResponse;

/**
 * @author balde
 *
 */
@RestController
public class UserController implements IUserApi {

	@Inject
	IUser user;

	@Override
	public ResponseEntity<JwtTokenResponse> connexion(UserDto userDto) {
		try {
			return this.user.authentification(userDto);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new JwtTokenResponse(null, "L'email ou le mot de passe est incorrect",
					HttpStatus.UNAUTHORIZED.value()), HttpStatus.UNAUTHORIZED);
		}
	}

	@Override
	public ResponseEntity<ImoResponse<UserMoralDto>> creationCompte(UserMoralDto professionnel) {
		ImoResponse<UserMoralDto> imoResponse = this.user.registration(professionnel);
		return new ResponseEntity<>(imoResponse, HttpStatus.valueOf(imoResponse.getStatut()));
	}

	@Override
	public ResponseEntity<ImoResponse<UserDto>> creationCompte(UserDto particulier) {
		ImoResponse<UserDto> imoResponse = this.user.registration(particulier);
		return new ResponseEntity<>(imoResponse, HttpStatus.valueOf(imoResponse.getStatut()));
	}

}
