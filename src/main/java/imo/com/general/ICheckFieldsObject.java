/**
 * 
 */
package imo.com.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import imo.com.logic.utilisateur.dto.AdresseDto;
import imo.com.response.ImoResponse;

/**
 * @author mbalde
 *
 */
public interface ICheckFieldsObject {

	/**
	 * 
	 * @param <D>
	 *                    object response
	 * @param dto
	 * @param imoResponse
	 * @return boolean
	 */
	public <D> boolean checkObjectDto(Object dto, ImoResponse<D> imoResponse);

	/**
	 * check object adresse
	 * 
	 * @param adresse
	 *                Adresse
	 * @return message
	 */
	public default String checkAdresse(AdresseDto adresse) {
		List<String> pays = new ArrayList<>(Arrays.asList(ConstantesUtils.pays));
		String message = "";
		if (adresse == null)
			message += "pays ville ";
		else {
			if (StringUtils.isBlank(adresse.getPays()))
				message += "pays";
			else if (!pays.contains(adresse.getPays())) {
				// verification rue, numero et code postal
				if (StringUtils.isBlank(adresse.getNumeroRue()))
					message += "numeroRue ";
				if (StringUtils.isBlank(adresse.getLibelleRue()))
					message += "libelleRue ";
				if (adresse.getCodePostal() <= 0)
					message += "codePostal ";
			}
			if (adresse.getVille() == null)
				message += "ville ";
		}
		return message;
	}

}
