/**
 * 
 */
package imo.com.logic.offre.impl;

import imo.com.logic.offre.dto.OffreDto;
import imo.com.logic.offre.mapper.OffreMapper;
import imo.com.model.offre.OffreEntity;
import imo.com.repo.offre.OffreBaseRepository;
import imo.com.repo.offre.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import imo.com.general.ConstantesUtils;
import imo.com.logic.FonctialiterCommunes;
import imo.com.logic.offre.CheckFieldsOffre;
import imo.com.logic.offre.IOffre;
import imo.com.logic.offre.dto.OffreGlobalDto;
import imo.com.logic.offre.mapper.ImmobilierMapper;
import imo.com.logic.offre.mapper.MobileMapper;
import imo.com.model.immobilier.ImmobilierEntity;
import imo.com.model.mobile.MobileEntity;
import imo.com.model.utilisateur.AppUser;
import imo.com.repo.offre.ImmobilierRepository;
import imo.com.repo.offre.MobileRepository;
import imo.com.repo.utilisateur.UserRepository;
import imo.com.response.ImoResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author balde
 *
 */
@Component
public class OffreImpl implements IOffre {

	@Autowired
	private MobileMapper mobileMapper;

	@Autowired
	private ImmobilierMapper immobilierMapper;

	@Autowired
	private MobileRepository mobileRepository;

	@Autowired

	private OffreMapper offremapper;
	@Autowired
	private ImmobilierRepository immobilierRepository;

	@Autowired
	private UserRepository userRepo;

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
				}
				else {
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
				}
				return imoResponse;
			}

			// Erreur lors de la création de l'offre
			FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.BAD_REQUEST.value(),
					ConstantesUtils.MESSAGE_ERREUR_CREATION_OFFRE, null);
		} catch(Exception ex) {
			FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					ConstantesUtils.contrainteMessage(ex.getCause().getCause().getMessage()), null);
		}
		return imoResponse;
	}

	@Override
	public ImoResponse<OffreDto> getListesOffres() {

		List<OffreDto>  listoffredto= new ArrayList<>();


		List<OffreEntity> offreEntities = (List<OffreEntity>) offreRepository.findAll();
		 listoffredto = offreEntities.stream().map(offremapper::asObjectDto).collect(Collectors.toList());

		ImoResponse<OffreDto> imoResponse = new ImoResponse<>();

		FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.OK.value(),
				listoffredto.isEmpty()? ConstantesUtils.MESSAGE_EMPTY: null, listoffredto);
	return imoResponse ;



	}
}
