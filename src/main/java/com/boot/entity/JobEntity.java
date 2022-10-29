package com.boot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Job_Detail")
public class JobEntity 
{
	@Id   // it declare particular column as primary key of the table
	@GeneratedValue(strategy = GenerationType.AUTO)   // it will set the primary key to Auto increment
	private int jobId;

	@Column(nullable = false)
	private String companyName;
	 
	@Column(nullable = false)
	private String jobTitle;

	
	@Column(nullable=false)
	private String jobCategory;
	
	@Column(nullable=false)
	private String jobDescription;

	@Column(nullable=false)
	private String jobLocation;
	
	@Column(nullable=false)
	private String jobSalary;
	
	
	@OneToMany(mappedBy="job1")     // one job can be applied by many users
	private List<UserEntity> userList = new ArrayList();
	
	
	

	public List<UserEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<UserEntity> userList) {
		this.userList = userList;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getJobSalary() {
		return jobSalary;
	}

	public void setJobSalary(String jobSalary) {
		this.jobSalary = jobSalary;
	}

	

	@Override
	public String toString() {
		return "JobEntity [jobId=" + jobId + ", companyName=" + companyName + ", jobTitle=" + jobTitle
				+ ", jobCategory=" + jobCategory + ", jobDescription=" + jobDescription + ", jobLocation=" + jobLocation
				+ ", jobSalary=" + jobSalary + ", userList=" + userList + "]";
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public JobEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
