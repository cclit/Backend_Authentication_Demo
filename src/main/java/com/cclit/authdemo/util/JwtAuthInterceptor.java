package com.cclit.authdemo.util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *  JWT Authentication interceptor class
 *  
 *  @author GalenLin
 */
@Component
public class JwtAuthInterceptor implements HandlerInterceptor {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// allow getAll event pass
		
		
		
		return true;
	}
	
	

}