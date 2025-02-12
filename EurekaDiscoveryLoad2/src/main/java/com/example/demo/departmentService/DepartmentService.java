package com.example.demo.departmentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.departmentInterface.DepartmentInterface;
import com.example.demo.departmentRepo.DepartmentRepo;
import com.example.demo.model.Department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class DepartmentService implements DepartmentInterface {
	
	@Autowired
	private DepartmentRepo repo;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Department saveDept(Department department) {
		Department save = repo.save(department);
		return save;
	}

	@Override
	public List<Department> getAllDept() {
		List<Department> listOfDept = repo.findAll();
		return listOfDept;
	}

	@Override
	public Department getDepartment(long id) {
		Department department = repo.findById(id).get();
		return department;
	}

	@Override
	public Map<String, String> deleteById(long id) {
		repo.deleteById(id);
		Map<String,String> res = new HashMap<String,String>();
		res.put("status", "deleted sucessfully");
		return res;
	}

	@Override
	public Map<String, String> updateDepartment(Department department) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("updateDepartment");
		query.registerStoredProcedureParameter("iId", Integer.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iDepartment", String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("iName", String.class, ParameterMode.IN);
		query.setParameter("iId", department.getId());
		query.setParameter("iDepartment", department.getDepartment());
		query.setParameter("iName", department.getDepartmentName());
		query.execute();
		Map<String, String> res = new HashMap<String,String>();
		res.put("status", "date updated");
		return res;
	}
	
	

}
