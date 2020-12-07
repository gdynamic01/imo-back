package imo.com.logic.offre.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import imo.com.model.offre.OffreEntity;
import imo.com.repo.offre.OffreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import imo.com.general.ConstantesUtils;
import imo.com.logic.FonctialiterCommunes;
import imo.com.logic.adresse.dto.PaysDto;
import imo.com.logic.adresse.dto.VilleDto;
import imo.com.logic.adresse.mapper.AdresseMapper;
import imo.com.logic.offre.CheckFieldsOffre;
import imo.com.logic.offre.IOffre;
import imo.com.logic.offre.dto.OffreGlobalDto;
import imo.com.logic.offre.dto.OffreSearchViewDto;
import imo.com.logic.offre.mapper.ImmobilierMapper;
import imo.com.logic.offre.mapper.MobileMapper;
import imo.com.logic.offre.mapper.OffreSearchViewMapper;
import imo.com.logic.utilisateur.dto.AdresseDto;
import imo.com.model.enums.TypeServiceOffre;
import imo.com.model.immobilier.ImmobilierEntity;
import imo.com.model.mobile.MobileEntity;
import imo.com.model.pays.PaysEntity;
import imo.com.model.utilisateur.AppUser;
import imo.com.model.view.OffreSearchView;
import imo.com.repo.adresse.PaysRepository;
import imo.com.repo.offre.ImmobilierRepository;
import imo.com.repo.offre.MobileRepository;
import imo.com.repo.utilisateur.UserRepository;
import imo.com.repo.view.offre.IOffreSearchViewRepositoryCustom;
import imo.com.response.ImoResponse;


@Service
public class OffreImpl implements IOffre {

	private static final Logger LOGGER = LoggerFactory.getLogger(OffreImpl.class);

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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
	private PaysRepository paysRepository;

	@Autowired
	private IOffreSearchViewRepositoryCustom iOffreSearchViewRepo;

	@Autowired
	private OffreSearchViewMapper offreSearchViewMapper;

	@Autowired
	private AdresseMapper adresseMapper;

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

					LOGGER.error(
							"---------------- [creation offre] : " + ConstantesUtils.MESSAGE_ERREUR_CREATION_OFFRE);
				} else {
					AdresseDto adresseDto = null;
					AppUser user = this.userRepo.findByEmail(dto.getEmail());
					// sauvegarde de l'offre mobile
					if (dto.getMobile() != null) {
						adresseDto = dto.getMobile().getAdresse();
						MobileEntity entity = mobileMapper.asObjectEntity(dto.getMobile());
						entity.setUser(user);
						mobileRepository.save(entity);
						// calcul codeOffre
						calculCodeOffre((OffreEntity) entity);
					}
					// Sauvegarde de l'offre immobilier
					if (dto.getImmobilier() != null) {
						adresseDto = dto.getImmobilier().getAdresse();
						ImmobilierEntity entity = this.immobilierMapper.asObjectEntity(dto.getImmobilier());
						entity.setUser(user);
						immobilierRepository.save(entity);
						// calcul codeOffre
						calculCodeOffre((OffreEntity) entity);
					}

					PaysEntity paysEntity = paysRepository.findByNomPays(adresseDto.getPays());
					if (paysEntity == null) {
						// creation Pays d'offre
						createPaysAndVille(adresseDto);
					}

					FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.OK.value(),
							ConstantesUtils.MESSAGE_CREATION_OFFRE, null);

					LOGGER.info("---------------- [creation offre] : " + ConstantesUtils.MESSAGE_CREATION_OFFRE);
				}
				return imoResponse;
			}

			// Erreur lors de la création de l'offre
			FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.BAD_REQUEST.value(),
					ConstantesUtils.MESSAGE_ERREUR_CREATION_OFFRE, null);

			LOGGER.info("---------------- [creation offre] : " + ConstantesUtils.MESSAGE_ERREUR_CREATION_OFFRE);
		} catch (Exception ex) {
			FonctialiterCommunes.setImoResponse(imoResponse, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					ConstantesUtils.contrainteMessage(ex.getCause().getCause().getMessage()), null);
		}
		return imoResponse;
	}

	public ImoResponse<OffreSearchViewDto> getListOffres(TypeServiceOffre typesServices, String ville, String pays,
			String dateDebut, String dateFin, String categories) {

		List<OffreSearchViewDto> listOffreDto = new ArrayList<>();
		LocalDate fin = null;
		LocalDate debut = null;
		if (dateFin != null) {
			fin = LocalDate.parse(dateFin, formatter);
		}
		if (dateDebut != null) {
			debut = LocalDate.parse(dateDebut, formatter);
		}
		List<OffreSearchView> offreSearchView = iOffreSearchViewRepo.getOffres(typesServices, ville, pays, debut, fin,
				categories);
		listOffreDto = offreSearchView.stream().map(offreSearchViewMapper::asObjectDto).collect(Collectors.toList());
		ImoResponse<OffreSearchViewDto> imoResponse = new ImoResponse<>();
		FonctialiterCommunes.setImoResponse(imoResponse,
				listOffreDto.isEmpty() ? HttpStatus.NO_CONTENT.value() : HttpStatus.OK.value(),
				listOffreDto.isEmpty() ? ConstantesUtils.MESSAGE_EMPTY : null, listOffreDto);
		return imoResponse;
	}

	public ResponseEntity<?> isOffreByCodeOffre(String codeOffre) {
		Optional<OffreEntity> offreEntity = offreRepository.findByCodeOffre(codeOffre);
		return new ResponseEntity<>(offreEntity.isPresent() ? HttpStatus.OK : HttpStatus.NO_CONTENT);
	}

	private void createPaysAndVille(AdresseDto adresseDto) {

		List<VilleDto> listVilleDto = new ArrayList<>();
		PaysDto paysDto = new PaysDto();
		VilleDto villeDto = new VilleDto();
		paysDto.setNomPays(adresseDto.getPays());
		villeDto.setCodePostal(adresseDto.getCodePostal());
		villeDto.setNomVille(adresseDto.getVille());
		listVilleDto.add(villeDto);
		paysDto.setVilles(listVilleDto);
		PaysEntity entity = adresseMapper.asObjectEntity(paysDto);
		paysRepository.saveAndFlush(entity);
	}
	
	private void calculCodeOffre(OffreEntity entity) {
		entity.setCodeOffre(entity.getId()+entity.getTypeOffre().toString());
		entity.setCodeOffre(entity.getId()+entity.getTypeOffre().toString());
		offreRepository.saveAndFlush(entity);
	}
}
