/**
 * 
 */
package imo.com.logic.offre;

import org.apache.commons.lang3.StringUtils;

import imo.com.general.ICheckFieldsObject;
import imo.com.logic.offre.dto.ImmobilierDto;
import imo.com.logic.offre.dto.MobileDto;
import imo.com.logic.offre.dto.OffreDto;
import imo.com.logic.offre.dto.OffreGlobalDto;
import imo.com.model.enums.TypeServiceOffre;
import imo.com.response.ImoResponse;

/**
 * @author balde
 */
public class CheckFieldsOffre implements ICheckFieldsObject {

	@SuppressWarnings("unused")
	private String champsObligatoires;

	@Override
	public <D> boolean checkObjectDto(Object dto, ImoResponse<D> imoResponse) {

		if (dto instanceof OffreGlobalDto) {
			if (((OffreGlobalDto) dto).getImmobilier() != null) {
				this.champsObligatoires = checkFieldsOffre(((OffreGlobalDto) dto).getImmobilier()); // cas global
				this.champsObligatoires += this.checkFieldsImmobilier(((OffreGlobalDto) dto).getImmobilier()); // (OffreDto)
			}
			if (((OffreGlobalDto) dto).getMobile() != null) {
				this.champsObligatoires = checkFieldsOffre(((OffreGlobalDto) dto).getMobile()); // cas global															// (OffreDto)
				this.champsObligatoires += checkFieldsMobile(((OffreGlobalDto) dto).getMobile());
			}
			if (StringUtils.isBlank(((OffreGlobalDto) dto).getEmail())) {
				this.champsObligatoires += "email";
			}
			if (!StringUtils.isBlank(champsObligatoires)) {
				imoResponse.setChampsObligatoires(champsObligatoires.split(" "));
				return true;
			}
		}
		return false;
	}

	/**
	 * Check les champs obligatoires des offres
	 * 
	 * @param dto offre
	 * @return champs
	 */
	private String checkFieldsOffre(OffreDto dto) {

		String champs = "";
		if (StringUtils.isBlank(dto.getTitre())) {
			champs += "titre ";
		}
		champs += checkAdresse(dto.getAdresse());
		if (dto.getTypeOffre() == null) {
			champs += "typeOffre ";
		}
		if (dto.getTypeServiceOffre() == null) {
			champs += "typeServiceOffre ";
		}
		return champs;
	}

	/**
	 * Check les champs obligatoires des offres mobile
	 * 
	 * @param mobileDto OffreMobile
	 * @return champs
	 */
	private String checkFieldsMobile(MobileDto mobileDto) {

		String champs = "";
		if (mobileDto.getDateMiseEnCircualtion() == null) {
			champs += "dateMiseEnCircualtion ";
		}
		if (mobileDto.getTypeMobileMoteur() == null) {
			champs += "typeMobileMoteur ";
		}
		return champs;
	}

	private String checkFieldsImmobilier(ImmobilierDto immobilierDto) {

		String champs = "";
		if (immobilierDto.getSurface() == null || immobilierDto.getSurface() < 9) {
			champs += "surface ";
		}

		if (immobilierDto.getTypeDeBien() == null) {
			champs += "type_de_Bien ";
		}
		if (immobilierDto.getParking() == null) {
			champs += "parking ";
		}
		if (immobilierDto.getElectricite() == null) {
			champs += "electricite ";
		}
		if (immobilierDto.getEau() == null) {
			champs += "eau ";
		}
		if (immobilierDto.getSanitaire() == null) {
			champs += "sanitaire ";
		}
		if (immobilierDto.getDateDebut() == null) {
			champs += "date_debut ";
		}
		if (immobilierDto.getTypeServiceOffre() != null
				&& TypeServiceOffre.LOCATION.equals(immobilierDto.getTypeServiceOffre())
				&& immobilierDto.getDateFin() == null) {
			champs += "date_fin ";
		}
		return champs;
	}

}
