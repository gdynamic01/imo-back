/**
 * 
 */
package imo.com.resource.api.offre;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import imo.com.logic.offre.dto.OffreGlobalDto;
import imo.com.response.ImoResponse;

/**
 * @author balde
 *
 */
@RequestMapping(
		path = "/immo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
)
public interface IOffreApi {

	/**
	 * creation une offre
	 * @param dto
	 * @return offreGlobalDto
	 */
	@PostMapping(path = "/creation-offre")
	public ImoResponse<OffreGlobalDto> creationOffre(@RequestBody OffreGlobalDto dto);

	/**
	 * recupère toutes les offres
	 * @return listeOffre
	 */
	@GetMapping(path = "/liste/offres")
	public ImoResponse<OffreGlobalDto> getListesOffres();
}
