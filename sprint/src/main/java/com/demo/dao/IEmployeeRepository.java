package com.demo.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.demo.entities.Employee;

//extends jpa repository to perform CRUD operations

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
	Employee findById(int id);

	
	

}