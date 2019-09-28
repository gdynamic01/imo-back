package imo.com.general;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author mbalde
 *
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/immo/**").allowedOrigins("http://localhost:4200")
                .allowedMethods("PUT", "DELETE", "POST", "GET").allowedHeaders("*").allowCredentials(true);
    }

    /**
     * @return
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /**
     * @return
     */
    // @Bean
    // public BCryptPasswordEncoder passwordEncoder() {
    // BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    // return bCryptPasswordEncoder;
    // }
}
