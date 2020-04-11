package imo.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author mbalde
 *
 */
@ComponentScan(basePackages = "imo.com") // scan les packages des beans (@Component,@Service,@Autowired...)
@EntityScan(basePackages = "imo.com.model") // scan les packages des entités
@SpringBootApplication
public class ImoBackApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ImoBackApplication.class, args);
	}
}
