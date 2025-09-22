package com.assh.supervisor.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assh.supervisor.model.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class JwtDao {

	@PersistenceContext
	private EntityManager entity;
	
//	@Autowired 
//	private UserRepository repo;
	
	public Users getUserData(String userName) {
		Users user = new Users();
		entity.unwrap(Session.class).doWork(connection->{
			try(CallableStatement cstmt = connection.prepareCall("{ call userDetailsData(?, ?) }")) {

				cstmt.setString(1, userName);
				cstmt.registerOutParameter(2, Types.REF_CURSOR);
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
	
//	public Users findByUsername(String username) {
//		Users user = repo.findByUsername(username);
//		return user;
//	}

}