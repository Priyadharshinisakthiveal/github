package com.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "statusreport")
@Getter @Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StatusReport implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="status_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int statusId;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="details")
	private String details;
	
	@Column(name="create_date")
	private LocalDate createDate;
	
	//joining compliance and statusReport using one to one association
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="com_id")
	private Compliance compliance;
	
	//joining user and statusReport using one to one association
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	//joining department and statusReport using one to one association
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="departid")
	private Department department;
	
	@JsonIgnore
	public Department getDepartment() {
		return department;
	}
	
	@JsonIgnore
	public Compliance getCompliance() {
		return compliance;
	}
	
	@JsonIgnore
	public User getUser() {
		return user;
	}

}