package com.example.demo.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Collections;

import org.hibernate.Session;
import org.hibernate.dialect.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AuthRequest;
import com.example.demo.model.Users;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Transactional
@Repository
public class JwtDao {

	@Autowired
	private EntityManager entity;
	
	public Users getUserData(String userName) {
		Users user = new Users();
		entity.unwrap(Session.class).doWork(connection->{
			try(CallableStatement cstmt = connection.prepareCall("{ call userDetailsData(?, ?) }")) {

				cstmt.setString(1, userName);
				cstmt.registerOutParameter(2, OracleTypes.CURSOR);
				cstmt.execute();
				ResultSet rs = (ResultSet) cstmt.getObject(2);
				while(rs.next()) {
					user.setCatererId(rs.getString("catererId"));
					user.setPassword(rs.getString("password")); 
					user.setUsername(rs.getString("name"));
				}
			}
		});
		return user;
	}

	
	
}
