package com.example.demo.configuration;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.demo.model.Users;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	    @Value("${jwt.secret}")
	    private String secret;

	    @Value("${jwt.expiration}")
	    private long expiration;
	    
	    @Autowired
	    private StringRedisTemplate redisTemplate;
//	 private final String SECRET_KEY = "0123456789012345678901234567890101234567890123456789012345678901";
	    
//	    private final long EXPIRATION_TIME = 864_000_00L;
//	 1000 * 60 * 60
	   
	    private Key getSigningKey() {
	        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
	    }
	    
	   

	    public String generateToken(Users user) {
	    	Map<String,Object> claimsData = new HashMap<String,Object>();
	    	claimsData.put("catererId", user.getCatererId());
	     String token =   Jwts.builder()
	        		.setClaims(claimsData)
	                .setSubject(user.getUsername())
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + expiration)) 
	                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
	                .compact();

	     
	     String userKey = "user:" + user.getUsername();  // e.g. user:john_doe
	     String oldToken = redisTemplate.opsForValue().get(userKey);

	   
	     if (oldToken != null) {
	         redisTemplate.delete(oldToken);
	     }

	    
	     redisTemplate.opsForValue().set(token, user.getUsername(), expiration, TimeUnit.MILLISECONDS);

	     
	     redisTemplate.opsForValue().set(userKey, token, expiration, TimeUnit.MILLISECONDS);

	     
	     return token;
	    }
	    
	 
	    public boolean validateToken(String token) {
	        try {
	            Claims claims = getClaims(token);
	            String username = claims.getSubject();

	            if (claims.getExpiration().before(new Date())) {
	                return false;
	            }

	            String cachedToken = redisTemplate.opsForValue().get("user:" + username);
	            return cachedToken != null && cachedToken.equals(token);

	        } catch (JwtException | IllegalArgumentException e) {
	            return false;
	        }
	    }
	    
	 
	    public Claims getClaims(String token) {
	        return Jwts.parserBuilder()
	                .setSigningKey(getSigningKey())
	                .build()
	                .parseClaimsJws(token)
	                .getBody();
	    }
	      
	    
	    public boolean isTokenValid(String token) {
	        return redisTemplate.hasKey(token);
	    }
	    
	    public void deleteToken(String token) {
	        redisTemplate.delete(token);
	    }

}
