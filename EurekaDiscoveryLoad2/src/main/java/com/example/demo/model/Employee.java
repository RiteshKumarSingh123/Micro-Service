package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	private long id;
	private String name;
	private String address;
	private String salary;
	private List<Department> deptList;
	private Employee employeeData;
	private Common common;
	private  List<Employee> employee;
	
	public Common getCommon() {
		return common;
	}
	public void setCommon(Common common) {
		this.common = common;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public List<Department> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<Department> deptList) {
		this.deptList = deptList;
	}
	public Employee getEmployeeData() {
		return employeeData;
	}
	public void setEmployeeData(Employee employeeData) {
		this.employeeData = employeeData;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	
}
