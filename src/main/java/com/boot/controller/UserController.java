package com.boot.controller;

import java.util.List;
import java.util.Optional;

import com.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.UserEntity;
import com.boot.exceptions.ApiResponse;
import com.boot.service.UserService;



@RestController      // to deal with the REST API
@RequestMapping("/user")
public class UserController 
{
	
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepo;



	
	
	// get all the User records
		@GetMapping("/view_user")    
		public ResponseEntity<List<UserEntity>> getAllUser()
		{
			List<UserEntity> allUser = this.userService.getAllUser();
			return new ResponseEntity<List<UserEntity>>(allUser, HttpStatus.OK);
		}
		
		
		

		// get the user record acc to ID

		@GetMapping("view_user/{userId}")
		public ResponseEntity<UserEntity> getUserById(@PathVariable("userId") int userId)
		{
			UserEntity userById = this.userService.getUserById(userId);		
			return new ResponseEntity<UserEntity>(userById, HttpStatus.OK);
		}
		
		
		
		// update User using User name
	// you can go with this approach also fetching the username from already
		// authenticated user and then updating his/her details
		@PutMapping("update_user")
		public ResponseEntity<UserEntity> updateUserById(@RequestBody UserEntity user)
		{
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();

			Optional<UserEntity> userInDB = userRepo.findByUserName(username);
			if(userInDB.isPresent()) {
				UserEntity updatedUser = userInDB.get();

				//updatedUser.setUserPassword(user.getUserPassword());
				updatedUser.setUserName(user.getUserName());
				updatedUser.setUserEmail(user.getUserEmail());
				updatedUser.setUserMobile(user.getUserMobile());
				updatedUser.setUserQualification(user.getUserQualification());
				updatedUser.setUserSkills(user.getUserSkills());

				userRepo.save(updatedUser);
			}

			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		
		
		
		
		// delete user by ID
		@DeleteMapping("del_user/{userId}")
		public ResponseEntity<ApiResponse> deleteUserById(@PathVariable("userId") int userId)
		{
			this.userService.deleteUserById(userId);
			
			ApiResponse response = new ApiResponse();
			response.setMesaage("Your record is deleted Successfully! with User ID: " + userId);
			return new ResponseEntity<ApiResponse> (response, HttpStatus.OK);
		}
		
		
		
		@GetMapping("/job/{jobId}")    // end point  http://localhost:8080/course/student/4
		public ResponseEntity<List<UserEntity>> getJobsEnrolledByUserId(@PathVariable("jobId") int jobId) 
		{
			List<UserEntity> jobApplied = this.userService.getJobsEnrolledByUserId(jobId);		
			return new ResponseEntity<List<UserEntity>>(jobApplied, HttpStatus.OK);
		}	
			
		
		
		
		
}
