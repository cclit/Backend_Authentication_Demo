package com.cclit.authdemo.util;

import com.cclit.authdemo.bean.User;

/**
 *  JWT Generator interface
 *  
 *  @author GalenLin
 */

public interface JwtGenerator {

	public String generateJwtToken(User user);
}
