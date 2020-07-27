package com.test.allObjects;

import java.time.LocalDate;
import imo.com.logic.offre.dto.ImmobilierDto;
import imo.com.logic.offre.dto.MobileDto;
import imo.com.logic.offre.dto.OffreDto;
import imo.com.logic.utilisateur.dto.AdresseDto;
import imo.com.model.enums.SanitaireEnum;
import imo.com.model.enums.TypeBienImmobilierEnum;
import imo.com.model.enums.TypeMobileMoteurEnum;
import imo.com.model.enums.TypeOffreEnum;
import imo.com.model.enums.TypeServiceOffre;

public interface IOffreGlobalTest extends IUtilisateursTest {

	MobileDto mobileDto = new MobileDto();

	ImmobilierDto immobilierDto = new ImmobilierDto();

	default void createOffre(OffreDto offreDto) {

		offreDto.setDescription("Description 1");
		offreDto.setTitre("Titre1");

		AdresseDto adresse = new AdresseDto();
		createAdresse(adresse);
		offreDto.setAdresse(adresse);

		offreDto.setTypeServiceOffre(TypeServiceOffre.VENTE);

		// Offre Mobile
		if (offreDto instanceof MobileDto) {
			offreDto.setTypeOffre(TypeOffreEnum.MOBILE);
			((MobileDto) offreDto).setTypeMobileMoteur(TypeMobileMoteurEnum.SANS_MOTEUR);
			((MobileDto) offreDto).setModel("model 1");
		}

		// Offre Immobilier
		if (offreDto instanceof ImmobilierDto) {
			offreDto.setTypeOffre(TypeOffreEnum.IMMOBILIER);
			((ImmobilierDto) offreDto).setSurface(9.0);
			((ImmobilierDto) offreDto).setPrix(700.5);
			((ImmobilierDto) offreDto).setDateDebut(LocalDate.now());
			((ImmobilierDto) offreDto).setDateFin(LocalDate.now());
			((ImmobilierDto) offreDto).setNbrePieces(2);
			((ImmobilierDto) offreDto).setTypeDeBien(TypeBienImmobilierEnum.APPARTEMENT);
			((ImmobilierDto) offreDto).setSanitaire(SanitaireEnum.EXTERIEUR);
			((ImmobilierDto) offreDto).setParking(true);
			((ImmobilierDto) offreDto).setElectricite(true);
			((ImmobilierDto) offreDto).setEau(true);
		}
	}

	// creation adresse
	default void createAdresse(AdresseDto dto) {
		dto.setPays("Guinee");
		dto.setVille("Conakry");
	}
	
}
