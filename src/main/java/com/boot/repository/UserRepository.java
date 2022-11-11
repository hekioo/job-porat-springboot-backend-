package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>
{
	
	// for checking the UserName and password while login
	UserEntity findByUserEmailAndUserPassword(String userEmail, String userPassword);
	
	
}
