/**
 * 
 */
package com.test.offre;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.config.ConfigTestImo;

import imo.com.general.ConstantesUtils;
import imo.com.logic.offre.IOffre;
import imo.com.logic.offre.dto.ImmobilierDto;
import imo.com.logic.offre.dto.MobileDto;
import imo.com.logic.offre.dto.OffreDto;
import imo.com.logic.offre.dto.OffreGlobalDto;
import imo.com.logic.utilisateur.dto.AdresseDto;
import imo.com.model.enums.SanitaireEnum;
import imo.com.model.enums.TypeBienImmobilierEnum;
import imo.com.model.enums.TypeMobileMoteurEnum;
import imo.com.model.enums.TypeOffreEnum;
import imo.com.model.enums.TypeServiceOffre;
import imo.com.model.enums.TypeUtilisateurEnum;
import imo.com.model.info.RepresentantLegal;
import imo.com.model.utilisateur.Role;
import imo.com.model.utilisateur.RoleUserEnum;
import imo.com.model.utilisateur.SexeEnum;
import imo.com.model.utilisateur.UserPhysiqueEntity;
import imo.com.repo.utilisateur.RoleRepository;
import imo.com.repo.utilisateur.UserRepository;
import imo.com.response.ImoResponse;

/**
 * @author balde
 *
 */
public class OffreImplTest extends ConfigTestImo {

	@Autowired
	private IOffre iOffre;

	private MobileDto mobileDto;

	private ImmobilierDto immobilierDto;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepository;

	private UserPhysiqueEntity particulier;

	private OffreGlobalDto offreGlobalDto;

	@Before
	public void initDataOffreMobileAndImmobilier() {
		this.offreGlobalDto = new OffreGlobalDto();

		this.mobileDto = new MobileDto();
		this.immobilierDto = new ImmobilierDto();

		createOffre(this.mobileDto);
		createOffre(this.immobilierDto);

		this.offreGlobalDto.setMobile(this.mobileDto);
		this.offreGlobalDto.setImmobilier(immobilierDto);

		this.particulier = creationParticulier();
		this.offreGlobalDto.setEmail(this.particulier.getEmail());
	}

	@Test
	public void shouldCreationOffreWithMobileSansErreur() {

		ImoResponse<OffreGlobalDto> response = this.iOffre.creationOffre(this.offreGlobalDto);

		assertNull(response.getChampsObligatoires());
		assertEquals(200, response.getStatut());

	}

//	@Test
//	public void shouldCreationOffreWithImmobilierSansErreur() {
//
//		ImoResponse<OffreGlobalDto> response = this.iOffre.creationOffre(this.offreGlobalDto);
//
//		assertNull(response.getChampsObligatoires());
//		assertEquals(200, response.getStatut());
//
//	}

	@Test
	public void shouldCreationOffreDeMobileAvecAdresseErreur() {

		OffreGlobalDto offreGlobalDto = new OffreGlobalDto();
		MobileDto mobileDto = new MobileDto();

		offreGlobalDto.setMobile(mobileDto);

		ImoResponse<OffreGlobalDto> response = this.iOffre.creationOffre(offreGlobalDto);

		assertEquals(ConstantesUtils.MESSAGE_ERREUR_CREATION_OFFRE, response.getMessageResponse());
		assertNotNull(response.getChampsObligatoires());
	}

	@Test
	public void shouldCreationOffreDeMobileAvecAdresseErreurbis() {

		OffreGlobalDto offreGlobalDto = new OffreGlobalDto();
		MobileDto mobileDto = new MobileDto();

		offreGlobalDto.setMobile(mobileDto);

		// check adresse
		AdresseDto dto = new AdresseDto();
		dto.setPays("France");

		offreGlobalDto.getMobile().setAdresse(dto);

		ImoResponse<OffreGlobalDto> response = this.iOffre.creationOffre(offreGlobalDto);

		assertEquals(ConstantesUtils.MESSAGE_ERREUR_CREATION_OFFRE, response.getMessageResponse());
		assertNotNull(response.getChampsObligatoires());

	}

	// ========= EN COUR DE DEV
	@Test
	public void shouldCreationOffreImmobilierAvecAdresseErreurbis() {

		OffreGlobalDto offreGlobalDto = new OffreGlobalDto();
		ImmobilierDto immoDto = new ImmobilierDto();

		offreGlobalDto.setImmobilier(immoDto);

		// check adresse
		AdresseDto dto = new AdresseDto();
		dto.setPays("France");

		immoDto.setSurface(8.5);

		offreGlobalDto.getImmobilier().setAdresse(dto);

		ImoResponse<OffreGlobalDto> response = this.iOffre.creationOffre(offreGlobalDto);

		assertEquals(ConstantesUtils.MESSAGE_ERREUR_CREATION_OFFRE, response.getMessageResponse());
		assertNotNull(response.getChampsObligatoires());

	}

	@Test
	public void shouldCreationOffreDeMobileEtImmoAvecErreur() {

		offreGlobalDto = new OffreGlobalDto();

		ImoResponse<OffreGlobalDto> response = this.iOffre.creationOffre(offreGlobalDto);
		assertEquals(ConstantesUtils.MESSAGE_ERREUR_CREATION_OFFRE, response.getMessageResponse());
	}

	// Creation sans erreur
	public void createOffre(OffreDto offreDto) {

		offreDto.setDescription("Description 1");
		offreDto.setTitre("Titre1");

		AdresseDto adresse = new AdresseDto();
		createAdresse(adresse);
		offreDto.setAdresse(adresse);

		offreDto.setTypeServiceOffre(TypeServiceOffre.VENTE);

		// Offre Mobile
		if (offreDto instanceof MobileDto) {
			offreDto.setTypeOffre(TypeOffreEnum.MOTO);
			((MobileDto) offreDto).setDateMiseEnCircualtion(LocalDate.now());
			((MobileDto) offreDto).setTypeMobileMoteur(TypeMobileMoteurEnum.SANS_MOTEUR);
			((MobileDto) offreDto).setModel("model 1");
		}

		// Offre Immobilier
		if (offreDto instanceof ImmobilierDto) {
			offreDto.setTypeOffre(TypeOffreEnum.APPARTEMENT);
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
	public void createAdresse(AdresseDto dto) {
		dto.setPays("Guinée");
		dto.setVille("Conakry");
	}

	/**
	 * creation particulier
	 * @return entity
	 */
	public UserPhysiqueEntity creationParticulier() {

		UserPhysiqueEntity user = new UserPhysiqueEntity();
		RepresentantLegal repr = new RepresentantLegal();
		List<RoleUserEnum> roles = new ArrayList<>();
		List<Role> role = new ArrayList<>();
		repr.setNom("BAH");
		repr.setPrenom("Mata");
		repr.setSexe(SexeEnum.F);
		user.setRepresentantLegal(repr);
		user.setEmail("test2@yahoo.fr");
		user.setEnabled(true);
		user.setPassword("testtest");
		roles.add(RoleUserEnum.USER_PHYSIQUE);
		role = roleRepository.findByRoleEnumIn(roles);
		user.setTypeUtilisateur(TypeUtilisateurEnum.PARTICULIER);
		user.setRoles(role);

		return userRepo.save(user);
	}

}
