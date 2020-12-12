package com.test.offre;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.hasSize;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.test.allObjects.IGeneralTest;
import com.test.config.ConfigTestImo;
import com.test.config.WithMockAdminUser;

import imo.com.model.enums.TypeServiceOffre;
import imo.com.repo.offre.OffreRepository;
import imo.com.repo.utilisateur.RoleRepository;
import imo.com.repo.utilisateur.UserRepository;

public class OffreControllerTest extends ConfigTestImo implements IGeneralTest {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPassword;
	
	@Autowired
	private OffreRepository offreRepository;

	/**
	 * @throws Exception
	 */
	@Test
	@WithMockAdminUser
	public void should_creation_offre_mobile_with_fields_required_missing_error() throws Exception {
		mockMvc.perform(post(uri + "/offre").accept(mediaAccept).contentType(ContentType)
				.content(getJsonFromFile(pathOffres + "create-offres-mobile-errors.json")))
				.andExpect(status().isBadRequest()).andExpect(jsonPath("$.champsObligatoires", hasSize(8)))
				.andExpect(jsonPath("$.champsObligatoires[5]").value("dateMiseEnCircualtion"))
				.andExpect(jsonPath("$.messageResponse").value("Votre annonce n'a pas pu être créer")).andDo(print());
	}

	@Test
	@WithMockAdminUser
	public void should_creation_offre_mobile_with_success() throws Exception {
		mockMvc.perform(post(uri + "/offre").accept(mediaAccept).contentType(ContentType)
				.content(getJsonFromFile(pathOffres + "create-offres-mobile-success.json"))).andExpect(status().isOk())
				.andExpect(jsonPath("$.messageResponse")
						.value("<h3>Confirmation</h3><h5>Votre offre a bien été créé</h5>"))
				.andDo(print());
	}

	@Test
	@WithMockAdminUser
	public void should_creation_offre_immobilier_with_fields_required_missing_error() throws Exception {
		mockMvc.perform(post(uri + "/offre").accept(mediaAccept).contentType(ContentType)
				.content(getJsonFromFile(pathOffres + "create-offres-immobilier-errors.json")))
				.andExpect(status().isBadRequest()).andExpect(jsonPath("$.champsObligatoires", hasSize(14)))
				.andExpect(jsonPath("$.messageResponse").value("Votre annonce n'a pas pu être créer")).andDo(print());
	}

	@Test
	@WithMockAdminUser
	public void should_creation_offre_immobilier_with_success() throws Exception {
		mockMvc.perform(post(uri + "/offre").accept(mediaAccept).contentType(ContentType)
				.content(getJsonFromFile(pathOffres + "create-offres-immobilier-success.json")))
				.andExpect(status().isOk()).andExpect(jsonPath("$.messageResponse")
						.value("<h3>Confirmation</h3><h5>Votre offre a bien été créé</h5>"))
				.andDo(print());
	}

	/**
	 * @throws Exception
	 */
	@Test
	@WithMockAdminUser
	public void should_creationOffre_mobile_without_notMobile_and_notImmo_error() throws Exception {
		mockMvc.perform(post(uri + "/offre").accept(mediaAccept).contentType(ContentType).content("{}"))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.messageResponse").value("Votre annonce n'a pas pu être créer")).andDo(print());
	}

	@Test
	@WithMockAdminUser
	public void should_creation_tout_offre_with_email_notFound_error() throws Exception {
		mockMvc.perform(post(uri + "/offre").accept(mediaAccept).contentType(ContentType)
				.content(getJsonFromFile(pathOffres + "create-offres-mobile-notFound-email.json")))
				.andExpect(status().is5xxServerError())
				.andExpect(jsonPath("$.messageResponse")
						.value("Le formulaire contient des erreurs, veuillez contacter le service loumo@contact.fr"))
				.andDo(print());
	}

	@Test
	public void should_get_all_offres_noContent() throws Exception {

		String categories = "APPARTEMENT_VOITURE";

		mockMvc.perform(get(uri + "/offres").queryParam("typesServices", TypeServiceOffre.VENTE.toString())
				.queryParam("ville", "FakeVille").queryParam("pays", "FakePays").queryParam("dateDebut", "2019-05-01")
				.queryParam("dateFin", "2019-09-01").queryParam("categories", categories).accept(mediaAccept)
				.contentType(ContentType)).andExpect(status().isNoContent()).andDo(print());
	}

	@Test
	public void should_isOffreByCodeOffre_success() throws Exception {
		mockMvc.perform(get(uri + "/200IMMOBILIER/offre").accept(mediaAccept).contentType(ContentType))
				.andExpect(status().isOk()).andDo(print());

	}

	@Test
	public void should_isOffreByCodeOffre_NoContent() throws Exception {
		mockMvc.perform(get(uri + "/23456/offre").accept(mediaAccept).contentType(ContentType))
				.andExpect(status().isNoContent()).andDo(print());

	}

	@Before
	public void initDatas() {
		userRepo.deleteAll();
		creationParticulier(userRepo, roleRepository, bcryptPassword);
		creationProfessionnel(userRepo, roleRepository, bcryptPassword);
		creationImmobilier(userRepo, offreRepository);
	}

}
