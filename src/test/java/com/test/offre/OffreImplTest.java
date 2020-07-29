/**
 * 
 */
package com.test.offre;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.allObjects.IOffreGlobalTest;
import com.test.config.ConfigTestImo;

import imo.com.general.ConstantesUtils;
import imo.com.logic.offre.IOffre;
import imo.com.logic.offre.dto.ImmobilierDto;
import imo.com.logic.offre.dto.MobileDto;
import imo.com.logic.offre.dto.OffreGlobalDto;
import imo.com.logic.utilisateur.dto.AdresseDto;
import imo.com.model.utilisateur.UserPhysiqueEntity;
import imo.com.repo.utilisateur.RoleRepository;
import imo.com.repo.utilisateur.UserRepository;
import imo.com.response.ImoResponse;

/**
 * @author balde
 *
 */
public class OffreImplTest extends ConfigTestImo implements IOffreGlobalTest {

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
		offreGlobalDto = new OffreGlobalDto();

		mobileDto = new MobileDto();
		immobilierDto = new ImmobilierDto();

		particulier = creationParticulier(userRepo, roleRepository);
		offreGlobalDto.setEmail(this.particulier.getEmail());
	}

	@Test
	public void shouldCreationOffreWithMobileSansErreur() {
		
		createOffre(mobileDto);
		this.offreGlobalDto.setMobile(mobileDto);

		ImoResponse<OffreGlobalDto> response = this.iOffre.creationOffre(this.offreGlobalDto);

		assertNull(response.getChampsObligatoires());
		assertEquals(200, response.getStatut());

	}

	@Test
	public void shouldCreationOffreWithImmobilierSansErreur() {
		
		createOffre(immobilierDto);
		offreGlobalDto.setImmobilier(immobilierDto);

		ImoResponse<OffreGlobalDto> response = iOffre.creationOffre(offreGlobalDto);

		assertNull(response.getChampsObligatoires());
		assertEquals(200, response.getStatut());

	}

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
		dto.setPays("");

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
}
