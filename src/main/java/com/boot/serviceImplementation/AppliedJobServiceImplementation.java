package com.boot.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.AppliedJobEntity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.repository.AppliedJobRepository;

import com.boot.service.AppliedJobService;


@Service
public class AppliedJobServiceImplementation implements AppliedJobService{

	
	@Autowired
	private AppliedJobRepository appliedJobRepo;
	

	
	@Override
	public AppliedJobEntity getAppliedJobById(int jobId) {
		// TODO Auto-generated method stub
		return this.appliedJobRepo.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("User", "UerId", jobId));
	}

	@Override
	public List<AppliedJobEntity> getAllAppliedJobs() {
		// TODO Auto-generated method stub
		return this.appliedJobRepo.findAll();
	}

	@Override
	public AppliedJobEntity addAppliedJob(AppliedJobEntity appliedJob) {
		// TODO Auto-generated method stub
		return this.appliedJobRepo.save(appliedJob);
	}
	
	
}
