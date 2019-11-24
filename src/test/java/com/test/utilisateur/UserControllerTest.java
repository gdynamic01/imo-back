package com.test.utilisateur;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.config.ConfigTestImo;

import imo.com.logic.utilisateur.IUser;
import imo.com.logic.utilisateur.dto.RepresentantLegalDto;
import imo.com.logic.utilisateur.dto.UserDto;
import imo.com.logic.utilisateur.dto.UserMoralDto;
import imo.com.model.typeutilisateur.TypeUtilisateurEnum;
import imo.com.model.utilisateur.RoleUserEnum;
import imo.com.model.utilisateur.SexeEnum;
import imo.com.response.ImoResponse;

/**
 * @author balde
 *
 */

public class UserControllerTest extends ConfigTestImo {

	private UserMoralDto userMoralDto = new UserMoralDto();

	private UserDto userDto = new UserDto();

	RepresentantLegalDto repr;

	@Autowired
	private IUser iUser;

	List<RoleUserEnum> roles;

	@Test
	public void userControllerTest() {
	}

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

		ImoResponse<UserDto> response3, response4, response6;

		// 1-- Cas erreur [champs obligatoires n'ont renseigné]
		response3 = this.iUser.registration(userDto);

		// 2-- Cas sans erreur
		userDto.setEmail("test@yahoo.fr");
		response4 = this.iUser.registration(userDto);

		// 3-- Cas erreur [email existant]
		response6 = this.iUser.registration(userDto);

		assertNotNull(response3);
		assertTrue(response3.getStatut() == 400);
		assertNotNull(response6);
		assertTrue(response6.getStatut() == 500);
		assertNotNull(response4);
		assertTrue(response4.getStatut() == 200);
	}

	@Before
	public void initData() {

		// Init Professionnel
		roles = new ArrayList<RoleUserEnum>();
		repr = new RepresentantLegalDto();
		repr.setNom("BALDE");
		repr.setPrenom("Mamadou");
		repr.setSexe(SexeEnum.M);
		userMoralDto.setEmail("test20@yahoo.fr");
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
		userDto.setRepresentantLegal(repr);
		userDto.setPassword("testtest");
		roles.add(RoleUserEnum.USER_PHYSIQUE);
		userDto.setTypeUtilisateur(TypeUtilisateurEnum.PARTICULIER);
		userDto.setRoles(roles);
	}

}
