package com.assh.supervisor.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assh.supervisor.configuration.JwtUtil;
import com.assh.supervisor.dao.JwtDao;
import com.assh.supervisor.model.AuthRequest;
import com.assh.supervisor.model.Users;



@Service
public class JwtService {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private JwtDao dao;

//	public Map<String,String> loginUserData(AuthRequest authRequest){
//		Map<String,String> response = new HashMap<String,String>();
//		Users user = dao.getUserData(authRequest.getUserName());
//		if(user != null &&
//			user.getUsername().equals(authRequest.getUserName())&&user.getCatererId().equals(authRequest.getCatererId())&&
//			user.getPassword().equals(authRequest.getPassword())) {
//			System.out.println("rrrrrr"+user);
//			String token = jwtUtil.generateToken(user);
//			 response.put("token", token);
//		}
//		return response;
//		}
	
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