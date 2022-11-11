package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="AppliedJob")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","FieldHandler"})
public class AppliedJobEntity 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int ApplyJobid;
	
	@Column
	private String jobTitle;
	
	@ManyToOne
	@JoinColumn(name="uid")
	@JsonIgnore
	 private UserEntity users1;

	@ManyToOne
	@JoinColumn(name="jid")
	@JsonIgnore
	 private JobEntity jobs1;

	@Override
	public String toString() {
		return "AppliedJobEntity [ApplyJobid=" + ApplyJobid + ", jobTitle=" + jobTitle + ", users=" + users1 + ", jobs="
				+ jobs1 + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public AppliedJobEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getApplyJobid() {
		return ApplyJobid;
	}

	public void setApplyJobid(int applyJobid) {
		ApplyJobid = applyJobid;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public UserEntity getUsers() {
		return users1;
	}

	public void setUsers(UserEntity users) {
		this.users1 = users;
	}

	public JobEntity getJobs() {
		return jobs1;
	}

	public void setJobs(JobEntity jobs) {
		this.jobs1 = jobs;
	}

	

	
	
	
	
}
