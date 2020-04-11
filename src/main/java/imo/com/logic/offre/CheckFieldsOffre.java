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
import imo.com.response.ImoResponse;

/**
 * @author balde
 *
 */
public class CheckFieldsOffre implements ICheckFieldsObject {

	@SuppressWarnings("unused")
	private String champsObligatoires;

	@Override
	public <D> boolean checkObjectDto(Object dto, ImoResponse<D> imoResponse) {

		if (dto instanceof OffreGlobalDto) {
			if (((OffreGlobalDto) dto).getImmobilierDto() != null) {
				this.champsObligatoires = checkFieldsOffre(((OffreGlobalDto) dto).getImmobilierDto()); // cas global
				this.champsObligatoires += this.checkFieldsImmobilier(((OffreGlobalDto) dto).getImmobilierDto()); // (OffreDto)
			}
			if (((OffreGlobalDto) dto).getMobileDto() != null) {
				this.champsObligatoires = checkFieldsOffre(((OffreGlobalDto) dto).getMobileDto()); // cas global
																									// (OffreDto)
				this.champsObligatoires += checkFieldsMobile(((OffreGlobalDto) dto).getMobileDto());
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
		if (StringUtils.isBlank(mobileDto.getModel())) {
			champs += "model";
		}
		return champs;
	}

	private String checkFieldsImmobilier(ImmobilierDto immobilierDto) {

		String champs = "";
		if (immobilierDto.getSurface() == null || immobilierDto.getSurface() < 9) {
			champs += "surface ";
		}
		return champs;
	}

}
