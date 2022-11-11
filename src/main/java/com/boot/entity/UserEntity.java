package com.boot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="User_Detail")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","FieldHandler"})
public class UserEntity {

	
	
	@Id   // it declare particular column as primary key of the table
	@GeneratedValue(strategy = GenerationType.AUTO)   // it will set the primary key to Auto increment
	private int userId;

	@Column(nullable = false, length=30)
	private String userName;

	@Column(unique = true, nullable=false)
	private String userEmail;

	@Column(nullable=false, length=10)
	private String userPassword;
	
	@Column(unique = true,nullable=false)
	private String userMobile;

	
	@Column(nullable=false)
	private String userQualification;

	@Column(nullable=false)
	private String userSkills;
	
	//OneToMany
	
	 @OneToMany(mappedBy = "users1",cascade = CascadeType.ALL)
	    @JsonIgnore
	    private List<AppliedJobEntity> aplliedList=new ArrayList();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserQualification() {
		return userQualification;
	}

	public void setUserQualification(String userQualification) {
		this.userQualification = userQualification;
	}

	public String getUserSkills() {
		return userSkills;
	}

	public void setUserSkills(String userSkills) {
		this.userSkills = userSkills;
	}

	public List<AppliedJobEntity> getAplliedList() {
		return aplliedList;
	}

	public void setAplliedList(List<AppliedJobEntity> aplliedList) {
		this.aplliedList = aplliedList;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", userMobile=" + userMobile + ", userQualification="
				+ userQualification + ", userSkills=" + userSkills + ", aplliedList=" + aplliedList + "]";
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	
	 
	 
	
	//@OneToMany(mappedBy="user1")     // one user can apply many jobs
	//@JsonIgnore
	//private List<JobEntity> jobList = new ArrayList();
	
//	@OneToMany(mappedBy="user1")     // one user can apply many jobs
//	@JsonIgnore
//	private List<JobEntity> jobList = new ArrayList();

	
	

	
	

//	public List<JobEntity> getJobList() {
//		return jobList;
//	}
//
//	public void setJobList(List<JobEntity> jobList) {
//		this.jobList = jobList;
//	}

	
	



}
