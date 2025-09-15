package com.example.demo.pojo;

import java.util.List;

import com.example.demo.model.Company;
import com.example.demo.model.Customers;
import com.example.demo.model.Workers;

public class CompanyDetails {
private long count;
private List<Company> companyFilter;
private List<Workers> workersFilter;
private List<Customers> customersFilter;

public long getCount() {
	return count;
}
public void setCount(long count) {
	this.count = count;
}
public List<Company> getCompanyFilter() {
	return companyFilter;
}
public void setCompanyFilter(List<Company> companyFilter) {
	this.companyFilter = companyFilter;
}
public List<Workers> getWorkersFilter() {
	return workersFilter;
}
public void setWorkersFilter(List<Workers> workersFilter) {
	this.workersFilter = workersFilter;
}
public List<Customers> getCustomersFilter() {
	return customersFilter;
}
public void setCustomersFilter(List<Customers> customersFilter) {
	this.customersFilter = customersFilter;
}
@Override
public String toString() {
	return "CompanyDetails [count=" + count + ", companyFilter=" + companyFilter + ", workersFilter=" + workersFilter
			+ "]";
}


}
