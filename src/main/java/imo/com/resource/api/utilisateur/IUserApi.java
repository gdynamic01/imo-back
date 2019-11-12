package imo.com.resource.api.utilisateur;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import imo.com.logic.utilisateur.dto.UserDto;
import imo.com.logic.utilisateur.dto.UserMoralDto;
import imo.com.response.ImoResponse;

/**
 * @author balde
 *
 */
@RequestMapping(path = "/immo")
public interface IUserApi {

	/**
	 * Connexion au site
	 * @param userDto
	 * @return token
	 */
	@PostMapping(
			path = "/authentification", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
	)

	public ResponseEntity<?> connexion(@RequestBody UserDto userDto);

	/**
	 * creation compte professionnel
	 * @param userMoralDto
	 * @return responseEntity
	 */
	@PostMapping(
			path = "/inscription/professionnel", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
	)

	public ResponseEntity<ImoResponse<UserMoralDto>> creationCompte(@RequestBody UserMoralDto professionnel);

	/**
	 * creation compte particulier
	 * @param userPhysiqueDto
	 * @param responseEntity
	 */
	@PostMapping(
			path = "/inscription/particulier", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
	)

	public ResponseEntity<ImoResponse<UserDto>> creationCompte(@RequestBody UserDto particulier);

}
