package com.cclit.authdemo.service;

import com.cclit.authdemo.bean.User;
import com.cclit.authdemo.dto.UserLoginReq;

/**
 *  User service interface
 *  
 *  @author GalenLin
 */
public interface UserService {
	
	
	public User register(UserLoginReq userLoginReq);

}
