package com.cclit.authdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cclit.authdemo.util.JwtAuthInterceptor;


/**
 *  JWT Authentication Configuration setting for related interceptor
 *  
 *  @author GalenLin
 */
@Configuration
public class JwtAuthConfig implements WebMvcConfigurer {

	@Autowired
	private JwtAuthInterceptor jwtAuthInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(jwtAuthInterceptor).addPathPatterns("/events", "/events/**");
		
	}
	

}
