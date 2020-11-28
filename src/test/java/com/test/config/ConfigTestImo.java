/**
 * 
 */
package com.test.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import imo.com.ImoBackApplication;

/**
 * @author balde
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { ImoBackApplication.class })
// @TestPropertySource("classpath:application-test.properties")
@AutoConfigureMockMvc(addFilters=false) // pour desactiver la sécurité
@Transactional
public abstract class ConfigTestImo {

	protected final String mediaAccept = MediaType.APPLICATION_JSON_VALUE;
	protected final String ContentType = MediaType.APPLICATION_JSON_VALUE;
	protected final String uri = "/loumos";
	
	@Autowired
	protected MockMvc mockMvc;
	
	@Value("${path.users}")
	protected String pathUsers;

	@Value("${path.offres}")
	protected String pathOffres;

	public String getJsonFromFile(String path) throws IOException  {
		byte[] datas = Files.readAllBytes(Paths.get(path));
		return new String(datas, "UTF-8");
	}
}
