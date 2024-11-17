package com.boot.serviceImplementation;

import com.boot.entity.JobEntity;
import com.boot.entity.UserEntity;
import com.boot.exceptions.ResourceNotFoundException;
import com.boot.repository.JobRepository;
import com.boot.repository.UserRepository;
import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private JobRepository jobRepo;

	private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserEntity addUser(UserEntity stu) {
		stu.setUserPassword(passwordEncoder.encode(stu.getUserPassword()));
		return this.userRepo.save(stu);
	}

	@Override
	public List<UserEntity> getAllUser() {
		return this.userRepo.findAll();
	}

	@Override
	public UserEntity getUserById(int userId) {
		return this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
	}

	@Override
	public UserEntity updateUserById(UserEntity stu, int UserID) {
		if (!this.userRepo.existsById(UserID)) {
			throw new ResourceNotFoundException("User", "User Id", UserID);
		} else {
			return this.userRepo.save(stu);
		}
	}

	@Override
	public void deleteUserById(int UserId) {
		this.userRepo.deleteById(UserId);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> user = userRepo.findByUserName(username);
		if (user.isPresent()) {
			UserEntity userEntity = user.get();
			return org.springframework.security.core.userdetails.User.builder()
					.username(userEntity.getUserName())
					.password(userEntity.getUserPassword())
					.roles("USER") // or fetch roles from userEntity
					.build();
		} else {
			throw new UsernameNotFoundException("User with username " + username + " not found");
		}
	}


	@Override
	public UserEntity addUser() {
		return null;
	}

	@Override
	public List<UserEntity> getJobsEnrolledByUserId(int jobId) {
		JobEntity jobObj = this.jobRepo.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("Job", "JobID", jobId));
		return this.userRepo.getJobsEnrolledByUserId(jobId);
	}
}