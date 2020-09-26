/**
 * 
 */
package imo.com.logic.adresse;

import imo.com.logic.adresse.dto.PaysDto;
import imo.com.response.ImoResponse;

/**
 * @author mbalde
 *
 */
public interface IAdresse {
	
	public ImoResponse<PaysDto> getListPays();

}
