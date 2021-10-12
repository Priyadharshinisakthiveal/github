package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IComplianceRepository;
import com.demo.entities.Compliance;
import com.demo.entities.StatusReport;

//provide services for compliance
@Service
public class IComplianceServiceImpl implements  IComplianceService{
	@Autowired
	private  IComplianceRepository repository;

	//to create RL
	@Override
	public Compliance createRL(Compliance co) {
		return repository.save(co);
		
	}

	//to get all RL
	@Override
	public List<Compliance> getAllRl() {
		return (List<Compliance>) repository.findAll();
	}

	//to get RL by id
	@Override
	public Compliance getAllRlById(int compid) {
		return repository.findById(compid).get();
	}

	//to create a status report
	@Override
	public StatusReport createStatusReport(StatusReport statusreport) {
		return repository.save(statusreport);
	}

	
	//to get list of status report
	@Override
	public List<StatusReport> getAllStatusReport(int userid) {
		return repository.getByUserId(userid);
		//return null;
	}
	
	

}