/**
 * 
 */
package imo.com.logic.offre.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import imo.com.general.ConstantesUtils;
import imo.com.logic.FonctialiterCommunes;
import imo.com.logic.offre.CheckFieldsOffre;
import imo.com.logic.offre.IOffre;
import imo.com.logic.offre.dto.OffreDto;
import imo.com.logic.offre.dto.OffreGlobalDto;
import imo.com.logic.offre.mapper.ImmobilierMapper;
import imo.com.logic.offre.mapper.MobileMapper;
import imo.com.logic.offre.mapper.OffreMapper;
import imo.com.model.immobilier.ImmobilierEntity;
import imo.com.model.mobile.MobileEntity;
import imo.com.model.offre.OffreEntity;
import imo.com.model.utilisateur.AppUser;
import imo.com.repo.offre.ImmobilierRepository;
import imo.com.repo.offre.MobileRepository;
import imo.com.repo.offre.OffreRepository;
import imo.com.repo.utilisateur.UserRepository;
import imo.com.response.ImoResponse;

/**
 * @author balde
 */
@Service
public class OffreImpl implements IOffre {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OffreImpl.class);

	@Autowired
	private MobileMapper mobileMapper;

	@Autowired
	private ImmobilierMapper immobilierMapper;

	@Autowired
	private MobileRepository mobileRepository;

	@Autowired
	private ImmobilierRepository immobilierRepository;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private OffreMapper offremapper;

	@Autowired
	private OffreRepository offreRepository;

	@Override
	public ImoResponse<OffreGlobalDto> creationOffre(OffreGlobalDto dto) {

		ImoResponse<OffreGlobalDto> imoResponse = new ImoResponse<>();
		CheckFieldsOffre checkFields = new CheckFieldsOffre();
		try {
			if (dto != null && (dto.getMobile() != null || dto.getImmobilier() != null)) {
				if (checkFields.checkObjectDto(dto, imoResponse)) {
					FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.BAD_REQUEST.value(),
							ConstantesUtils.MESSAGE_ERREUR_CREATION_OFFRE, null);
					
					LOGGER.error("---------------- [creation offre] : "+ConstantesUtils.MESSAGE_ERREUR_CREATION_OFFRE);
				} else {
					AppUser user = this.userRepo.findByEmail(dto.getEmail());
					// sauvegarde de l'offre mobile
					if (dto.getMobile() != null) {
						MobileEntity entity = mobileMapper.asObjectEntity(dto.getMobile());
						entity.setUser(user);
						mobileRepository.save(entity);
					}
					// Sauvegarde de l'offre immobilier
					if (dto.getImmobilier() != null) {
						ImmobilierEntity entity = this.immobilierMapper.asObjectEntity(dto.getImmobilier());
						entity.setUser(user);
						immobilierRepository.save(entity);
					}
					FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.OK.value(),
							ConstantesUtils.MESSAGE_CREATION_OFFRE, null);
					
					LOGGER.info("---------------- [creation offre] : "+ConstantesUtils.MESSAGE_CREATION_OFFRE);
				}
				return imoResponse;
			}

			// Erreur lors de la création de l'offre
			FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.BAD_REQUEST.value(),
					ConstantesUtils.MESSAGE_ERREUR_CREATION_OFFRE, null);
			
			LOGGER.info("---------------- [creation offre] : "+ConstantesUtils.MESSAGE_ERREUR_CREATION_OFFRE);
		} catch (Exception ex) {
			FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					ConstantesUtils.contrainteMessage(ex.getCause().getCause().getMessage()), null);
		}
		return imoResponse;
	}

	@Override
	public ImoResponse<OffreDto> getListOffres() {
		List<OffreDto> listoffreDto = new ArrayList<>();
		List<OffreEntity> offreEntities = (List<OffreEntity>) offreRepository.findAll();
		listoffreDto = offreEntities.stream().map(offremapper::asObjectDto).collect(Collectors.toList());
		ImoResponse<OffreDto> imoResponse = new ImoResponse<>();
		FonctialiterCommunes.setImoResponse(imoResponse, listoffreDto.isEmpty() ? HttpStatus.NOT_FOUND.value() : HttpStatus.OK.value(),
				listoffreDto.isEmpty() ? ConstantesUtils.MESSAGE_EMPTY : null, listoffreDto);
		return imoResponse;
	}
}
