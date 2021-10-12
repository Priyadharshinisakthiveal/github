package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.dao.IEmployeeRepository;
import com.demo.entities.Employee;

@Service
public class IEmployeeServiceImpl implements IEmployeeService{
	@Autowired
	private IEmployeeRepository repository;

	//add employee 
	@Override
	public Employee addEmployee(Employee emp) {
		return repository.save(emp);
	}

	//to delete employee
	@Override
	public boolean deleteEmployee(int id) {
		repository.deleteById(id);
		return true;
		
	}

	//to update email id of employee
	@Override
	public Employee updateEmployee(Employee emp) {
		Employee employee = repository.findById(emp.getUserId());
		employee.setEmail(emp.getEmail());
		return repository.save(employee);
	}

	//to get all employees
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) repository.findAll();
	}

	//to get employee by  id
	@Override
	public Employee getEmployeeById(int userid) {
		// TODO Auto-generated method stub
		return repository.findById(userid);
	}

	//to get employee by pagination
	@Override
	public List<Employee> getAllEmployeesByPagination(int maxPage, int ofset) {
		Pageable paging = PageRequest.of(maxPage-1, ofset);
		Page<Employee> pageresult = repository.findAll(paging);
		
		return pageresult.toList();
		//return null;
	}

	//returns the employee count
	@Override
	public int getEmployeeCount() {
		// TODO Auto-generated method stub
		List<Employee> al= repository.findAll();
		return al.size();
	}
	

}