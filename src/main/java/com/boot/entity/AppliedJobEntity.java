package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AppliedJob")
public class AppliedJobEntity 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column()
	private int ApplyJobid;
	
	@ManyToOne
	@JoinColumn(name="userId")
	 private UserEntity users;

	@ManyToOne
	@JoinColumn(name="jobId")
	 private JobEntity jobs;

	

	

	public UserEntity getUsers() {
		return users;
	}

	public void setUsers(UserEntity users) {
		this.users = users;
	}

	public JobEntity getJobs() {
		return jobs;
	}

	public void setJobs(JobEntity jobs) {
		this.jobs = jobs;
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

	@Override
	public String toString() {
		return "AppliedJobEntity [ApplyJobid=" + ApplyJobid + ", users=" + users + ", jobs=" + jobs + "]";
	}

	
	
	
	
}
