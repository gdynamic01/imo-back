/**
 * 
 */
package imo.com.logic.offre;

import imo.com.logic.offre.dto.OffreDto;
import imo.com.logic.offre.dto.OffreGlobalDto;
import imo.com.response.ImoResponse;

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
	 * liste des  offres
	 * @param
	 * @return offreDto
	 */
	public ImoResponse<OffreDto> getListesOffres();
}
