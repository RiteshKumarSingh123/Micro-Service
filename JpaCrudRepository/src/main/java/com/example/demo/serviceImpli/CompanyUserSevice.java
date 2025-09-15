package com.example.demo.serviceImpli;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Company;
import com.example.demo.model.Customers;
import com.example.demo.model.Workers;
import com.example.demo.pojo.CompanyDetails;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.WorkersRepository;
import com.example.demo.service.CompanyService;
@Service
public class CompanyUserSevice implements CompanyService {

	@Autowired
	private CompanyRepository repository;
	
	@Autowired
	private WorkersRepository workerRepo;
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Company saveCompanyInfo(Company company) {
		Company saveResponse = repository.save(company);
		return saveResponse;
	}

//	@Override
//	public CompanyDetails getCompanyList() {
//		List<Company> companyList = repository.findAll();
//		long count = companyList.stream().count();
//		List<Company> companyFilter = companyList.stream().map(a->{a.setCompanyName(a.getCompanyName().toUpperCase());return a;}).sorted(Comparator.comparing(Company::getCompanyId).reversed()).toList();
//		CompanyDetails setCompany = new CompanyDetails();
//		setCompany.setCount(count);
//		setCompany.setCompanyFilter(companyFilter);
//		return setCompany;
//	        
//		}
	
	@Override
	public CompanyDetails getCompanyList() {
		List<Company> companyList = repository.findAll();
		
		CompanyDetails companyFilter = companyList.stream().map(a->{a.setCompanyName(a.getCompanyName().toUpperCase());return a;}).sorted(Comparator.comparing(Company::getCompanyId).reversed())
		.collect(Collectors.collectingAndThen(Collectors.toList(), detailsList->{
		CompanyDetails setDetails = new CompanyDetails();
		setDetails.setCompanyFilter(detailsList);
		setDetails.setCount(detailsList.size());
		return setDetails;
		}));
		
	    return   companyFilter;
	}
		
	@Override
	public CompanyDetails getCompanyDetailsList() {
		List<Company> companyList = repository.findAll();
		CompanyDetails companyDetailsData = companyList.stream().map(a->{
			a.setCompanyName(a.getCompanyName().toUpperCase());
			a.setOwnerName(a.getOwnerName().toUpperCase());
			a.setCompanyProducts(a.getCompanyProducts().toUpperCase());
			return a;
		})
		.collect(Collectors.collectingAndThen(Collectors.toList(), listOfCompany->{
		CompanyDetails details = new CompanyDetails();
		details.setCompanyFilter(listOfCompany);
		details.setCount(listOfCompany.size());
		return details;
		}));
		return companyDetailsData;
	}

	@Override
	public Optional<Company> getCompanyById(long companyId) {
		Optional<Company> dataById = repository.findById(companyId);
		Optional<Company> companyInfoById = dataById.stream().map(a->{a.setCompanyName(a.getCompanyName().toUpperCase());return a;}).findAny();
		return companyInfoById;
	}

	@Override
	public Map<String, String> deleteCompanyById(long companyId) {
		repository.deleteById(companyId);
		Map<String, String> res = new HashMap<String,String>();
		res.put("status", "data deleted successfully");
		return res;
	}

	@Override
	public Map<String, String> updateCompany(Company company) {
		Company companyData = null;
		if(company.getCompanyId()>0) {
			companyData = new Company();
			companyData.setCompanyId(company.getCompanyId());
			companyData.setCompanyAddress(company.getCompanyAddress());
			companyData.setCompanyName(company.getCompanyName());
			companyData.setCompanyProducts(company.getCompanyProducts());
			companyData.setCompanyTotalMembers(company.getCompanyTotalMembers());
			companyData.setOwnerName(company.getOwnerName());
			companyData.setWorkingHours(company.getWorkingHours());
		}
		Company setCompany = repository.save(companyData);
		Map<String,String> res = new HashMap<String,String>();
		res.put("status", "data updated successfully");
		return res;
	}

	@Override
	public Map<String, String> getDuplicateCompany(long companyId) {
	boolean exist = false;
	exist =	repository.existsById(companyId);
	Map<String,String> res = new HashMap<String,String>();
	if(exist) {
		res.put("status", "record exists");
	}else {
		res.put("status", "record doesn't exists");
	}
	return res; 

    }

