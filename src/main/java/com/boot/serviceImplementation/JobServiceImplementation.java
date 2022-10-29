package com.boot.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.JobEntity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.repository.JobRepository;
import com.boot.service.JobService;

@Service
public class JobServiceImplementation implements JobService{
	
	
	
	@Autowired
	private JobRepository jobRepo;

	@Override	
	public JobEntity addJob(JobEntity jobb) {
		return this.jobRepo.save(jobb);
	}

	@Override
	public void deleteJobById(int jobId) {
		// TODO Auto-generated method stub
		this.jobRepo.deleteById(jobId);
		
	}

	@Override
	public List<JobEntity> viewAllJobs() {
		// TODO Auto-generated method stub
		return this.jobRepo.findAll();
	}

	@Override
	public List<JobEntity> getJobByLocation(String loc) {
//		return this.jobRepo.findAllByName(loc).orElseThrow(() -> new ResourceNotFoundException("JOb", "JOb Id", jobId));
	    return this.jobRepo.findByJobLocation(loc);
	}
//
	@Override
	public List<JobEntity> getJobByCategory(String category) {
	    return this.jobRepo.findByJobCategory(category);

	}

	@Override
	public JobEntity updateJobById(JobEntity job, int jobId) {
		// TODO Auto-generated method stub
		if(!this.jobRepo.existsById(jobId))
		{
			throw new ResourceNotFoundException("JOb", "JOb Id", jobId);
		}
		else
		{
			return this.jobRepo.save(job);
		}
	}

	

	@Override
	public JobEntity getJobById(int jobId) {
		// TODO Auto-generated method stub
		return this.jobRepo.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("JOb", "JOb Id", jobId));

	}

	


}
