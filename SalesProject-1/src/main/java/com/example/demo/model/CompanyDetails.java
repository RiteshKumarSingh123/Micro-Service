package com.example.demo.model;

import java.util.List;

public class CompanyDetails {
	private long count;
	private List<Customers> customersFilter;
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public List<Customers> getCustomersFilter() {
		return customersFilter;
	}
	public void setCustomersFilter(List<Customers> customersFilter) {
		this.customersFilter = customersFilter;
	}
	
	
	@Override
	public String toString() {
		return "CompanyDetails [count=" + count + ", customersFilter=" + customersFilter + "]";
	}

	
}
