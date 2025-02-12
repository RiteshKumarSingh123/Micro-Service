package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employeeInterface.EmployeeInterface;
import com.example.demo.model.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeeContoller {
	
	@Autowired
	private EmployeeInterface employeeInterface;
	
	@GetMapping("getEmployeeData")
	public String employeeData() {
		return "here all employess are";
	}
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		Employee save = employeeInterface.saveEmployee(employee);
		return save;
	}
	
	@GetMapping("getAllEmployee")
	public List<Employee> getAllEmployee(){
		List<Employee> employeeList = employeeInterface.getAllEmployee();
		return employeeList;
	}
	
	@GetMapping("getEmployee")
	public Employee getEmployee(@RequestParam("id") long id) {
		Employee employee = employeeInterface.getEmployee(id);
		return employee;
		}
	
	@GetMapping("deleteById")
	public Map<String,String> deleteById(@RequestParam("id") long id){
		Map<String,String> delete = employeeInterface.deleteById(id);
		return delete;
	}
	
	@PostMapping("updateEmployee")
	public Map<String,String> updateEmployee(@RequestBody Employee employee){
		Map<String,String> update = employeeInterface.updateEmployee(employee);
		return update;
	}

}
