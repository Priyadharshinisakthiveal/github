package com.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="compliance")

//provides getter,setter for all the fields
@Getter @Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Compliance implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//primary key of compliance 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "com_id")
	private int complianceId;
	
	@Column(name = "type")
	//@NotNull(message="type must not be empty")
	private String rlType;
	
	//@NotNull(message="details must not be empty")
	private String details;
	
	@Column(name ="date")
	private Date createDate;
	
	//joining Department and compliance using one to one association
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="departid")
	private Department department;
	
	@Column(name ="emp_count")
	private int empCount;
	
	@Column(name ="status_count")
	private int stsCount;
	
	//@NotNull(message="status must not be empty")
	private String status;
	
	//joining statusReport and compliance using one to one association
	@OneToOne(mappedBy="compliance", cascade = CascadeType.ALL)
	private StatusReport statusReport;
	
//	public Compliance(int complianceId,String details){
//		this.complianceId=complianceId;
//		this.details=details;
//	}
	
	public Compliance(int i, String string) {
		this.complianceId=i;
		this.details=string;
	}
	@JsonIgnore
	public  Department getDepartment() {
		return department;
	}
	//@JsonIgnore
	public StatusReport getStatusReport() {
		return statusReport;
	}

}