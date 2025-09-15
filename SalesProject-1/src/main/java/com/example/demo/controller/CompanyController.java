package com.example.demo.controller;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.AuthRequest;
import com.example.demo.model.CompanyDetails;
import com.example.demo.model.Customers;
import com.example.demo.model.Users;
import com.example.demo.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
    private	CompanyService service;
	 
	 @PostMapping("/login")
		public Users getUserData(@RequestBody AuthRequest authRequest){
			System.out.println(authRequest.getUserName()+"**********************************");
			Users response = service.getUserData(authRequest);
		return response;
		}
	 
	 @GetMapping("getCustomersList")
		public CompanyDetails getCustomersList(){
			CompanyDetails customersList = service.getCustomersList();
			return customersList;
		}
	 
	 @GetMapping("getCustomerById")
		public Customers getCustomerById(@RequestParam long customerId){
			 Customers customersById = service.getCustomerById(customerId);
			return customersById;
		}
	 
	 @PostMapping("saveCustomers")
		public Customers saveCustomersData(@RequestBody Customers customers) {
			Customers customer = service.saveCustomersData(customers);
			return customer;
		}
	 
	 @PostMapping("updateCustomers")
		public Map<String,String> updateCustomers(@RequestBody Customers customers) {
			Map<String,String> cusRes = service.updateCustomers(customers);
			return cusRes;
		}
	 
	 @GetMapping("deleteCustomerById")
		public Map<String,String> deleteCustomerById(@RequestParam long customerId){
			Map<String,String> deletedRes = service.deleteCustomerById(customerId);
			return deletedRes;
		}

}
