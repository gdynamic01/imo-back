package com.test.offre;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.allObjects.IOffreGlobalTest;
import com.test.config.ConfigTestImo;

import imo.com.repo.utilisateur.RoleRepository;
import imo.com.repo.utilisateur.UserRepository;


public class OffreControllerTest extends ConfigTestImo implements IOffreGlobalTest {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepository;
	
	
	/**
	 * ######## Creation offre mobile ########
	 * @throws Exception
	 */
	@Test
	public void should_creation_offre_mobile_with_fields_required_missing_error() throws Exception {
		mockMvc.perform(post("/immo/creation-offre")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getJsonFromFile(path+"create-offres-mobile-errors.json"))
				).andExpect(status().isOk())
		.andExpect(jsonPath("$.champsObligatoires", hasSize(8)))
		.andExpect(jsonPath("$.champsObligatoires[5]").value("dateMiseEnCircualtion"))
		.andExpect(jsonPath("$.messageResponse").value("Votre annonce n'a pas pu être créer"))
		.andDo(print());	
	}
	
	@Test
	public void should_creation_offre_mobile_with_success() throws Exception {
		mockMvc.perform(post("/immo/creation-offre")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getJsonFromFile(path+"create-offres-mobile-success.json"))
				).andExpect(status().isOk())
		.andExpect(jsonPath("$.messageResponse").value("<h3>Confirmation</h3><h5>Votre offre a bien été enregistré</h5>"))
		.andDo(print());	
	}
	
	@Test
	public void should_creation_offre_immobilier_with_fields_required_missing_error() throws Exception {
		mockMvc.perform(post("/immo/creation-offre")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getJsonFromFile(path+"create-offres-immobilier-errors.json"))
				).andExpect(status().isOk())
		.andExpect(jsonPath("$.champsObligatoires", hasSize(10)))
		.andExpect(jsonPath("$.messageResponse").value("Votre annonce n'a pas pu être créer"))
		.andDo(print());	
	}
	
	@Test
	public void should_creation_offre_immobilier_with_success() throws Exception {
		mockMvc.perform(post("/immo/creation-offre")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getJsonFromFile(path+"create-offres-immobilier-success.json"))
				).andExpect(status().isOk())
		.andExpect(jsonPath("$.messageResponse").value("<h3>Confirmation</h3><h5>Votre offre a bien été enregistré</h5>"))
		.andDo(print());	
	}
	
	/**
	 * ############## Erreur creation offre #################
	 * @throws Exception
	 */
	@Test
	public void should_creationOffre_mobile_without_notMobile_and_notImmo_error() throws Exception {
		mockMvc.perform(post("/immo/creation-offre")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content("{}")
				).andExpect(status().isOk())
		.andExpect(jsonPath("$.messageResponse").value("Votre annonce n'a pas pu être créer"))
		.andDo(print());	
	}
	
	@Test
	public void should_creation_tout_offre_with_email_notFound_error() throws Exception {
		mockMvc.perform(post("/immo/creation-offre")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getJsonFromFile(path+"create-offres-mobile-notFound-email.json"))
				).andExpect(status().isOk())
		.andExpect(jsonPath("$.messageResponse").value("Le formulaire contient des erreurs, veuillez contacter le service loumo@contact.fr"))
		.andDo(print());	
	}
	
	@Before
	public void initDataOffreMobileAndImmobilier() throws JsonProcessingException {
		creationParticulier(userRepo, roleRepository);
		creationProfessionnel(userRepo, roleRepository);
	}
	
}
