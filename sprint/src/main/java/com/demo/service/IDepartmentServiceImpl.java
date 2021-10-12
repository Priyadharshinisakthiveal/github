package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.dao.IDepartmentRepository;
import com.demo.entities.Department;
import com.demo.entities.Employee;

//provides all services for Department
@Service
public class IDepartmentServiceImpl implements IDepartmentService {
	@Autowired
	private IDepartmentRepository repository;

	//to add a Department
    @Override
    public Department addDepartment(Department dname) {
        return repository.save(dname);
    }

    //to get list of department
    @Override
    public List<Department> getAllDepartments() {
    	return (List<Department>)repository.findAll();

    }

    //to get list of department by pagination
    @Override
    public List<Department> getAllDepartmentByPagination(int maxPage, int ofset) {
    	Pageable paging = PageRequest.of(maxPage-1, ofset);
		Page<Department> pageresult = repository.findAll(paging);
		
		return pageresult.toList();
    }

    //returns department count 
    @Override
    public int getAllDepartCount() {

        return (int) repository.count();
   }

    //to delete a department
   @Override
   public boolean deleteDepartment(int id) {
	   repository.deleteById(id);
	   return true;
   }

}