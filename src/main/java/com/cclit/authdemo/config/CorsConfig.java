package com.cclit.authdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 *  CORS Setting Configurer
 *  
 *  @author GalenLin
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**")
				.allowedOrigins("http://localhost:3000")
				.allowedMethods(CorsConfiguration.ALL)
				.allowedHeaders(CorsConfiguration.ALL)
				.exposedHeaders("Content-Type", "Authorization")
				.allowCredentials(true);
		
	}
	
	

}
