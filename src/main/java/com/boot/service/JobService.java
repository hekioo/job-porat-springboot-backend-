package com.boot.service;

import java.util.List;

import com.boot.entity.AppliedJobEntity;
import com.boot.entity.JobEntity;

public interface JobService {
	
	// to add a new JOb
	public JobEntity addJob(JobEntity job);
	
	//to delete the job with ID
	public void deleteJobById(int jobId);
	
	// to view all jobs
	public List<JobEntity> viewAllJobs();
	
	//to get job according to location
	public List<JobEntity> getJobByLocation(String loc);

//	//to get job according to category
	public List<JobEntity> getJobByCategory(String category);
	
	// to update the job using jobID
	public JobEntity updateJobById(JobEntity job, int jobId);
	
	// getJobById
	public JobEntity getJobById(int jobId);

	
	// list of all jobs applied by UserID
	//public List<JobEntity> getJobsEnrolledByUserId(int userId);
	

}
