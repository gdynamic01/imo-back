/**
 * 
 */
package com.test.config;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import imo.com.ImoBackApplication;

/**
 * @author balde
 *
 */
@PropertySource(value = "classpath:application.properties")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { ImoBackApplication.class })
@Transactional
public abstract class ConfigTestImo {

}
