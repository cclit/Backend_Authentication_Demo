package com.cclit.authdemo.util;

import com.cclit.authdemo.bean.User;

/**
 *  JWT Util interface
 *  
 *  @author GalenLin
 */
public interface JwtUtil {

	public String generateJwtToken(User user);
	
	public String parseJwtToken(String jwtToken);
	
}
