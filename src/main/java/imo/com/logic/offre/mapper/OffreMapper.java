package imo.com.logic.offre.mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.time.temporal.ChronoUnit;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imo.com.general.SymbolesMonetaires;
import imo.com.logic.IGeneriqueMapper;
import imo.com.logic.offre.dto.ImmobilierDto;
import imo.com.logic.offre.dto.MobileDto;
import imo.com.logic.offre.dto.OffreDto;
import imo.com.logic.photos.dto.PhotosDto;
import imo.com.logic.utilisateur.dto.AdresseDto;
import imo.com.model.immobilier.ImmobilierEntity;
import imo.com.model.mobile.MobileEntity;
import imo.com.model.offre.OffreEntity;

@Component
public class OffreMapper implements IGeneriqueMapper<OffreDto, OffreEntity> {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public OffreDto asObjectDto(OffreEntity in) {
		OffreDto dto = null;
		if(in instanceof ImmobilierEntity) {
			dto = new ImmobilierDto();
			mapperDto(dto, in);
		}
		if(in instanceof MobileEntity) {
			dto = new MobileDto();
			mapperDto(dto, in);
		}
		return dto;
	}

	@Override
	public OffreEntity asObjectEntity(OffreDto in) {
		return null;
	}
	
	private void mapperDto(OffreDto dto, OffreEntity entity) {
		dto.setAdresse(modelMapper.map(entity.getAdresse(), AdresseDto.class));
		dto.setTitre(entity.getTitre());
		dto.setDescription(entity.getDescription());
		dto.setPrix(entity.getPrix());
		dto.setCreateAt(entity.getCreateAt());
		dto.setUpdateAt(entity.getUpdateAt());
		dto.setTypeOffre(entity.getTypeOffre());
		dto.setTypeServiceOffre(entity.getTypeServiceOffre());
		dto.setTypeAnnonce(entity.getUser().getTypeUtilisateur().getLibelle());
		dto.setSymboleMonetaire(SymbolesMonetaires.getSymboleMonetaires(entity.getAdresse().getPays()));
		dto.setDateDebut(entity.getDateDebut());
		dto.setDateFin(entity.getDateFin());
		List<PhotosDto> photosDtos = entity.getPhotosOffres().stream().map(photo -> {
			  PhotosDto p = new PhotosDto();
			  p.setPathPhotos(photo.getPathPhotos());
			  return p;
		}).collect(Collectors.toList());
		
		dto.setPhotosOffres(photosDtos);
		
		long nbJour = ChronoUnit.DAYS.between(entity.getCreateAt(), LocalDate.now());
		dto.setNombreDeJour(nbJour);
		
		dto.setImmobilier(entity instanceof ImmobilierEntity);
		dto.setMobile(entity instanceof MobileEntity);
	}

}
