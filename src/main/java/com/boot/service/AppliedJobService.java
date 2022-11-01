package com.boot.service;

import java.util.List;

import com.boot.entity.AppliedJobEntity;

public interface AppliedJobService {
	
	AppliedJobEntity getAppliedJobById(int jobId);

	AppliedJobEntity addAppliedJob(AppliedJobEntity appliedJob);
	List<AppliedJobEntity> getAllAppliedJobs();
	

}
