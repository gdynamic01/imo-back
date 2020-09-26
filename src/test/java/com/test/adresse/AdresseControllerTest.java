/**
 * 
 */
package com.test.adresse;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.allObjects.IGeneralTest;
import com.test.config.ConfigTestImo;

import imo.com.repo.adresse.PaysRepository;

/**
 * @author mbalde
 */
public class AdresseControllerTest extends ConfigTestImo implements IGeneralTest {

	@Autowired
	private PaysRepository paysRepository;

	@Test
	public void should_getAllPays_noContent() throws Exception {

		mockMvc.perform(get(uri + "/pays").accept(mediaAccept).contentType(ContentType))
				.andExpect(status().isNoContent()).andDo(print());
	}

	@Test
	public void should_getAllPays_success() throws Exception {

		createPays(paysRepository);
		mockMvc.perform(get(uri + "/pays").accept(mediaAccept).contentType(ContentType)).andExpect(status().isOk())
				.andExpect(jsonPath("$.result", hasSize(1))).andExpect(jsonPath("$.result.[0].nomPays").value("France"))
				.andExpect(jsonPath("$.result.[0].villes", hasSize(1)))
				.andDo(print());
	}

}
