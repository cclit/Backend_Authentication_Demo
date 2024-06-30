package com.cclit.authdemo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.cclit.authdemo.bean.User;
import com.cclit.authdemo.dao.UserDao;
import com.cclit.authdemo.dto.UserLoginReq;
import com.cclit.authdemo.exception.InvalidInputException;
import com.cclit.authdemo.exception.UserNotFoundException;
import com.cclit.authdemo.service.UserService;
import com.cclit.authdemo.util.JwtUtil;


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
		
		//// password needed to be encrypted before save to db table
		String hashedPwd = DigestUtils.md5DigestAsHex(userLoginReq.getPassword().getBytes());
		user.setPassword(hashedPwd);
		
		return userDao.save(user);
	}

	@Override
	public User login(UserLoginReq userLoginReq) {
		// 1. check if the user existed
		User user = userDao.findUserByEmail(userLoginReq.getEmail());
		if(user == null) {
			throw new UserNotFoundException("Authentication failed. Invalid email entered.");
		}
		
		// 2. check pwd
		String hashInputPwd = DigestUtils.md5DigestAsHex(userLoginReq.getPassword().getBytes());
		if(!hashInputPwd.equals(user.getPassword())) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("credentials", "Invalid password entered.");
			throw new InvalidInputException("Invalid credentials.", errorMap);
		}
		
		return user;
	}

	@Override
	public User findUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}
	
}
