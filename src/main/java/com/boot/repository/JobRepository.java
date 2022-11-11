package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.entity.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, Integer>
{
	
	List<JobEntity> findByJobLocation(String jobLocation);
	
	List<JobEntity> findByJobCategory(String category);
	
	//native query
		@Query(value="select * from job_detail jd where jd.uid=:userId", nativeQuery=true)
		List<JobEntity> getJobsEnrolledByUserId(@Param("userId") int userId);

}
