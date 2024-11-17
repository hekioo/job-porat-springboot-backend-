package com.boot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="User_Detail")

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
	
	
	@ManyToOne     // Many USer can apply in one Job
	@JoinColumn(name="jobID")
	private JobEntity job1;
	
	

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

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobEntity getJob1() {
		return job1;
	}

	public void setJob1(JobEntity job1) {
		this.job1 = job1;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", userMobile=" + userMobile + ", userQualification="
				+ userQualification + ", userSkills=" + userSkills + ", job1=" + job1 + "]";
	}

	
	
	
	
	
	
	


}
