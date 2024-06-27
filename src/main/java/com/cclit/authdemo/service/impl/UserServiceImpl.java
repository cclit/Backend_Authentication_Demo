package com.cclit.authdemo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cclit.authdemo.bean.User;
import com.cclit.authdemo.dao.UserDao;
import com.cclit.authdemo.dto.UserLoginReq;
import com.cclit.authdemo.exception.InvalidInputException;
import com.cclit.authdemo.service.UserService;


/**
 *  User service interface implementation class
 *  
 *  @author GalenLin
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User register(UserLoginReq userLoginReq) {
		
		// check if the user is existed or not
		User userCheck = userDao.findUserByEmail(userLoginReq.getEmail());
		if(userCheck != null) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("email", "Email exists already.");
			throw new InvalidInputException("User register failed due to validation errors.", errorMap);
		}
		
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setEmail(userLoginReq.getEmail());
		user.setPwd(userLoginReq.getPassword());
		
		return userDao.save(user);
	}

	
	
	
}
