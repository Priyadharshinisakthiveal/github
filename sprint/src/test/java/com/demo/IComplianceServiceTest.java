package com.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.dao.IComplianceRepository;
import com.demo.entities.Compliance;
import com.demo.entities.Employee;
import com.demo.service.IComplianceServiceImpl;

@ExtendWith(MockitoExtension.class)
public class IComplianceServiceTest {
	@Mock
	private IComplianceRepository complianceRepository;
	
	@InjectMocks
	private IComplianceServiceImpl complianceService;
	
	//testcase to get list of compliance
	@Test
	void getAllCompliance() {
		List<Compliance> list = new ArrayList<Compliance>();
		Compliance comp1 = new Compliance(111,"working");
		Compliance comp2 = new Compliance(222,"works");
		list.add(comp1);
		list.add(comp2);
		when(complianceRepository.findAll()).thenReturn(list);
		List<Compliance> compList = complianceService.getAllRl();
		assertEquals(2,compList.size());	
	}
	
	//testcase to get compliance by compliance id
	@Test
	void getAllComp() {
		Compliance comp1 = new Compliance(111,"working");
		complianceRepository.findById(comp1.getComplianceId());
		assertEquals(111,comp1.getComplianceId());	
	}
	
	
	//testcase for creating compliance  
	@Test
	void saveComplianceTest() {
		Compliance comp = new Compliance(111,"working");
		when(complianceRepository.save(comp)).thenReturn(comp);
		Compliance savedComp = complianceService.createRL(comp);
		assertThat(savedComp).isNotNull();
		assertEquals(111,savedComp.getComplianceId());
		assertEquals("working",savedComp.getDetails());
	}
	
	
}