package com.cclit.authdemo.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cclit.authdemo.dto.UserLoginReq;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
public class UserAuthenticationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	
	/*
	 * Register test
	 */
	
	@Test
	public void registerSucess() throws Exception {
		
		UserLoginReq userLoginReq = new UserLoginReq();
		userLoginReq.setEmail("test1115@test.com");
		userLoginReq.setPassword("123456");
		
		String json = objectMapper.writeValueAsString(userLoginReq);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/signup")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json);
		
		mockMvc.perform(requestBuilder)
		       .andExpect(status().is(201))
		       .andExpect(jsonPath("$.user.id", notNullValue()))
		       .andExpect(jsonPath("$.user.email", equalTo("test1115@test.com")))
		       .andExpect(jsonPath("$.token", notNullValue()));
		
	}
	
	
	@Test
	public void emaiAlreadyExist() throws Exception {
		
		UserLoginReq userLoginReq = new UserLoginReq();
		userLoginReq.setEmail("test1115@test.com");
		userLoginReq.setPassword("123456");
		
		String json = objectMapper.writeValueAsString(userLoginReq);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/signup")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json);
		
		mockMvc.perform(requestBuilder)
		       .andExpect(status().is(201));
		
		mockMvc.perform(requestBuilder)
	           .andExpect(status().is(422));
		
	}
	
	/*
	 * Login test
	 */
	@Test
	public void loginSucess() throws Exception {
		
		// register
		UserLoginReq userLoginReq = new UserLoginReq();
		userLoginReq.setEmail("test1115@test.com");
		userLoginReq.setPassword("123456");
		register(userLoginReq);
		
		
		// login
		userLoginReq.setEmail("test1115@test.com");
		userLoginReq.setPassword("123456");
		
		String json = objectMapper.writeValueAsString(userLoginReq);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json);
		
		mockMvc.perform(requestBuilder)
		       .andExpect(status().is(200))
		       .andExpect(jsonPath("$.user.id", notNullValue()))
		       .andExpect(jsonPath("$.user.email", equalTo("test1115@test.com")))
		       .andExpect(jsonPath("$.token", notNullValue()));
		       
	}
	
	
	@Test
	public void loginWithWrongPwd() throws Exception {
		
		// register
		UserLoginReq userLoginReq = new UserLoginReq();
		userLoginReq.setEmail("test1115@test.com");
		userLoginReq.setPassword("123456");
		register(userLoginReq);
		
		
		// login
		userLoginReq.setEmail("test1115@test.com");
		userLoginReq.setPassword("112233");
		
		String json = objectMapper.writeValueAsString(userLoginReq);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json);
		
		mockMvc.perform(requestBuilder)
		       .andExpect(status().is(422))
		       .andExpect(jsonPath("$.errors.credentials", notNullValue()));
		
	}
	
	@Test
	public void loginWithEmailNotRegister() throws Exception {
		
		// register
		UserLoginReq userLoginReq = new UserLoginReq();
		userLoginReq.setEmail("test1115@test.com");
		userLoginReq.setPassword("123456");
		register(userLoginReq);
		
		
		// login
		userLoginReq.setEmail("test1116@test.com");
		userLoginReq.setPassword("123456");
		
		String json = objectMapper.writeValueAsString(userLoginReq);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json);
		
		mockMvc.perform(requestBuilder)
		       .andExpect(status().is(401));
		
	}
	
	
	private void register(UserLoginReq userLoginReq) throws Exception {
		
		String json = objectMapper.writeValueAsString(userLoginReq);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/signup")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json);
		
		mockMvc.perform(requestBuilder)
		       .andExpect(status().is(201));		
		
	}
	
	
	
}
