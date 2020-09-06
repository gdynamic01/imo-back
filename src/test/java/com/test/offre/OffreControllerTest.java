package com.test.offre;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.allObjects.IGeneralTest;
import com.test.config.ConfigTestImo;
import com.test.config.WithMockAdminUser;

import imo.com.model.offre.OffreEntity;
import imo.com.repo.offre.OffreRepository;
import imo.com.repo.utilisateur.RoleRepository;
import imo.com.repo.utilisateur.UserRepository;

public class OffreControllerTest extends ConfigTestImo implements IGeneralTest {

	private final String uri = "/loumos";

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepository;

	@MockBean
	private OffreRepository offreRepo;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPassword;

	private List<OffreEntity> offreEntities = new ArrayList<>();

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@WithMockAdminUser
	public void should_creation_offre_mobile_with_fields_required_missing_error() throws Exception {
		mockMvc.perform(post(uri+"/offre").accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getJsonFromFile(pathOffres + "create-offres-mobile-errors.json"))).andExpect(status().isOk())
				.andExpect(jsonPath("$.champsObligatoires", hasSize(8)))
				.andExpect(jsonPath("$.champsObligatoires[5]").value("dateMiseEnCircualtion"))
				.andExpect(jsonPath("$.messageResponse").value("Votre annonce n'a pas pu être créer")).andDo(print());
	}

	@Test
	@WithMockAdminUser
	public void should_creation_offre_mobile_with_success() throws Exception {
		mockMvc.perform(post(uri+"/offre").accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getJsonFromFile(pathOffres + "create-offres-mobile-success.json"))).andExpect(status().isOk())
				.andExpect(jsonPath("$.messageResponse")
						.value("<h3>Confirmation</h3><h5>Votre offre a bien été enregistré</h5>"))
				.andDo(print());
	}

	@Test
	@WithMockAdminUser
	public void should_creation_offre_immobilier_with_fields_required_missing_error() throws Exception {
		mockMvc.perform(post(uri+"/offre").accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getJsonFromFile(pathOffres + "create-offres-immobilier-errors.json"))).andExpect(status().isOk())
				.andExpect(jsonPath("$.champsObligatoires", hasSize(15)))
				.andExpect(jsonPath("$.messageResponse").value("Votre annonce n'a pas pu être créer")).andDo(print());
	}

	@Test
	@WithMockAdminUser
	public void should_creation_offre_immobilier_with_success() throws Exception {
		mockMvc.perform(post(uri+"/offre").accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getJsonFromFile(pathOffres + "create-offres-immobilier-success.json"))).andExpect(status().isOk())
				.andExpect(jsonPath("$.messageResponse")
						.value("<h3>Confirmation</h3><h5>Votre offre a bien été enregistré</h5>"))
				.andDo(print());
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@WithMockAdminUser
	public void should_creationOffre_mobile_without_notMobile_and_notImmo_error() throws Exception {
		mockMvc.perform(post(uri+"/offre").accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content("{}")).andExpect(status().isOk())
				.andExpect(jsonPath("$.messageResponse").value("Votre annonce n'a pas pu être créer")).andDo(print());
	}

	@Test
	@WithMockAdminUser
	public void should_creation_tout_offre_with_email_notFound_error() throws Exception {
		mockMvc.perform(post(uri+"/offre").accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getJsonFromFile(pathOffres + "create-offres-mobile-notFound-email.json"))).andExpect(status().isOk())
				.andExpect(jsonPath("$.messageResponse")
						.value("Le formulaire contient des erreurs, veuillez contacter le service loumo@contact.fr"))
				.andDo(print());
	}

	@Test
	public void sould_get_all_offres() throws Exception {

		when(offreRepo.findAll()).thenReturn(offreEntities);
		mockMvc.perform(get(uri+"/offres").accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$.result", hasSize(2)))
				.andExpect(jsonPath("$.result.[0].titre").value("immo 1"))
				.andExpect(jsonPath("$.result.[1].titre").value("mobile 1"))
				.andExpect(jsonPath("$.nbOffreParticulier").value(1))
				.andExpect(jsonPath("$.nbOffreProfessionnel").value(1))
				.andExpect(jsonPath("$.nbOffre").value(2))
				.andDo(print());
	}

	@Before
	public void initDataOffreMobileAndImmobilier() throws JsonProcessingException {
		creationParticulier(userRepo, roleRepository, bcryptPassword);
		creationProfessionnel(userRepo, roleRepository, bcryptPassword);
		offreEntities.add(creationImmobilier(userRepo));
		offreEntities.add(creationMobile(userRepo));
	}

}
