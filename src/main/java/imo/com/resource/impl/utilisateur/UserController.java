/**
 * 
 */
package imo.com.resource.impl.utilisateur;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.RestController;

import imo.com.logic.FonctialiterCommunes;
import imo.com.logic.utilisateur.IUser;
import imo.com.logic.utilisateur.dto.UserDto;
import imo.com.logic.utilisateur.dto.UserMoralDto;
import imo.com.logic.utilisateur.dto.UserPhysiqueDto;
import imo.com.model.utilisateur.RoleUserEnum;
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
	public ResponseEntity<JwtTokenResponse> connexion(String email, String password) {
		try {
			UserDto dto = new UserDto();
			dto.setEmail(email);
			dto.setPassword(password);
			return user.authentification(dto);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new JwtTokenResponse(null, "L'email ou le mot de passe est incorrect",
					HttpStatus.UNAUTHORIZED.value()), HttpStatus.UNAUTHORIZED);
		}
	}

	@Override
	public ResponseEntity<ImoResponse<UserMoralDto>> creationCompte(UserMoralDto professionnel) {
		ImoResponse<UserMoralDto> imoResponse = new ImoResponse<>();
		try {
			imoResponse = user.registration(professionnel);
		} catch (UnexpectedRollbackException ex) {
			FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					FonctialiterCommunes.messageErreur, null);
		}
		return new ResponseEntity<>(imoResponse, HttpStatus.valueOf(imoResponse.getStatut()));
	}

	@Override
	public ResponseEntity<ImoResponse<UserPhysiqueDto>> creationCompte(UserPhysiqueDto particulier) {
		ImoResponse<UserPhysiqueDto> imoResponse = new ImoResponse<>();
		try {
			imoResponse = user.registration(particulier);
		} catch (UnexpectedRollbackException ex) {
			FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					FonctialiterCommunes.messageErreur, null);
		}
		return new ResponseEntity<>(imoResponse, HttpStatus.valueOf(imoResponse.getStatut()));
	}

	@Override
	public ResponseEntity<ImoResponse<String>> getEmailExist(String email) {
		ImoResponse<String> imoResponse = user.getEmail(email);
		return new ResponseEntity<>(imoResponse, HttpStatus.valueOf(imoResponse.getStatut()));
	}

	@Override
	public ResponseEntity<ImoResponse<RoleUserEnum>> getRolesByEmail(String email) {
		ImoResponse<RoleUserEnum> imoResponse = user.getRolesByEmail(email);
		return new ResponseEntity<>(imoResponse, HttpStatus.valueOf(imoResponse.getStatut()));
	}

}
