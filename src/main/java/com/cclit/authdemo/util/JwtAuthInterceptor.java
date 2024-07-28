package com.cclit.authdemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.cclit.authdemo.bean.User;
import com.cclit.authdemo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *  JWT Authentication interceptor class
 *  
 *  @author GalenLin
 */
@Component
public class JwtAuthInterceptor implements HandlerInterceptor {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// allow getAll event pass
		if(request.getMethod().equals("GET")) {
			return true;
		}
		
		
		if(request.getMethod().equals("OPTIONS")) {
			return true;
		}
		
		// JWT token check
		String authHeader = request.getHeader("Authorization");
		
		
		if(authHeader != null) {
			
			String accessToken = authHeader.replace("Bearer ", "");
			String userAccount = jwtUtil.parseJwtToken(accessToken);
			if(userAccount == null) {
				response.setStatus(401);
				return false;
			}
			
			User user = userService.findUserByEmail(userAccount);
			if(user == null) {
				response.setStatus(401);
				return false;
			}

			request.setAttribute("token", accessToken);
			return true;
			
		} 
		
		response.setStatus(401);
		return false;
	}

}
