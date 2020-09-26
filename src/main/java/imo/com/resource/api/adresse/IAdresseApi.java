/**
 * 
 */
package imo.com.resource.api.adresse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import imo.com.logic.adresse.dto.PaysDto;
import imo.com.response.ImoResponse;

/**
 * @author mbalde
 *
 */
@RequestMapping(
		path = "/loumos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
)
public interface IAdresseApi {

	/**
	 * recupère la liste des pays
	 * @return imoResponse
	 */
	@GetMapping(path="/pays")
	public ResponseEntity<ImoResponse<PaysDto>> getListPays();
	
}
