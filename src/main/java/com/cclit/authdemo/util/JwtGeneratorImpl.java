package com.cclit.authdemo.util;

import java.security.Key;
import java.util.Calendar;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cclit.authdemo.bean.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/**
 *  JWT Generator interface implement class
 *  
 *  @author GalenLin
 */
@Component
public class JwtGeneratorImpl implements JwtGenerator {

	@Value("${authdemo.jwt.key}")
	private String secretKey;
	
	@Value("${authdemo.jwt.expire-time.hour}")
	private int expiredTime;
	
	@Override
	public String generateJwtToken(User user) {
		
		Calendar exp = Calendar.getInstance();
		exp.add(Calendar.HOUR, expiredTime);
		
		Claims claims = Jwts.claims();
		claims.setSubject(user.getEmail());
		claims.setExpiration(exp.getTime());
		
		Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
		
		return Jwts.builder()
				   .setClaims(claims)
				   .signWith(key)
				   .compact();
	}

}
