/**
 * 
 */
package imo.com.resource.api.offre;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import imo.com.general.AuthorisationUser;
import imo.com.logic.offre.dto.OffreGlobalDto;
import imo.com.logic.offre.dto.OffreSearchViewDto;
import imo.com.model.enums.TypeServiceOffre;
import imo.com.response.ImoResponse;

/**
 * @author balde
 */
@RequestMapping(path = "/loumos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public interface IOffreApi {

	/**
	 * creation une offre
	 * 
	 * @param dto
	 * @return offreGlobalDto
	 */
	@PreAuthorize(AuthorisationUser.PROF_OR_PAR)
	@PostMapping(path = "/offre")
	public ResponseEntity<ImoResponse<OffreGlobalDto>> creationOffre(@RequestBody OffreGlobalDto dto);

	/**
	 * recupère toutes les offres
	 * 
	 * @return listeOffre
	 */
	@GetMapping(path = "/offres")
	public ImoResponse<OffreSearchViewDto> getListOffres(
			@RequestParam(required = false) TypeServiceOffre typesServices,
			@RequestParam(required = false) String ville, @RequestParam(required = false) String pays,
			@RequestParam(required = false) String dateDebut, @RequestParam(required = false) String dateFin,
			@RequestParam(required = false) String categories);

	@GetMapping(path = "/{codeOffre}/offre")
	public ResponseEntity<ImoResponse<OffreSearchViewDto>> getOffreByCodeOffre(@PathVariable(value = "codeOffre") String codeOffre);
}
