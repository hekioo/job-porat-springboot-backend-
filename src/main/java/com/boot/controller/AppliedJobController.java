package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.AppliedJobEntity;
import com.boot.service.AppliedJobService;


@RestController
@RequestMapping("/appliedJob")
@CrossOrigin("*")
public class AppliedJobController {
	
	
	@Autowired
	private AppliedJobService appliedJobService;	
	
	
	
    @PostMapping("/{userId}/{jobId}")
    public ResponseEntity<AppliedJobEntity> addJobApplied(@PathVariable int userId,@PathVariable int jobId)
    {
    	AppliedJobEntity ap = new AppliedJobEntity();
     
        AppliedJobEntity addedJob = this.appliedJobService.addJobApplied(ap,userId,jobId);
        return new ResponseEntity<AppliedJobEntity>(addedJob,HttpStatus.CREATED);
    }
	
	
	// get all applied JOb
	@GetMapping("/")
    public ResponseEntity<List<AppliedJobEntity>> getAllAppliedJob()  //to fetch all the User data
    {
    	List<AppliedJobEntity> allApplications = this.appliedJobService.getAllAppliedJobs();
    	return new ResponseEntity<List<AppliedJobEntity>>(allApplications,HttpStatus.OK);
    }
	
	// get applied job by userID

	@GetMapping("/ap/{userId}")
	public ResponseEntity<AppliedJobEntity> getAppliedJobById(@PathVariable("userId") int userId)  
	{
		AppliedJobEntity appliedJobsById = this.appliedJobService.getAppliedJobById(userId);
    	return new ResponseEntity<AppliedJobEntity>(appliedJobsById,HttpStatus.OK);
	}
		

}


//@PostMapping("/") //end point http:localhost:8080/User/
//public ResponseEntity<AppliedJobEntity> addAppliedJob(@RequestBody AppliedJobEntity job)
//{
//    
//  AppliedJobEntity savedAppliedJob=this.appliedJobService.addAppliedJob(job);
//    return new ResponseEntity<AppliedJobEntity>(savedAppliedJob,HttpStatus.CREATED);
//}
//
//
