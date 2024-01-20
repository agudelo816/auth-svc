package com.agudelo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.agudelo.helper.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
//import io.jsonwebtoken.security.Keys;

@Service
public class TokenServiceImpl implements TokenService {


	private static final long ACCESS_TOKEN_VALIDITY = 1000 * 60 * 15; // 15 minutes
	private static final long REFRESH_TOKEN_VALIDITY = 1000 * 60 * 60 * 24; // 24 hours

	private static final SecretKey SECRET_KEY = MacProvider.generateKey(SignatureAlgorithm.HS256); // Replace with a
	// more
	// secure key management

	@Override
	public String generateAccessToken(String username) {
		return this.createToken(username, ACCESS_TOKEN_VALIDITY);
	}

	@Override
	public String generateRefreshToken(String username) {
		return this.createToken(username, REFRESH_TOKEN_VALIDITY);
	}

	@Override
	public boolean validateAccessToken(String token) {
		return this.validateToken(token, "username");
	}

	@Override
	public boolean validateRefreshToken(String token) {
		return this.validateToken(token, "username");

	}

	@Override
	public UserDetails extractUserDetailsFromAccessToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	private String createToken(String subject, long validity) {
		final Map<String, Object> claims = new HashMap<>();
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + validity))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	private Boolean validateToken(String token, String username) {
		final String subject = this.extractUsername(token);
		return subject.equals(username) && !this.isTokenExpired(token);
	}

	public String extractUsername(String token) {
		return this.extractClaim(token, Claims::getSubject);
	}

	private Boolean isTokenExpired(String token) {
		return this.extractClaim(token, Claims::getExpiration).before(new Date());
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = this.extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		//		Jwts.builder().
		return null;
		//		return Jwts.builder()
		//				.setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
	}




}
