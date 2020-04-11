/**
 * 
 */
package imo.com.resource.impl.offre;

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
	private IOffreApi iOffre;

	@Override
	public ImoResponse<OffreGlobalDto> creationOffre(OffreGlobalDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImoResponse<OffreGlobalDto> getListesOffres() {
		// TODO Auto-generated method stub
		return null;
	}

}
