package com.example.demo.departmentInterface;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Department;

@Service
public interface DepartmentInterface {

	public Department saveDept(Department department);
	
	public List<Department> getAllDept();
	
	public Department getDepartment(long id);
	
	public Map<String,String> deleteById(long id);
	
	public Map<String,String> updateDepartment(Department department);
	
}
