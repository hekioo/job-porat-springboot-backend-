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

import com.boot.entity.UserEntity;
import com.boot.exceptions.ApiResponse;
import com.boot.service.UserService;



@RestController      // to deal with the REST API
@RequestMapping("/user")
public class UserController 
{
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add_user")    // end point  http://localhost:8080/user/add_user  
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user)
	{
		UserEntity savedUser = this.userService.addUser(user);
		return new ResponseEntity<UserEntity>(savedUser, HttpStatus.CREATED);
		
		// we have used ResponseEntity because to change the HTTP status to 201(CREATED) (request send and new resource created)
		// earlier which was at default at 200(OK) Status i.e request created
	}
	
	
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
		
		
		
		// update USer using User Id
		@PutMapping("update_user/{userId}")
		public ResponseEntity<UserEntity> updateUserById(@RequestBody UserEntity user, @PathVariable("userId") int userId)
		{
			UserEntity userById = this.userService.updateUserById(user, userId);
			return new ResponseEntity<UserEntity>(userById, HttpStatus.OK);
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
		
		
		
		
			
		
		
		
		
}
