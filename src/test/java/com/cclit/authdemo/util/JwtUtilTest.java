package com.cclit.authdemo.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.cclit.authdemo.bean.User;

@SpringBootTest
public class JwtUtilTest {
	
	@Autowired
	private JwtUtil jwtGenerator;
	
	@Value("${authdemo.jwt.key}")
	private String secretKey;
	
	@Value("${authdemo.jwt.expire-time.hour}")
	private int expiredTime;
	
	@Test
	public void jwtPropTest() {
		
		assertEquals("SuperSecretForThisAuthenticationDemoApp", secretKey);
		assertEquals(1, expiredTime);
		
	}
	
	@Test
	public void jwtGeneratedTest() {
		
		User testUser = new User();
		testUser.setEmail("testtest@test.com");
		String token = jwtGenerator.generateJwtToken(testUser);
		
		assertNotNull(token);
		
	}
	
	

}
