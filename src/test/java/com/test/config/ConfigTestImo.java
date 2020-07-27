/**
 * 
 */
package com.test.config;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import imo.com.ImoBackApplication;

/**
 * @author balde
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { ImoBackApplication.class })
// @TestPropertySource("classpath:application-test.properties")
@AutoConfigureMockMvc(addFilters=false)
@Transactional
public abstract class ConfigTestImo {

	protected String mediaAccept = MediaType.APPLICATION_JSON_VALUE;
	protected String ContentType = MediaType.APPLICATION_JSON_VALUE;
}
