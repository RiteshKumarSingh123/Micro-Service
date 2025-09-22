package com.assh.supervisor.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assh.supervisor.configuration.JwtUtil;
import com.assh.supervisor.model.AuthRequest;
import com.assh.supervisor.service.JwtService;



@RestController
@RequestMapping("/auth")
public class JwtController {
	
	@Autowired
	private JwtService service;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/test")
	public String Test() {
		return "sucess";
	}

	@PostMapping("/login")
	public Map<String,String> loginUserData(@RequestBody AuthRequest authRequest){
		System.out.println(authRequest.getUserName()+"will have rush today");
	Map<String,String> response = service.loginUserData(authRequest);
	return response;
	}
	
	    
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
