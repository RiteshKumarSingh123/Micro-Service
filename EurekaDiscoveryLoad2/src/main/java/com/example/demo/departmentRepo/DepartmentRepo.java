package com.example.demo.departmentRepo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Serializable> {

}
