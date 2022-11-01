package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.AppliedJobEntity;
import com.boot.service.AppliedJobService;
import com.boot.service.JobService;


@RestController
@RequestMapping("/appliedJob")
public class AppliedJobController {
	
	
	@Autowired
	private AppliedJobService appliedJobService;
	private AppliedJobEntity appliedJobEntity;
	
	
	
	
	
	  @PostMapping("/") //end point http:localhost:8080/User/
	    public ResponseEntity<AppliedJobEntity> addAppliedJob(@RequestBody AppliedJobEntity job)
	    {
	        
		  AppliedJobEntity savedAppliedJob=this.appliedJobService.addAppliedJob(job);
	        return new ResponseEntity<AppliedJobEntity>(savedAppliedJob,HttpStatus.CREATED);
	    }
	
	
	
	
	// get all applied JOb
	@GetMapping("/")
    public ResponseEntity<List<AppliedJobEntity>> getAllAppliedJob()  //to fetch all the User data
    {
    	List<AppliedJobEntity> allApplications = this.appliedJobService.getAllAppliedJobs();
    	return new ResponseEntity<List<AppliedJobEntity>>(allApplications,HttpStatus.OK);
    }
	
	// get applied job by ID

	@GetMapping("/{jobId}")
	public ResponseEntity<AppliedJobEntity> getApplieJobById(@PathVariable("jobId") int jobId)  
	{
		AppliedJobEntity appliedJobsById = this.appliedJobService.getAppliedJobById(jobId);
    	return new ResponseEntity<AppliedJobEntity>(appliedJobsById,HttpStatus.OK);
	}
	
	

}
