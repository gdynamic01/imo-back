/**
 * 
 */
package imo.com.logic.offre.mapper;

import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imo.com.logic.IGeneriqueObjectDtoMapper;
import imo.com.logic.offre.dto.OffreSearchViewDto;
import imo.com.model.view.OffreSearchView;

/**
 * @author mbalde
 */
@Component
public class OffreSearchViewMapper implements IGeneriqueObjectDtoMapper<OffreSearchViewDto, OffreSearchView> {

	private final ModelMapper modelMapper;

	@Autowired
	public OffreSearchViewMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public OffreSearchViewDto asObjectDto(OffreSearchView in) {
		OffreSearchViewDto offreSearchViewDto = modelMapper.map(in, OffreSearchViewDto.class);
		// Calcule de la durée de l'offre
		calculDureeOffre(offreSearchViewDto);
		String typeUser = offreSearchViewDto.getTypeUser();
		typeUser = StringUtils.substring(offreSearchViewDto.getTypeUser(), 0, 3);
		offreSearchViewDto.setTypeUser(typeUser != null ? StringUtils.capitalize(typeUser.toLowerCase()) : null);
		return offreSearchViewDto;
	}
	
	private void calculDureeOffre(OffreSearchViewDto offreSearchViewDto) {
		LocalDateTime dateDuJour = LocalDateTime.now();
		Duration duration = Duration.between(dateDuJour, offreSearchViewDto.getCreateAt());
		long diff = Math.abs(duration.toDays());
		offreSearchViewDto.setDureeOffre(diff);
	}

}
