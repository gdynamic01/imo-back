package com.test.utilisateur;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.test.config.ConfigTestImo;

import imo.com.logic.utilisateur.IUser;
import imo.com.logic.utilisateur.dto.RepresentantLegalDto;
import imo.com.logic.utilisateur.dto.UserMoralDto;
import imo.com.logic.utilisateur.dto.UserPhysiqueDto;
import imo.com.model.enums.TypeUtilisateurEnum;
import imo.com.model.utilisateur.AppUser;
import imo.com.model.utilisateur.RoleUserEnum;
import imo.com.model.utilisateur.SexeEnum;
import imo.com.model.utilisateur.UserPhysiqueEntity;
import imo.com.repo.utilisateur.UserRepository;
import imo.com.response.ImoResponse;

/**
 * @author balde
 *
 */
public class UserImplTest extends ConfigTestImo {

	private UserMoralDto userMoralDto = new UserMoralDto();

	private UserPhysiqueDto userPhysiqueDto = new UserPhysiqueDto();

	RepresentantLegalDto repr;

	@Autowired
	private IUser iUser;

	List<RoleUserEnum> roles;
	
	private static final String emailParticulier = "particulier@yahoo.fr";
	
	private static final String emailProfessionnel = "professionel@yahoo.fr";
	
	@MockBean
	private UserRepository userRepo;

	@Test
	public void registrationProfessionnelTest() {

		ImoResponse<UserMoralDto> response1, response2, response5;

		// 1-- Cas erreur [champs obligatoires n'ont renseigné]
		response1 = this.iUser.registration(userMoralDto);

		// 2-- Cas sans erreur
		userMoralDto.setTypeUtilisateur(TypeUtilisateurEnum.ENTREPRISE);
		response2 = this.iUser.registration(userMoralDto);

		// 3-- Cas erreur [email existant]
		response5 = this.iUser.registration(userMoralDto);

		assertNotNull(response1);
		assertTrue(response1.getStatut() == 400);
		assertNotNull(response5);
		assertTrue(response5.getStatut() == 500);
		assertNotNull(response2);
		assertTrue(response2.getStatut() == 200);
	}

	@Test
	public void registrationParticulierTest() {

		ImoResponse<UserPhysiqueDto> response3, response4, response6;

		// 1-- Cas erreur [champs obligatoires n'ont renseigné]
		response3 = this.iUser.registration(userPhysiqueDto);

		// 2-- Cas sans erreur
		userPhysiqueDto.setEmail(emailParticulier);
		response4 = this.iUser.registration(userPhysiqueDto);

		// 3-- Cas erreur [email existant]
		response6 = this.iUser.registration(userPhysiqueDto);

		assertNotNull(response3);
		assertTrue(response3.getStatut() == 400);
		assertNotNull(response6);
		assertTrue(response6.getStatut() == 500);
		assertNotNull(response4);
		assertTrue(response4.getStatut() == 200);
	}
	
	@Test
	public void getEmailNotFoundTest() {
		ImoResponse<String> response;
		response = iUser.getEmail("m@yahoo.fr");
		assertTrue(response.getResult().isEmpty());
		assertEquals(204, response.getStatut());
	}
	
	@Test 
	public void getEmailSuccessTest() {
		ImoResponse<String> response;
		response = iUser.getEmail(emailParticulier);
		assertNotNull(response.getResult());
		assertEquals(emailParticulier, response.getResult().get(0));
	}

	@Before
	public void initData() {

		// Init Professionnel
		roles = new ArrayList<RoleUserEnum>();
		repr = new RepresentantLegalDto();
		repr.setNom("BALDE");
		repr.setPrenom("Mamadou");
		repr.setSexe(SexeEnum.M);
		userMoralDto.setEmail(emailProfessionnel);
		userMoralDto.setRepresentantLegal(repr);
		userMoralDto.setPassword("testtest");
		userMoralDto.setSiret("215468L");
		roles.add(RoleUserEnum.USER_MORAL);
		userMoralDto.setRoles(roles);

		// Init Particulier
		roles = new ArrayList<RoleUserEnum>();
		repr = new RepresentantLegalDto();
		repr.setNom("BAH");
		repr.setPrenom("Mata");
		repr.setSexe(SexeEnum.F);
		userPhysiqueDto.setRepresentantLegal(repr);
		userPhysiqueDto.setPassword("testtest");
		roles.add(RoleUserEnum.USER_PHYSIQUE);
		userPhysiqueDto.setTypeUtilisateur(TypeUtilisateurEnum.PARTICULIER);
		userPhysiqueDto.setRoles(roles);
		
		AppUser appUser = new UserPhysiqueEntity();
		appUser.setEmail(emailParticulier);
		appUser.setId(1L);
		
		when(userRepo.findByEmail(emailParticulier)).thenReturn(appUser);
		
	}

}
