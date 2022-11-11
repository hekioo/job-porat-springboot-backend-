package com.boot.service;

import java.util.List;

import com.boot.entity.AppliedJobEntity;

public interface AppliedJobService {
	
	// to get all the job applied according to user id
	AppliedJobEntity getAppliedJobById(int userId);

	//AppliedJobEntity addAppliedJob(AppliedJobEntity appliedJob);
	List<AppliedJobEntity> getAllAppliedJobs();
	
	// to add the job and user details to the third table
	public AppliedJobEntity addJobApplied(AppliedJobEntity ap,int userId,int jobId);
	

}
