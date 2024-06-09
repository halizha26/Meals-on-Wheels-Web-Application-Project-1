package com.group6.MoM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group6.MoM.entity.Driver;
import com.group6.MoM.entity.Member;
import com.group6.MoM.entity.User;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
	
	public Driver findByUser(User user);

}
