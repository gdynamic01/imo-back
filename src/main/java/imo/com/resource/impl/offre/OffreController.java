/**
 * 
 */
package imo.com.resource.impl.offre;

import imo.com.logic.offre.IOffre;
import imo.com.logic.offre.dto.OffreDto;
import imo.com.logic.utilisateur.dto.UserMoralDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<ImoResponse<OffreGlobalDto>>  creationOffre(OffreGlobalDto dto) {
		// TODO Auto-generated method stub
		ImoResponse<OffreGlobalDto> imoResponse = this.iOffre.creationOffre(dto);
		return new ResponseEntity<>(imoResponse, HttpStatus.valueOf(imoResponse.getStatut()));
		//return null;
	}

	@Override
	public ImoResponse<OffreGlobalDto> getListesOffres() {
		// TODO Auto-generated method stub
		return null;
	}

}
