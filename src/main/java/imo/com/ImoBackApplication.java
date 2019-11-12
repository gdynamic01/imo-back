package imo.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author mbalde
 *
 */
// @EnableJpaAuditing
// @ServletComponentScan
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "imo.com")
// @SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) pour desactiver la securité spring
@SpringBootApplication
public class ImoBackApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ImoBackApplication.class, args);
	}
}
