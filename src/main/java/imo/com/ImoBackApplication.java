package imo.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author mbalde
 *
 */
@ComponentScan(basePackages = "imo.com")
@SpringBootApplication
// @SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) pour desactiver la securité spring
public class ImoBackApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ImoBackApplication.class, args);
	}
}
