package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, Integer>
{
	
	List<JobEntity> findByJobLocation(String jobLocation);
	
	List<JobEntity> findByJobCategory(String category);

}
