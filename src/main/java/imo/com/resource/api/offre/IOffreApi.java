/**
 * 
 */
package imo.com.resource.api.offre;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import imo.com.general.AuthorisationUser;
import imo.com.logic.offre.dto.OffreDto;
import imo.com.logic.offre.dto.OffreGlobalDto;
import imo.com.response.ImoResponse;

/**
 * @author balde
 *
 */
@RequestMapping(
		path = "/loumos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
)
public interface IOffreApi {

	/**
	 * creation une offre
	 * @param dto
	 * @return offreGlobalDto
	 */
	@PreAuthorize(AuthorisationUser.PROF_OR_PAR)
	@PostMapping(path="/offre")
	public ImoResponse<OffreGlobalDto> creationOffre(@RequestBody OffreGlobalDto dto);

	/**
	 * recupère toutes les offres
	 * @return listeOffre
	 */
	@GetMapping(path="/offres")
	public ImoResponse<OffreDto> getListOffres();
}
