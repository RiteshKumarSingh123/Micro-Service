package com.example.demo.service;
import java.util.Map;
import java.util.Optional;
import com.example.demo.model.Company;
import com.example.demo.model.Customers;
import com.example.demo.model.Workers;
import com.example.demo.pojo.CompanyDetails;

public interface CompanyService {

public Company saveCompanyInfo(Company company);
	
	public CompanyDetails getCompanyList();
	
	public CompanyDetails getCompanyDetailsList();
	
	public Optional<Company> getCompanyById(long companyId);
	
	public Map<String,String> deleteCompanyById(long companyId);
	
	public Map<String,String> updateCompany(Company company);
	
	public Map<String,String> getDuplicateCompany(long companyId);
	
	public Workers saveWorkersData(Workers worker); 
	
	public CompanyDetails getWorkersList();

	public Optional<Workers> getWorkersById(long workerId);
	
	public Map<String,String> deleteWorkerById(long workerId);
	
	public Map<String,String> updateWorkers(Workers worker);
	
	public Customers saveCustomersData(Customers customers);
	
	public CompanyDetails getCustomersList();
	
	public  Optional<Customers> getCustomerById(long customerId);
	
	public Map<String,String> deleteCustomerById(long customerId);
	
	public Map<String,String> updateCustomers(Customers customers);
	
}
