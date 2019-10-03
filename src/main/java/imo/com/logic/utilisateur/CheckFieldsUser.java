/**
 * 
 */
package imo.com.logic.utilisateur;

import org.apache.commons.lang3.StringUtils;

import imo.com.general.IFonctionaliteCommune;
import imo.com.logic.utilisateur.dto.AdresseDto;
import imo.com.logic.utilisateur.dto.RepresentantLegalDto;
import imo.com.logic.utilisateur.moral.dto.UserMoralDto;
import imo.com.response.ImoResponse;

/**
 * @author mbalde
 *
 */
public class CheckFieldsUser implements IFonctionaliteCommune {

	/**
	 * check object adresse
	 * 
	 * @param adresse
	 *                Adresse
	 * @return message
	 */
	private String checkAdresse(AdresseDto adresse) {
		String message = "";
		if (adresse == null)
			message += "pays ville ";
		else {
			if (StringUtils.isBlank(adresse.getPays()))
				message += "pays";
			else if (!"Guinee".equals(adresse.getPays())) {
				// verification rue, numero et code postal
				if (StringUtils.isBlank(adresse.getNumeroRue()))
					message += "numeroRue ";
				if (StringUtils.isBlank(adresse.getLibelleRue()))
					message += "libelleRue ";
				if (StringUtils.isBlank(adresse.getCodePostal()))
					message += "codePostal ";
			}
			if (adresse.getVille() == null)
				message += "ville ";
		}
		return message;
	}

	/**
	 * verification des champs non nullable
	 * 
	 * @param <D>
	 *                    object response
	 * 
	 * @param dto
	 *                    userPhysique or user
	 * @param imoResponse
	 * @return boolean
	 */
	@Override
	public <D> boolean checkObjectDto(Object dto, ImoResponse<D> imoResponse) {

		String champsObligatoires = "";
		if (dto instanceof UserMoralDto) {
			if (((UserMoralDto) dto).getSiret() == null)
				champsObligatoires += "numero siret ";
		}
		// champs communs
		champsObligatoires += checkRepresentantLegal(((UserDto) dto).getRepresentantLegal());
		if (StringUtils.isBlank(((UserDto) dto).getEmail()))
			champsObligatoires += "email ";
		if (StringUtils.isBlank(((UserDto) dto).getPassword()))
			champsObligatoires += "password ";
		// Traitement resultat
		if (!StringUtils.isBlank(champsObligatoires)) {
			imoResponse.setChampsObligatoires(champsObligatoires.split(" "));
			return true;
		}
		return false;
	}

	/**
	 * check object representant legal
	 * 
	 * @param repL
	 *             Representant legal
	 * @return message
	 */
	private String checkRepresentantLegal(RepresentantLegalDto repL) {
		String message = "";
		if (repL == null)
			message += "nom prenom ";
		else {
			if (StringUtils.isBlank(repL.getNom()))
				message += "nom ";
			if (StringUtils.isBlank(repL.getPrenom()))
				message += "prenom ";
		}
		return message;
	}

}
