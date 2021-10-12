package com.demo.service;

import java.util.List;

import com.demo.entities.Employee;

//employee service interface
public interface IEmployeeService {
	public Employee addEmployee(Employee emp);
	public boolean deleteEmployee(int id);
	public Employee updateEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int userid);
	public List<Employee> getAllEmployeesByPagination(int maxPage,int ofset);
	public int getEmployeeCount();
	
	
	
	

}