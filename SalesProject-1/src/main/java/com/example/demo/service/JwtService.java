package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.JwtUtil;
import com.example.demo.dao.JwtDao;
import com.example.demo.model.AuthRequest;
import com.example.demo.model.Users;
@Service
public class JwtService {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private JwtDao dao;

	public Map<String,String> loginUserData(AuthRequest authRequest){
		Map<String,String> response = new HashMap<String,String>();
		Users user = dao.getUserData(authRequest.getUserName());
		if(user != null &&
			user.getUsername().equals(authRequest.getUserName())&&user.getCatererId().equals(authRequest.getCatererId())&&
			user.getPassword().equals(authRequest.getPassword())) {
			System.out.println("rrrrrr"+user);
			String token = jwtUtil.generateToken(user);
			 response.put("token", token);
		}
		return response;
		}
}
