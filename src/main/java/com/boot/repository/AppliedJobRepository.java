package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.AppliedJobEntity;

public interface AppliedJobRepository extends JpaRepository<AppliedJobEntity, Integer>{

}
