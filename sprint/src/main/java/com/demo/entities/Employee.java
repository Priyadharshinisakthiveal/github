package com.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="employee_master")
//provides getter,setter for all the fields
@Getter @Setter  
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	private int userId;
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@OneToOne(fetch=FetchType.LAZY)
	//joining the primary key of employee and user
	@PrimaryKeyJoinColumn(name="user_id")//
	private User user;
	
	
	@Column(name="first_name")
	@NotNull(message="first name cannot be empty")
	@Size(min=2,max=20 , message="name is not valid")
	private String firstName;
	
	@NotNull(message="last name cannot be empty")
	@Size(min=2,max=20 , message="name is not valid")
	private String lastName;
	
	@NotNull(message="DOB cannot be empty")  
	private LocalDate dob;
	
	@Email
	private String email;
	
	// joining department and employee using one to one association
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="departid",nullable=false)
	private Department department;
	
	
public Employee(int i, String string, String string2, String string3) {
		this.userId=i;
		this.firstName=string;
		this.lastName=string2;
        this.email=string3;
	}

	

	@JsonIgnore
	public User getUser() {
		return user;
	}
	
	
}