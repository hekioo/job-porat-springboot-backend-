package com.boot.service;

import java.util.List;

import com.boot.entity.UserEntity;

public interface UserService {
	
	
	// below all these are the abstract method as this is the interface created!

		// to add a new record of User
		public UserEntity addUser(UserEntity user);

		// to get all the User list
		public List<UserEntity> getAllUser();

		// to get a particular User info by its ID
		public UserEntity getUserById(int UserId);

		// to update any of the User data with its ID
		public UserEntity updateUserById(UserEntity stu, int UserID);

		// delete User record by ID
		public void deleteUserById(int UserId);

		//login User acc to credentials
				public UserEntity checkLogin(String userEmail, String userPassword);
	

}
