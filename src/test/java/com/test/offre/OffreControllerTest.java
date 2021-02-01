package com.test.offre;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.test.allObjects.IGeneralTest;
import com.test.config.ConfigTestImo;
import com.test.config.WithMockAdminUser;

import imo.com.model.enums.TypeOffreEnum;
import imo.com.model.enums.TypeServiceOffre;
import imo.com.model.view.OffreSearchView;
import imo.com.repo.offre.OffreRepository;
import imo.com.repo.utilisateur.RoleRepository;
import imo.com.repo.utilisateur.UserRepository;
import imo.com.repo.view.offre.IOffreSearchViewRepositoryCustom;

public class OffreControllerTest extends ConfigTestImo implements IGeneralTest {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPassword;
	
	@Autowired
	private OffreRepository offreRepository;
	
	@MockBean
	private IOffreSearchViewRepositoryCustom iOffreSearchViewRepository;

	private List<OffreSearchView> offreSearchViews = new ArrayList<>();

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
				.queryParam("ville", "FakeVille").queryParam("pays", "FakePays").queryParam("dateDebut", "2019-05-01 02:30")
				.queryParam("dateFin", "2019-09-01 02:30").queryParam("categories", categories).accept(mediaAccept)
				.contentType(ContentType)).andExpect(jsonPath("$.status").value(204)).andDo(print());
	}

	@Test
	public void should_isOffreByCodeOffre_success() throws Exception {
		mockMvc.perform(get(uri + "/200IMMOBILIER/offre").accept(mediaAccept).contentType(ContentType))
				.andExpect(status().isOk()).andDo(print());

	}

	@Test
	public void should_isOffreByCodeOffre_NoContent() throws Exception {
		mockMvc.perform(get(uri + "/23456/offre").accept(mediaAccept).contentType(ContentType))
				.andExpect(status().isNotFound()).andDo(print());

	}
	
	@Test
	public void should_get_all_offres() throws Exception {

		initDataOffreSearchView();
		when(iOffreSearchViewRepository.getOffres(TypeServiceOffre.LOCATION, null, null, null, null, null))
				.thenReturn(offreSearchViews);
		mockMvc.perform(get(uri + "/offres").queryParam("typesServices", TypeServiceOffre.LOCATION.toString())
				.accept(mediaAccept).contentType(ContentType)).andExpect(status().isOk())
				.andExpect(jsonPath("$.result", hasSize(1)))
				.andExpect(jsonPath("$.result.[0].titre").value("FakeOffre"))
				.andExpect(jsonPath("$.result.[0].typeServiceOffre").value("LOCATION")).andDo(print());
	}
	
	private void initDataOffreSearchView() {
		OffreSearchView offreSearchView = new OffreSearchView();
		offreSearchView.setId(1L);
		offreSearchView.setTitre("FakeOffre");
		offreSearchView.setTypeOffre(TypeOffreEnum.IMMOBILIER);
		offreSearchView.setTypeServiceOffre(TypeServiceOffre.LOCATION);
		offreSearchView.setTypeDebienImmobilier("APPARTEMENT");
		offreSearchView.setUsersId(1L);
		offreSearchView.setCreateAt(LocalDateTime.parse("2020-12-25T05:14"));

		offreSearchViews.add(offreSearchView);
	}

	@Before
	public void initDatas() {
		creationParticulier(userRepo, roleRepository, bcryptPassword);
		creationProfessionnel(userRepo, roleRepository, bcryptPassword);
		creationImmobilier(userRepo, offreRepository);
	}

}
