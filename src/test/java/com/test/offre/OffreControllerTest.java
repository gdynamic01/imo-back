package com.test.offre;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.allObjects.IOffreGlobalTest;
import com.test.config.ConfigTestImo;

import imo.com.logic.offre.dto.MobileDto;
import imo.com.logic.offre.dto.OffreGlobalDto;


public class OffreControllerTest extends ConfigTestImo implements IOffreGlobalTest {

	@Autowired
	private MockMvc mockMvc;
	
	private OffreGlobalDto offreGlobalDto;
	
	@Test
	public void should_creationOffre_success() throws Exception {
		
		mockMvc.perform(post("/immo/creation-offre")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(createOffreMobile())
				).andExpect(status().isOk())
		.andDo(print());
	}
	
	private String createOffreMobile() throws JsonProcessingException {
		offreGlobalDto = new OffreGlobalDto();
		MobileDto mobileDto = new MobileDto();
		createOffre(mobileDto);
		offreGlobalDto.setMobile(mobileDto);
		offreGlobalDto.setImmobilier(null);
		return new ObjectMapper().writeValueAsString(offreGlobalDto);
	}
	
	
}
