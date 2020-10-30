/**
 * 
 */
package com.test.utilisateur;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
import imo.com.repo.utilisateur.RoleRepository;
import imo.com.repo.utilisateur.UserRepository;
import imo.com.repo.view.offre.IOffreSearchViewRepositoryCustom;

/**
 * @author mbalde
 */
public class UserControllerTest extends ConfigTestImo implements IGeneralTest {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPassword;
	
	@MockBean
	private IOffreSearchViewRepositoryCustom iOffreSearchViewRepository;

	private List<OffreSearchView> offreSearchViews = new ArrayList<>();

	@Test
	public void should_creation_user_with_field_mandatory_error() throws Exception {

		// --- user professionnel
		mockMvc.perform(post(uri + "/professionnel").accept(mediaAccept)
				.contentType(ContentType)
				.content(getJsonFromFile(pathUsers + "creation-user-error.json"))).andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.champsObligatoires", hasSize(10)))
				.andExpect(jsonPath("$.champsObligatoires[0]").value("numero"))
				.andExpect(jsonPath("$.messageResponse")
						.value("Le formulaire contient des erreurs, veuillez contacter le service loumo@contact.fr"))
				.andDo(print());

		// --- user particulier
		mockMvc.perform(post(uri + "/particulier").accept(mediaAccept)
				.contentType(ContentType)
				.content(getJsonFromFile(pathUsers + "creation-user-error.json"))).andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.champsObligatoires", hasSize(8)))
				.andExpect(jsonPath("$.champsObligatoires[0]").value("nom"))
				.andExpect(jsonPath("$.messageResponse")
						.value("Le formulaire contient des erreurs, veuillez contacter le service loumo@contact.fr"))
				.andDo(print());
	}

	@Test
	public void should_creation_professionnel_with_email_exist_error() throws Exception {
		mockMvc.perform(post(uri + "/professionnel").accept(mediaAccept)
				.contentType(ContentType)
				.content(getJsonFromFile(pathUsers + "creation-professionnel-email-exists.json")))
				.andExpect(status().isInternalServerError())
				.andExpect(jsonPath("$.messageResponse").value("Cet email existe dejà veuillez vous connecter"))
				.andDo(print());
	}

	@Test
	public void should_creation_particulier_with_email_exists_error() throws Exception {
		mockMvc.perform(post(uri + "/particulier").accept(mediaAccept)
				.contentType(ContentType)
				.content(getJsonFromFile(pathUsers+ "creation-particulier-email-exists.json")))
				.andExpect(status().isInternalServerError())
				.andExpect(jsonPath("$.messageResponse").value("Cet email existe dejà veuillez vous connecter"))
				.andDo(print());
	}

	@Test
	public void should_creation_professionnel_with_success() throws Exception {
		mockMvc.perform(post(uri + "/professionnel").accept(mediaAccept)
				.contentType(ContentType)
				.content(getJsonFromFile(pathUsers + "creation-professionnel-success.json")))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.messageResponse").value(
						"<h6>ACTIVATION COMPTE</h6> <p><span>Votre compte a été créé avec succès!</span></p><p><strong>veuillez cliquer sur le lien figurant dans l’email de confirmation que nous venons de vous envoyer.</strong></p>"))
				.andDo(print());
	}
	
	@Test
	public void should_creation_particulier_with_success() throws Exception {
		mockMvc.perform(post(uri + "/particulier").accept(mediaAccept)
				.contentType(ContentType)
				.content(getJsonFromFile(pathUsers + "creation-particulier-success.json")))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.messageResponse").value(
						"<h6>ACTIVATION COMPTE</h6> <p><span>Votre compte a été créé avec succès!</span></p><p><strong>veuillez cliquer sur le lien figurant dans l’email de confirmation que nous venons de vous envoyer.</strong></p>"))
				.andDo(print());
	}
	
	@Test
	public void should_get_email_with_not_exist() throws Exception {
		mockMvc.perform(get(uri + "/email/fakeemailnotfound@yahoo.fr")
				.accept(mediaAccept)
				.contentType(ContentType)
				).andExpect(status().isNoContent())
		.andDo(print());
	}
	
	@Test
	public void should_get_email_with_success() throws Exception {
		mockMvc.perform(get(uri + "/email/professionel@yahoo.fr")
				.accept(mediaAccept)
				.contentType(ContentType)
				).andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void should_authentification_with_success() throws Exception {
		mockMvc.perform(get(uri + "/authentification/"+emailParticulier+"/testtest")
				.accept(mediaAccept)
				.contentType(ContentType)
				).andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void should_authentification_with_user_isNotActif_401() throws Exception {
		mockMvc.perform(get(uri + "/authentification/"+emailParticulierNonActif+"/testtest")
				.accept(mediaAccept)
				.contentType(ContentType)
				).andExpect(status().isUnauthorized())
		.andDo(print());
	}
	
	@Test
	public void should_authentification_with_badCredentials_401() throws Exception {
		mockMvc.perform(get(uri + "/authentification/"+emailBadCredential+"/badCredential")
				.accept(mediaAccept)
				.contentType(ContentType)
				).andExpect(status().isUnauthorized())
		.andDo(print());
	}
	
	@Test
	@WithMockAdminUser
	public void should_get_roles_by_success() throws Exception {
		mockMvc.perform(get(uri + "/roles/professionel@yahoo.fr")
				.accept(mediaAccept)
				.contentType(ContentType)
				).andExpect(status().isOk())
		.andExpect(jsonPath("$.result").value("ROLE_USER_MORAL"))
		.andDo(print());
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

	@Before
	public void initData() {
		creationProfessionnel(userRepo, roleRepository, bcryptPassword);
		creationParticulier(userRepo, roleRepository, bcryptPassword);
		creationParticulierNonActif(userRepo, roleRepository, bcryptPassword);
		creationParticulierAvecMotDePasseNonCrypter(userRepo, roleRepository, bcryptPassword);
	}
	
	private void initDataOffreSearchView() {
		OffreSearchView offreSearchView = new OffreSearchView();
		offreSearchView.setId(1L);
		offreSearchView.setTitre("FakeOffre");
		offreSearchView.setTypeOffre(TypeOffreEnum.IMMOBILIER);
		offreSearchView.setTypeServiceOffre(TypeServiceOffre.LOCATION);
		offreSearchView.setTypeDebienImmobilier("APPARTEMENT");
		offreSearchView.setUsersId(1L);

		offreSearchViews.add(offreSearchView);
	}

}
