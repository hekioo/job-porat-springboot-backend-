package com.boot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.entity.JobEntity;
import com.boot.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>
{
	//List<UserRepository> findByJob1(JobEntity job);
	
	@Query(value="select * from user_detail ud where ud.jid=:jobId", nativeQuery=true)
	List<UserEntity> getJobsEnrolledByUserId(@Param("jobId") int jobId);

	Optional<UserEntity> findByUserName(String username);
	
	
	
}
