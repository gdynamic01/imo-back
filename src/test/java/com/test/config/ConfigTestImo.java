/**
 * 
 */
package com.test.config;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
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
@Transactional
public abstract class ConfigTestImo {

}
