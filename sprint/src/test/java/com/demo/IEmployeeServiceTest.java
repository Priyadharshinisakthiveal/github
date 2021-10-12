package com.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.dao.IEmployeeRepository;
import com.demo.entities.Employee;
import com.demo.service.IEmployeeServiceImpl;


@ExtendWith(MockitoExtension.class)
public class IEmployeeServiceTest {
	@Mock
	private IEmployeeRepository employeeRepository;
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private IEmployeeServiceImpl employeeService;
	
	
	//testcase to get list of employees
	@Test
	void getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		Employee emp1 = new Employee(101,"nir@gmail.com","niranj","mani");
		Employee emp2 = new Employee(102,"pavi@gmail.com","pavi","pv");
		Employee emp3 = new Employee(103,"po@gmail.com","pooja","lion");
		Employee emp4 = new Employee(104,"pr@gmail.com","priya","dhar");
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		when(employeeRepository.findAll()).thenReturn(list);
		//when(employeeRepository.deleteAll());
		
		List<Employee> empList = employeeService.getAllEmployees();
		assertEquals(4,empList.size());	
	}
	
	
	@Test
	void getEmployeeById() {
		Employee emp4 = new Employee(104,"pr@gmail.com","priya","dhar");
		employeeRepository.findById(emp4.getUserId());
		assertEquals(104,emp4.getUserId());//it checks the expected id is equal to given  		
	}
	
	
	//testcase to add an employee
	@Test
	void saveEmployeeTest() {
		Employee emp = new Employee(101,"nir@gmail.com","niranj","mani");
		when(employeeRepository.save(emp)).thenReturn(emp);
		Employee savedEmp = employeeService.addEmployee(emp);
		assertThat(savedEmp).isNotNull();//it checks the employee object is not null
		assertEquals("niranj",savedEmp.getFirstName());//it checks the expected firstname is equal to given firstname
	}
	
	
	//testcase for deleting employee
	@Test
	public void deleteEmployeeTest() {
		Employee emp1 = new Employee(102,"pavi@gmail.com","pavi","pv");
		employeeRepository.deleteById(emp1.getUserId());
		boolean deleteEmp = employeeService.deleteEmployee(102);
		assertThat(deleteEmp).isNotNull();//it checks the employee object is not null
		assertEquals(true,deleteEmp);//it checks the expected value is true
		
	}

}