package com.example.demo.service;




import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.CompanyDao;
import com.example.demo.model.AuthRequest;
import com.example.demo.model.CompanyDetails;
import com.example.demo.model.Customers;
import com.example.demo.model.Users;
@Service
public class CompanyService {

	
	@Autowired
	private CompanyDao dao;
	
	
	
	public Users getUserData(AuthRequest request) {
		return dao.getUserData(request);
	}
	
	public CompanyDetails getCustomersList(){
		CompanyDetails customersList = dao.getCustomersList();
		return customersList;
	}
	
	public  Customers getCustomerById(long customerId){
		 Customers customersById = dao.getCustomerById(customerId);
		return customersById;
	}
	
	public Customers saveCustomersData(Customers customers) {
		Customers customer = dao.saveCustomersData(customers);
		return customer;
	}
	
	public Map<String,String> updateCustomers(Customers customers) {
		Map<String,String> cusRes = dao.updateCustomers(customers);
		return cusRes;
	}
	
	public Map<String,String> deleteCustomerById(long customerId){
		Map<String,String> deletedRes = dao.deleteCustomerById(customerId);
		return deletedRes;
	}
	
}
