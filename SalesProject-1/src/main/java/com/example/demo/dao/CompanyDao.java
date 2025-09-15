package com.example.demo.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.dialect.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.example.demo.model.AuthRequest;
import com.example.demo.model.CompanyDetails;
import com.example.demo.model.Customers;
import com.example.demo.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CompanyDao {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
    private WebClient webClient;
	
	
	public Users getUserData(AuthRequest request) {
		Users user = new Users();
		entityManager.unwrap(Session.class).doWork(connection->{
			try(CallableStatement cstmt = connection.prepareCall("{ call userDetailsData(?, ?) }")) {

				cstmt.setString(1, request.getUserName());
				System.out.println(request.getUserName());
				cstmt.registerOutParameter(2, OracleTypes.CURSOR);
				cstmt.execute();
				ResultSet rs = (ResultSet) cstmt.getObject(2);
				while(rs.next()) {
					user.setCatererId(rs.getString("catererId"));
					System.out.println(rs.getString("catererId")); 
					user.setPassword(rs.getString("password")); 
					System.out.println(rs.getString("password"));
					user.setUsername(rs.getString("name"));
					System.out.println(rs.getString("name"));  
				}
			}
		});
		return user;
	}
	
	
	public CompanyDetails getCustomersList() {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder
	                    .path("/company/getCustomersList")
	                    .build()
	            )
				.retrieve()
				.bodyToFlux(CompanyDetails.class)
//				.collectList()
				.next()
				.block();
	}

	public Customers getCustomerById(long customerId) {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder
	                    .path("/company/getCustomerById")
	                    .queryParam("customerId", customerId)
	                    .build()
	            )
				.retrieve()
				.bodyToFlux(Customers.class)
//				.collectList()
				.next()
				.block();
	}
	
	public Customers saveCustomersData(Customers customers){
		return webClient.post()
				.uri("company/saveCustomers")
				.bodyValue(customers)
				.retrieve()
				.bodyToMono(Customers.class)
				.block();
	}
	
	public Map<String, String> updateCustomers(Customers customers){
		return webClient.post()
				.uri("company/updateCustomers")
				.bodyValue(customers)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {})
				.block();
	}
	
	public Map<String, String> deleteCustomerById(long customerId){
		return webClient.get()
				.uri(uriBuilder->uriBuilder
				.path("/company/deleteCustomerById")	
				.queryParam("customerId", customerId)
				.build()
						)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {})
				.block();
	}
	
	}
