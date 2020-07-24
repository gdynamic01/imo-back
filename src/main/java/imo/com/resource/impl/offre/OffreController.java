/**
 * 
 */
package imo.com.resource.impl.offre;

import imo.com.logic.offre.IOffre;
import imo.com.logic.offre.dto.OffreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import imo.com.logic.offre.dto.OffreGlobalDto;
import imo.com.resource.api.offre.IOffreApi;
import imo.com.response.ImoResponse;

/**
 * @author balde
 *
 */
@RestController
public class OffreController implements IOffreApi{

	@Autowired
	private IOffre iOffre;

	@Override
	public ImoResponse<OffreGlobalDto> creationOffre(OffreGlobalDto dto) {
		return iOffre.creationOffre(dto);
	}

	@Override
	public ImoResponse<OffreDto> getListesOffres() {
		return iOffre.getListesOffres();
	}

}
