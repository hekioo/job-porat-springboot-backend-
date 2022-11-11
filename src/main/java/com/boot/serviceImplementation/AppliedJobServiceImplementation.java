package com.boot.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.AppliedJobEntity;
import com.boot.entity.JobEntity;
import com.boot.entity.UserEntity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.repository.AppliedJobRepository;
import com.boot.repository.JobRepository;
import com.boot.repository.UserRepository;
import com.boot.service.AppliedJobService;


@Service
public class AppliedJobServiceImplementation implements AppliedJobService{

	
	@Autowired
	private AppliedJobRepository appliedJobRepo;
	
	@Autowired
	private JobRepository jobRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	

	
	@Override
	public AppliedJobEntity getAppliedJobById(int userId) {
		// TODO Auto-generated method stub
		return this.appliedJobRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
	}

	@Override
	public List<AppliedJobEntity> getAllAppliedJobs() {
		// TODO Auto-generated method stub
		return this.appliedJobRepo.findAll();
	}

	
	@Override
		public AppliedJobEntity addJobApplied(AppliedJobEntity ap, int userId, int jobId) {
		
		UserEntity user = this.userRepo.findById(userId).get();
		
		JobEntity job = this.jobRepo.findById(jobId).get();
		
		ap.setJobTitle(job.getJobTitle());   
		ap.setJobs(job);
		ap.setUsers(user);
		
		return this.appliedJobRepo.save(ap);
	}
	
	
	
	
	 
	
	
}
