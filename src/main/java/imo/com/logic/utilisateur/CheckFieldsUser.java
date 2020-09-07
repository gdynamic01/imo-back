/**
 * 
 */
package imo.com.logic.utilisateur;

import org.apache.commons.lang3.StringUtils;

import imo.com.general.ICheckFieldsObject;
import imo.com.logic.utilisateur.dto.RepresentantLegalDto;
import imo.com.logic.utilisateur.dto.UserDto;
import imo.com.logic.utilisateur.dto.UserMoralDto;
import imo.com.response.ImoResponse;

/**
 * @author mbalde
 *
 */
public class CheckFieldsUser implements ICheckFieldsObject {

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
		if (dto instanceof UserMoralDto && ((UserMoralDto) dto).getSiret() == null) {
			champsObligatoires += "numero siret ";
		}
		// champs communs
		champsObligatoires += checkRepresentantLegal(((UserDto) dto).getRepresentantLegal());
		champsObligatoires += checkAdresse(((UserDto) dto).getAdresse());
		if (StringUtils.isBlank(((UserDto) dto).getEmail()))
			champsObligatoires += "email ";
		if (StringUtils.isBlank(((UserDto) dto).getPassword()))
			champsObligatoires += "password ";
		if (((UserDto) dto).getTypeUtilisateur() == null)
			champsObligatoires += "type_utilisateur ";
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
			if (repL.getSexe() == null) {
				message += "sexe ";
			}
		}
		return message;
	}

}
