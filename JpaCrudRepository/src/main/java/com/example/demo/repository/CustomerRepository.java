package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Serializable> {

}
