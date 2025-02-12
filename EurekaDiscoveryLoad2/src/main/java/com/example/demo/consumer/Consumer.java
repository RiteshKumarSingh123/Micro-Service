package com.example.demo.consumer;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;

@FeignClient("EurekaDiscoveryLoad1")
public interface Consumer {

	@GetMapping("/emp/getAllEmployee")
	public List<Employee> getAllData();
	
	@PostMapping("/emp/saveEmployee")
	public Employee saveEmployee(Employee employee);
	
	@GetMapping("/emp/getEmployee")
	public Employee getEmployee(@RequestParam("id") long id);
	
	@GetMapping("/emp/deleteById")
	public Map<String,String> deleteById(@RequestParam("id") long id);
	
	@PostMapping("/emp/updateEmployee")
	public Map<String,String> updateEmployee(Employee employee);
	
}
