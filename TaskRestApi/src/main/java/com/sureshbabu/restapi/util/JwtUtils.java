package com.sureshbabu.restapi.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.sureshbabu.restapi.exception.AccessDeniedException;
import com.sureshbabu.restapi.exception.GlobalException;
import com.sureshbabu.restapi.request.LoginRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	private static final String MY_SECRET_KEY = "MY_SECRET*KEY";

	private static final long EXPIRY_DURATION = 60 * 60;

	public String generateToken(LoginRequest loginRequest) {

		long currentTime = System.currentTimeMillis();
		long expiryTime = currentTime + EXPIRY_DURATION * 1000;

		Date issuedAt = new Date(currentTime);
		Date expiredAt = new Date(expiryTime);

		Claims claims = Jwts.claims()
			.setIssuer(loginRequest.getUserCode())
				
				.setIssuedAt(issuedAt)
				
				.setExpiration(expiredAt);

		claims.put(ProjectConstants.CLAIM_USER_NAME, loginRequest.getUserCode());

		return Jwts.builder()
			
				.setClaims(claims)
				
				.signWith(SignatureAlgorithm.HS256, MY_SECRET_KEY)
		
				.compact();
	}

	public Claims verify(String authorization) throws Exception {
		try {
			return Jwts.parser().setSigningKey(MY_SECRET_KEY).parseClaimsJws(authorization).getBody();
		} catch (Exception e) {
			throw new AccessDeniedException(GlobalException.ACCESS_DENIED_EXCEPTION);
		}
	}

}
