package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.JobEntity;
import com.boot.exceptions.ApiResponse;
import com.boot.service.JobService;

@RestController // to deal with the REST API
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobService jobService;
	

	// add a new JOb
	@PostMapping("/add_job") // end point http://localhost:8080/job/add_job
	public ResponseEntity<JobEntity> addJob(@RequestBody JobEntity job) {
		JobEntity savedJob = this.jobService.addJob(job);
		return new ResponseEntity<JobEntity>(savedJob, HttpStatus.CREATED);

	}

	
	
	// update Job using jobID
	@PutMapping("update_job/{jobId}")
	public ResponseEntity<JobEntity> updateJobById(@RequestBody JobEntity job, @PathVariable("jobId") int jobId) {
		JobEntity jobById = this.jobService.updateJobById(job, jobId);
		return new ResponseEntity<JobEntity>(jobById, HttpStatus.OK);
	}

	
	
	// delete user by ID
	@DeleteMapping("del_job/{jobId}")
	public ResponseEntity<ApiResponse> deleteJobById(@PathVariable("jobId") int jobId) {
		this.jobService.deleteJobById(jobId);

		ApiResponse response = new ApiResponse();
		response.setMesaage("Your record is deleted Successfully! with Job ID: " + jobId);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

	
	
	// get all the Jobs records
	@GetMapping("view_job")
	public ResponseEntity<List<JobEntity>> viewAllJobs() {
		List<JobEntity> allJobs = this.jobService.viewAllJobs();
		return new ResponseEntity<List<JobEntity>>(allJobs, HttpStatus.OK);
	}

	
	
	// get the JOb record according to ID

	@GetMapping("view_job/{jobId}")
	public ResponseEntity<JobEntity> getJobById(@PathVariable("jobId") int jobId) {
		JobEntity jobById = this.jobService.getJobById(jobId);
		return new ResponseEntity<JobEntity>(jobById, HttpStatus.OK);
	}

	
	
	// get all jobs acc to location
	@GetMapping("viewjob/{loc}")
	public ResponseEntity<List<JobEntity>> getJobByLocation(@PathVariable("loc") String loc)
	{
		List<JobEntity> jobByLocation = this.jobService.getJobByLocation(loc);
		return new ResponseEntity<List<JobEntity>>(jobByLocation, HttpStatus.OK);
		
	}
	
	
	// get all job acc to category
	@GetMapping("jobByCat/{category}")
	public ResponseEntity<List<JobEntity>> getJobByCategory(@PathVariable("category") String cat)
	{
		List<JobEntity> jobByCategory = this.jobService.getJobByCategory(cat);
		return new ResponseEntity<List<JobEntity>>(jobByCategory, HttpStatus.OK);
		
	}
}
