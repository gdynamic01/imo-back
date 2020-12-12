/**
 * 
 */
package imo.com.resource.impl.offre;

import imo.com.logic.offre.IOffre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import imo.com.logic.offre.dto.OffreGlobalDto;
import imo.com.logic.offre.dto.OffreSearchViewDto;
import imo.com.model.enums.TypeServiceOffre;
import imo.com.resource.api.offre.IOffreApi;
import imo.com.response.ImoResponse;

/**
 * @author balde
 */
@RestController
public class OffreController implements IOffreApi {

	private final IOffre iOffre;

	@Autowired
	public OffreController(IOffre iOffre) {
		this.iOffre = iOffre;
	}

	@Override
	public ResponseEntity<ImoResponse<OffreGlobalDto>> creationOffre(OffreGlobalDto dto) {
		ImoResponse<OffreGlobalDto> imoResponse = iOffre.creationOffre(dto);
		return new ResponseEntity<>(imoResponse, HttpStatus.valueOf(imoResponse.getStatut()));
	}

	@Override
	public ResponseEntity<ImoResponse<OffreSearchViewDto>> getListOffres(TypeServiceOffre typesServices, String ville,
			String pays, String dateDebut, String dateFin, String categories) {
		ImoResponse<OffreSearchViewDto> imoResponse = iOffre.getListOffres(typesServices, ville, pays, dateDebut,
				dateFin, categories);
		return new ResponseEntity<>(imoResponse, HttpStatus.valueOf(imoResponse.getStatut()));
	}

	@Override
	public ResponseEntity<?> isOffreByCodeOffre(String codeOffre) {
		return iOffre.isOffreByCodeOffre(codeOffre);
	}

}
