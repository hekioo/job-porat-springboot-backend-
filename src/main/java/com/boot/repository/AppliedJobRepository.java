package com.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.AppliedJobEntity;
import com.boot.entity.UserEntity;

public interface AppliedJobRepository extends JpaRepository<AppliedJobEntity, Integer>{

	List<AppliedJobEntity> findByUsers1(UserEntity user);
}
