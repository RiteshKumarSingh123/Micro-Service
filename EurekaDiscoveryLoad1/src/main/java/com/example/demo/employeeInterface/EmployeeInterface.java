package com.example.demo.employeeInterface;




import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;
@Service
public interface EmployeeInterface {

	public Employee saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployee(long id);
	
	public Map<String,String> deleteById(long id);
	
	public Map<String,String> updateEmployee(Employee employee);
}
