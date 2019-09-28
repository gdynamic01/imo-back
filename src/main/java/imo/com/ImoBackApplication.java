package imo.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author mbalde
 *
 */
@SpringBootApplication
@EnableJpaAuditing
@ServletComponentScan
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "imo.com")
public class ImoBackApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ImoBackApplication.class, args);
	}
}
