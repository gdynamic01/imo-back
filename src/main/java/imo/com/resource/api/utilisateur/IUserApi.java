package imo.com.resource.api.utilisateur;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import imo.com.logic.utilisateur.dto.UserMoralDto;
import imo.com.logic.utilisateur.dto.UserPhysiqueDto;
import imo.com.model.utilisateur.RoleUserEnum;
import imo.com.response.ImoResponse;

/**
 * @author balde
 */
@RequestMapping(path = "/loumos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public interface IUserApi {

	/**
	 * Connexion au site
	 * 
	 * @param userDto
	 * @return token
	 */
	@GetMapping(path = "/authentification/{email}/{password}")
	public ResponseEntity<?> connexion(@PathVariable(value = "email") String email,
			@PathVariable(value = "password") String password);

	/**
	 * creation compte professionnel
	 * 
	 * @param userMoralDto
	 * @return responseEntity
	 */
	@PostMapping(path = "/professionnel")
	public ResponseEntity<ImoResponse<UserMoralDto>> creationCompte(@RequestBody UserMoralDto professionnel);

	/**
	 * creation compte particulier
	 * 
	 * @param userPhysiqueDto
	 * @param responseEntity
	 */
	@PostMapping(path = "/particulier")
	public ResponseEntity<ImoResponse<UserPhysiqueDto>> creationCompte(@RequestBody UserPhysiqueDto particulier);

	/**
	 * get email
	 * 
	 * @param email
	 * @return responseEntity
	 */
	@GetMapping(path = "/email/{email:.+}")
	public ResponseEntity<ImoResponse<String>> getEmailExist(@PathVariable(value = "email") String email);

	/**
	 * get roles
	 * 
	 * @param email
	 * @return
	 */
	@GetMapping(path = "/roles/{email:.+}")
	public ResponseEntity<ImoResponse<RoleUserEnum>> getRolesByEmail(@PathVariable(value = "email") String email);

}
