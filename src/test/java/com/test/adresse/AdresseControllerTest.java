/**
 * 
 */
package com.test.adresse;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.test.allObjects.IGeneralTest;
import com.test.config.ConfigTestImo;

import imo.com.model.pays.PaysEntity;
import imo.com.model.ville.VilleEntity;
import imo.com.repo.adresse.PaysRepository;

/**
 * @author mbalde
 */
public class AdresseControllerTest extends ConfigTestImo implements IGeneralTest {

	@MockBean
	private PaysRepository paysRepository;

	@Test
	public void should_getAllPays_noContent() throws Exception {

		when(paysRepository.findAll()).thenReturn(new ArrayList<>());
		
		mockMvc.perform(get(uri + "/pays").accept(mediaAccept).contentType(ContentType))
				.andExpect(status().isNoContent()).andDo(print());
	}

	@Test
	public void should_getAllPays_success() throws Exception {

		when(paysRepository.findAll()).thenReturn(getAllPays());
		mockMvc.perform(get(uri + "/pays").accept(mediaAccept).contentType(ContentType)).andExpect(status().isOk())
				.andExpect(jsonPath("$.result", hasSize(1))).andExpect(jsonPath("$.result.[0].nomPays").value("FakePays"))
				.andExpect(jsonPath("$.result.[0].villes", hasSize(1)))
				.andDo(print());
	}
	
	private List<PaysEntity> getAllPays() {
		
		List<VilleEntity> listVilles = new ArrayList<>();
		List<PaysEntity> listPays = new ArrayList<>();
		
		VilleEntity villeEntity = new VilleEntity();
		villeEntity.setId(1L);
		villeEntity.setCodePostal(94500);
		villeEntity.setNomVille("FakeVille");
		
		listVilles.add(villeEntity);
		
		PaysEntity paysEntity = new PaysEntity();
		paysEntity.setId(1L);
		paysEntity.setNomPays("FakePays");
		paysEntity.setVilles(listVilles);
		
		listPays.add(paysEntity);
		
		
		return listPays;
	}

}
