package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Department;


//extends jpa repository to perform CRUD operations
public interface IDepartmentRepository extends JpaRepository<Department,Integer>{

}