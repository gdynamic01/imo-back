/**
 * 
 */
package imo.com.resource.impl.adresse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import imo.com.logic.adresse.IAdresse;
import imo.com.logic.adresse.dto.PaysDto;
import imo.com.resource.api.adresse.IAdresseApi;
import imo.com.response.ImoResponse;

/**
 * @author mbalde
 */
@RestController
public class AdresseController implements IAdresseApi {

	private final IAdresse iAdresse;

	@Autowired
	public AdresseController(IAdresse iAdresse) {
		this.iAdresse = iAdresse;
	}

	@Override
	public ResponseEntity<ImoResponse<PaysDto>> getListPays() {

		ImoResponse<PaysDto> imoResponse = iAdresse.getListPays();
		return new ResponseEntity<>(imoResponse, HttpStatus.valueOf(imoResponse.getStatut()));
	}

}