	@Override
	public Workers saveWorkersData(Workers worker) {
		Workers saveResponse = workerRepo.save(worker);
		return saveResponse;
	}

	@Override
	public CompanyDetails getWorkersList() {
		List<Workers> workersDataList = workerRepo.findAll();
		CompanyDetails workerFilterList = workersDataList.stream()
				.map(a->{a.setWorkerName(a.getWorkerName().toUpperCase());
				a.setUnderWhichCompany(a.getUnderWhichCompany().toUpperCase());        
				return a;})
				.sorted(Comparator.comparing(Workers::getWorkerId).reversed())
				.collect(Collectors.collectingAndThen(Collectors.toList(), listOfWorkers->{
				CompanyDetails details = new CompanyDetails();	
				details.setWorkersFilter(listOfWorkers);
				details.setCount(listOfWorkers.size());
				return details;
				}));
		return workerFilterList;
	}

	@Override
	public Optional<Workers> getWorkersById(long workerId) {
		Optional<Workers> workersData = workerRepo.findById(workerId);
		Optional<Workers> workers = workersData.stream().map(a->{
			a.setWorkerName(a.getWorkerName().toUpperCase());
			a.setUnderWhichCompany(a.getUnderWhichCompany().toUpperCase());
			return a;
		}).findAny();
		return workers;
	}

	@Override
	public Map<String, String> deleteWorkerById(long workerId) {
		workerRepo.deleteById(workerId);
		Map<String,String> res = new HashMap<String,String>();
		res.put("status", "data deleted sucessfully");
		return res;
	}

	@Override
	public Map<String, String> updateWorkers(Workers worker) {
		Workers workerRes = new Workers();
		if(worker.getWorkerId()>0) {
		workerRes.setWorkerId(worker.getWorkerId());
		workerRes.setAddress(worker.getAddress());
		workerRes.setUnderWhichCompany(worker.getUnderWhichCompany());
		workerRes.setWorkerName(worker.getWorkerName());
		workerRes.setWorkerPosition(worker.getWorkerPosition());
		workerRes.setDate(worker.getDate());
		}
		Workers workerdata = workerRepo.save(workerRes);
		Map<String,String> res = new HashMap<String,String>();
		res.put("status", "data updated sucessfully");
		return res;
	}

	@Override
	public Customers saveCustomersData(Customers customers) {
	 Customers saveCustomer = customerRepo.save(customers);
	 return saveCustomer;
	}

	@Override
	public CompanyDetails getCustomersList() {
	    List<Customers> customersList = customerRepo.findAll();
	    CompanyDetails details = customersList.stream().map(a->{a.setCustomerName(a.getCustomerName().toUpperCase());return a;})
	    		.sorted(Comparator.comparing(Customers::getCustomerId).reversed())
	    		.collect(Collectors.collectingAndThen(Collectors.toList(), customerListData->{
	    			CompanyDetails companyData = new CompanyDetails();
	    			companyData.setCustomersFilter(customerListData);
	    			companyData.setCount(customerListData.size());
	    			return companyData;
	    		}));
		return details;
	}

	@Override
	public Optional<Customers> getCustomerById(long customerId) {
		 Optional<Customers> customerData = customerRepo.findById(customerId);
		 Optional<Customers> customersDataById = customerData.stream()
		 .map(a->{a.setCustomerName(a.getCustomerName().toUpperCase());return a;}).findAny();
		return customersDataById;
	}

	@Override
	public Map<String, String> deleteCustomerById(long customerId) {
		customerRepo.deleteById(customerId);
		Map<String, String> delRes = new HashMap<String,String>();
		delRes.put("status", "data deleted sucessfully");
		return delRes;
	}

	@Override
	public Map<String, String> updateCustomers(Customers customers) {
		Customers customerUpdate = new Customers();
		if(customers.getCustomerId()>0) {
			customerUpdate.setCustomerId(customers.getCustomerId());	
			customerUpdate.setCustomerAdress(customers.getCustomerAdress());
			customerUpdate.setCustomerAge(customers.getCustomerAge());
			customerUpdate.setCustomerName(customers.getCustomerName());
		}
		Customers resData = customerRepo.save(customerUpdate);
		Map<String, String> updateRes = new HashMap<String,String>();
		updateRes.put("status", "data updated sucessfully");
		return updateRes;
	}

}
