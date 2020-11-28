/**
 * 
 */
package imo.com.logic.offre;

import imo.com.logic.offre.dto.OffreGlobalDto;
import imo.com.logic.offre.dto.OffreSearchViewDto;
import imo.com.model.enums.TypeServiceOffre;
import imo.com.response.ImoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author balde
 *
 */
public interface IOffre {

	/**
	 * creation offre
	 * @param dto
	 * @return offreGlobalDto
	 */
	public ImoResponse<OffreGlobalDto> creationOffre(OffreGlobalDto dto);
	
	/**
	 * 
	 * @return offreDto
	 */
	public ImoResponse<OffreSearchViewDto> getListOffres(TypeServiceOffre typesServices, String ville,
			String pays, String dateDebut, String dateFin, String categories);

	public ResponseEntity<?> isOffreByCodeOffre(@PathVariable(value="codeOffre") String codeOffre);
}
