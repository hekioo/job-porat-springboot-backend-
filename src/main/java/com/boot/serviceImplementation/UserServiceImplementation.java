package com.boot.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.JobEntity;
import com.boot.entity.UserEntity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.repository.JobRepository;
import com.boot.repository.UserRepository;
import com.boot.service.UserService;


@Service     // It is used to mark the class as a service provider.
				// this class provide some functionality
public class UserServiceImplementation implements UserService
{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private JobRepository jobRepo;
	
	@Override
	public UserEntity addUser(UserEntity stu) {
		return this.userRepo.save(stu);
	}
	
	

	@Override
	public List<UserEntity> getAllUser() {
		return this.userRepo.findAll();
	}

	@Override
	public UserEntity getUserById(int userId) {
		
		//return this.userRepo.findById(UserId).get();
		return this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
	}

	@Override
	public UserEntity updateUserById(UserEntity stu, int UserID) {
		
		if(!this.userRepo.existsById(UserID))
		{
			throw new ResourceNotFoundException("User", "User Id", UserID);
		}
		else
		{
			return this.userRepo.save(stu);
		}
	}

	@Override
	public void deleteUserById(int UserId) {
		this.userRepo.deleteById(UserId);
		
	}

	
	@Override
	public UserEntity addUser() {
		
		return null;
	}

  // added later on after creating the relation

	@Override
	public List<UserEntity> getJobsEnrolledByUserId(int jobId) {
		
		JobEntity jobObj = this.jobRepo. findById(jobId).orElseThrow(( )-> new ResourceNotFoundException("JOb", "JObID", jobId)); 
		return this.userRepo.getJobsEnrolledByUserId(jobId);
	}
	
	
}
