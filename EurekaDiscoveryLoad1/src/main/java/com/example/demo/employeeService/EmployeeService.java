package com.example.demo.employeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employeeInterface.EmployeeInterface;
import com.example.demo.employeeRepo.EmployeeRepository;
import com.example.demo.model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
@Transactional
@Service
public class EmployeeService implements EmployeeInterface{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EntityManager entitymanager;

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee save = employeeRepository.save(employee);
		return save;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employeelist = employeeRepository.findAll();
		return employeelist;
	}

	@Override
	public Employee getEmployee(long id) {
		Employee employee = employeeRepository.findById(id).get();
		return employee;
	}

	@Override
	public Map<String, String> deleteById(long id) {
		employeeRepository.deleteById(id);
		Map<String,String> res = new HashMap<String,String>();
		res.put("status", "deleted sucessfully");
		return res;
	}

	@Override
	public Map<String, String> updateEmployee(Employee employee) {
		StoredProcedureQuery query = entitymanager.createStoredProcedureQuery("updateEmployee");
		query.registerStoredProcedureParameter("iId", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iAddress", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iName", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iSalary", String.class, ParameterMode.IN);
		query.setParameter("iId", employee.getId());
		query.setParameter("iAddress", employee.getAddress());
		query.setParameter("iName", employee.getName());
		query.setParameter("iSalary", employee.getSalary());
		query.execute();
		Map<String, String> res = new HashMap<String,String>();
		res.put("status", "date updated");
		return res;
	}

}
