package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.JwtUtil;
import com.example.demo.model.AuthRequest;
import com.example.demo.service.JwtService;


@RestController
@RequestMapping("/auth")
public class JwtController {
	
	@Autowired
	private JwtService service;
	
	@Autowired
	private JwtUtil jwtUtil;
	

	@PostMapping("/login")
	public Map<String,String> loginUserData(@RequestBody AuthRequest authRequest){
		System.out.println(authRequest.getUserName());
	Map<String,String> response = service.loginUserData(authRequest);
	return response;
	}
	
//	 @GetMapping("/validate")
//	    public ResponseEntity<String> validateToken(@RequestHeader("Authorization") String authHeader) {
//	        try {
//	            String token = extractToken(authHeader);
//	            boolean isValid = jwtUtil.validateToken(token);
//
//	            if (!isValid) {
//	                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is expired or invalid.");
//	            }
//
//	            Claims claims = jwtUtil.getClaims(token);
//	            String username = claims.getSubject();
//	            Date expiration = claims.getExpiration();
//
//	            return ResponseEntity.ok("Token is valid. User: " + username + ", Expires: " + expiration);
//
//	        } catch (Exception e) {
//	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid token or header.");
//	        }
//	    }
//
//	    private String extractToken(String authHeader) {
//	        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//	            return authHeader.substring(7);
//	        }
//	        throw new IllegalArgumentException("Authorization header must start with Bearer ");
//	    }
	    
	    @PostMapping("/logout")
	    public Map<String, String> logout(@RequestHeader("Authorization") String authHeader) {
	        String token = authHeader.substring(7);
	        jwtUtil.deleteToken(token);
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Logged out successfully");
	        return response;
	    }

	    @GetMapping("/validate")
	    public Map<String, Object> validateToken(@RequestHeader("Authorization") String authHeader) {
	        String token = authHeader.substring(7);
	        boolean valid = jwtUtil.validateToken(token) && jwtUtil.isTokenValid(token);
            System.out.println(valid+"valid");
	        Map<String, Object> response = new HashMap<>();
	        response.put("valid", valid);
	        return response;
	    }
	    
	    

	
}
